package com.sun.springboot.jasperreport.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.sun.springboot.jasperreport.entity.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.export.XlsxReportConfiguration;

@Service
public class ReportService {
	@Autowired
	UserService userService;
	
	public String exportReport(String reportFormat, String title) throws FileNotFoundException, JRException{
		List<User> users = userService.getAllUsers();
		String path = "C:\\Users\\SUN\\Desktop\\Reports";
		//load file and compile it
		File file = ResourceUtils.getFile("classpath:users.jrxml");
		System.out.println("file.getAbsolutePath(): "+file.getAbsolutePath());
		System.out.println("title: "+title);
		JasperReport jasperReport =  JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", title);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\users.pdf");
		}
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\users.html");
		}
		
		if (reportFormat.equalsIgnoreCase("xlsx")) {
			
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path+"\\users.xlsx"));
			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setDetectCellType(true);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			
		}
		return "report generated in path :"+path;
	}

}
