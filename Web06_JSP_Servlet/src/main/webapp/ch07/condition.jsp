<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>condition</title>
 <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 100px;
        }
        .message {
            font-size: 24px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
            display: inline-block;
        }
        .weekday {
            background-color: #3498db;
            color: white;
        }
        .weekend {
            background-color: #2ecc71;
            color: white;
        }
    </style>
</head>
<body>
	<%
		int day = 1; // 지역변수
	%>

	<%
		if(day == 1 || day == 7) {
			// HTML에 출력
	%>
		<!-- <p>오늘은 주말입니다.</p> -->
		<div class="message weekend">오늘은 주말입니다.</div>
	<%
		} else {
	%>
		<!--	<p>오늘은 평일입니다.</p>  -->
		<div class="message weekday">오늘은 평일입니다.</div>
	<%
		}
	%>
</body>
</html>








