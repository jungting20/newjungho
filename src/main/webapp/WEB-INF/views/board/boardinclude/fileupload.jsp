<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.fileDrop {

width:100%;
height:1000px;
border:1px dotted blue;


}

small {
margin-left:3px;
font-weight:bold;
color:gray;

}


</style>


</head>
<body>
<!-- 파일 드랍영역보다 스크립트를 아래 써야 이벤트가 제대로 발생함 -->
<div class="fileDrop">





</div>

<script type="text/javascript">

$(".fileDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".fileDrop").on("drop",function(event) {
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var formData = new FormData();
	
	for(var i = 0 ; i < files.length ; i++){
		
	formData.append("file",files[i]);
	
	}
	
	$.ajax({
		url:'/test/ajax/uploadajax',
		data:formData,
		dataType:'json',
		processData:false,
		contentType:false,
		type:'POST',
		success:function(data){
			
			alert(data);
			console.log(data);
		}
		
	})
	
	
	
});


</script> 




</body>
</html>