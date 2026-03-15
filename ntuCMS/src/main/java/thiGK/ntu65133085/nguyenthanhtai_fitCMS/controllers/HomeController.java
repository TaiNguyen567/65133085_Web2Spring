package thiGK.ntu65133085.nguyenthanhtai_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Page;
import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Post;

@RestController
public class HomeController {

	ArrayList<Page> dsTrang = new ArrayList<Page>();
	ArrayList<Post> dsBaiViet = new ArrayList<Post>();

	public HomeController() {
		dsTrang.add(new Page(1, "Trang chủ", "home", "Nội dung trang chủ", 0));
		dsTrang.add(new Page(2, "Giới thiệu", "about", "Giới thiệu về chúng tôi", 0));

		dsBaiViet.add(new Post(1, "Bài viết 1", "Nội dung bài 1", 10));
		dsBaiViet.add(new Post(2, "Bài viết 2", "Nội dung bài 2", 10));
	}

	@GetMapping({ "/", "/dashboard", "/dasdboard", "/dash-board" })
	public String home() {
		return "index";
	}

	@GetMapping("/api/pages")
	public String getAllPages(ModelMap m) {
		m.addAttribute("listPages", dsTrang);
		return "allPage";
	}

	@GetMapping("/page/new")
	public String showNewPageForm(ModelMap m) {
		m.addAttribute("page", new Page());
		return "newPage";
	}

	@PostMapping("/page/new")
	public String savePage(@ModelAttribute("page") Page newPage) {
		dsTrang.add(newPage);
		return "redirect:/page/all";
	}

	@GetMapping("/page/view/{id}")
	public String viewPage(@PathVariable("id") int id, ModelMap m) {
		Page foundPage = dsTrang.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		m.addAttribute("page", foundPage);
		return "viewPage";
	}

	@GetMapping("/page/delete/{id}")
	public String deletePage(@PathVariable("id") int id) {
		dsTrang.removeIf(p -> p.getId() == id);
		return "redirect:/page/all";
	}

	@GetMapping("/post/all")
	public String getAllPosts(ModelMap m) {
		m.addAttribute("listPosts", dsBaiViet);
		return "allPost";
	}

	@GetMapping("/post/new")
	public String showNewPostForm(ModelMap m) {
		m.addAttribute("post", new Post());
		return "newPost";
	}

	@PostMapping("/post/new")
	public String savePost(@ModelAttribute("post") Post newPost) {
		dsBaiViet.add(newPost);
		return "redirect:/post/all";
	}

	@GetMapping("/post/view/{id}")
	public String viewPost(@PathVariable("id") int id, ModelMap m) {
		Post foundPost = dsBaiViet.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		m.addAttribute("post", foundPost);
		return "viewPost";
	}

	@GetMapping("/post/delete/{id}")
	public String deletePost(@PathVariable("id") int id) {
		dsBaiViet.removeIf(p -> p.getId() == id);
		return "redirect:/post/all";
	}
}