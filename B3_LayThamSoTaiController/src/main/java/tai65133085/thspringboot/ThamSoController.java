package tai65133085.thspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThamSoController {

	@GetMapping("/nhap-lieu")
	public String hienThiForm() {
		return "form_nhap";
	}

	@PostMapping("/xu-ly")
	public String xuLyDuLieu(@RequestParam("hoTen") String tenNhanDuoc, Model model) {
		model.addAttribute("tenHienThi", tenNhanDuoc);
		return "ket_qua";
	}
}