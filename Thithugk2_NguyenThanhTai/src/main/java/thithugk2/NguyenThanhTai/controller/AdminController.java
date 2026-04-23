package thithugk2.NguyenThanhTai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thithugk2.NguyenThanhTai.model.SanPham;
import thithugk2.NguyenThanhTai.service.SanPhamService;

@Controller
@RequestMapping("/admin/sanpham")
public class AdminController {

	@Autowired
	private SanPhamService service;

	// Xem danh sách
	@GetMapping
	public String list(Model model) {
		model.addAttribute("listSP", service.getAll());
		return "admin/list"; // Trả về file admin/list.html
	}

	// Form thêm mới
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("sanpham", new SanPham());
		return "admin/form";
	}

	// Lưu DB (Dùng cho cả thêm và sửa)
	@PostMapping("/save")
	public String save(@ModelAttribute("sanpham") SanPham sp) {
		service.save(sp);
		return "redirect:/admin/sanpham";
	}

	// Xóa
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/admin/sanpham";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		SanPham sp = service.getById(id);
		if (sp != null) {
			model.addAttribute("sanpham", sp);
			return "admin/form"; // Tái sử dụng lại chính file form.html tuyệt đẹp lúc nãy
		}
		return "redirect:/admin/sanpham";
	}
}