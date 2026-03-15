package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;

@RestController
public class APIPageController {
	@GetMapping("/api/page")
	public String getAllPages() {
		return "Thử API";
	}

	@GetMapping("/api/oneObj")
	public Page getOneOBJ() {
		return new Page(0, "Giới thiệu", "từ khóa", "nội dung gì đó", 0);
	}
}
