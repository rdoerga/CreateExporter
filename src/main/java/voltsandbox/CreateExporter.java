package voltsandbox;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;


/**
 * Servlet implementation class CreateExporter
 */
@WebServlet("/CreateExporter")
public class CreateExporter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	org.voltdb.client.Client client = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateExporter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
		Enumeration<String> it= request.getParameterNames();		
		while(it.hasMoreElements()) {
			String key = (String) it.nextElement();
			//if(key=="operation")
			response.getWriter().println("Key = " + key);
			response.getWriter().println("value = " + request.getParameter(key));
		}
		
		String topic_name = request.getParameter("topic_name");
		String procedure_name = request.getParameter("procedure_name");
		String number_of_columns = request.getParameter("column_count");
		String columns = "";
		String values="";
		for (int i=0 ; i<Integer.parseInt(number_of_columns) ; i++) {
			if (i>0) {
				columns+=",";
				values+=",";
			}
			columns += " col" + Integer.toString(i) +" varchar(100) ";
			values +="?";
		}
		String[] ddlStatements = new String[] {"drop procedure "+ procedure_name," drop stream "+ topic_name,
					"create stream " + topic_name + " export to target test ("+ columns +")",
					"create procedure "+procedure_name + " as insert into "+topic_name+" values " + values};
		for (int i = 0; i < ddlStatements.length; i++) {
            try {
                ClientResponse cr = client.callProcedure("@AdHoc", ddlStatements[i]);
                if (cr.getStatus() != ClientResponse.SUCCESS) {
                    throw new Exception("Attempt to execute '" + ddlStatements[i] + "' failed:" + cr.getStatusString());
                }
            } catch (Exception e) {
            	response.getWriter().println(e.getMessage());
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
