<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sandbox</title>
<style>
.btn {
    border: none;
    background-color: inherit;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
    display: inline-block;
}

/* Green */
.success {
    color: green;
}

.success:hover {
    background-color: #04AA6D;
    color: white;
}

/* Blue */
.info {
    color: dodgerblue;
}

.info:hover {
    background: #2196F3;
    color: white;
}

/* Orange */
.warning {
    color: orange;
}

.warning:hover {
    background: #ff9800;
    color: white;
}

/* Red */
.danger {
    color: red;
}

.danger:hover {
    background: #f44336;
    color: white;
}

/* Gray */
.default {
    color: black;
}

.default:hover {
    background: #e7e7e7;
}
</style>
</head>
<body>
	<table>
		<form method="POST" action="/voltsandbox/CreateExporter">
			<tr> 
			<td>
				
				<!-- <form method="POST" action="/voltsandbox/main.jsp?action_selected=cr_table"> -->
					<button class="btn success" type="SUBMIT" value="">CREATE</button>
			</td>
			<td> 
				<label>Topic Name:</label>
				<input type="text" name="topic_name" />
			</td>
			</tr>
			<tr><td></td>
			<td> 
				<label>Procedure Name:</label>
				<input type="text" name="procedure_name" />
			</td>
			</tr>
			<tr><td></td>
			<td> 
				<label>Number of Columns:</label>
				<input type="text" name="column_count" />
			</td>
			</tr>
		</form>
	</table>



</body>
</html>