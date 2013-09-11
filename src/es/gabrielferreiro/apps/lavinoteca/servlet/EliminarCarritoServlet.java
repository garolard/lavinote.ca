package es.gabrielferreiro.apps.lavinoteca.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

/**
 * Servlet implementation class EliminarCarritoServlet
 */
@WebServlet("/EliminarCarrito")
public class EliminarCarritoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EliminarCarritoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro en el servlet");
		IVinoService vinoService = getApplicationContext().getBean("vinoService", IVinoService.class);
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)request.getSession().getAttribute("carrito");
		Integer vinoId = Integer.parseInt(request.getParameter("id"));
		
		Vino vino = vinoService.obtener(vinoId);
		if (vino != null)
			carrito.remove(vino);
		
		request.getSession().setAttribute("carrito", carrito);
		response.sendRedirect("user.jsp");
	}

}
