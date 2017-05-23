<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
input {
	background-color: transparent;
	border: 0 solid black;
	text-align: left;
}
</style>
<script>

function auth(kk,id){
//kk = this
//id=list.id

	
$(document).ready(function(){

	
	$.ajax({
		type: "put",
		url:"../ajax/updateconfirmationajax/"+id,
		dataType:"text",
		success: function(responseData, status, xhr){
			
			$(kk).replaceWith("<p>승인완료</p>");
			
			
			
		}
	
		
	})//ajax
	

	









})//end document
}
function modify(kk,as){
	

	
	
	var value = document.getElementsByClassName(kk);
	
	
	for(var i = 0 ; i <value.length ; i++){
		value[i].removeAttribute('readonly');
		value[i].style.border = "3px solid blue"
	}
	
 		$(document).ready(function(){
			
 			
			$(as).replaceWith("<button id='" + kk + "'>수정하기!</button>");
 			$("#"+kk+"").attr('onclick', "realmodify('" + kk + "','" + this + "')");
 			
			
 		});	
		
		
		
		
	//end document jquery
	
}
function realmodify(kk,as){
	
	
	
	var value = document.getElementsByClassName(kk);
	
	var temp = {
			name:value[0].value,
			birthdate:value[1].value,
			gender:value[2].value,
			id:kk,
			phone_num:value[3].value,
			email:value[4].value
	};
	console.log(temp);
	for(var i = 0 ; i <value.length ; i++){
		value[i].setAttribute('readonly','readonly');
		value[i].style.border = "0px solid black"
		
	}
		
	
	
	
	
	
	
	
	$(document).ready(function(){
	
		
		
		$.ajax({
			type: "post",
			url:"../ajax/updatememberajax",
			dataType:"text",
			headers:{
				'Content-Type' : 'application/json'
			},			
			data:JSON.stringify(temp),
			success: function(responseData, status, xhr){
				
				
			}
		
			
		})//ajax
		
		
		
		
		});
}

</script>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>이메일</th>
				<c:if test="${param.mem == 'watinglist'}">
					<th>승인</th>
				</c:if>
				<c:if test="${param.mem == 'student' || param.mem == 'teacher'}">
					<th>회원정보수정</th>
				</c:if>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
			<tbody>
				<tr>
					<td>${list.id }</td>
					<td><input type="text" value=${list.name } class=${list.id }
						readonly="readonly" name="name"></td>
					<td><input type="text" value=${list.birthdate }
						class=${list.id } name="birthdate" readonly="readonly"></td>
					<td><input type="text" value=${list.gender } class=${list.id }
						name="gender" readonly="readonly"></td>
					<td><input type="text" value=${list.phone_num }
						class=${list.id } name="phone_num" readonly="readonly"></td>
					<td><input type="text" value=${list.email } class=${list.id }
						name="email" readonly="readonly"></td>
					<c:if test="${param.mem == 'watinglist'}">
						<input type="hidden" name="v1" id="v1" value="${list.id }">
						<td><button type="button" class="btn btn-danger authk"
								onclick="auth(this,'${list.id}')">승인</button></td>
					</c:if>
					<c:if test="${param.mem == 'student' || param.mem == 'teacher'}">
						<td>

							<button type="button" class="btn btn-danger"
								onclick="modify('${list.id}',this)">회원정보수정</button>
						</td>
					</c:if>

				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>


