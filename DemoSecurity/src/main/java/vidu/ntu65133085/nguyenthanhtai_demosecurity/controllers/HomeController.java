package vidu.ntu65133085.nguyenthanhtai_demosecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "HomePage";
	}

	@GetMapping("/products")
	public String indexP() {
		return "sanpham";
	}

	@GetMapping("/admin")
	public String indexAD() {
		return "indexadmin";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
