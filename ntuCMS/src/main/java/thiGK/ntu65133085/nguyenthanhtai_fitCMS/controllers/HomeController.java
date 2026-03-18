package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Post;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories.PageRepository;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories.PostRepository;

@Controller // Dùng @Controller để trả về file giao diện HTML (Thymeleaf)
public class HomeController {

	// Inject các Repository để kết nối Database
	@Autowired
	private PageRepository pageRepository;

	@Autowired
	private PostRepository postRepository;

	// Trang chủ Dashboard (Tôi thấy trong HTML của bạn có link /dashboard)
	@GetMapping({ "/", "/dashboard" })
	public String dashboard() {
		return "index";
	}

	// ==================== QUẢN LÝ PAGE ====================

	@GetMapping("/page/all")
	public String getAllPages(ModelMap m) {
		m.addAttribute("listPages", pageRepository.findAll()); // Lấy từ Database
		return "allPage";
	}

	@GetMapping("/page/new")
	public String showNewPageForm(ModelMap m) {
		m.addAttribute("page", new Page());
		return "newPage";
	}

	@PostMapping("/page/new")
	public String savePage(@ModelAttribute("page") Page newPage) {
		pageRepository.save(newPage); // Lưu thẳng vào Database
		return "redirect:/page/all";
	}

	@GetMapping("/page/view/{id}")
	public String viewPage(@PathVariable("id") int id, ModelMap m) {
		Page foundPage = pageRepository.findById(id).orElse(null);
		m.addAttribute("page", foundPage);
		return "viewPage";
	}

	@GetMapping("/page/delete/{id}")
	public String deletePage(@PathVariable("id") int id) {
		pageRepository.deleteById(id); // Xóa trong Database
		return "redirect:/page/all";
	}

	// ==================== QUẢN LÝ POST ====================

	@GetMapping("/post/all")
	public String getAllPosts(ModelMap m) {
		m.addAttribute("listPosts", postRepository.findAll());
		return "allPost";
	}

	@GetMapping("/post/new")
	public String showNewPostForm(ModelMap m) {
		m.addAttribute("post", new Post());
		return "newPost"; // (Nhớ đảm bảo bạn có file newPost.html nhé)
	}

	@PostMapping("/post/new")
	public String savePost(@ModelAttribute("post") Post newPost) {
		postRepository.save(newPost);
		return "redirect:/post/all";
	}
}