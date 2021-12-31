package springredirectsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class SearchController {
	
	@RequestMapping("/home")
	public String home(){
		System.out.println("This is home page..");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("query") String query){
		System.out.println("This is my search action to redirect: "+query);
		
		RedirectView rv = new RedirectView();
		String url = "https://www.google.com/search?q="+query;
		rv.setUrl(url);
		return rv;
	}

}
