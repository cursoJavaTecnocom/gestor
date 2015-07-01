<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<c:if test="${ not logado }">
<jsp:forward page="noLogado.gin"></jsp:forward>
</c:if> 