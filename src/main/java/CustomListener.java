import org.apache.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomListener implements ITestListener {
    public  void onTestStart(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    public void onTestSuccess(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a method fails but has been annotated with successPercentage and this failure
     * still keeps it within the success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     */
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
     * and calling all their Configuration methods.
     */
    public void onStart(ITestContext context) {
        System.out.println("------------------------------------------- Suite Execution Begins -------------------------------------------------------");
        try {
        String fileName="./src/log.txt";
        PatternLayout patternLayout=new PatternLayout("%d %m %n");
        FileAppender fileAppender = new FileAppender(patternLayout,fileName);
        ConsoleAppender consoleAppender=new ConsoleAppender(patternLayout);
        BasicConfigurator.configure(fileAppender);
        BasicConfigurator.configure(consoleAppender);
        Logger logger = Logger.getLogger(getClass());
        logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
     * and all their Configuration methods have been called.
     */
    public void onFinish(ITestContext context) {
        System.out.println("------------------------------------------- Suite Execution Completed -------------------------------------------------------");
    }

}
