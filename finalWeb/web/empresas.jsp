<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">
        <script src="bootstrap-3.3.6-dist/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <title>DOR</title>
    </head>
    <body>
        <!-- Header -->
        <div class="header">
            <span class="title">WEB - Final <small>- Empresas -</small></span>
            <span class="log-out"><a href="LogoutProcess"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></span>  
        </div>
        <!-- Navbar -->
        <nav class="navbar navbar-default menu">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Menu</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="empresas.jsp">Empresas <span class="sr-only">(atual)</span></a></li>
                        <li><a href="companies.jsp">Empresas</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Section Header -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>    Empresaes</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <a href="addEmpresa.jsp"><button type="button" class="btn btn-info navbar-btn">Adicionar</button></a>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Table -->
        <table class="table table-hover my-table">
            <thead>
                <tr>
                    <td><b>#</b></td>
                    <td><b>Nome</b></td>
                    <td><b>CNPJ</b></td>
                    <td><b>Razão Social</b></td>
                    <td><b>Email</b></td>
                    <td><b>Endereco</b></td>
                    <td><b>Editar</b></td>
                </tr>
            </thead>

            <tbody>
                <c:set var="index" value="${1}" scope="page"/>
                <c:set var="empresas" scope="session" value="${listEmpresas}"/>
                <c:forEach items="${listEmpresas}" var="empresa">

                    <tr>
                        <td><c:out value="${index}" /></td>
                        <td><c:out value="${empresa.name}" /></td>
                        <td><c:out value="${empresa.cnpj}" /></td>
                        <td><c:out value="${empresa.razaoSocial}" /></td>
                        <td><c:out value="${empresa.endereco}" /></td>
                        <td><c:out value="${empresa.email}" /></td>
                        <td>
                            
                            <c:url value="EmpresaController?type=get" var="url">
                                <c:param name="empresaId" value="${empresa.id}"/>
                            </c:url>
                            <a href="${url}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
                            </td>
                        </tr>
                        <c:set var="index" value="${index+1}" scope="page"/>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
