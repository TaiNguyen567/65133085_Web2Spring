package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {

	@GetMapping("/thong-tin")
	public String hienThiThongTin(Model model) {
		model.addAttribute("mssv", "SV123456");
		model.addAttribute("hoTen", "Nguyễn Văn A");
		model.addAttribute("namSinh", 2004);
		model.addAttribute("gioiTinh", "Nam");

		return "thongtin_view";
	}
}