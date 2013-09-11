package es.gabrielferreiro.apps.lavinoteca.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ApplicationContext context;

    static {
    	context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    protected ApplicationContext getApplicationContext() {
    	return context;
    }

}
