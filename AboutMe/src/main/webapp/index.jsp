<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin sinh viên - Nguyễn Thành Tài</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="card">
			<div class="card-header">
				<img src="${pageContext.request.contextPath}/images/avatar.jpg"
					alt="Profile Image" class="profile-img">
			</div>

			<div class="card-body">
				<h2 class="name">${name}</h2>
				<p style="color: #666; font-size: 0.9em; margin-top: -5px;">MSSV:
					${mssv}</p>

				<h4 class="job-title">${job}</h4>
				<p class="bio">${bio}</p>

				<div class="skills-section">
					<h3>Kỹ năng</h3>
					<div class="skills-list">
						<% 
                        String[] skills = (String[]) request.getAttribute("skills");
                        if(skills != null) {
                            for(String s : skills) {
                        %>
						<span class="skill-tag"><%=s %></span>
						<% 
                            }
                        }
                        %>
					</div>
				</div>
			</div>

			<div class="card-footer">
				<a href="mailto:${email}" class="btn btn-primary"><i
					class="fas fa-envelope"></i> Email</a> <a href="${github}"
					class="btn btn-secondary" target="_blank"><i
					class="fab fa-github"></i> Github</a>
			</div>
		</div>
	</div>

</body>
</html>