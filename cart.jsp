<%@page
	import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="com.dao.model.Cart,com.dao.model.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.cart-container {
	width: 70%;
	margin: 40px auto;
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
}

.cart-item {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 15px 10px;
	border-bottom: 1px solid #ddd;
}

.item-name {
	font-size: 18px;
	font-weight: 600;
	color: #333;
}

.price {
	font-size: 16px;
	color: #555;
	width: 80px;
	text-align: right;
}

.quantity-controls {
	display: flex;
	align-items: center;
	gap: 10px;
}

.quantity-controls button {
	width: 30px;
	height: 30px;
	border: none;
	cursor: pointer;
	font-size: 18px;
	border-radius: 4px;
	background-color: #008CBA;
	color: white;
}

.quantity-controls input {
	width: 40px;
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	padding: 5px;
}

.cart-total {
	text-align: right;
	padding: 10px;
	font-size: 20px;
	font-weight: bold;
}

.checkout-btn {
	display: block;
	margin-left: auto;
	margin-top: 10px;
	padding: 10px 20px;
	background-color: green;
	color: white;
	border: none;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

.checkout-btn:hover {
	background-color: darkgreen;
}

.add-more-btn {
	display: block;
	padding: 10px 20px;
	background-color: green;
	color: white;
	border: none;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

.add-more-btn:hover{
	background: #c074f2;
background: linear-gradient(90deg, rgba(192, 116, 242, 1) 0%, rgba(255, 113, 103, 1) 0%, rgba(194, 13, 255, 1) 100%, rgba(225, 111, 171, 1) 32%, rgba(255, 117, 101, 1) 75%, rgba(255, 112, 104, 1) 41%, rgba(255, 107, 107, 1) 100%, rgba(252, 176, 69, 1) 100%);
}
.remove-btn{
    display: flex;
    justify-content: center;
    align-items: center;
    margin : 40px auto;
	padding: 10px 20px;
	background-color: green;
	color: white;
	border: none;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}
.remove-btn:hover{
	background: #c074f2;
background: linear-gradient(90deg, rgba(192, 116, 242, 1) 0%, rgba(255, 113, 103, 1) 0%, rgba(194, 13, 255, 1) 100%, rgba(225, 111, 171, 1) 32%, rgba(255, 117, 101, 1) 75%, rgba(255, 112, 104, 1) 41%, rgba(255, 107, 107, 1) 100%, rgba(252, 176, 69, 1) 100%);
}

.add-items {
  text-decoration: none;   /* removes underline */
  background-color: #4CAF50; /* button color */
  color: white;
  padding: 10px 15px;
  border-radius: 5px;
  border: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}

.add-items:hover {
  opacity: 0.9;
}


</style>
</head>
<body>


	<div class="cart-container">
		<h2>Your Cart</h2>
		
		<% Cart cart = (Cart)session.getAttribute("cart");
		  Integer restaurantId  = (Integer)session.getAttribute("restarentid");
		 
		  if(cart !=null && !cart.getItems().isEmpty()){
			  for(CartItem item : cart.getItems().values()){
				  
		%>
		<!-- Sample Cart Item -->
		<div class="cart-item">
			<div class="item-name"><%= item.getName() %></div>
			<div class="quantity-controls">
				<form action="cart" method="post" style="display:inline">
				<input type="hidden" name="itemId" value=<%=item.getItemId()%>>
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="restarentid" value="<%= session.getAttribute("restarentid") %>">
				<input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>">
				<button>+</button>
				</form>
				
				
				<p><%=item.getQuantity()%></p>
				<form action="cart" method="post" style="display:inline;">
				<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
				<input type="hidden" name ="action" value="update">
				<input type="hidden" name="restarentid" value="<%= session.getAttribute("restarentid") %>">
				<input type="hidden" name="quantity" value="<%= item.getQuantity() -1%>">
				<button <%if(item.getQuantity() <= 1){%> disabled <%} %>>-</button>
				</form>
			</div>
			
			<div class="price"><%= item.getPrice() %></div>
			
			<form action="cart" method="post">
             <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
              <input type="hidden" name="action" value="remove">
              <input type="hidden" name="restarentid" value="<%= restaurantId %>">
              <button type="submit" class="remove-btn">Remove</button>
             </form>
		</div>
		<%}
			%>
		
		
		<div class="cart-total">Total: ₹ <%=cart.getTotalPrice()%></div>
		
		<a href="menu?restarentid=<%= session.getAttribute("restarentid") %>" style="text-decoration: none"><button class="add-more-btn">Add More Items</button></a>
		
		
		
		  <%   }else { %>
		
		<p class="Empty-mes" style="text-align: center;color: #757575;">Your Cart is Empty</p>
		 <div>
		 <a class="add-items" href="home">Add Items</a>
		 </div>
		
		<%} 
		
		%>
		
		<% if(cart != null){%>
		<a href="checkout.jsp" style="text-decoration: none"><button class="checkout-btn">Checkout</button></a>
		
		
		<%} %>
		
		

		
	</div>
</body>
</html>
