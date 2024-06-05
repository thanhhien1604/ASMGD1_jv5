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
        <jsp:include page="../views/navbar.jsp"></jsp:include>
    </div>
    <div class="row">
        <div class="col-sm-2 mt-5">
            <jsp:include page="../views/navbarcoll.jsp"></jsp:include>
        </div>

        <div class="col-sm-10">
            <div>
                Quuyen :${sessionScope.quyen}
            </div>
            <div>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="mt-5">
                                <form action="/taoHoaDon" method="post">
                                    <button type="submit" class="btn btn-outline-info">Tạo hóa đơn</button>
                                </form>

                            </div>

                            <h6 class="mt-2">Hóa đơn</h6>
                            <div class="table">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <th>ID</th>
                                    <th>Ngày tạo</th>
                                    <th>Tên nhân viên</th>
                                    <th>Trạng thái</th>
                                    <thead>
                                    <tbody>
                                    <c:forEach varStatus="i" var="item" items="${dataHoaDon}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.ma}</td>
                                            <td>${item.ten}</td>
                                            <td>${item.trangThai}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <h6>Giỏ hàng</h6>
                            <div class="table">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <th>ID</th>
                                    <th>Mã SP</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Màu Sắc</th>
                                    <th>Kích thước</th>
                                    <th>Số luượng</th>
                                    <th>Đơn giá</th>
                                    <th>Thành tiền</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach varStatus="i" var="item" items="${dataGioHang}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.ma}</td>
                                            <td>${item.ten}</td>
                                            <td>${item.ten}</td>
                                            <td>${item.ten}</td>
                                            <td>${item.soLuong}</td>
                                            <td>${item.donGia}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <h6>Sản phẩm chi tiết</h6>
                            <div class="table">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <th>ID</th>
                                    <th>Mã San Pham Chi Tiết</th>
                                    <th>Màu Sắc</th>
                                    <th>Kích thước</th>
                                    <th>Tên Sản Phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach varStatus="i" var="item" items="${data}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.maSPCT}</td>
                                            <td>${item.mauSac.ten}</td>
                                            <td>${item.kichThuoc.ten}</td>
                                            <td>${item.sanPham.ten}</td>
                                            <td>${item.soLuong}</td>
                                            <td>${item.donGia}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div class="col-sm-4 custom-border mt-5">
                            <form>
                                <label class="form-label">Mã hóa đơn: </label>
                                <br>
                                <label class="form-label">Ngày tạo: </label>
                                <br>
                                <label class="form-label">Tên nhân viên: </label>
                                <br>
                                <label class="form-label">Tổng tiền: </label>
                                <br>
                                <label class="form-label">Thành tiền: </label>
                                <input type="text" class="form-control">
                                <br>
                                <label class="form-label">Tiền dư: </label>
                                <br>
                                <button type="submit" class="btn btn-primary">Thanh toán</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <jsp:include page="../views/footer.jsp"></jsp:include>
    </div>
</div>
</body>