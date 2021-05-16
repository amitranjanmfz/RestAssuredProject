package dataprovider;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DataProviderUtils {
    public static Map<String,String> resolveDataProviderMergeArguments(Method testMethod) throws Exception {

        if (testMethod == null)
            throw new IllegalArgumentException("Test Method context cannot be null.");

        Test testName = testMethod.getAnnotation(Test.class);
        DataProviderArguments args = testMethod.getAnnotation(DataProviderArguments.class);
        if (args == null)
            throw new IllegalArgumentException("Test Method context has no DataProviderArguments annotation.");
        if (args.value() == null || args.value().length == 0)
            throw new IllegalArgumentException("Test Method context has a malformed DataProviderArguments annotation.");
        Map<String,String> arguments = new HashMap<>();
        for (int i = 0; i < args.value().length; i++) {
            String[] parts = args.value()[i].split("=");
            arguments.put(parts[0].trim(), parts[1].trim());
        }

        arguments.put("testName",testName.testName());
        return arguments;
    }
}
