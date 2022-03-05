<%@ include file="fragment/header.jsp"%>
 
<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<br>
		<h3 class="text-center">List of Bills</h3>
		<hr>
		<div class="row">
			<div class="col-md-4">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Issue New Bill</a>

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
				<c:forEach var="bill" items="${listBill}">

					<tr>

						<td><c:out value="${bill.username}" /></td>
						<td><c:out value="${bill.month}" /></td>
						<td><c:out value="${bill.totalAmount}" /></td>
						<td><c:out value="${bill.status}" /></td>
						<td><a class="btn btn-primary"
							href="edit?username=<c:out value='${bill.username}' />">Edit</a>
							&nbsp;<a class="btn btn-danger"
							href="delete?username=<c:out value='${bill.username}' />">Delete</a></td>
					</tr>
				</c:forEach>			
					
			</tbody>

		</table>
	</div>
</div>
<%@include file="fragment/footer.jsp"%>