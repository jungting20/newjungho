<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 
	
 <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        
      </tr>
    </thead>
    <c:forEach var ="list" items="${list}">
    <tbody>
      <tr>
        <td>${list.id }</td>
        <td>${list.name }</td>
        <td>${list.phone_num }</td>
        <td>${list.email }</td>
      
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
  
  <a href="studentattendancelist" class="btn btn-info" role="button">출석목록으로</a>
