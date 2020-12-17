<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<meta charset="UTF-8">
		<title>테스트 페이지(사원관리)</title>
	<script>
		//ajax로 전체 데이터를 끌어옴
		function init() {
			tempmap = new Map();
			var time = new Date();
			$("#dude").html("<div class='log_message'>This is the Newest Version at "+time+".</div>");
			$.ajax({
				method : "post"
				, url  : "getAll"
				, success : output
			});
		}
		function output(resp){
			var instantHTML = "<table border='2'><tr><td><input class='chkall' type='checkbox'></td>"
							+"<th>사원번호</th><th>부서번호</th><th>사원이름(성)</th><th>사원이름(이름)</th><th>직책</th>"
							+"<th>우편번호</th><th>전화번호</th><th>배우자</th><th>호봉</th><th>급여</th></tr>";
			for ( var i in resp) {
				instantHTML += "<tr><td><input class='chkbox' type='checkbox' name='chkbox'></td>";
				instantHTML += "<td class='empno'>"+resp[i].empno+"</td><td id='deptno'>"+resp[i].deptno+"</td><td id='fname'>"+resp[i].fname+"</td><td id='mname'>"+resp[i].mname+"</td>";
				instantHTML += "<td id='position'>"+resp[i].position+"</td><td id='cpnum'>"+resp[i].cpnum+"</td><td id='zipcode'>"+resp[i].zipcode+"</td><td id='married'>"+resp[i].married+"</td>";
				instantHTML += "<td id='salevel'>"+resp[i].salevel+"</td><td id='salary'>"+resp[i].salary+"</td></tr>";
			}
			instantHTML += "</table>";
			$("#datarea").html(instantHTML);
			alert("성공했습니다.");
		}
		var recordcnt = 0;
		var listlist = new Array();
		var tempmap = new Map();
		$(function(){//Ajax기능 활용하기 - 버튼 1,2
			$('#dude').css('border','1px solid blue');
			$("*").css("color","green");
			setInterval(drawData,1000);
			$("#reqBtn1").on("click", reqAjax1);//버튼1 = 사원번호로 필터링조회
			$("#reqBtn2").on("click", reqAjax2);//버튼2 = 전 사원 조회
			$(document).on("change", ".chkbox", chkfunc);
			$(document).on("change", ".chkall", chkall);
			init();
		});
		function chkall(){
			alert("ok!")
			if (tempmap) {
			}
		};
		function chkfunc(){//this의 활용과 parent의 활용을 반드시 기억해두는 것이 좋다.
			var upperarr = new Object();
			head = $(this).parent().parent().children(".empno").text();
			body = $(this).parent().parent().text();
			if ($(this).is(":checked")){
				tempmap[head] = body;
				console.log(tempmap);
				}else{
					delete tempmap[head];
					}
		}
		function reqAjax1(){
			var empno = $("#textarea").val();
			var soption = $("#searchopt").val();
			$("#output").html("Please input "+soption);
			if (empno==""){
				alert("Please input "+soption)};
				return;
		};
		function drawData(){
			tiime = new Date();
			$("#output").html(tiime); 
		};
		function reqAjax2(){
			init();
		};
	</script>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	<h2>
		お前何してるの？ああ？
	</h2>
	<input id="reqBtn2" type="button" value="전 사원목록 새로고침" />
	<div id="refresh_message"></div>
	<p>
	<div id="datarea"><!-- 표가 나오는 부분 -->
	</div>
	<div id="dude"><!-- 표가 나오는 부분 -->
	</div>
	<div id="inputarea">
	<input id="textarea" type="text" name="textarea">
	<select id="searchopt">
		<option value="사번">사번</option>
		<option value="이름(성)">이름(성)</option>
		<option value="이름">이름</option>
		<option value="부서번호">부서번호</option>
		<option value="부서명">부서명</option>
		<option value="직위">직위</option>
	</select>
	<input id="reqBtn1" type="button" value="검색" />
	<p>
	
	<input id="reqBtn3" type="button" value="신입사원 등록" />
	</div>
	<div id="output">
	
	</div>
	<!-- script area begin -->
	
	<!-- script area end -->
</body>
</html>
