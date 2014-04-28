<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>개인회원가입</title>



<script>

var checkobj

function agreesubmit(el){
checkobj=el
if (document.all||document.getElementById){
for (i=0;i<checkobj.form.length;i++){  
var tempobj=checkobj.form.elements[i]
if(tempobj.type.toLowerCase()=="submit")
tempobj.disabled=!checkobj.checked
}}}

function defaultagree(el){
if (!document.all&&!document.getElementById){
if (window.checkobj&&checkobj.checked)
return true
else{
alert("동의 하지 않으면 버튼을 클릭 할 수 없습니다")
return false
}}}
</script>
</head>


<body>

<form method="post" action="my_inputAction.action" name="agreeform" onSubmit="return defaultagree(this)">
  <table width="600" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr> 
    <td colspan="2" height="39" align="center" bgcolor="${value_c}" >
       <font size="+1" ><b>개인회원가입</b></font></td>
    </tr>
    

    <tr> 
      <td width="200"> *회원아이디</td>
      <td width="400"> 
        <input type="text" name="myid"  value="${myid}"size="10" maxlength="12">
        <input type="button" name="confirm_id" value="ID중복확인" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    <tr> 
      <td width="200"> *비밀번호</td>
      <td width="400" > 
        <input type="passwd" name="passwd"  value="${passwd}"size="15" maxlength="12">
      </td>
    <tr>  
      <td width="200">*비밀번호 확인</td>
      <td width="400"> 
        <input type="password" name="passwd2"  value="${passwd}" size="15" maxlength="12">
      </td>
    </tr>
    
   
    <tr> 
      <td width="200">*성명</td>
      <td width="400"> 
        <input type="text" name="myname"  value="${myname}"size="15" maxlength="10">
      </td>
    </tr> 
    <tr>
	<td width="200">*성별</td>
	 <td width="400"> 
	 <input type="text" name="gender"  value="${gender}"size="15" maxlength="10">
	<!--  	남자 <INPUT  TYPE="radio" NAME="gender"  VALUE="1"  checked>-->
	        <!--     여자 <INPUT TYPE="radio" NAME="gender" VALUE="2"><p>-->
	          </td>
</tr>
<tr>
	<td width="200">*생년월일</td>
	 <td width="400"> 
	 <input type="text" name="year1" size="10" maxlength="12">년
	  <input type="text" name="month1" size="10" maxlength="12">월
        <input type="text" name="date1" size="10" maxlength="12">일
         </td>
</tr>
    <tr> 
      <td width="200">*E-Mail</td>
      <td width="400"> 
        <input type="text" name="email" size="40" value="${email}"maxlength="30">
      </td>
    </tr>
    <tr> 
      <td width="200"> *연락처</td>
      <td width="400"> 
        <input type="text" name="hp1" size="10" maxlength="10">-
        <input type="text" name="hp2" size="10" maxlength="10">-
        <input type="text" name="hp3" size="10" maxlength="10">
      </td>
    </tr>
 
     <tr> 
      <td colspan="2" align="center" bgcolor="${value_c}"> 
      	<input name="agreecheck" type="checkbox" onClick="agreesubmit(this)"><b>예, 동의 합니다</b>
          <input type="submit" name="confirm" value="등   록" disabled>
          <input type="reset" name="reset" value="다시입력">
          <input type="button" value="가입안함" onClick="javascript:window.location='mc_loginForm.jsp'">
      </td>
    </tr>
     
  </table>
</form>
<script>
	document.forms.agreeform.agreecheck.checked=false
</script>
</body>
</html>
