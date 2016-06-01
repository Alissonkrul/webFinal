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
        <title>WEB</title>
    </head>
    <body>
        <!-- Header -->
        <div class="header">
            <span class="title">WEB <small>- WEB Final</small></span>
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
                        <li><a href="empresas.jsp">Empresas</a></li>
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>   Adicionar Funcionário</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Form -->
        <div class="form">
            <form action="FuncionarioController?type=add" method="POST" role="form">
                <div class="form-group">
                    <label>Nome:</label>
                    <input type="text" class="form-control" placeholder="nome" name="nome"/>
                </div>
                <div class="form-group">
                    <label>CPF</label>
                    <input type="text" class="form-control" placeholder="cpf" name="cpf"/>
                </div>
                 <div class="form-group">
                    <label>Endereco</label>
                    <input type="text" class="form-control" placeholder="endereco" name="endereco"/>
                </div>
                 <div class="form-group">
                    <label>Celular</label>
                    <input type="text" class="form-control" placeholder="celular" name="celular"/>
                </div>
                 <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" placeholder="email" name="email"/>
                </div>
               
                <div>
                    <button type="submit" class="btn btn-info">Adicionar</button>
                    <a href="portal.jsp"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
