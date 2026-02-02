package vn.edu.NguyenThanhTai_651330085.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Đường dẫn URL để truy cập trang web
@WebServlet("/profile") 
public class AboutMeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Chuẩn bị dữ liệu (Giả lập lấy từ Database)
        String fullName = "Nguyễn Văn A";
        String jobTitle = "Sinh Viên CNTT & Java Developer";
        String bio = "Xin chào! Tôi là sinh viên năm 3 chuyên ngành Kỹ thuật phần mềm. "
                   + "Tôi đam mê xây dựng các ứng dụng web hiệu năng cao và thiết kế giao diện người dùng.";
        
        String[] skills = {"Java Core", "Servlet/JSP", "HTML5/CSS3", "MySQL", "Git"};
        String email = "contact@student.edu.vn";
        String githubLink = "https://github.com/yourusername";

        // 2. Đóng gói dữ liệu vào request để gửi sang JSP
        request.setAttribute("name", fullName);
        request.setAttribute("job", jobTitle);
        request.setAttribute("bio", bio);
        request.setAttribute("skills", skills);
        request.setAttribute("email", email);
        request.setAttribute("github", githubLink);

        // 3. Chuyển hướng (Forward) sang trang giao diện (JSP)
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
