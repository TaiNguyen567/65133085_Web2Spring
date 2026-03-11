package tai65133085.thspringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DanhSachSinhVienController {

	@GetMapping("/danh-sach")
	public String hienThiDanhSach(Model model) {

		List<SinhVien> danhSach = new ArrayList<>();
		danhSach.add(new SinhVien("SV001", "Nguyễn Văn A", 8.5));
		danhSach.add(new SinhVien("SV002", "Trần Thị B", 7.0));
		danhSach.add(new SinhVien("SV003", "Lê Văn C", 9.2));
		danhSach.add(new SinhVien("SV004", "Phạm Văn D", 6.5));

		model.addAttribute("danhSachSV", danhSach);

		return "sinhvien_list";
	}
}
