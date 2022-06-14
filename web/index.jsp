<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>오픈소스프로젝트_8팀</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet"/>
    <%@ page import="test.ApiExplorer" %>
    <%@ page import="test.Item" %>
    <%@ page import="java.util.*" %>

    <script type="text/javascript">

        function keyword_check() {//검색창
            if (document.search.search_value.value == '') { //검색어가 없을 경우
                alert('검색어를 입력하세요'); //경고창 띄움
                document.search.search_value.focus(); //다시 검색창으로 돌아감
                return false;
            } else return true;
        }

    </script>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String search_value, searchField;
    search_value = request.getParameter("search_value");
    searchField = request.getParameter("searchField");
    ApiExplorer ae = new ApiExplorer();
    if (search_value == null) {//임시
        search_value = "닥터베아제정";
    }
    if (searchField == null) {//임시
        searchField = "itmname";
    }
    System.out.println("search_value : " + search_value);
    System.out.println("searchField : " + searchField);
    ArrayList<Item> list = ae.getItemList(search_value, searchField); //검색정보값
    List<String> itmname_all = new ArrayList<>();
    for (Item xx : list) {
        itmname_all.add(xx.getItemName());
    }
    request.setAttribute("itmname_all", itmname_all);//천제 검색기록값의 제품 이름을 배열로 저장

%>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#!">medicine community</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <%--            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">--%>
            <%--                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>--%>
            <%--                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>--%>
            <%--                <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>--%>
            <%--                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Blog</a></li>--%>
            <%--            </ul>--%>
        </div>
    </div>
</nav>
<!-- Page content-->
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-8">
            <!-- Post content-->
            <article>
                <!-- Post header-->
                <header class="mb-4">
                    <!-- Post title-->
                    <h1 class="fw-bolder mb-1"><%=list.get(0).getItemName()%>
                    </h1>
                    <!-- Post meta content-->
                    <div class="text-muted fst-italic mb-2"><%=list.get(0).entpName%>
                    </div>
                    <!-- Post categories-->


                </header>
                <!-- Preview image figure-->
                <figure class="mb-4"><img class="img-fluid rounded" src=<%=list.get(0).getItemImage()%> alt="..."/>
                </figure>
                <!-- Post content-->
                <section class="mb-5">
                    <h2 class="fw-bolder mb-4 mt-5">효능</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getEfcyQesitm()%>
                    </p>
                    <h2 class="fw-bolder mb-4 mt-5">사용법</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getUseMethodQesitm()%>
                    </p>
                    <h2 class="fw-bolder mb-4 mt-5">주의 사항</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getAtpnQesitm()%>
                    </p>
                    <h2 class="fw-bolder mb-4 mt-5">이상반응</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getSeQesitm()%>
                    </p>
                    <h2 class="fw-bolder mb-4 mt-5">보관방법</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getDepositMethodQesitm()%>
                    </p>
                    <h2 class="fw-bolder mb-4 mt-5">같이 복용하면 안되는 약 또는 음식</h2>
                    <p class="fs-5 mb-4"><%=list.get(0).getIntrcQesitm()%>
                    </p>
                </section>
            </article>
            <!-- Comments section-->
            <section class="mb-5">
                <div class="card bg-light">
                    <div class="card-body">
                        <!-- Comment form-->
                        <form class="mb-4"><textarea class="form-control" rows="3"
                                                     placeholder="Join the discussion and leave a comment!"></textarea>
                        </form>
                        <!-- Comment with nested comments-->
                        <div class="d-flex mb-4">
                            <!-- Parent comment-->
                            <div class="flex-shrink-0"><img class="rounded-circle"
                                                            src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                            alt="..."/></div>
                            <div class="ms-3">
                                <div class="fw-bold">Commenter Name</div>
                                If you're going to lead a space frontier, it has to be government; it'll never be
                                private enterprise. Because the space frontier is dangerous, and it's expensive, and it
                                has unquantified risks.
                                <!-- Child comment 1-->
                                <div class="d-flex mt-4">
                                    <div class="flex-shrink-0"><img class="rounded-circle"
                                                                    src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                                    alt="..."/></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Commenter Name</div>
                                        And under those conditions, you cannot establish a capital-market evaluation of
                                        that enterprise. You can't get investors.
                                    </div>
                                </div>
                                <!-- Child comment 2-->
                                <div class="d-flex mt-4">
                                    <div class="flex-shrink-0"><img class="rounded-circle"
                                                                    src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                                    alt="..."/></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Commenter Name</div>
                                        When you put money directly to a problem, it makes a good headline.
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Single comment-->
                        <div class="d-flex">
                            <div class="flex-shrink-0"><img class="rounded-circle"
                                                            src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                            alt="..."/></div>
                            <div class="ms-3">
                                <div class="fw-bold">Commenter Name</div>
                                When I look at the universe and all the ways the universe wants to kill us, I find it
                                hard to reconcile that with statements of beneficence.
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
            <!-- Search widget-->
            <div class="card mb-4">
                <div class="card-header">Search</div>
                <div class="card-body">
                    <div class="input-group">
                        <form name="search" action="index.jsp" onsubmit="return keyword_check()">
                            <td><select class="form-control" name="searchField">
                                <option value="itmname">상품이름</option>
                                <option value="symptom">증상</option>
                                <option value="manufacturer">제약회사</option>
                            </select></td>
                            <input class="form-control" type="text" placeholder="Enter search term..."
                                   aria-label="Enter search term..." aria-describedby="button-search"
                                   name="search_value"
                            />
                            <button class="btn btn-primary" id="button-search" type="submit" value="search">Go!</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Categories widget-->
<%--            <div class="card mb-4">--%>
<%--                <div class="card-header">Categories</div>--%>
<%--                <div class="card-body">--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-sm-6">--%>
<%--                            <ul class="list-unstyled mb-0">--%>
<%--                                <li><a href="#!">Web Design</a></li>--%>
<%--                                <li><a href="#!">HTML</a></li>--%>
<%--                                <li><a href="#!">Freebies</a></li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-6">--%>
<%--                            <ul class="list-unstyled mb-0">--%>
<%--                                <li><a href="#!">JavaScript</a></li>--%>
<%--                                <li><a href="#!">CSS</a></li>--%>
<%--                                <li><a href="#!">Tutorials</a></li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <!-- Side widget-->
            <div class="card mb-4">
                <div class="card-header">검색결과</div>
                <div class="card-body"><c:forEach var="tmp" items="${requestScope.itmname_all}">
                    <a class="badge bg-secondary text-decoration-none link-light"
                       href='?search_value=${tmp}'>${tmp}</a>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
