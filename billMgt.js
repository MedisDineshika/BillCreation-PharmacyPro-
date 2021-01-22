$(document).ready(function() {
		//$('myform').submit(function(e) {
		    //  e.preventDefault();
		$("#billSubmit").click(function(){
		
		var bill = [];
			
		for (i=0;i<5;i++) {
			var itemName =$("#"+i+" #itemName option:selected").text();
			var quantity=$("#"+i+" #quantity").val();
			var unitPrice=$("#"+i+" #show_selected").val();
			var price =$("#"+i+" #price").val();
			var total = $("#txtd").text();
			
			var bill_item = {itemName:itemName,quantity:quantity,unitPrice:unitPrice,price:price,total:total};
			bill.push(bill_item);
		}
		
		console.log(JSON.stringify(bill));
		
		$.ajax({
			url : "/bill2/add",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(bill),
			success : function(data, status) {
				console.log(data);
				if (data.status) {
					// window.open("CreateEvent.jsp","_self"); //using "_self"
					// or "_parent" will open in same window and same tab
					// window.open("CreateEvent.jsp","_self");
					alert(data.responseMessage);

				} else {
					// window.open("index.jsp","_self");
					alert("not inserted");
				}
			},
			error : function(e) {
				console.log("error");
			}
		});


		  });
		 });
	
	
	