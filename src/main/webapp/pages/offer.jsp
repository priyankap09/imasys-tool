<html>
<head>
<link href="css/common.css" rel="stylesheet"></link>
<title>Offers</title>
</head>
<body>
	Offer Description:
	<input type="text" name="offerDesc" id="offerDesc" size="100px">
	<select name="status" id="status">
		<option value="Active">Active</option>
		<option value="Inactive">Active</option>
		<option value="Cancelled">Active</option>
		<option value="Pending">Active</option>
	</select>
	<input type="submit" value="Save" formaction="/save/offer" class="btn1">
	
	<table>
		<tr>
			<td>Offer Id</td>
			<td>Offer Description</td>
			<td>Status</td>
		</tr>
		<c: forEach var="offer" items="${allOffers}">
			<td>${offer.offerid }</td>
			<td>${offer.offerDesc }</td>
			<td>${offer.status }</td>
		</c:>
	</table>

</body>
</html>