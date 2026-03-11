package tai65133085.thspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

	@GetMapping("/tinh-bmi")
	public String hienThiFormBmi() {
		return "bmi_form";
	}

	@PostMapping("/ket-qua")
	public String xuLyTinhBmi(@RequestParam("chieuCao") double chieuCao, @RequestParam("canNang") double canNang,
			Model model) {

		double bmi = canNang / (chieuCao * chieuCao);

		String phanLoai = "";
		if (bmi < 18.5) {
			phanLoai = "Gầy (Cần ăn uống thêm nhé!)";
		} else if (bmi >= 18.5 && bmi <= 24.9) {
			phanLoai = "Bình thường (Cơ thể rất chuẩn!)";
		} else if (bmi >= 25 && bmi <= 29.9) {
			phanLoai = "Thừa cân (Nên vận động nhiều hơn)";
		} else {
			phanLoai = "Béo phì (Cần chú ý chế độ ăn kiêng!)";
		}

		model.addAttribute("chiSoBmi", String.format("%.2f", bmi));
		model.addAttribute("ketLuan", phanLoai);

		return "bmi_result";
	}
}