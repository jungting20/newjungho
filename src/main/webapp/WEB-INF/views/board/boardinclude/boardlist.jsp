<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {

 $("#prev").click(function(){
	 
	 console.log('함수실행?')
	 var url = 'boardlist?page=${dto.binfo.page-1}'
	 
	 $(location).attr('href',url);
	 
 });
 
 $("#next").click(function(){
	 
	 console.log('함수실행?')
	 var url = 'boardlist?page=${dto.binfo.page+1}'
	 
	 $(location).attr('href',url);
	 
 });
 
 
});
</script>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
			<tr>
			<th>번호</th>			
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${dto.list}" var="list">
			<tr>
			<td>${list.id }</td>
			<td>${list.title }</td>
			<td>${list.writer_id }</td>
			<td>${list.written_date }</td>
			<td>${list.readcnt }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="" class="btn btn-default pull-left">글쓰기</a>
		
		<div class="text-center">
			<ul class="pagination">
			
			<c:out value="${dto.prev?'<li><a href=# id=prev>prev</a>':'' }" escapeXml="false"></c:out>
			<c:forEach begin="${dto.startpage }" end="${dto.endpage }" varStatus="i">
			<c:choose>
			<c:when test="${dto.binfo.page != i.current}">
			<li><a href="boardlist?page=${i.current}">${i.current}</a></li>
			</c:when>
			<c:otherwise>
			<li class="active"><a>${i.current}</a></li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:out value="${dto.next?'<li><a href=# id=next >next</a>':'' }" escapeXml="false"></c:out>
			</ul>
			
		</div>
		<form action="boardlist">
		<select name="searchtype">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">글쓴이</option>
		</select>
		<input type="text" name="search">
		<input type="submit" value="검색">
		<input type="hidden" value=1 name="page">
		<input type="hidden" value=10 name="perpagelist">
		</form>
		
	</div>
</body>
