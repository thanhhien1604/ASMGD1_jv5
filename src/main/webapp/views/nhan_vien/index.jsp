<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<html>
<head></head>
<body>
<div class="container-fluide">
    <div class="">
        <jsp:include page="../../views/navbar.jsp"></jsp:include>
    </div>
    <div class="row">
        <div class="col-sm-2 mt-5">
            <jsp:include page="../../views/navbarcoll.jsp"></jsp:include>
        </div>

        <div class="col-sm-10">
            <h1>Quan ly nhan vien</h1>
            <form action="/nhan-vien/tim-kiem" method="post">
                <input value="${valueSearch}" type="text" name="valueSearch" placeholder="Nhập từ khóa">
                <select name="searchStatus">
                    <option <c:if test="${searchStatus eq 1}">selected</c:if> value="1">Dang hoat dong</option>
                    <option <c:if test="${searchStatus eq 0}">selected</c:if>  value="0">Ngưng hoat dong</option>
                </select>
                <button type="submit" class="btn btn-light">Tìm kiếm</button>
            </form>
            <a href="/nhan-vien/create">
                <button class="btn btn-success">Them</button>
            </a>
            <table class="table">
                <thead>
                <th>#</th>
                <th>ID</th>
                <th>Ma</th>
                <th>Ten</th>
                <th>Ten dang nhap</th>
                <th>Mat khau</th>
                <th>Trang thai</th>
                <th>Hanh động</th>
                </thead>
                <tbody>
                <c:forEach varStatus="i" var="item" items="${data}">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${item.id}</td>
                        <td>${item.ma}</td>
                        <td>${item.ten}</td>
                        <td>${item.tenDangNhap}</td>
                        <td>${item.matKhau}</td>
                        <td>${item.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                        <td>
                            <a href="/nhan-vien/delete/${item.id}">
                                <button class="btn btn-danger">Xóa</button>
                            </a>
                            <a href="/nhan-vien/edit/${item.id}">
                                <button class="btn btn-warning">Chỉnh sửa</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${totalPages > 0}">
                <c:if test="${currentPage > 0}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}"><<</a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 0}">
                    <li class="page-item disabled">
                        <span class="page-link"><<</span>
                    </li>
                </c:if>
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <li class="page-item <c:if test="${currentPage == i}">active</c:if>">
                        <a class="page-link" href="?page=${i}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage < totalPages - 1}">
                    <li class="page-item">
                        <a class="page-link"  href="?page=${currentPage + 1}">>></a>
                    </li>
                </c:if>
                <c:if test="${currentPage == totalPages - 1}">
                    <li class="page-item">
                        <a class="page-link"  href="?page=0">>></a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
    <div>
        <jsp:include page="../../views/footer.jsp"></jsp:include>
    </div>

</div>
</body>
</html>