package thigk2.nguyenthanhtai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyenthanhtai.model.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
	NguoiDung findByUsernameAndPassword(String username, String password);
}
