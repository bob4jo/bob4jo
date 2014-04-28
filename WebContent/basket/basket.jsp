<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>장바구니</title>
		<meta charset="utf-8"/>
		<link rel="stylesheet" type="text/css" href="view/basket.css"/>

		<script type="text/javascript">
<!-- 전체선택 -->	
		var checkflag = "false";
		function check(field){
		if (checkflag == "false") {
		for (i = 0; i < field.length; i++) { // 폼필드를 체크하여 모두체크되었다면
		field[i].checked = true;
		}
		checkflag = "true";
		return "전체해제"; // 버튼 레이블을 '해제' 로 바꿈
		}
		else {
		for (i = 0; i < field.length; i++) {
		field[i].checked = false;}
		checkflag = "false";
		return "전체선택";
		}}

		</script>
		
<!-- 폼 여러개 사용 -->
<script>
	 

	  function openUpdate(myform){ //스크립트 이름(폼정보)

	  myform.action="updateBasket.action?m_Ea="+myform.m_Ea.value+"&no="+myform.no.value; //폼정보를 보낼 액션	  
	  

	  myform.submit(); //서브밋 명령어 추가

	  }

</script>
	</head>
	<body>
	<div id="top">
		<font size="2">
		<div align="right">
		  <ul align="right">
		    <li><a href="index.html">home</a></li> 
		    |
		    <li><a href="index.html">로그인</a></li> 
		    |
		    <li><a href="index.html">회원가입</a></li> 
		    |
		    <li><a href="index.html">마이페이지</a></li> 
		    |
		    <li><a href="index.html">고객센터</a></li> 
	      </ul>
  </div>

	</div>
	</font>
	</div>
	<div id="header">
			
			<font size="7">
				<ul>
					<li><a href="index.html">메뉴1 </a></li>  |
					<li><a href="index.html">메뉴2 </a></li>  |
					<li><a href="index.html">메뉴3 </a></li>  |
					<li><a href="index.html">메뉴4 </a></li>
				</ul>
			</font>
	</div>
		
	<div id="wrapper">
		<div id="content">
			<div id="content1">

			<table width="920px" border="1">
			
				<tr>
					<td width="60px"><!-- <input type=button value="전체선택" onClick="this.value=check(this.form.checkAll)"> --></td>
					<td colspan="5">상품명</td>
					<td>상품금액</td>
				</tr>
	<c:forEach var="list" items="${list}" varStatus="status"> 
		<form name="myform" action="" method="post">
		<c:set var="store" value="${list.store }"/>
				<tr>
					<td><!--  <input type="checkbox" name="checkAll"   value=""/>-->
					<c:set var="number" value="${list.no -1}" /> 
					<c:out value="${list.no}" /> <%--리스트 번호 세팅하는 곳 --%>
         			 
         			 <c:set var="mul" value="${list.m_Price * list.m_Ea }"/></td>
					<td width="110px"><div class="box1"><이미지></div></td>
					<td colspan="3">${list.store }</td>
					<td><input type="button" name="deleteOne" value="삭제"  onclick="document.location.href='deleteBasketOne.action?no=${list.no}'"/></td>
					<td rowspan="2">합계 ${mul } 원</td>
				</tr>
				<tr>
					<td><!--  <input type="checkbox" name="checkAll" />--></td>
					<td>${list.m_Name } |</td> 
					<td>${list.m_Price }원</td>
					<td>
					<input type="text" size="1" name="m_Ea" value="${list.m_Ea }" />
					<input type="hidden" name="no" value="${list.no }"/>
					<input type="button" name="update" value="변경" onclick="openUpdate(this.form)"/>
					</td>
					<td> 합계 ${mul } 원</td> 
					<td><input type="button" name="deleteOne" value="삭제"/></td>
				</tr>
		</form>
			
	</c:forEach>
				
				<tr>
					<td colspan="7"><input type="button" name="delete" value="장바구니 비우기" 
					onclick="document.location.href='deleteBasket.action?myid=myid'"/></td> 
					
				</tr>
			
			</table>
			<table>
				<tr align="center">
    		<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    	      </tr>
			</table>
			
			</div>
		</div>

		<div id="middle">
			<table width="920px">
				<tr>
					<td>주문금액</td>
					<td>포인트</td>
					<td>결제 예정금액</td>
				</tr>
				<tr>
					<td><input type="text" name="sum" value=""/></td>
					<td><input type="text" name="point" value="0"/></td>
					<td><input type="text" name="" value=""/></td>
			</table>
		</div>

		<div id="siderbar">
			<div id="siderbar1">
				<center>
				<input type="button" name="" value="쇼핑 계속하기" onclick="document.location.href='ms_MenuMain.action'"/>
				<input type="submit" name="" value="주문결제" />
			</center>
			</div>
		</div>
	</div>

	<div id="footer">
		<ul>
			<li><a href="index.html">Base</a></li>
			<li><a href="index.html">Base</a></li>
		</ul>
	</div>
	</body>
</html>