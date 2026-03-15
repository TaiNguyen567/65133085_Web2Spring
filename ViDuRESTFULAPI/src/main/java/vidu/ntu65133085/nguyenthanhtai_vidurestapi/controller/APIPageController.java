package vidu.ntu65133085.nguyenthanhtai_vidurestapi.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vidu.ntu65133085.nguyenthanhtai_vidurestapi.model.Page;

@RestController
public class APIPageController {

	// Danh sách Page, Post (Dùng như một Database tạm thời)
	ArrayList<Page> dsTrang = new ArrayList<Page>();

	// Constructor: Khởi tạo dữ liệu mẫu khi Controller được gọi
	public APIPageController() {
		Page p1 = new Page(0, "GioiThieu", "mct", "Nội dungg tran ở đây", 0);
		Page p2 = new Page(1, "Trang X", "gi do", "Nội dungg tran ở đây", 0);
		Page p3 = new Page(2, "Trang Y", "sth", "Nội dungg tran ở đây", 0);

		dsTrang.add(p1);
		dsTrang.add(p2);
		dsTrang.add(p3);
	}

	// API 1: Lấy danh sách tất cả các trang
	@GetMapping("/api/page")
	public ArrayList<Page> getAllPages() {
		return dsTrang;
	}

	// API 2: Lấy thông tin 1 trang cụ thể dựa vào ID
	@GetMapping("/api/page/{id}")
	public Page getOneOBJ(@PathVariable("id") Long id) {
		for (Page p : dsTrang) {
			if (p.getId() == id) {
				return p; // Tìm thấy thì trả về object Page
			}
		}
		return null; // Không tìm thấy thì trả về null
	}

	// API 3: Xóa 1 trang dựa vào ID
	@DeleteMapping("/api/page/del/{id}")
	public boolean pageDelete(@PathVariable("id") int id) {
		// Tìm page
		for (Page p : dsTrang) {
			if (p.getId() == id) {
				return dsTrang.remove(p); // Xóa thành công sẽ trả về true
			}
		}
		return false; // Không tìm thấy để xóa sẽ trả về false
	}

	// API 4: Thêm mới 1 trang
	@PostMapping("/api/page/add")
	public boolean addPage(@RequestBody Page newPage) {
		// Hàm add() của ArrayList sẽ tự động trả về true nếu thêm thành công
		return dsTrang.add(newPage);
	}

	// API 5: Cập nhật (Sửa) thông tin 1 trang đã có dựa vào ID
	@PutMapping("/api/page/update/{id}")
	public boolean updatePage(@PathVariable("id") long id, @RequestBody Page updatedPage) {
		// Duyệt qua danh sách để tìm trang cần sửa
		for (Page p : dsTrang) {
			if (p.getId() == id) {
				// Nếu tìm thấy, tiến hành cập nhật các thuộc tính bằng dữ liệu mới gửi lên
				p.setTitle(updatedPage.getTitle());
				p.setSlug(updatedPage.getSlug());
				p.setContent(updatedPage.getContent());
				p.setStatus(updatedPage.getStatus());

				return true; // Trả về true báo hiệu cập nhật thành công
			}
		}
		return false; // Trả về false nếu không tìm thấy ID này trong danh sách
	}
}