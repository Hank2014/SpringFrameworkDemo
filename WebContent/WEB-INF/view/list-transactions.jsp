<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Crypto</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Crypto Cost Calculator</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<input type="button" value="Add Transaction"
				onclick="window.location.href='showFormForAddTransaction';return false;"
				class="add-button"
		/>
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Transaction Date</th>
					<th>Transaction Type</th>
					<th>Asset Pair</th>
					<th>Amount</th>
					<th>At Price</th>
					<th>Exchange</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempTransaction" items="${transactions}">
					<tr>
						<td> ${tempTransaction.transactionDate} </td>
						<td> ${tempTransaction.transactionType} </td>
						<td> ${tempTransaction.assetPair} </td>
						<td> ${tempTransaction.amount} </td>
						<td> ${tempTransaction.atPrice} </td>
						<td> ${tempTransaction.exchange} </td>
					</tr>
				
				</c:forEach>

			</table>
				
				
			<table>
				<tr>
					<th>Coin</th>
					<th>Amount</th>
					<th>Avg Cost</th>
					<th>Exchange</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCoin" items="${coins}">
					<tr>
						<td> ${tempCoin.value.coinName} </td>
						<td> ${tempCoin.value.totalAmount} </td>
						<td> ${tempCoin.value.avgCost} </td>
						<td> ${tempCoin.value.exchange} </td>
					</tr>
		
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









