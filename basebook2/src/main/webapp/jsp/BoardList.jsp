<%@page import="java.util.List"%>
<%@page import="servlets.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<link href='css/bootstrap.min.css' rel='stylesheet' media='screen'>
<link rel='stylesheet' type='text/css' href='css/common.css'>
</head>
<body>
	<div id=add_content>
		<form id='formdata' role='form' action='add' role='form' method='post'>
			<textarea id='formarea' name=content class=form-control rows='10'
				cols='35' placeholder='내용을 추가해주세요!'></textarea>
			<input id='formurl' name=url class=form-control type='text'
				placeholder='이미지URL or 유투브 URL'> <input id='formid' name=id
				class=form-control type='text' placeholder='아이디'> <input
				id='formpassword' name=password class=form-control type='password'
				placeholder='비밀번호'>
			<button id='form_btn1' type='submit' class='btn btn-large btn-block'>Write</button>
			<button id='form_btn2' type='reset' class='btn btn-large btn-block'>Cancle</button>
		</form>
	</div>
	<div class=container>
		<section> 
		
		
		<c:forEach items="${boardList}" var="board">
		
			<table class='${board.contentPassword}'
				id='t${board.contentNo}'>
				<tr>
					<th id='i${board.contentNo}'>${board.contentId}
					<th>
				</tr>
				<tr>
					<td>
						<%
							if (board.getContentAvi() != "") {
									String[] urlSplit = board.getContentAvi().split("\\.");

									if (urlSplit[urlSplit.length - 1].equals("png")
											|| urlSplit[urlSplit.length - 1].equals("jpg")
											|| urlSplit[urlSplit.length - 1].equals("jpeg")) {
										out.println("<center><img id='" + "u"
												+ board.getContentNo() + "' src='"
												+ board.getContentAvi()
												+ "' width='450' ></center>");

										//만약 무언가 주소가 있다면
										//http://youtu.be/1WRuSEPKS0I
									} else {
										for (int i = 0; i < board.getContentAvi().split("/").length; i++) {
											if (board.getContentAvi().split("/")[i]
													.equals("youtu.be")) {
												out.println("<center><iframe id='"
														+ "u"
														+ board.getContentNo()
														+ "' width='450' height='300' src='//www.youtube.com/embed/"
														+ board.getContentAvi().split("/")[board
																.getContentAvi().split("/").length - 1]
														+ "' frameborder='0' allowfullscreen></iframe></center>");
											}
										}
									}
								}
						%>


					</td>
				</tr>
				<tr>
					<td><pre id='p${board.contentNo}'>${board.contentContent}</pre></td>
				</tr>
				<tr id='iconCombine'>
					<td><span id=l${board.contentNo}
						class='btn_like glyphicon glyphicon-thumbs-up' aria-hidden='true'>${board.contentLike}</span>
						<span id=k${board.contentNo}
						class='btn_unlike glyphicon glyphicon-thumbs-down'
						aria-hidden='true'>${board.contentUnlike}</span> <span
						id=u${board.contentNo}
						class='btn_update glyphicon glyphicon-pencil' aria-hidden='true'></span>
						<span id=d${board.contentNo}
						class='btn_delete glyphicon glyphicon-remove' aria-hidden='true'></span>
						<span class='btn_reply glyphicon glyphicon-user'
						aria-hidden='true'>0</span></td>
				</tr>
			</table>
			</br>
			</br>


		</c:forEach> </section>
		<header>&nbsp; &nbsp; &nbsp; &nbsp; BASEBOOK</header>
		<footer> </br>
		@bit.co.kr 윤용식,김광철,김원기</footer>
		<script src='js/jquery-1.11.1.js'></script>
		<script src='js/bootstrap.min.js'></script>
		<script src='js/respond.js'></script>
		<script src='js/common.js'></script>
</body>
</html>