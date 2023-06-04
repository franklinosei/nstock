<%-- 
    Document   : unauthorized
    Created on : Jun 4, 2023, 11:48:36 AM
    Author     : iamdveloper
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>NStock</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


        <!--         Fontawesome
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        -->

        <!-- Local CSS -->
        <link rel="stylesheet" type="text/css" href="./assets/styles/template-style.css" >
        <link rel="stylesheet" type="text/css" href="./assets/styles/styles.css" >

        <!--Google Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">

    </head>
    <body class="center-div">

        <div class="container">
            <div class="row justify-content-center">

                <div class="col-md-6 shadow p-4">

                    <h2 class="text-center mb-4">You are not authorized to access this page</h2>

                    <div class="text-center">
                        <a href="/nstock/dashboard">
                            <button type="submit" class="btn btn-primary">Go Back Home</button>
                        </a>
                    </div>

                </div>
            </div>
        </div>


        <!-- Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html > 
