package vidu.ntu65133085.nguyenthanhtai_vidurestapi.model;

public class Page {
	private long id;
	private String title;
	private String slug;
	private String content;
	private int status;

	public Page() {
	}

	// Constructor đầy đủ tham số
	public Page(long id, String title, String slug, String content, int status) {
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.content = content;
		this.status = status;
	}

	// Getters và Setters (Bắt buộc phải có để Spring Boot có thể chuyển object
	// thành JSON)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}