
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	var msg = '${mesg}';
	if(msg != null && msg !=''){
		alert(msg);
	}
</script>
<div class="container">
	<h2>출석</h2>
	<form class="col-xs-3" method="POST" action="/test/member/login">
		<div class="form-group">
			<label>아이디:</label> <input type="text" class="form-control" id="id"
				placeholder="아이디" name="userid">
		</div>

		<div class="form-group">
			<label for="pwd">비밀번호:</label> <input type="password"
				class="form-control" id="pw" placeholder="비밀번호" name="passwd">
		</div>
		<button type="submit" class="btn btn-primary" id="submit">로그인</button>
		<a href="joinmemberform" role="button" class="btn btn-warning">회원가입</a>
		<div class="checkbox">
			<label><input type="checkbox" value="autologin" name="isautologin">자동 로그인</label>
		</div>
	</form>



</div>