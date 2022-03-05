<%@ include file="fragment/adminHeader.jsp"%>

<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<br>
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/newUser" class="btn btn-success">Add
				New User</a>
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

				<c:forEach var="user" items="${listUser}">

					<tr>
						
						<td><c:out value="${user.username}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.role}" /></td>
						<td><a class="btn btn-primary" href="editUser?username=<c:out value='${user.username}' />">Edit</a>
							&nbsp; <a class="btn btn-danger"
							href="deleteUser?username=<c:out value='${user.username}' />">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
</div>
<%@include file="fragment/footer.jsp"%>