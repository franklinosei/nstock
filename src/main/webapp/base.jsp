<%-- 
    Document   : base
    Created on : May 27, 2023, 2:49:19 PM
    Author     : iamdveloper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>NStock</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


        <!--         Fontawesomw 
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        -->

        <!-- Local CSS -->
        <link rel="stylesheet" type="text/css" href="./assets/styles/template-style.css" >
        <link rel="stylesheet" type="text/css" href="./assets/styles/styles.css" >

        <!--Google Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    </head>
    <body id="page-top">


        <div id="wrapper">

            <div class="sidebar">
                <%@ include file="sidebar.jsp" %>
            </div>




            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <%--<%@ include file="navbar.jsp"%>--%>


                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <jsp:include page="${contentName}" flush="true"></jsp:include>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!--<script src="./assets/js/script.js"></script>-->

    </body>
</html > 
