package thithugk2.NguyenThanhTai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thithugk2.NguyenThanhTai.model.SanPham;
import thithugk2.NguyenThanhTai.repository.SanPhamRepository;

@Service
public class SanPhamService {
	@Autowired
	private SanPhamRepository repo;

	public List<SanPham> getAll() {
		return repo.findAll();
	}

	public void save(SanPham sp) {
		repo.save(sp);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public SanPham getById(Long id) {
		return repo.findById(id).orElse(null);
	}
}