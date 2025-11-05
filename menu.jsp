<%@page
	import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.dao.model.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f8f8;
	margin: 0;
}

h1 {
	text-align: center;
	padding: 10px 10px;
}

.menu-container {
	text-align: center;
	padding: 40px 20px;
}

.menu-title {
	color: #333;
	margin-bottom: 30px;
	font-size: 2.2rem;
	letter-spacing: 1px;
}

.menu-grid {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 20px;
	justify-content: center;
	text-align: center;
	padding: 20px;
	width: 90%;
	margin: 0 auto;
}

.menu-card {
	background: #fff;
	border-radius: 15px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	padding: 15px;
	transition: transform 0.3s ease, bax-shadow 0.3s ease;
}

.menu-card:hover {
	transform: scale(1.05);
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

.menu-card img {
	width: 100%;
	height: 150px;
	border-radius: 10px;
	object-fit: cover;
}

.menu-card h3 {
	color: #222;
	margin: 10px 0 5px;
}

.menu-card p {
	color: #555;
	font-size: 0.9rem;
	margin-bottom: 10px;
}

.price {
	display: inline-block;
	color: #e91e63;
	font-weight: bold;
	font-size: 1rem;
}

.btn {
	background-color: #ff4081;
	color: white;
	padding: 8px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 0.9rem;
	transition: background 0.3s ease, transform 0.3s ease;
}

.btn:hover {
	background-color: #e91e63;
	transform: scale(1.05);
}
</style>
</head>
<body>
	<h1 class="menu-title">OUR MENU</h1>
	<div class="menu-container">
		<div class="menu-grid">
			<%
			List<Menu> allmenu = (List<Menu>) request.getAttribute("menulist");
			Integer restarentid = (Integer)request.getAttribute("restarentid");

			if (allmenu != null && !allmenu.isEmpty()) {
				for (Menu allmenus : allmenu) {
					
			%>

			<div class="menu-card">
				<img alt="Item Image" src="<%=allmenus.getImagePath()%>">
				<h2><%=allmenus.getItemName()%></h2>
				<p><%=allmenus.getDescription()%></p>
				<span class="price">₹<%=allmenus.getPrice()%></span>
				
				
				<form action="cart" method="post" class="btn">
					<input type="hidden" name="restarentid" value=<%= allmenus.getRestaurantid()%>>
					<input type="hidden" name="menuid" value=<%= allmenus.getMenu_id()%>>
					<input type="hidden" name="quantity" value="1">
					<input type="hidden" name="action" value="add">
				<input type="submit" value="Add to cart">
				</form>
			</div>
			<%
			}
			} else {
			%>
			<p>No items available.</p>
			<%
		}
		%>
		</div>
	</div>
</body>
</html>