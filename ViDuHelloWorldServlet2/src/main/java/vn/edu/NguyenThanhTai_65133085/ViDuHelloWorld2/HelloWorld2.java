package vn.edu.NguyenThanhTai_65133085.ViDuHelloWorld2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; // Cần thêm thư viện này để in ra màn hình

/**
 * Servlet implementation class HelloWorld2
 */
@WebServlet("/HelloWorld2")
public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Thiết lập kiểu nội dung trả về là HTML và mã hóa UTF-8 (để hiển thị tiếng Việt)
		response.setContentType("text/html;charset=UTF-8");
		
		// 2. Tạo đối tượng PrintWriter để ghi nội dung phản hồi
		PrintWriter out = response.getWriter();
		
		// 3. Ghi nội dung HTML ra response
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Kết quả HelloWorld 2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Xin chào, đây là Hello World từ phương thức doPost!</h1>");
		out.println("<p>Code được viết bởi: Nguyễn Thanh Tài - 65133085</p>");
		out.println("</body>");
		out.println("</html>");
		
		// Đóng luồng ghi (tùy chọn, server thường tự xử lý)
		// out.close(); 
	}

}