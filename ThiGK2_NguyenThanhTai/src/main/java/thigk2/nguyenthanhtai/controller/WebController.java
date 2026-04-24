package thigk2.nguyenthanhtai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import thigk2.nguyenthanhtai.model.NguoiDung;
import thigk2.nguyenthanhtai.repository.NguoiDungRepository;
import thigk2.nguyenthanhtai.repository.TheLoaiTinRepository;
import thigk2.nguyenthanhtai.repository.TinRepository;

@Controller
public class WebController {

	@Autowired
	private TinRepository tinRepository;

	@Autowired
	private TheLoaiTinRepository theLoaiTinRepository;

	@Autowired
	private NguoiDungRepository nguoiDungRepository;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {
		NguoiDung nd = nguoiDungRepository.findByUsernameAndPassword(username, password);
		if (nd != null) {
			session.setAttribute("user", nd);
			return "redirect:/";
		}
		model.addAttribute("error", "Sai tai khoan hoac mat khau!");
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("user") == null)
			return "redirect:/login";
		model.addAttribute("listTheLoai", theLoaiTinRepository.findAll());
		model.addAttribute("listTin", tinRepository.findAll());
		return "index";
	}

	@GetMapping("/theloai/{id}")
	public String tinTheoTheLoai(@PathVariable Long id, Model model, HttpSession session) {
		if (session.getAttribute("user") == null)
			return "redirect:/login";
		model.addAttribute("listTheLoai", theLoaiTinRepository.findAll());
		model.addAttribute("listTin", tinRepository.findByTheLoaiTinId(id));
		return "index";
	}

	@GetMapping("/tin/chitiet/{id}")
	public String chiTietTin(@PathVariable Long id, Model model, HttpSession session) {
		if (session.getAttribute("user") == null)
			return "redirect:/login";
		model.addAttribute("tin", tinRepository.findById(id).orElse(null));
		return "detail";
	}
}
