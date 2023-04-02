<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Create new Transaction</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
		  
		  
	<script>
		function getval(sel)
		{
		    alert(sel.value);
		}
	</script>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Transaction</h3>
	
	
		<form:form id="form-add-transaction" action="saveCryptoTransaction" modelAttribute="cryptoTransaction" method="POST">
		
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>transaction date</label></td>
						<td><form:input type="date" path="transactionDate" value="2021-11-14"/></td>
					</tr>

					<tr>
						<td>transaction type </td>
						<td>
						<form:select id="txTypeSelect" path="transactionType" onchange="getval(this);">
					
							<form:options items="${theTxTypeOptions}"/>
							
						</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label>asset pair</label></td>
						<td><form:input path="assetPair" />
					</tr>
					
					<tr>	
						<td><label>amount</label></td>
						<td><form:input type="number" step="any" path="amount"/></td>
					</tr>
					
					<tr>	
						<td><label>At price</label></td>
						<td><form:input type="number" step="any" path="atPrice"/></td>
					</tr>
					
					
					<tr>	
						<td><label>Exchange</label></td>
						<td>
						<form:select id="exchangeSelect" path="exchange">
					
							<form:options items="${exchangeOptions}"/>
							
						</form:select>
						</td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		
		</form:form>
	
	

					       
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/crypto/list">Back to List</a>
		</p>
	
	</div>


</body>

</html>










