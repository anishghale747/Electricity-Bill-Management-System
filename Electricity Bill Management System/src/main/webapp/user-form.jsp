<%@ include file="fragment/adminHeader.jsp" %>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updateUser" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertUser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="username" value="<c:out value='${user.username}' />" />
				</c:if>

				 <fieldset class="form-group">
                                <label>Username</label> <input type="text"
                                                                 value="<c:out value='${user.username}' />" class="form-control"
                                                                 name="username" required="required" minlength="5">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Password</label> <input type="text"
                                                                      value="<c:out value='${user.password}' />" class="form-control"
                                                                      name="password" minlength="5">
                            </fieldset>
                            
                            <fieldset class="form-group">
                                <label>First Name</label> <input type="text"
                                                                      value="<c:out value='${user.firstName}' />" class="form-control"
                                                                      name="firstName" minlength="3">
                            </fieldset>
                            
                            <fieldset class="form-group">
                                <label>Last Name</label> <input type="text"
                                                                      value="<c:out value='${user.lastName}' />" class="form-control"
                                                                      name="lastName" minlength="3">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Role</label> <select class="form-control"
                                                                   name="role">
                                    <option disabled hidden selected><c:out value='${user.role}' /></option>
                                    <option value="User">User</option>
                                    <option value="Customer">Customer</option>
                                </select>
                            </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="fragment/footer.jsp" %>