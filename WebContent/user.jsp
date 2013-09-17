<%@page import="java.util.LinkedList"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.oldmodel.EstadoPedido"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Vino"%>
<%@page import="es.gabrielferreiro.apps.lavinoteca.model.Cliente"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>La vinote.ca</title>
        <meta charset="utf-8" />
        <meta http-equiv="content-language" content="es">
        <link rel="stylesheet" type="text/css" href="../../css/index.css" />
        <link rel="stylesheet" type="text/css" href="../../css/user.css" />
        <script type="text/javascript">
        	
        </script>
    </head>
    <%
    	Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
    	Cliente cliente = (Cliente) session.getAttribute("cliente");
    	List<Pedido> clientePedidos = cliente.getPedidos();
    	if (clientePedidos == null)
    		clientePedidos = new LinkedList<Pedido>();
    	Float precioCalculado = 0f;
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
                <!-- p><a href="../carrito/principal">Mi Carrito</a -->
            <%} else {%>
            	<p><%= ((Cliente) session.getAttribute("cliente")).getNombre() %> | <a href="../usuario/desloguear">Desloguear</a></p>
            	<!-- p><a href="../carrito/principal">Mi Carrito</a -->
            <%} %>
            </form>
        </div>
        <div id="section">
            <div id="article">
                <div id="user-history-container">
                    <h2 class="home-vine-container-header">Mis Pedidos</h2>
                    <ul class="overflow-item-list">
                    	<% for (Pedido p : clientePedidos) { %>
                        <li>
                        <c:set var="fecha" value="<%= p.getFecha() %>" />
                        <%-- Mostrar el icono de la papelera solo en los estados en los que
                        se pueda eliminar el pedido por el usuario. --%>
                            <p>
                                Pedido realizado el <fmt:formatDate value="${fecha}" type="date" pattern="dd/MM/yyyy"/>
                                <% switch (p.getEstado()) {
                                
                                case (byte)0: %>
                                <a href="pagar?p=<%= p.getId() %>">
                                	<img src="../../img/icons/buck-ic.png" width="20" height="20" />
                                </a>
                                <% break;
                                case (byte)1: %>
                                <img src="../../img/icons/clock-ic.png" width="20" height="20" />
                                <% break;
                                case (byte)2:%>
                                <img src="../../img/icons/check-mark-ic.png" width="20" height="20" />
                                <% break;
                                case (byte)3:%>
                                <img src="../../img/icons/x-mark-ic.png" width="20" height="20" />
                                <% break;
                                }%>
                                <img src="../../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <% } %>
                        <!-- li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li>
                        <li>
                            <p>
                                Pedido del día XX/XX/XXXX
                                <img src="../../img/icons/check-mark-ic.png" width="20" height="20" />
                                <img src="../../img/icons/trash-can-ic.png" width="20" height="20" />
                            </p>
                        </li -->
                    </ul>
                </div>
                <div id="user-lists-container">
                    <!-- Insertar contenido dinámico del cuerpo de la página -->
                    <h2 class="home-vine-container-header">Mi Carrito</h2>
                    <ul class="overflow-item-list">
                    	<form id="agregarCarritoForm" action="agregar" method="post">
                        <!-- Usar el li como plantilla para items -->
                        <%
                        for (Map.Entry<Vino, Integer> entryset : carrito.entrySet()) {
                        	Vino vino = entryset.getKey();
                        %>
                        <li>
                            <div class="home-vine-item">
                                <img src="../../<%= vino.getRutaImagen() %>" width="100" height="100" />
                                <p class="home-vine-item-info-first-line"><%= vino.getNombre() %></p>
                                <p><%= vino.getPrecio() %> €</p>
                                <p><input class="inputCantidad" type="text" size="3" maxlength="3" value="1"></input></p>
                                <p><a href="eliminar?id=<%= vino.getId() %>">Quitar del carrito</a></p>
                            </div>
                        </li>
                        <%
                        	precioCalculado += vino.getPrecio();
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