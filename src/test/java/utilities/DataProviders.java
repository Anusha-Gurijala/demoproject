package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

		@DataProvider(name="Logindata")
		public String[][] getData() throws IOException
		{
			String path=".\\testData\\Opencart_LoginData.xlsx";
			ExcelUtility EU=new ExcelUtility(path);
			int getrowcount=EU.getRowCount("Sheet1");
			int clmncount=EU.getCellCount("sheet1", 1);
			
			String logindata[][]=new String[getrowcount][clmncount];
			for(int i=1;i<=getrowcount;i++)
			{
				for(int j=0;j<clmncount;j++)
				{
					logindata[i-1][j]=EU.getCellData("Sheet1", i, j);
				}
			}
			return logindata;
			
		}
		
		
		
		
	

}
