<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="student" items="${list}">
	${student.id}:${student.name}:${student.course}<br>
</c:forEach>

<%@include file="../footer.html"%>