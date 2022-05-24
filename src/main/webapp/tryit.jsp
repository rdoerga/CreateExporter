<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>try the proc</title>
</head>
<body>
	<table>
		<form method="POST" action="/voltsandbox/CallProc">
			<tr> 
			<td>
				
				<!-- <form method="POST" action="/voltsandbox/main.jsp?action_selected=cr_table"> -->
					<button class="btn success" type="SUBMIT" value="">Post Values</button>
					<input type="hidden" name="procedure_name" value="<%response.getWriter().print(request.getParameter("procedure_name")); %>" />
			</td>
			</tr>
			<% 
			for (int i=0 ; i<Integer.parseInt(request.getParameter("column_count")) ; i++) {
				response.getWriter().println("<tr><td><input type=\"text\" name=\"col"+Integer.toString(i)+"\" /> </td></tr>");
			}
			%>
		</form>
	</table>
</body>
</html>