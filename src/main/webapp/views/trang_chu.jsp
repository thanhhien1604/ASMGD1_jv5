<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<html>
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
         <div>Quuyen :${sessionScope.quyen}</div>
        </div>
    </div>
    <div>
        <jsp:include page="../views/footer.jsp"></jsp:include>
    </div>
</div>

</body>
</html>