<%@ include file="fragment/header.jsp" %>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${bill != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${bill == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${bill != null}">
            			Edit Bill
            		</c:if>
						<c:if test="${bill == null}">
            			Issue New Bill
            		</c:if>
					</h2>
				</caption>

				<c:if test="${bill != null}">
					<input type="hidden" name="username" value="<c:out value='${bill.username}' />" />
				</c:if>

				 <fieldset class="form-group">
                                <label>Username</label> <input type="text"
                                                                 value="<c:out value='${bill.username}' />" class="form-control"
                                                                 name="username" required="required" minlength="5">
                            </fieldset>

							 <fieldset class="form-group">
                                <label>Month</label> <select class="form-control" 
                                                                   name="month" required="required" >
                                    <option disabled hidden selected><c:out value='${bill.month}' /></option>
                                    <option value="January">January</option>
                                    <option value="February">February</option>
                                     <option value="March">March</option>
                                    <option value="April">April</option>
                                     <option value="May">May</option>
                                    <option value="June">June</option>
                                     <option value="July">July</option>
                                    <option value="August">August</option>
                                     <option value="September">September</option>
                                    <option value="October">October</option>
                                     <option value="November">November</option>
                                    <option value="December">December</option>
                                </select>
                            </fieldset>
							
							<%--  
                            <fieldset class="form-group">
                                <label>Month</label> <input type="text"
                                                                      value="<c:out value='${bill.month}' />" class="form-control"
                                                                      name="month" minlength="2">
                            </fieldset> --%>
                                                                      
                            <fieldset class="form-group">
                                <label>Total Amount</label> <input type="text"
                                                                      value="<c:out value='${bill.totalAmount}' />" class="form-control"
                                                                      name="totalAmount" minlength="2">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Bill Status</label> <select class="form-control"
                                                                   name="isPaid" >
                                    <option disabled hidden selected><c:out value='${bill.status}' /></option>
                                    <option value="Unpaid">Unpaid</option>
                                    <option value="Paid">Paid</option>
                                </select>
                            </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="fragment/footer.jsp" %>