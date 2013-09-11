package es.gabrielferreiro.apps.lavinoteca.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

/**
 * Servlet implementation class IndiceServlet
 */
@WebServlet("/Indice")
public class IndiceServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IVinoService vinoService = getApplicationContext().getBean("vinoService", IVinoService.class);
		
		HttpSession session = request.getSession();
		session.setAttribute("todosVinos", vinoService.obtenerTodos());
		
		Map<Vino, Integer> carrito = new HashMap<>();
		carrito.put(vinoService.obtenerTodos().get(0), 1);
		carrito.put(vinoService.obtenerTodos().get(1), 1);
		carrito.put(vinoService.obtenerTodos().get(2), 1);
		carrito.put(vinoService.obtenerTodos().get(3), 1);
		carrito.put(vinoService.obtenerTodos().get(4), 1);
		session.setAttribute("carrito", carrito);
		
		response.sendRedirect("index.jsp");
	}

}
