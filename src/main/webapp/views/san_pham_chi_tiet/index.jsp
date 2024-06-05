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
            <h1>Quan ly san pham chi tiet</h1>
            <a href="/san-pham-chi-tiet/create"><button class="btn btn-success">Them</button></a>


            <div class="col-md-3">
                <form method="get" action="/san-pham-chi-tiet/index" name="SPCT">
                    <label>Chọn Sản Phẩm:</label>
                    <select class="form-select" name="sanPham">
                        <c:forEach var="spct" items="${data.content}">
                            <option value="${spct.id}">${spct.sanPham.ten}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-success">Tìm</button>
                </form>

            </div>

            <table class="table">
                <thead>
                <th>#</th>
                <th>ID</th>
                <th>Ma san pham chi tiet</th>
                <th>Mau Sac</th>
                <th>Kich Thuoc</th>
                <th>San pham</th>
                <th>So luong</th>
                <th>Don gia</th>
                <th>Trang thai</th>
                <th>Hanh động</th>
                </thead>
                <tbody>
                <c:forEach varStatus="i" var="item" items="${data.content}">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${item.id}</td>
                        <td>${item.maSPCT}</td>
                        <td>${item.mauSac.ten}</td>
                        <td>${item.kichThuoc.ten}</td>
                        <td>${item.sanPham.ten}</td>
                        <td>${item.soLuong}</td>
                        <td>${item.donGia}</td>
                        <td>${item.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                        <td>
                            <a href="/san-pham-chi-tiet/delete/${item.id}">
                                <button class="btn btn-danger">Xóa</button>
                            </a>
                            <a href="/san-pham-chi-tiet/edit/${item.id}">
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
                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}"><<</a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 1}">
                    <li class="page-item disabled">
                        <span class="page-link"><<</span>
                    </li>
                </c:if>

                <!-- Logic for displaying page numbers with "..." -->
                <c:choose>
                    <c:when test="${totalPages <= 5}">
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <li class="page-item ${currentPage == i ? 'active' : ''}">
                                <a class="page-link" href="?page=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item ${currentPage == 1 ? 'active' : ''}">
                            <a class="page-link" href="?page=1">1</a>
                        </li>
                        <c:if test="${currentPage > 3}">
                            <li class="page-item disabled">
                                <span class="page-link">...</span>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="${currentPage - 1}" end="${currentPage + 1}">
                            <c:if test="${i > 1 && i < totalPages}">
                                <li class="page-item ${currentPage == i ? 'active' : ''}">
                                    <a class="page-link" href="?page=${i}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${currentPage < totalPages - 2}">
                            <li class="page-item disabled">
                                <span class="page-link">...</span>
                            </li>
                        </c:if>
                        <li class="page-item ${currentPage == totalPages ? 'active' : ''}">
                            <a class="page-link" href="?page=${totalPages}">${totalPages}</a>
                        </li>
                    </c:otherwise>
                </c:choose>

                <c:if test="${currentPage < totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}">>></a>
                    </li>
                </c:if>
                <c:if test="${currentPage == totalPages}">
                    <li class="page-item disabled">
                        <span class="page-link">>></span>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
    <div class="mt-5">
        <jsp:include page="../../views/footer.jsp"></jsp:include>
    </div>
</div>

</body>
</html>