package com.sun.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		String studyNames="study";
		String studyIds="";
		Map<String, String> studyMap=new HashMap<String, String>();
		String[] studyArr=null;
		String[] studyIdArr=null;
		if(studyNames.contains(",") && studyIds.contains(",") && !studyNames.isEmpty() && !studyIds.isEmpty()){
			 studyArr = studyNames.split(",");
			 studyIdArr = studyIds.split(",");
		}
		
		//System.out.println(studyArr[0]);
		
		if(studyArr !=null && studyIdArr !=null){ 
		for(int i=0;i<studyArr.length;i++){
			studyMap.put(studyIdArr[i], studyArr[i]);
		}
		
		}
		else{
			studyMap.put(studyIds, studyNames);
		}
		model.addAttribute("studyMap", studyMap );
		return "home";
	}
	
}
