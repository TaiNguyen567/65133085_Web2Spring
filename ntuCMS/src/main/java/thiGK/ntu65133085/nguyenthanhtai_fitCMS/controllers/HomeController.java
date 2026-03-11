package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Post;

@Controller
public class HomeController {

	ArrayList<Page> dsTrang = new ArrayList<Page>();
	ArrayList<Post> dsBaiViet = new ArrayList<Post>();

	public HomeController() {
		dsTrang.add(new Page(1, "Trang chủ", "home", "Nội dung trang chủ", 0));
		dsTrang.add(new Page(2, "Giới thiệu", "about", "Giới thiệu về chúng tôi", 0));
		dsTrang.add(new Page(3, "Sản phẩm", "product", "Danh sách sản phẩm", 0));
	}

	@GetMapping({ "/", "/dashboard", "/dasdboard" })
	public String home() {
		return "index";
	}

	@GetMapping("/page/all")
	public String getAllPages(ModelMap m) {
		m.addAttribute("listPages", dsTrang);
		return "allPage";
	}
}