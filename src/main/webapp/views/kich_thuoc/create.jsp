<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<html>
<head></head>
<body>
<h1>Quan ly kich thuoc</h1>
<form method="POST" action="/kich-thuoc/store">

    <div class="mb-3">
        <label>Mã</label>
        <input type="text" name="ma" value="${data.ma}">
        <c:if test="${not empty errors['ma']}">
            <span style="color: red">${errors['ma']}</span>
        </c:if>
    </div>

    <div class="mb-3">
        <label>Tên</label>
        <input type="text" name="ten" value="${data.ten}">
        <c:if test="${not empty errors['ten']}">
            <span style="color: red">${errors['ten']}</span>
        </c:if>
    </div>

    <div class="mb-3">
        <label>Trạng thái</label>
        <select name="trangThai">
            <option value="1">Đang hoạt động</option>
            <option value="0">Ngừng hoạt động</option>
        </select>
    </div>

    <button type="submit" class="btn btn-outline-dark">Lưu</button>
</form>
</body>
</html>