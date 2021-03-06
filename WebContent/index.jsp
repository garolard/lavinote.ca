<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Cliente"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Vino"%>
<%@page import="java.util.List"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>lavinote.ca</title>
		<link rel="stylesheet" type="text/css" href="../../css/index.css" />
    </head>
    <%
    	List<Vino> novedades = (List<Vino>)session.getAttribute("novedades");
    	List<Vino> vendidos = (List<Vino>)session.getAttribute("vendidos");
    %>
    <body>
        <div id="header">
            <img src="../../img/logo.png" alt="La Vinote.ca" />
        </div>
        <div id="login-form-container">
            <form id="login-form" action="../usuario/loguear" method="POST">
            <% if (! (Boolean)session.getAttribute("logueado") ) {%>
                <p>Usuario:
                	<input type="text" name="email" /> Contraseña: <input type="password" name="contrasenha" /> <input type="submit" value="Loguearse" /> | <a href="../usuario/registro">Registrarse</a></p>
                </form>
                <p><a href="../carrito/principal">Mi Carrito</a>
            <%} else {%>
            	<p><%= ((Cliente) session.getAttribute("cliente")).getNombre() %> | <a href="../usuario/desloguear">Desloguear</a></p>
            	<p><a href="../carrito/principal">Mi Carrito</a>
            	</form>
            <%} %>
            
        </div>
        <div id="section">
            <div id="article">
                <form action="buscar" method="get" class="search-form">
                    <select>
                        <option value="bodegas">Bodegas</option>
                        <option value="vinos">Vinos</option>
                        <option value="categoria">Categoría</option>
                    </select>
                    <input type="text" placeholder="Buscar vinos..." value="" name="query-text" id="query-input" />
                    <input type="submit" value="Buscar" />
                </form>
                <div id="home-vine-containers">
                    <div class="home-vine-container" id="nuevos-container">
                        <h2 class="home-vine-container-header">Novedades</h2>
                        <div class="home-vine-container-row">
                        	<%
                        	int contador = 0;
                        	for (Vino vino : novedades) { 
                        		if (contador == 6)
                        			break;
                        		if (contador == 3) { %>
                        	</div>
                        <div class="home-vine-container-row">
                        		<%}%>
                        	<div class="home-vine-item">
	                            <img src="../../<%= vino.getRutaImagen() %>" width="100" height="100" />
	                            <p class="home-vine-item-info-first-line"><%= vino.getNombre() %></p>
	                            <p><%= vino.getPrecio() %> €</p>
	                            <a href="agregar?id=<%= vino.getId() %>">Agregar</a>
                            </div>
                        	<%
                        		contador++;
                        	}
                        	%>
                        </div>
                    </div>
                    <p class="home-vine-container-footer">Todas las novedades &gt;</p>
                    <div class="home-vine-container" id="vendidos-container">
                        <h2 class="home-vine-container-header">Más vendidos</h2>
                        <div class="home-vine-container-row">
                        	<%
                        	contador = 0;
                        	for (Vino vino : novedades) { 
                        		if (contador == 6)
                        			break;
                        		if (contador == 3) { %>
                        	</div>
                        <div class="home-vine-container-row">
                        		<%}%>
                        	<div class="home-vine-item">
	                            <img src="../../<%= vino.getRutaImagen() %>" width="100" height="100" />
	                            <p class="home-vine-item-info-first-line"><%= vino.getNombre() %></p>
	                            <p><%= vino.getPrecio() %> €</p>
	                            <a href="agregar?id=<%= vino.getId() %>">Agregar</a>
                            </div>
                        	<%
                        		contador++;
                        	}
                        	%>
                        </div>
                        <!-- div class="home-vine-container-row">
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">Do Ferreiro Cepas Vellas</p>
                                <p>24,95€</p>
                            </div>
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">
                                    Do Ferreiro Cepas Vellas
                                </p>
                                <p>24,95€</p>
                            </div>
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">
                                    Do Ferreiro Cepas Vellas
                                </p>
                                <p>24,95€</p>
                            </div>
                        </div>
                        <div class="home-vine-container-row">
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">Do Ferreiro Cepas Vellas</p>
                                <p>24,95€</p>
                            </div>
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">
                                    Do Ferreiro Cepas Vellas
                                </p>
                                <p>24,95€</p>
                            </div>
                            <div class="home-vine-item">
                                <img src="img/wine-stock.jpg" width="100" height="100" />
                                <p class="home-vine-item-info-first-line">
                                    Do Ferreiro Cepas Vellas
                                </p>
                                <p>24,95€</p>
                            </div>
                        </div -->
                    </div>
                    <p class="home-vine-container-footer">Los más vendidos &gt;</p>
                </div>
            </div>
            <div id="aside">
                <ul>
                    <li><a href="categoria?cat=0">Vinos tintos</a></li>
                    <li><a href="categoria?cat=1">Vinos blancos</a></li>
                    <li><a href="categoria?cat=2">Vinos rosados</a></li>
                </ul>
            </div>
        </div>
    </body>
</html>