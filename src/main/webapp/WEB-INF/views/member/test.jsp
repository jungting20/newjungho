<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>


<script type="text/javascript">


	$.getJSON("../ajax/getattendanceday",function(data){
		
		console.log('안녕',data);
		var aa = new Array();
		$.each(data,function(i,data){
			console.log(data.course_date);
			console.log(i);
			aa[i]=data.course_date;
			
		});
				
		
	console.log(aa);
		
		
	})
	


</script>


</body>
</html>