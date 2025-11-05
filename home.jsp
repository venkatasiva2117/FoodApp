<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.dao.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants</title>
<style>
/* ---------- Base Page Styling ---------- */
body {
	background: linear-gradient(135deg, #fff8e7, #ffe9e3);
	margin: 0;
	padding: 0;
	font-family: 'Poppins', sans-serif;
	overflow-x: hidden;
}
body h1{
top : 30;
}

/* ---------- Header Section ---------- */
.header {
  background: linear-gradient(90deg, #ff6b6b, #ff9068);
  padding: 14px 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: white;
  position: fixed;         
  top: 0;                  
  left: 0;
  width: 100%;
  z-index: 1000;           
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  flex-wrap: wrap;
}

.header-left {
  display: flex;
  align-items: center;
  gap: 15px;
  flex-wrap: wrap;
  animation: slideInLeft 1s ease forwards;
}

.header-left select {
  background: rgba(255, 255, 255, 0.15);
  color: #fff;
  border: 1px solid rgba(255, 255, 255, 0.4);
  padding: 8px 14px;
  border-radius: 6px;
  font-size: 14px;
  cursor: pointer;
  backdrop-filter: blur(6px);
  transition: all 0.3s ease;
  appearance: none;
}

.header-left select:hover {
  background: rgba(255, 255, 255, 0.3);
  transform: scale(1.05);
}

.header-left option {
  background-color: #fff;
  color: #333;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 15px;
  animation: slideInRight 1s ease forwards;
  flex-wrap: wrap;
}

/* ----------- Search Box ----------- */
.search-box {
  display: flex;
  align-items: center;
  background: rgba(255, 255, 255, 0.2);
  border-radius: 25px;
  padding: 4px 10px;
  transition: all 0.4s ease;
  backdrop-filter: blur(6px);
}

.search-box input {
  border: none;
  outline: none;
  background: transparent;
  color: white;
  font-size: 14px;
  padding: 6px 8px;
  width: 160px;
  transition: width 0.4s ease;
}

.search-box input::placeholder {
  color: rgba(255, 255, 255, 0.8);
}

.search-box:hover input {
  width: 220px;
}

.search-btn {
  background: transparent;
  border: none;
  color: white;
  font-size: 18px;
  cursor: pointer;
  transition: transform 0.3s ease;
}

.search-btn:hover {
  transform: scale(1.2);
}

/* ----------- Buttons and Profile ----------- */
.header button {
  background-color: white;
  color: #ff6b6b;
  border: none;
  padding: 8px 16px;
  font-size: 14px;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
  font-weight: 600;
}

.header button:hover {
  background-color: #ffe3e3;
  transform: scale(1.05);
}

.profile-icon {
  width: 38px;
  height: 38px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.2);
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  font-size: 18px;
  cursor: pointer;
  transition: 0.3s;
}

.profile-icon:hover {
  background: rgba(255, 255, 255, 0.4);
  transform: scale(1.1);
}

/* ----------- Simple Entry Animations ----------- */
@keyframes slideInLeft {
  from { opacity: 0; transform: translateX(-50px); }
  to { opacity: 1; transform: translateX(0); }
}

@keyframes slideInRight {
  from { opacity: 0; transform: translateX(50px); }
  to { opacity: 1; transform: translateX(0); }
}


/* ---------- Animations ---------- */
@keyframes slideInLeft {
	0% { transform: translateX(-50px); opacity: 0; }
	100% { transform: translateX(0); opacity: 1; }
}

@keyframes slideInRight {
	0% { transform: translateX(50px); opacity: 0; }
	100% { transform: translateX(0); opacity: 1; }
}

/* ---------- Floating Food Animation ---------- */
.food-animation span {
	position: absolute;
	font-size: 30px;
	animation: float 8s linear infinite;
	opacity: 0.6;
}

@keyframes float {
	0% { transform: translateY(100vh) rotate(0deg); opacity: 0.9; }
	100% { transform: translateY(-10vh) rotate(360deg); opacity: 0; }
}

/* ---------- Heading ---------- */
h1 {
	text-align: center;
	margin: 30px 0;
	color: #333;
	font-size: 2.2em;
	animation: fadeInDown 1s ease forwards;
}

@keyframes fadeInDown {
	0% { transform: translateY(-30px); opacity: 0; }
	100% { transform: translateY(0); opacity: 1; }
}

/* ---------- Restaurant Grid ---------- */
.restarent-container {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
	gap: 20px;
	padding: 20px 40px;
}

.restarent-container a {
	text-decoration: none;
}

.restarent-card {
	background: #fff;
	border-radius: 12px;
	overflow: hidden;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	animation: fadeUp 0.8s ease;
}

.restarent-card:hover {
	transform: scale(1.05);
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
}

.restarent-card img {
	width: 100%;
	height: 200px;
	object-fit: cover;
}

.restarent-info {
	padding: 15px;
}

.restarent-info h3 {
	margin: 5px 0;
	font-size: 18px;
	color: #333;
}

.restarent-info p {
	color: #555;
	font-size: 14px;
	margin: 3px 0;
}

@keyframes fadeUp {
	from { transform: translateY(20px); opacity: 0; }
	to { transform: translateY(0); opacity: 1; }
}
</style>
</head>
<body>

<!-- 🍕 Floating Food Animation -->
<div class="food-animation" id="foodAnimation"></div>

<!-- 🔝 Header -->
<header class="header">
  <div class="header-left">
    <select>
      <option selected disabled>Category</option>
      <option>Veg</option>
      <option>Non-Veg</option>
      <option>Fast Food</option>
    </select>

    <select>
      <option selected disabled>Location</option>
      <option>Hyderabad</option>
      <option>Chirala</option>
      <option>Vijayawada</option>
    </select>

    <select>
      <option selected disabled>Food Type</option>
      <option>Indian</option>
      <option>Chinese</option>
      <option>Italian</option>
    </select>
  </div>

  <div class="header-right">
    <div class="search-box">
      <input type="text" placeholder="Search for food or restaurant..." />
      <button class="search-btn">🔍</button>
    </div>

    <a href="login.html"><button>Login</button></a>
    <a href="registerpage.html"><button>Register</button></a>
    <div class="profile-icon">👤</div>
  </div>
</header>


<!-- 🍽️ Title -->
<h1>Available Restaurants</h1>

<!-- 🏪 Restaurants -->
<div class="restarent-container">
<%
    List<Restaurant> allrestarent = (List<Restaurant>) request.getAttribute("allrestaurants");

	if (allrestarent != null && !allrestarent.isEmpty()) {
	    for (Restaurant restaurant : allrestarent) {
%>
		<a href="menu?restarentid=<%= restaurant.getRestaurantid()%>">
			<div class="restarent-card">
			    <img src="<%= restaurant.getImagePath() %>" alt="Restaurant Image">
			    <div class="restarent-info">
			        <h3><%= restaurant.getName() %></h3>
			        <p>📞 Phone: <%= restaurant.getPhone() %></p>
			        <p>⭐ Rating: <%= restaurant.getRating() %></p>
			    </div>
			</div>
		</a>
<%
	    }
	} else {
%>
	<p style="text-align:center; color:#888; font-size:18px;">No restaurants available.</p>
<%
	}
%>
</div>

<!-- 🍔 Floating Food JS -->
<script>
const foodIcons = ["🍕","🍔","🥗","🍩","🍣","🍰","🍟","🍛","🍗","🥪"];
const container = document.getElementById("foodAnimation");

function createFood() {
	const food = document.createElement("span");
	food.innerText = foodIcons[Math.floor(Math.random() * foodIcons.length)];
	food.style.left = Math.random() * 100 + "vw";
	food.style.animationDuration = 6 + Math.random() * 5 + "s";
	container.appendChild(food);
	setTimeout(() => food.remove(), 10000);
}

setInterval(createFood, 600);
</script>

</body>
</html>
