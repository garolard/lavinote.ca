<%@page import="java.text.DecimalFormat"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Vino"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>La vinote.ca</title>
        <meta charset="utf-8" />
        <meta http-equiv="content-language" content="es">
        <link rel="stylesheet" type="text/css" href="../css/index.css" />
        <link rel="stylesheet" type="text/css" href="../css/user.css" />
        <script type="text/javascript">
        	function validarFormulario() {
        		var valido = true;
        		var inputs = document.getElementsByClassName("inputCantidad");
        		
        		/*for ( var iterable_element in inputs) {
					if ( isNaN(inputs[iterable_element].value) ) {
						alert("Las cantidades deben ser números enteros.");
						valido = false;
						break;
					}
				}*/
        		
        		return valido;
        	}
        	
        	/*window.onload = function() {
        		var formularioAgregar = document.getElementById("agregarCarritoForm");
        		formularioAgregar.addEventListener("submit", validarFormulario, false);
        	}*/
        </script>
    </head>
    <%
    	Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
    	Float precioCalculado = 0f;
    %>
    <body>
        <div id="header">
            <img src="../img/logo.png" alt="La Vinote.ca" />
        </div>
        <div id="login-form-container">
            <form id="login-form">
                <p>Usuario: <input type="text" name="usuario" /> Contraseña: <input type="password" name="usuarioclave" /> <a href="#">Loguearse</a> | <a href="#">Registrarse</a></p>
            </form>
        </div>
        <div id="section">
            <div id="article">
                <div id="user-history-container">
                    <h2 class="home-vine-container-header">Mis Pedidos</h2>
                    <ul class="overflow-item-list">
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                    </ul>
                </div>
                <div id="user-lists-container">
                    <!-- Insertar contenido dinámico del cuerpo de la página -->
                    <h2 class="home-vine-container-header">Mi Carrito</h2>
                    <ul class="overflow-item-list">
                    	<form id="agregarCarritoForm" action="ConfirmarCarrito" method="post">
                        <!-- Usar el li como plantilla para items -->
                        <%
                        for (Map.Entry<Vino, Integer> entryset : carrito.entrySet()) {
                        	Vino vino = entryset.getKey();
                        %>
                        <li>
                            <div class="home-vine-item">
                                <img src="../<%= vino.getRutaImagen() %>" width="100" height="100" />
                                <p class="home-vine-item-info-first-line"><%= vino.getNombre() %></p>
                                <p><%= vino.getPrecioUnitario() %> €</p>
                                <p><input class="inputCantidad" type="text" size="3" maxlength="3" value="1"></input></p>
                                <p><a href="./carrito/eliminar?id=<%= vino.getId() %>">Quitar del carrito</a></p>
                            </div>
                        </li>
                        <%
                        	precioCalculado += vino.getPrecioUnitario();
                        } // FIN DEL FOR
                        %>
                    </ul>
                    <div id="user-cart-total-container">
                        <span class="hero-text">Total: <%= new DecimalFormat("#.##").format(precioCalculado) %> €</span><br />
                        <input id="user-add-to-cart" type="submit" name="agregar-carrito" value="Aceptar pedido" onclick="javascript: return validarFormulario()" />
                    </div>
                    </form>
                </div>
            </div>
            <div id="aside">
                <ul>
                    <li>Vinos blancos</li>
                    <li>Vinos tintos</li>
                    <li>Vinos rosados</li>
                </ul>
            </div>
        </div>
    </body>
</html>