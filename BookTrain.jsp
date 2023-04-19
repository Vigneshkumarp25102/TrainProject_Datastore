<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Train</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function sendData() {
	var trainId = document.getElementById("trainId").value;
	var trainNo = document.getElementById("trainNo").value;
    var trainName = document.getElementById("trainName").value;
	  	var passengerName = document.getElementById("passengerName").value;
	    var passesngerAge = document.getElementById("passesngerAge").value;
	    var passengerSeats = document.getElementById("passengerSeats").value;
	    
	    var data = {
	    		 "trainId": trainId,
	    		 "trainNo": trainNo,
	 	        "trainName": trainName,
	        "passengerName": passengerName,
	        "passesngerAge": passesngerAge,
	        "passengerSeats": passengerSeats
	    };

	    $.ajax({
	        type: "POST",
	        url: "/train/passenger/booking",
	        data: JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    });
	    alert("Successfully added");
    } 
 </script>
<h1>Train Booking</h1><br>
<p>Train No : ${trainDetail.trainNo}</p>
<p>Train Name : ${trainDetail.trainName}</p>
<p>Available Seats : ${trainDetail.trainSeats}</p>
<input type='hidden' name='tarinId' id='trainId' value='${trainDetail.id}'/><br>
<input type='hidden' name='tarinNo' id='trainNo' value='${trainDetail.trainNo}'/><br><br>
<input type='hidden' name='tarinName' id='trainName' value='${trainDetail.trainName}'/><br>

<label>Passenger name : </label>
<input type='text' name='passengerName' id='passengerName' /><br><br>
<label>Passenger age : </label>
<input type='text' name='passesngerAge'  id='passesngerAge'/><br><br>
<label>Passenger Seats : </label> 
<input type='text' name='passengerSeats' id='passengerSeats'/><br><br>
<input type='button' value='submit' onclick='sendData()'/>
</body>
</html>