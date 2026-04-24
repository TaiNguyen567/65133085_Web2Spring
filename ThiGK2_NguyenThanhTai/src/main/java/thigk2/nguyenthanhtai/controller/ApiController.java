package thigk2.nguyenthanhtai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thigk2.nguyenthanhtai.model.TheLoaiTin;
import thigk2.nguyenthanhtai.model.Tin;
import thigk2.nguyenthanhtai.repository.TheLoaiTinRepository;
import thigk2.nguyenthanhtai.repository.TinRepository;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private TheLoaiTinRepository theLoaiTinRepository;

	@Autowired
	private TinRepository tinRepository;

	@GetMapping("/theloai")
	public List<TheLoaiTin> getDanhSachTheLoai() {
		return theLoaiTinRepository.findAll();
	}

	@GetMapping("/tin/{id}")
	public List<Tin> getTinByTheLoai(@PathVariable Long id) {
		return tinRepository.findByTheLoaiTinId(id);
	}
}
