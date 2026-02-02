<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tính BMI</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; display: flex; justify-content: center; padding-top: 50px; }
        .card { background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); width: 350px; }
        h2 { text-align: center; color: #1a73e8; margin-top: 0; }
        .input-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: 600; color: #555; }
        input[type="text"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 6px; box-sizing: border-box; }
        .btn-submit { width: 100%; padding: 12px; background-color: #1a73e8; color: white; border: none; border-radius: 6px; font-size: 16px; cursor: pointer; transition: 0.3s; }
        .btn-submit:hover { background-color: #1557b0; }
        
        .result-section { margin-top: 20px; padding: 15px; background-color: #e8f0fe; border-radius: 8px; text-align: center; }
        .bmi-number { font-size: 2em; color: #c5221f; font-weight: bold; margin: 10px 0; }
        .error-msg { color: red; text-align: center; margin-top: 10px; }
    </style>
</head>
<body>

    <div class="card">
        <h2>BMI Calculator</h2>
        
        <form action="BMI" method="post">
            <div class="input-group">
                <label>Chiều cao (m)</label>
                <input type="text" name="height" value="${old_h}" placeholder="VD: 1.70" required>
            </div>
            
            <div class="input-group">
                <label>Cân nặng (kg)</label>
                <input type="text" name="weight" value="${old_w}" placeholder="VD: 65" required>
            </div>
            
            <button type="submit" class="btn-submit">Tính Ngay</button>
        </form>

        <% if(request.getAttribute("KQ_BMI") != null) { %>
            <div class="result-section">
                <div>Chỉ số của bạn:</div>
                <div class="bmi-number">${KQ_BMI}</div>
                <div>Phân loại: <b>${KQ_PhanLoai}</b></div>
            </div>
        <% } %>
        
        <div class="error-msg">${KQ_Msg}</div>
    </div>

</body>
</html>