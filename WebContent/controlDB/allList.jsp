<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../HTML/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
<tr>
<th>学生番号</th><th>学生名</th><th>コース名</th>
</tr>
<tr>
<c:forEach var="student" items="${list}">
<th>${student.id}</th><th>${student.name}</th><th>${student.course}</th>
</c:forEach>
</tr>
</table>

<%@include file="../HTML/footer.html"%>