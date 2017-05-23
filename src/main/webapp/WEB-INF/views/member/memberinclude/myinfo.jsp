<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
<style type="text/css">
.Highlighted a {
	background-color: #456baf !important;
	background-image: none !important;
	color: White !important;
	font-weight: bold !important;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#modify")
								.on(
										"click",
										function() {
											var tag = "<input type='submit' class='btn btn-warning' value='수정하기!'>"
											$("#att").remove();
											$("input").removeAttr("readonly");

											$("#sub").html(tag);

										})

					});

	$(function() { // 날짜 입력
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1;
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		today = yyyy + '/' + mm + '/' + dd; //오늘날짜 ex. 2016/11/12

		//데이트피커

		//출석날짜 불러오는 에이잭스 

		$.ajax({
			type : "get",
			url : "../ajax/getattendanceday",
			dataType : "json",
			success : function(responseData, status, xhr) {
				$('#date1').datepicker({
					showOn : 'both',
					buttonText : "달력",
					changeMonth : true,
					changeYear : true,
					showButtonPanel : true,
					yearRange : 'c-99:c+99',
					constrainInput : true,
					maxDate : '+1y',
					beforeShowDay : disableAllTheseDays
				});
				/* var attendancedate = responseData.split(",")
				attendancedate[0] = attendancedate[0].trim();
				 */
				var attendancedate = new Array();
				$.each(responseData, function(i, responseData) {

					attendancedate[i] = responseData.course_date;

				})

				function disableAllTheseDays(date) {
					var dd = date.getDate();
					var mm = date.getMonth() + 1;
					var yyyy = date.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					dat = yyyy + '-' + mm + '-' + dd;

					for (i = 0; i < attendancedate.length; i++) {
						if ($.inArray(dat, attendancedate) != -1) {
							return [ true, "Highlighted" ];
						}

					}
					return [ true ];
				}

			} //end success

		}) //ajax

	}); //end 데이트피커
</script>
</head>


<body>

	<form class="form-horizontal" role="form" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" placeholder="이름"
					readonly="readonly" value="${userid.name }" name="name">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">생년월일</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="birthdate" readonly="readonly"
					value="${userid.birthdate }" name="birthdate">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="name"
					placeholder="password" readonly="readonly"
					value="${userid.password }" name="password">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">gender</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="gender" readonly="readonly" value="${userid.gender }"
					name="gender">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">phone_num</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="phone_num" readonly="readonly"
					value="${userid.phone_num }" name="phone_num">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="exampleInputEmail2">email</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" placeholder="이메일"
					readonly="readonly" value="${userid.email }" name="email">
			</div>
		</div>
		<input type="hidden" value="${userid.id }" name="id">

		<div id="sub"></div>
	</form>






	<button type="button" class="btn btn-success" id="modify">내정보수정</button>
	<a href="myattendancecheck" class="btn btn-success" role="button">출석목록보기</a>

	<div class="container" id="att">
		<h2>내 출석률</h2>
		<div class="progress">
			<div class="progress-bar active" role="progressbar"
				aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"
				style="width:${attendancelate}%">${attendancelate }%Complete</div>
		</div>
	</div>

	이번달 출석 보기
	<input type="text" id="date1">


</body>
</html>