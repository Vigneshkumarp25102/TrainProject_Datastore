<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Train Dashboard</title>
   </head>
   <body>
      <h1>Train Dashboard</h1>
      <table>
         <thead>
            <tr>
               <th>Train No</th>
               <th>Train Name</th>
               <th>Train Seats</th>
               <th>Action</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="train" items="${trainList}">
               <tr>
                  <td>${train.trainNo}</td>
                  <td>${train.trainName}</td>
                  <td>${train.trainSeats}</td>
                  <td><button type="button" onclick="location.href='/train/update?id=${train.id}'">Update</button></td>
                  <td><button type="button" onclick="location.href='/train/delete?id=${train.id}'">Delete</button></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      <a href="/Home.jsp">Home</a>
   </body>
</html>