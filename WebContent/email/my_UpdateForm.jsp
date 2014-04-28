    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="color.jspf"%>
<html>

<title>회원정보수정</title>
<link href="style.css" rel="stylesheet" type="text/css">


<script language="JavaScript">
   <!-- 
    function checkIt() {
        var userinput = eval("document.userinput");
               
        if(!userinput.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.myname.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        
        
    }
-->
</script>

<body bgcolor="${bodyback_c}">
<form method="post" action="my_UpdateAction.action" name="userinput" onsubmit="return checkIt()">

  <table width="600" border="1" cellspacing="0" cellpadding="3"  align="center">
    <tr > 
      <td  colspan="2" height="39" bgcolor="${title_c}" align="center">
	     <font size="+1" ><b>개인회원 정보수정</b></font></td>
    </tr>
    <tr>
     
    </tr>
     

    <tr> 
      <td  width="200"> 회원아이디</td>
      <td  width="330"> ${memId}</td>
       <input type="hidden" value="${memId}" name="myid">
  </tr>
    
     <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400"> 
        <input type="password" name="passwd" size="10" maxlength="10" value="${session.my_memberdto.passwd}">
      </td>
    </tr>
    <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400"> 
        <input type="password" name="passwd2" size="10" maxlength="10" value="${c.passwd2}">
      </td>
    </tr>
    
    <tr> 
      <td   width="200">성명</td>
      <td  width="400"> 
        <input type="text" name="myname" size="15" maxlength="20" value="${c.myname}">
      </td>
    </tr>
    <tr> 
      <td   width="200">성별</td>
      <td  width="400"> 
        <input type="text" name="gender" size="15" maxlength="20" value="${c.gender}">
      </td>
    </tr>
  <!--    <tr> 
      <td width="200">성별</td>
      <td width="400"> 
       ${c.gender}
      </td>
    </tr> --> 
   <tr>
	<td width="200">생년월일</td>
	 <td width="400"> 
	 <input type="text" name="year1" size="10" maxlength="12"value="${c.year1}">년
	  <input type="text" name="month1" size="10" maxlength="12"value="${c.month1}">월
        <input type="text" name="date1" size="10" maxlength="12"value="${c.date1}">일
         </td>
</tr>
    <tr> 
      <td width="200">E-Mail</td>
      <td width="400">
	    
          
          <input type="text" name="email" size="40" maxlength="30" value="${ c.email}">	
	
      </td>
    </tr>
    <tr> 
      <td width="200"> *연락처</td>
      <td width="400"> 
        <input type="text" name="hp1" size="10" maxlength="10" value="${c.hp1}">-
        <input type="text" name="hp2" size="10" maxlength="10"value="${c.hp2}">-
        <input type="text" name="hp3" size="10" maxlength="10"value="${c.hp3}">
      </td>
    </tr>    
    <tr> 
      <td colspan="2" align="center" bgcolor="${ value_c}"> 
       <input type="submit" name="modify" value="수   정" >
       <input type="button" value="취  소" onclick="javascript:window.location='main.ch'">      
      </td>
    </tr>
  </table>
</form>
</body>

</html>