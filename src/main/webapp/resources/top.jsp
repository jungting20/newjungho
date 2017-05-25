<%@page import="com.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

#watingnumber {
	color: red;
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<script>
	function startTime() {
		var today = new Date();
		var week = new Array('일', '월', '화', '수', '목', '금', '토', '일');
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		var year = today.getFullYear();
		var month = new String(today.getMonth() + 1);
		var day = new String(today.getDate());

		m = checkTime(m);
		s = checkTime(s);
		document.getElementById('clock').innerHTML = year + "." + month + "."
				+ day + "." + week[today.getDay()] + "요일" + "  " + h + ":" + m
				+ ":" + s;
		var t = setTimeout(startTime, 500);
	}
	function checkTime(i) {
		if (i < 10) {
			i = "0" + i
		}
		; // 숫자가 10보다 작을 경우 앞에 0을 붙여줌
		return i;
	}
</script>


<body onload="startTime()">

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">

				<h4>회원관리시스템</h4>
				<ul class="nav nav-pills nav-stacked">

					<li class="active"><a href="BoardList?cate=공지사항">공지사항</a></li>

					<li><a href="../board/boardlist">자유게시판</a></li>
					<li><a href="CourseSchedule">강의관리</a></li>
					<c:if test="${userid != null && userid.classification == 'student'}">
					<li><a href="myinfo">내정보</a></li>
					</c:if>
					<c:if test="${userid != null && userid.classification == 'manager'}">
					<li><a href="memberlist?mem=student">모든학생보기</a></li>
					<li><a href="memberlist?mem=teacher">모든선생님보기</a></li>
					<li><a href="memberlist?mem=watinglist" id="wating">가입대기자보기 </a></li>
					<li><a href="GoProhibit">게시판금지어설정</a>
					</c:if>

					<li><a href="CourseList">강의목록</a></li>
					<c:if test="${userid != null }">
					<li><a href="readarticle">오늘의뉴스</a></li>
					<li><a href="setreadarticle">다른뉴스보기</a></li>
					</c:if>

				</ul>
				<br>


			</div>

			<div class="col-sm-9">

				<h1>현재시간</h1>
				<h1 id="clock"></h1>
				
				<br>
				<c:if test="${userid != null}">
				<a href="/test/member/logout" class="btn btn-warning"
					role="button">로그아웃</a> 
				</c:if> 
					<c:if test="${userid != null && userid.classification == 'student'}">
					<a href="doattend?logout=logout"
					class="btn btn-warning" role="button">퇴실하기</a>
					
					</c:if>			