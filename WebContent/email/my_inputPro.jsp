


 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style type="text/css">
 body,td,th {
	color: #666;
}
 </style>
 
  <table width="200" border="0" align="center">
     <tr>
      <td colspan="2"><h1>&nbsp;</h1>
      <h1>&nbsp;</h1>
      <h1>&nbsp;</h1>
      <h1>안녕하세요. ${myname}님${myid }</h1></td>
    </tr>
   <tr>
      <td colspan="2"><img src="/ProjectStore/email/img/inpu2.jpg" width="300" height="200"></td>
    </tr>
    <tr>
      <td><a href="mc_member/mc_LoginForm.action"><img src="/ProjectStore/email/img/login.jpg" width="150" height="75"  align="right"></a></td>
      <td><img src="/ProjectStore/email/img/mypage.jpg" width="150" height="75">
      <form method="post" action="my_SendMailAction.action">
      <input type="hidden" name="myid" value="${myid }"/>
      <input type="submit" name="confirm" value="이메일체크"/>
            <!-- <input type="button" name="confirm_email" value="이메일체크" onclick="javascript:location.href='my_SendMailAction.action?myid=${myid}'"/> -->
     </form> </td>
    </tr>
  
  </table>
  
 <p/><p/>