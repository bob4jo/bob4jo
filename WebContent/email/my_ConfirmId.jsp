<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="color.jsp"%>
<html>
<head><title>ID 중복확인</title>




<body bgcolor="${bodyback_c}">

<c:if test="${my_memberdto.myid != null}"> 

<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${title_c}">
    <td height="39" >${myid}이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="my_ConfirmId.action">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td bgcolor="${ value_c}" align="center"> 
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="myid"> 
       <input type="submit" value="ID중복확인"  >
    </td>
  </tr>
</table>
</form>

</c:if>
 <c:if test="${my_memberdto.myid == null}"> 
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${ title_c}"> 
    <td align="center"> 
      <p>입력하신 ${myid} 는 사용하실 수 있는 ID입니다. </p>
      <input type="button" value="닫기" onClick="setid()">
    </td>
  </tr>
</table>
</c:if>

</body>
</html>
<script language="javascript">
<!--
  function setid()//현재 창의 userinput의 id값으로 넣는다 
    {		
    	opener.document.userinput.myid.value="${myid}"; 
		self.close();
		}
		-->
</script>


