package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.services.PageService;

@RestController
public class APIPageController {
	// Để sử dụng repos, ta phải Inject
	@Autowired
	PageService pService;

	@GetMapping("restAPI/pages/all")
	public List<Page> getAllPage() {
		List<Page> dsTrang = new ArrayList<Page>();
		// Test
//		dsTrang.add(new Page(0, "ten Trang", "Tu khoa", "noi dung", 0));
//		dsTrang = (ArrayList<Page>) pRepos.findAll();
		dsTrang = pService.getAllPages();
		return dsTrang;
	}
}
