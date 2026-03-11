package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/dash-board")
	public String home() {
		return "index";
	}
//	ArrayList<Page> dsTrang = new ArrayList<Page>();
//	ArrayList<Post> dsBaiViet = new ArrayList<Post>();
}
