<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="content-language" content="es">
        <link rel="stylesheet" type="text/css" href="../../css/index.css" />
        <link rel="stylesheet" type="text/css" href="../../css/register.css" />
    </head>
    <body>
        <div id="header">
            <img src="../../img/logo.png" alt="La Vinote.ca" />
        </div>
        <div id="login-form-container">
        </div>
        <div id="section">
            <div id="article">
                <div id="home-vine-containers">
                    <!-- Insertar contenido dinámico del cuerpo de la página -->
                    <form id="register-form" action="../usuario/registrar" method="post">
                        <ul>
                        <li><p>Nombre:<input type="text" name="nombre" /></p></li>
                        <li><p>Apellido<input type="text" name="apellido" /></p></li>
                        <li><p>Correo electrónico<input type="text" name="correo" /></p></li>
                        <li><p>Contraseña<input type="password" name="contrasenha" /></p></li>
                        <li><p>Dirección<input type="text" name="direccion" /></p></li>
                        <li><p>DNI<input type="text" name="dni" /></p></li>
                        <!-- <li><p>Fecha de nacimiento<input type="date" name="fechaNacimiento" /></p></li> -->
                        <li><p>Teléfono fijo<input type="tel" name="tfnoFijo" /></p></li>
                        <li><p>Teléfono principal<input type="tel" name="tfnoPrincipal" /></p></li>
                        <li><p>Código postal<input type="text" name="codigoPostal" /></p></li>
                        <li><input type="submit" name="Registrarme" /></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
	</body>
</html>