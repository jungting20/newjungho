<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 

<c:if test="${isnoti }">
<script>
Notification.requestPermission(function (result) {
    //요청을 거절하면,
if (result === 'denied') {
    return;
}
//요청을 허용하면,
else {
    //데스크탑 알림 권한 요청 버튼을 비활성화
   requestPermissionButton.attr('disabled', 'disabled');
    //데스크탑 메시지 입력폼을 활성화
    notificationMessage.removeAttr('disabled');
    //데스크탑 메시지 요청 버튼을 활성화
    notificationButton.removeAttr('disabled');
    return;
}
});

var message = "가입승인 요청이있습니다";

    var options = {
        body: message
        
}
    
    var notification = new Notification("가입승인 요청여부", options);
    setTimeout(function () {
        
        notification.close();
    }, 10000);


</script>


</c:if>




 <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>출석일</th>
        <th>출석시간</th>
        
      </tr>
    </thead>
    <c:forEach var ="list" items="${list}">
    <tbody>
      <tr>
        <td>${list.student_id }</td>
        <td>${list.student_name }</td>
        <td>${list.course_date }</td>
        <td>${list.tag_time }</td>
      
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
  
  <a href="todayabsence" class="btn btn-success" role="button">출석하지않은인원확인하기</a>
