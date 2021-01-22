


<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<%@ page import = "com.pharmacy.model.Bill" %>
<html lang="en">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Landing Page - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/css/landing-page.min.css" rel="stylesheet">

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<script> 
		var total = 0;
		$(document).ready(function () {   
   		$('body').on('change', '.medicine-select', function() {
    	
        $(this).closest('tr').find('#show_selected').val($(this).val());
        // calculate Price of each row
         var unitPrice = parseFloat($(this).closest('tr').find('#show_selected').val());
         var quantity = parseFloat($(this).closest('tr').find('.medicine-quantity').val());
         var unitTag = parseFloat($(this).closest('tr').find('#show_selected2').val());
         if(unitPrice && quantity){
        	 var price = unitPrice * quantity;
             $(this).closest('tr').find('#price').val(price);
             console.log(unitTag);
             console.log(quantity);
             $('#txttag').html(unitTag);
             calculate();
         }
    });
    
   
    $('body').on('keyup', '.medicine-quantity', function() {
        var unitPrice = parseFloat($(this).closest('tr').find('#show_selected').val());
        var quantity = parseFloat($(this).val());
        if(unitPrice && quantity){
       	 var price = unitPrice * quantity;
            $(this).closest('tr').find('#price').val(price);
            calculate();
        }
     
    });
    
   
    
    
    
});  

function calculate() {
	
	total =0;
	
	$("#tbl tbody tr").each(function() {
		 var price = parseFloat($(this).find('#price').val());
		 if(price) {
			total += price; 
			$('#txtd').html(total);
		
		 }
		
	});
	
}  

	

</script> 
</head>
<body>
Total <h4 id="txtd"></h4>
Item Code <P id= "txttag"></P>
<spring:url value="/bill2/add" var="itemActionUrl2" />


	<form:form class="form-horizontal" id ="bill"  method="post" name = "itemM" modelAttribute="itemM" action="${itemActionUrl2}">
	
	
	
	
	
<table id="tbl">
<thead>
	<tr>
	
			<th>Id</th>
			<th>Item Name</th>
			<th>Item code</th>
			<th>Quantity</th>
			<th>UnitPrice</th>
			<th>Price</th>
			
			
	</tr>
</thead>
<tbody>
 <% for(int i=0;i<5;i++){ %>
	 <tr id="<%=i %>" >
	
		 <td><form:hidden path="id" /></td>
		 <td>
		               
				<spring:bind path="itemName">
					<select name="itemName" class="medicine-select" id="itemName">
					    <c:forEach items="${ItemsForBill}" var="product">
			
					       <option value="${product.unitPrice}">${product.itemName}</option>
					       
					       
					    </c:forEach>
					</select>
				</spring:bind>
	
		</td>		
		<td>
               
		<spring:bind path="item_code">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				
				<div class="col-sm-10">
					<form:input path="item_code" type="text" disabled="true" class="medicine-item_code"  id="show_selected2" placeholder="item_code " />
					<form:errors path="item_code" class="control-label" />
				</div>
			</div>
		</spring:bind>

		
</td>	
	
<td>	
		<spring:bind path="quantity">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				
				<div class="col-sm-10">
					<form:input path="quantity" id="quantity" type="number" class="medicine-quantity" placeholder="quantity"/>
					<form:errors path="quantity" class="control-label" />
				</div>
			</div>
		</spring:bind>
</td>
<td>	

		<spring:bind path="unitPrice">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				
				<div class="col-sm-10">
					<form:input path="unitPrice" type="text" disabled="true" class="medicine-unitprice"  id="show_selected" placeholder="unitPrice " />
					<form:errors path="unitPrice" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
</td>

<td>	
	<spring:bind path="price">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				
				<div class="col-sm-10">
					<form:input path="price"  id="price" placeholder="price" />
					<form:errors path="price" class="control-label" />
				</div>
			</div>
		</spring:bind>	
</td>


 </tr>
 <% } %>

</tbody>
  </table>
 
 	


<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			 	<button type="button" class="btn-lg btn-primary pull-right"
					id="billSubmit">Add</button>
			</div>
		</div>

</form:form>
<h4 onclick="window.print();">Print</h4>

<script src="${pageContext.request.contextPath}/js/itemManagement.js"></script>

<script src="${pageContext.request.contextPath}/js/billMgt.js"></script>

</body>
</html>