package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentReport extends BaseTest{
	public static ExtentReports getreports() {
		String folderpath=System.getProperty("user.dir")+"\\reports";
		if(report==null) {
			report=	new ExtentReports();
			
			File folder=new File(folderpath);
			folder.mkdir();
			Date date= new Date();
			String pattren="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat day=	new SimpleDateFormat(pattren);
			String dates =day.format(date);
			System.out.println(dates);
			dates=dates.replace(":", "-");
			System.out.println(dates);
			
			File filepath =new File(folderpath+"\\" +dates+".html");
			
			ExtentSparkReporter webreport =	new ExtentSparkReporter(filepath);
			webreport.config().setDocumentTitle("SearchFunction");
			webreport.config().setReportName("searchHotel");
			webreport.config().setTheme(Theme.DARK);
			report.attachReporter(webreport);
		}
			
		
		return report;
		
	}

}
