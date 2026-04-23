package thithugk2.NguyenThanhTai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thithugk2.NguyenThanhTai.model.SanPham;
import thithugk2.NguyenThanhTai.service.SanPhamService;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamRestController {
	@Autowired
	private SanPhamService service;

	@GetMapping
	public List<SanPham> getAllApi() {
		return service.getAll();
	}
}