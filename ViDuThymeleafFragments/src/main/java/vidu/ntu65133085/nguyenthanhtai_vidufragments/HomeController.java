package vidu.ntu65133085.nguyenthanhtai_vidufragments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/Home")
	public String showHomePage() {
		// Trả về tên file giao diện là "index" (Thymeleaf sẽ tự tìm file index.html)
		return "index";
	}
}