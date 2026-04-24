package thigk2.nguyenthanhtai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyenthanhtai.model.Tin;

public interface TinRepository extends JpaRepository<Tin, Long> {
	List<Tin> findByTheLoaiTinId(Long id);
}
