<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book the Train</title>
</head>
<body>
<h1>Booking</h1>
      <table>
         <thead>
            <tr>
               <th>Train No</th>
               <th>Train Name</th>
               <th>Available Seats</th>
               <th>Booking</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="train" items="${trainList}">
               <tr>
                  <td>${train.trainNo}</td>
                  <td>${train.trainName}</td>
                  <td>${train.trainSeats}</td>
                  <td><button type="button" onclick="location.href='/train/book?id=${train.id}'">Book</button></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      <a href="/Home.jsp">Home</a>
</body>
</html>