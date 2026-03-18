package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories.PageRepository;

@RestController
public class APIPageController {
	// Để sử dụng repo, ta phải Inject
	@Autowired
	PageRepository pRepos;

	@GetMapping("restAPI/pages/all")
	public ArrayList<Page> getAllPage() {
		ArrayList<Page> dsTrang = new ArrayList<Page>();
		// Test
//		dsTrang.add(new Page(0, "ten Trang", "Tu khoa", "noi dung", 0));
		dsTrang = (ArrayList<Page>) pRepos.findAll();
		return dsTrang;
	}
}
