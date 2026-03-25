package thiGK.ntu65133085.nguyenthanhtai_fitCMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories.PageRepository;

@Service
public class PageService {
	@Autowired
	PageRepository pRepos;

	// Dịch vụ lấy danh sách về tất cả các trang
	public List<Page> getAllPages() {
		return pRepos.findAll();
	}

//	Dịch vụ lấy thông tin theo từng trang (theo ID)
	public Page getPageByID(int id) {
		return pRepos.getById(id);
//		return pRepos.findById(id).orElse(null);
	}
}
