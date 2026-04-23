package thithugk2.NguyenThanhTai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thithugk2.NguyenThanhTai.service.SanPhamService;

@Controller
public class HomeController {

	@Autowired
	private SanPhamService service;

	// Đường dẫn gốc của trang web
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("listSP", service.getAll());
		// Để tiết kiệm thời gian thi, ta cho người dùng xem luôn giao diện list của
		// admin
		// Nếu có thời gian, bạn có thể tạo một file index.html riêng cho đẹp
		return "admin/list";
	}
}