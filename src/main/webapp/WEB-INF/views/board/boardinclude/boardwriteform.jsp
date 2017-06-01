<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta charset="UTF-8">



<link rel="stylesheet"
href="//fonts.googleapis.com/css?family=Roboto:400,300,500,500italic,700,900,400italic,700italic">


<style>
section {
margin-top: 50px;
margin-bottom: 50px;
margin-right: 50px;
margin-left: 50px;
}
h1 {
font-family: "Times New Roman", Times, serif;
text-align: center;
}
span.space {
margin-left: 10px;
}
.space_top{
margin-top: 10px;
}
</style>
</head>
<body>
<form action="boardwriteform" method="post">
<section>
  <div class="form-group">
   <label class="col-sm-2 control-label" for="wr_subject"><b>제목</b><strong
    class="sound_only">필수</strong></label>
   <div class="col-sm-10">
    <div class="input-group">
     <input type="text" name="title" id="wr_subject"
      required class="form-control input-sm" size="50" maxlength="255">
     <span class="input-group-btn" role="group"> 
		<span class="space"></span>
      <button type="button" id="btn_autosave" data-toggle="modal"
       data-target="#autosaveModal" class="btn btn-black btn-sm">
       저장 (<span id="autosave_count">0</span>)
      </button>
     </span>
    </div>
   </div>
  </div>
  <div class="form-group">
<div class="col-sm-12">
  <div class="space_top">
    <textarea class="space_top" id="wr_content" name="content" style="width:100%; height: 300px" maxlength="65536"></textarea> </div>
</div>
</div>
<div class="form-group">
  <label class="col-sm-2 control-label" for="wr_link1">링크 #1</label>
  <div class="col-sm-10">
   <input type="text" name="wr_link1" value="" id="wr_link1" class="form-control input-sm" size="50">
       <div class="text-muted font-12" style="margin-top:4px;">
     유튜브, 비메오 등 동영상 공유주소 등록시 해당 동영상은 본문 자동실행
    </div>
     </div>
</div>
<div class="write-btn pull-center">
<input type="submit" value="작성완료" class="btn btn-info">
<a href="boardlist?page=${info.page }&perpagelist=${info.perpagelist}&
searchtype=${info.searchtype}&search=${info.search}" 
class="btn btn-danger" role="button">작성취소</a>
</div>
<div class="clearfix"></div>
</section>
<input type="hidden" name="category" value=${param.category }>
<input type="hidden" name="writer_id" value="${userid.id }">
</form>

