package thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
	// JpaRepository đã tự động code sẵn các hàm thêm, sửa, xóa, tìm kiếm cho bạn
}