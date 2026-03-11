package tai65133085.thspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {

	@GetMapping("/thong-tin-doi-tuong")
	public String hienThiDoiTuong(Model model) {

		SinhVien sv = new SinhVien("SV001", "Trần Thị B", 8.5);

		model.addAttribute("sinhVien", sv);

		return "sinhvien_detail";
	}
}
