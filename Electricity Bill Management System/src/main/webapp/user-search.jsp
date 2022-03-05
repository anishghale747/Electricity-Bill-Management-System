<%@ include file="fragment/adminHeader.jsp"%>
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
        select * from user where username = '<%= request.getParameter("q") %>';
    </sql:query>

<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<br>
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="row">
		<div class="col-md-4">
			<a href="<%=request.getContextPath()%>/newUser"
				class="btn btn-success">Add New User</a>
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
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Role</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="users" items="${sql.rows}">

					<tr>

						<td><c:out value="${users.username}" /></td>
						<td><c:out value="${users.password}" /></td>
						<td><c:out value="${users.first_name}" /></td>
						<td><c:out value="${users.last_name}" /></td>
						<td><c:out value="${users.role}" /></td>
						<td><a class="btn btn-primary"
							href="editUser?username=<c:out value='${users.username}' />">Edit</a>
							&nbsp; <a class="btn btn-danger"
							href="deleteUser?username=<c:out value='${users.username}' />">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
</div>
<%@include file="fragment/footer.jsp"%>