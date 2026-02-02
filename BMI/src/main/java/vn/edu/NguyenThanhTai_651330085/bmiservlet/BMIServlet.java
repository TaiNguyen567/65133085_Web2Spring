package vn.edu.NguyenThanhTai_651330085.bmiservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BMI")
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BMIServlet() {
		super();
	}

	// 1. Chạy khi mở trình duyệt (GET) -> Hiện Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/bmi.jsp").forward(request, response);
	}

	// 2. Chạy khi bấm nút Tính (POST) -> Xử lý
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String heightStr = request.getParameter("height");
		String weightStr = request.getParameter("weight");

		Double bmi = null;
		String phanLoai = "";
		String msg = "";

		try {
			double h = Double.parseDouble(heightStr);
			double w = Double.parseDouble(weightStr);

			// Tính BMI
			bmi = w / (h * h);

			// Phân loại
			if (bmi < 18.5)
				phanLoai = "Gầy";
			else if (bmi < 24.9)
				phanLoai = "Bình thường";
			else if (bmi < 29.9)
				phanLoai = "Thừa cân";
			else
				phanLoai = "Béo phì";

			// Làm tròn 2 số lẻ
			bmi = Math.round(bmi * 100.0) / 100.0;

		} catch (Exception e) {
			msg = "Lỗi nhập liệu: Phải nhập số!";
		}

		// Đẩy kết quả về trang JSP
		request.setAttribute("KQ_BMI", bmi);
		request.setAttribute("KQ_PhanLoai", phanLoai);
		request.setAttribute("KQ_Msg", msg);

		// Giữ lại số vừa nhập
		request.setAttribute("old_h", heightStr);
		request.setAttribute("old_w", weightStr);

		request.getRequestDispatcher("/bmi.jsp").forward(request, response);
	}
}