package Comprehensive.Hybrid.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void readExcelData() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("F:\\eclipse java\\ComprehensiveAssessment\\HybridFramework\\src\\main\\java\\Comprehensive\\Hybrid\\Resources\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		Map<String,String> map=new HashMap<String,String>();
		
		//int sheets=workbook.getNumberOfSheets();
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Iterator<Row> row=sheet.iterator();
		Row frow=row.next();
		Iterator<Cell> ce=frow.cellIterator();
		while(ce.hasNext())
		{
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("TestData"));
			while(row.hasNext())
			{
				Row r=row.next();
				Iterator<Cell> cv=r.cellIterator();
				//String cellval=r.getCell(0).getStringCellValue();
					while(cv.hasNext())
					{
						map.put(cv.next().getStringCellValue(),cv.next().getStringCellValue());
						
					}
			}
		}
		for(String key:map.keySet())
		{
			System.out.println(map.get(key));
		}
		
	}

}
