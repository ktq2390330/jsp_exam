<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<p>追加する生徒の情報を入力してください。</p>
<form action="insert" method="post">
氏名<input type="text" name="name">
コース名<input type="text" name="course">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html"%>