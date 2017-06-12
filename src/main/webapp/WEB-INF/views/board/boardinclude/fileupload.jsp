<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.fileDrop {
	width: 100%;
	height: 1000px;
	border: 1px dotted blue;
}

small {
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
</style>


</head>
<body>
	<!-- 파일 드랍영역보다 스크립트를 아래 써야 이벤트가 제대로 발생함 -->
	<div class="fileDrop">
		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>파일명</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody id="result">
					<c:forEach items="${dto.flist}" var="flist">
						<tr>
							<td>
							<form action="../ajax/downloadajax" method="post">
							<input type="submit" value="${flist.originalfilename }">
							<input type="hidden" name="realuploadpath" value="${flist.realuploadpath}">
							</form>
							</td>
							<td>${flist.uploaddate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>

	<script type="text/javascript">
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		$(".fileDrop").on(
				"drop",
				function(event) {
					var user = '${userid.classification}';
					if(user == 'student'){
						alert('업로드가 금지되었습니다.')
						event.preventDefault();
						return;
					}
					event.preventDefault();

					var files = event.originalEvent.dataTransfer.files;

					var formData = new FormData();

					for (var i = 0; i < files.length; i++) {

						formData.append("file", files[i]);

					}

					$.ajax({
						url : '/test/ajax/uploadajax',
						data : formData,
						dataType : 'json',
						processData : false,
						contentType : false,
						type : 'POST',
						success : function(data) {

							var result = "";
							$.each(data, function(idx, data) {
								
								console.log(data.realuploadpath);
								result += "<tr><td><form action=/test/ajax/downloadajax method=POST>"
								+"<input type=hidden name=realuploadpath value="+data.realuploadpath+">"
										+ "<input type=submit value="+data.originalfilename+">"+ 
										"</td>"
										+ "<td>" + data.uploaddate
										+ "</td></tr>";

							})
							$("#result").prepend(result);

						}

					})

				});
	</script>


</body>
</html>