<%@ include file="fragment/header.jsp"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

	<sql:setDataSource
	        var="myDS"
	        driver="com.mysql.cj.jdbc.Driver"
	        url="jdbc:mysql://localhost:3306/electricity_bill"
	        user="root" password="root"
	    />
    
     <sql:query var="sql"   dataSource="${myDS}">
        select * from bill where username = '<%= request.getParameter("q") %>';
    </sql:query>

 
<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<br>
		<h3 class="text-center">List of Bills</h3>
		<hr>
		<div class="row">
			<div class="col-md-4">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Bill</a>

			</div>
			<div class="col-md-4">
			<form action="" method="get">
			<input type="text" class="form-control" name="q"
					placeholder="Seach by username..." />
			</form>
				
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Username</th>
					<th>Month</th>
					<th>Total Amount</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>			
			
				<c:forEach var="bills" items="${sql.rows}">

					<tr>

						<td><c:out value="${bills.username}" /></td>
						<td><c:out value="${bills.month}" /></td>
						<td><c:out value="${bills.total_amount}" /></td>
						<td><c:out value="${bills.is_paid}" /></td>
						<td><a class="btn btn-primary"
							href="edit?username=<c:out value='${bills.username}' />">Edit</a>
							&nbsp; <a class="btn btn-danger"
							href="delete?username=<c:out value='${bills.username}' />">Delete</a></td>
					</tr>
				</c:forEach>
				
					
			</tbody>

		</table>
	</div>
</div>
<%@include file="fragment/footer.jsp"%>