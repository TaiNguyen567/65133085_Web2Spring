package vn.edu.NguyenThanhTai_651330085.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class AboutMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AboutMeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Xử lý lỗi font chữ tiếng Việt
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 1. Chuẩn bị dữ liệu
		String fullName = "Nguyễn Thành Tài";
		String mssv = "651330085";
		String jobTitle = "Sinh Viên CNTT - Lớp Web 2 Spring";
		String bio = "Xin chào! Mình là Tài. Hiện mình đang học môn Phát triển ứng dụng Web 2 "
				+ "với mong muốn trở thành một Full-stack Developer chuyên nghiệp.";

		String[] skills = { "Java Core", "Jakarta EE (Tomcat 10)", "HTML5/CSS3", "Eclipse IDE" };
		String email = "tai.nt.65cntt@ntu.edu.vn";
		String githubLink = "https://github.com/TaiNguyen567";

		// 2. Đẩy dữ liệu sang file JSP
		request.setAttribute("name", fullName);
		request.setAttribute("mssv", mssv);
		request.setAttribute("job", jobTitle);
		request.setAttribute("bio", bio);
		request.setAttribute("skills", skills);
		request.setAttribute("email", email);
		request.setAttribute("github", githubLink);

		// 3. Chuyển hướng về trang giao diện index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}