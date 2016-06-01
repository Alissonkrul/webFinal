<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="company" scope="request" class="models.entities.Company" />

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
            <span class="title">WEB <small>- WEB II</small></span>
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
                        <li><a href="empresas.jsp">empresas</a></li>
                        <li><a href="funcionarios.jsp">Funcionarios</a></li>          
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>   Editar Empresa</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Form -->
        <div class="form">
            <form action="EmpresaController?type=update" method="POST" role="form">
               
                <input type="hidden" value='${fn:escapeXml(company.id)}' class="form-control" name="id"/>
               
               <div class="form-group">
                    <label>Nome:</label>
                    <input type="text" value='${fn:escapeXml(company.name)}' class="form-control" placeholder="Nome" name="name"/>
                </div>
                <div class="form-group">
                    <label>Cnpj</label>
                    <input type="text" value='${fn:escapeXml(company.cnpj)}' class="form-control" placeholder="Cnpj" name="cnpj"/>
                </div>
                 <div class="form-group">
                    <label>Endereco</label>
                    <input type="text" value='${fn:escapeXml(company.endereco)}' class="form-control" placeholder="Endereco" name="endereco"/>
                </div>
                 <div class="form-group">
                    <label>Razao Social</label>
                    <input type="text" value='${fn:escapeXml(company.razaoSocial)}' class="form-control" placeholder="RazaoSocial" name="razaoSocial"/>
                </div>
                 <div class="form-group">
                    <label>Email</label>
                    <input type="text" value='${fn:escapeXml(company.email)}' class="form-control" placeholder="Email" name="email"/>
                </div>
                <div>
                    <button type="submit" class="btn btn-info">Salvar</button>
                    <a href="portal.jsp"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
