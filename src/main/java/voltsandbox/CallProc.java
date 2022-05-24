package voltsandbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.voltdb.VoltTable;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;

/**
 * Servlet implementation class CallProc
 */
@WebServlet("/CallProc")
public class CallProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	org.voltdb.client.Client client = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init() {
    	ClientConfig config = null;
    	try {
    	       config = new ClientConfig();       

    	       client = ClientFactory.createClient(config);       
    	 
    	       client.createConnection("localhost");       
    	} catch (java.io.IOException e) {
    	       e.printStackTrace();
    	       System.exit(-1);
    	}
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String procname = request.getParameter("procedure_name");
		VoltTable[] results;
		List<String> l = new ArrayList<String>();
		Enumeration<String> it= request.getParameterNames();		
		while(it.hasMoreElements()) {
			String key = (String) it.nextElement();
			if(key.startsWith("col")) {
				System.out.println(key);	
				l.add(request.getParameter(key));
			}
		}
	
		response.sendRedirect("/voltsandbox/tryit.jsp?procedure_name="+procname+"&column_count=2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
