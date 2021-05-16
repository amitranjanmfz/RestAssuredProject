package testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider2DArray {

    @DataProvider(name="dataprovider")
    public Object[][] data()
    {
      Object[][] dataArray = {{"A","1"},{"B","2"},{"C","3"}};
      return dataArray;
    }

@Test(dataProvider = "dataprovider")
public void testDataProvider(String col1,String col2)
    {
        System.out.println("Test");
        System.out.println(col1);
        System.out.println(col2);
    }
}
