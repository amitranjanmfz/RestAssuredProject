package dataprovider;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.*;
import utils.ExcelReadWrite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;



public class GenericDataProvider {

	@DataProvider(name="GenericDataProvider")
	public static Iterator<Object[]> resourceDataProvider(Method testMethod) throws Exception
	{
		Map<String,String> args=DataProviderUtils.resolveDataProviderMergeArguments(testMethod);
		List<Object[]> dataList = assetDataProvider(args.get("file"),args.get("testName"));
		return dataList.iterator();
	}

	
	public static List<Object[]> assetDataProvider(String filePath,String auditType) throws IOException
	{
//		ExcelReadWrite xl = new ExcelReadWrite("./src/test/resources/NewsAssessmentCreate.xls");
		ExcelReadWrite xl = new ExcelReadWrite(filePath);

		HSSFSheet sheet = xl.setSheet("newsAssessment");
		int rowCount = xl.rowCount(sheet);
		int colCount = xl.colCount(sheet, 0);
		
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i=1;i<=rowCount;i++)
		{
			String executeFlag = xl.readValue(sheet, i, "EXECUTE_FLAG");
			String audit = xl.readValue(sheet, i, "Asset Type");
			
			if(audit.equalsIgnoreCase(auditType) && executeFlag.equalsIgnoreCase("Y"))
			{
			    	Map<String,String> hmap = new HashMap<String, String>();
			    	for(int j = 0;j<colCount;j++)
			    	{
			    		String key =xl.readValue(sheet, 0, j);
			    		String value =xl.readValue(sheet, i, j);
				
			    		hmap.put(key, value);
				
			    	}
			
			    	Object[] obj = new Object[1];
			    	obj[0]=hmap;
			    	list.add(obj);
			}
		}
		return list;
	
	}
	
}
