<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Credit Card System</title>
<link rel="stylesheet" href="css/card.css" />

<style> 

table, td, th {  
  text-align: left;
}

table {
  width: 50%;
}

th, td {
  padding: 7px;
}

div.message {
	padding: 7px;
	margin-top: 5px;
	display: none;
	color: red;
}

</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(	function() {

  $('#messageDiv').css('display', 'none');
   
   $('#add').click(function() {

	   var name  = $('#name').val();
	   if(name == null || name == '' || !name.match("^[a-zA-Z]*$")){
		   $('#messageDiv').html('Please enter valid name !!').css('display', 'block').delay(1000).fadeOut();
		   return;
	   }

	   var cardNumber = $('#CardNo').val();
	   if(cardNumber == null || !jQuery.isNumeric(cardNumber)){
		   $('#messageDiv').html('Enter valid Card Number, only digits are allowed !!').css('display', 'block').delay(1000).fadeOut();
		   return;
	   }
	   
	   var limit = $('#limit').val();
	   if(limit == null || limit == ''){
		   $('#messageDiv').html('Limit is not valid').css('display', 'block').delay(1000).fadeOut();
		   return;
	   }

    	var param = JSON.stringify({ 'name': $.trim(name), 'number': cardNumber, 'creditLimit' : limit });

	   $.ajax({
			  dataType: "json",
			  url: "addCard",
			  type : "post",
			  contentType:"application/json; charset=utf-8",
			  data : param,
			  success: function(data){
				  
				  if(data != null){
				  	  $('#messageDiv').html(data.message).css('display', 'block').delay(10000).fadeOut();
				  	  if(data.status != null && data.status == 'SUCCESS'){
				  		fetchCards();
				  	  }
				  }
			  }
			});
    })
    
	});
</script>

</head>

<body>

	<h2>Credit Card System</h2>

	<form id="creditCardForm" method="post" action="add">

		<table >
            <tr>
				<td><h3><label class="cardLabel">Add</label></h3></td>
			</tr>
			<tr>
				<td>
					<div id="messageDiv" class='message'/>
				</td>
			</tr>
			<tr>
				<td><label>Name</label><BR/><input type="text" name="name" id="name" class="card-input input-border"></td>
			</tr>
			<tr>
				<td><label>Card Number</label><BR/><input type="text" name="CardNo" id="CardNo" class="card-input input-border" maxlength="19"></td>
			</tr>
			<tr>
				<td><label>Limit</label><BR/><input type="text" name="limit" id="limit" class="card-input input-border"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="button" name="add" id="add" value="Add" class='button'></td>
			</tr>
			<tr/><tr/>
		</table>
		
		<table>
		<tr><h3><label>Existing Card</label></h3></tr>
		</table>
		<table id = 'existinCard'>
		  
		    <tr >
				<th><label>Name</label></th>
				<th><label>Card Number</label></th>
				<th><label>Balance</label></th>
				<th><label>Limit</label></th>
		    </tr>
		</table>

	</form>
	<script type="text/javascript">
	fetchCards();
	function fetchCards() {
			$('#existinCard tr:not(:first)').remove();

		   $.ajax({
				  dataType: "json",
				  url: "fetchCards",
				  type : "get",
				  contentType:"application/json; charset=utf-8",
				  success: function(data){
					  
					  if(data != null){
						  if(data.status == 'SUCCESS'){
							  $.each(data.cards, function( index, value ) {
								  console.log( value.name);
									$("#existinCard tr:last").after('<tr><td>' + value.name + '</td><td>'+value.number+'</td><td>'+ '£' + value.balance+'</td><td>'+'£' +value.creditLimit+'</td></tr>');
	
								});
						  }
						  $('#messageDiv').html(data.message).css('display', 'block').delay(10000).fadeOut();
						  
						  
					  }
				  }
				});
	  }	
	
	</script>
</body>
</html>