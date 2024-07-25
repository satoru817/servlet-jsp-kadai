<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.ArrayList" %>


<html>
	<head>
		<title>kadai_web_app</title>
		<link href="https://fonts.googleapis.com/earlyaccess/nikukyu.css" rel="stylesheet">
		<link rel="stylesheet" hreef="nikukyu.css">
	</head>
	<body>
		<h2>入力内容をご確認ください</h2>
		<p>問題なければ「確定」、修正する場合は「キャンセル」をクリックしてください</p>
		<table border="1">
			<tr>
				<th>項目</th>
				<th>入力内容</th>
			</tr>
			<tr>
				<td>氏名</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td>${email}</td>
			</tr>
			<tr>
				<td>住所</td>
				<td>${address}</td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td>${phone_number}</td>
			</tr>
		</table>
		
		<%
		ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
			
		String disableConfirm = (errorList !=null) ? "disabled":"";
		%>
		
		<p>
			<button onclick="location.href='<%=request.getContextPath()%>/complete';"
					<%=disableConfirm %> method="post"
			>確定</button>
			
			<button onclick="history.back();">キャンセル</button>
		</p>
		
		<%
		if(errorList !=null){
			for(String errorMessage: errorList){
				out.println("<font color=\"red\">"+errorMessage+"</font><br>");
			}
		}
		
		%>
		
		
		
		
		
		
		
		
		
		
		
		
		