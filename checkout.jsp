<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
</head>
<style>
    body {
      font-family: 'Poppins', sans-serif;
      background: #f2f5f9;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .container {
      background: #fff;
      padding: 30px 40px;
      border-radius: 16px;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
      width: 400px;
      max-width: 90%;
    }

    h1 {
      text-align: center;
      color: #333;
      margin-bottom: 25px;
      font-size: 28px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: 600;
      color: #333;
    }

    textarea, select, input[type="text"], input[type="number"] {
      width: 100%;
      padding: 10px;
      border: 1.5px solid #ccc;
      border-radius: 8px;
      font-size: 14px;
      margin-bottom: 20px;
      transition: border-color 0.3s ease, box-shadow 0.3s ease;
    }

    textarea:focus, select:focus {
      border-color: #4a90e2;
      box-shadow: 0 0 8px rgba(74, 144, 226, 0.2);
      outline: none;
    }

    textarea {
      resize: none;
      height: 100px;
    }

    select {
      cursor: pointer;
    }

    input[type="button"] {
      width: 100%;
      background: linear-gradient(135deg, #4a90e2, #357ae8);
      color: #fff;
      padding: 12px;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background 0.3s ease, transform 0.2s ease;
    }

    input[type="button"]:hover {
      background: linear-gradient(135deg, #357ae8, #2d63c8);
      transform: translateY(-2px);
    }

    input[type="button"]:active {
      transform: translateY(0);
    }
  </style>
<body>
<div class="container">
<h1>Checkout</h1>
<form action="checkout" method="post">
<label for="address">Delivery Address:</label>
<textarea id="address" name="address" required></textarea>
<label for="payment-mode" >Payment Type:</label>
<select name="payment-mode" id="payment-mode">
<option name="Credit card">CREDITCARD</option>
<option name="UPI">UPI</option>
<option name="Case On Delivery">CASHONDELIVERY</option>
</select>
<input type="submit" value="Place Order">
</form>
</div>
</body>
</html>