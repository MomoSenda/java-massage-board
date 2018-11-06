<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>掲示板アプリケーション</h2>
	<br>


	<form:form modelAttribute="articleForm"
		action="${pageContext.request.contextPath}/article/insertArticle">
投稿者名：<form:input path="name" />
		<br>
投稿内容：<form:textarea path="content" />
		<br>

		<input type="submit" value="記事投稿">
	</form:form>
	<br>
	<br>
	<hr>

	<c:forEach var="article" items="${articleList}">
投稿ID:<c:out value="${article.id}" />
		<br>
投稿者名：<c:out value="${article.name}" />
		<br>
投稿内容：<c:out value="${article.content}" />
		<br>
		<form action="${pageContext.request.contextPath}/article/deleteArticle" method="post">
		
		<input type="hidden" name="id" value="${article.id}">
		<input type="submit" value="削除">
		</form>
		<br>
		<br>
		<c:forEach var="comment" items="${article.commentList}">
コメントID:<c:out value="${comment.id}" />
			<br>
コメント者名：<c:out value="${comment.name}" />
			<br>
コメント内容：<c:out value="${comment.content}" />
			<br>
			<br>


		</c:forEach>

		<form:form modelAttribute="commentForm"
			action="${pageContext.request.contextPath}/article/insertComment">
名前：<form:input path="name" />
			<br>
コメント：<form:textarea path="content" />
			<br>
			<input type="submit" value="コメント投稿">
			<input type="hidden" name="articleId" value="${article.id}">
			<!-- nameはdomainやcontrollerの表示形式と合わせる -->
			<!-- commentのarticleIdは、articleのid なので、valueにはarticle.idを入れないと、値が来ない。-->
			<hr>
		</form:form>
		<br>

	</c:forEach>



</body>
</html>