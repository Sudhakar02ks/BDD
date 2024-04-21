package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseTest;

public class UtilsKit extends BaseTest 
{
	static FileInputStream path;
	static XSSFWorkbook wb;
 public static HashMap<String, String>getdatafromExcel(String Testcase)
 {
	 try {
 path= new FileInputStream("src\\test\\resources\\Test Data\\Excel\\Adactin Master Test Data.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		wb= new XSSFWorkbook(path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 XSSFSheet ws=wb.getSheet("com.adactin");
	
	 
	 ArrayList<Row>  testcaserow =getTestcaserow(ws,Testcase);
	 HashMap<String, String> testdata=new HashMap<String, String>();
	 for(int i=0;i<testcaserow.size();i++) {
		int cellnum= testcaserow.get(i).getLastCellNum();
		for(int j=1;j<cellnum;j++) {
			testdata.put(testcaserow.get(0).getCell(j).getStringCellValue(),testcaserow.get(1).getCell(j).getStringCellValue());
		}
		 
	 }
	return testdata;
 }
 
private static ArrayList<Row> getTestcaserow(XSSFSheet ws, String testcase) {
	ArrayList<Row> allrows=new ArrayList<Row>();
	for(int i=0;i<=ws.getLastRowNum();i++) {       //to find all test cases
		if(ws.getRow(i) != null) {
			allrows.add(ws.getRow(i));
		}
	}
	ArrayList<Row> testcaserow=new ArrayList<Row>();        
	for(int i=0;i<allrows.size();i++) {                                            //to find particular testcase
		if(allrows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase)) {
			testcaserow.add(allrows.get(i));
		}
	}
	return testcaserow;
}
}
