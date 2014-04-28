<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>상세메뉴</title>
		<meta charset="utf-8"/>
		<link rel="stylesheet" type="text/css" href="view/styleMenu.css"/>
		
				
	<!-- 즉시구매 -->
  	<script>
	 function ck(f){
	
		 alert("전송완료"); 

	//f.submit(); //폼전송
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
			<center>
			<select>
			<option name="local">영등포</option>
			<option name="local">영등포</option>
			<option name="local">영등포</option>
		</select>
		<input type="button" name="local1" value="button"/>
	</center>
	</div>
		
	<div id="wrapper">
		<div id="content">
			<div id="content1">
			<p>이제 얼굴이 만들어지니 뭔가...이제 얼굴이 만들어지니 뭔가...이제 얼굴이 만들어지니 뭔가...이제 얼굴이 만들어지니 뭔가...이제 얼굴이 만들어지니 뭔가...
			</div>
			<div id="content2">
			<div class="box1">매장사진</div>
			</div>
		</div>
		<div id="middle">
		  <table width="960" border="0" cellpadding="0" cellspacing="0" id="Table_01">
            <tr>
              <td><form name="form1" method="post" action="">
                <label><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image5','','images/index_1.jpg',1)"><img src="images/index_01.jpg" name="Image5" width="240" height="65" border="0"></a></label>
              </form>              </td>
              <td><form name="form2" method="post" action="">
                <label><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image6','','images/index_02.jpg',1)"><img src="images/index_2.jpg" name="Image6" width="240" height="65" border="0"></a></label>
              </form>              </td>
              <td><form name="form3" method="post" action="">
                <label><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image7','','images/index_3.jpg',1)"><img src="images/index_03.jpg" name="Image7" width="240" height="65" border="0"></a></label>
              </form>              </td>
              <td><form name="form4" method="post" action="">
                <label><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image8','','images/index_4.jpg',1)"><img src="images/index_04.jpg" name="Image8" width="240" height="65" border="0"></a></label>
              </form>              </td>
            </tr>
          </table>
		</div>
		<div id="siderbar">
			<div id="siderbar1">
				<ul>
					<c:forEach var="list"  items="${list}" varStatus="status">
						<li class="box2">
						<img src="/ProjectStore/ms_UploadFile/store/${list.sfile_Savname}"  width="120" height="200" />
						<input type="checkbox" name="check" vlaue="1">빅맥<br/>
						<input type="text" name="m_Ea" size="1" value="${list.m_Ea }"><br/>
						가격: 123456원<br/>
						</li>
						<!--<c:if test ="${status.count%4 eq 0 }"></tr></c:if>-->
   					 </c:forEach>
				</ul>
			</div>
			<form action="basket.action" >
				<input type="hidden" name="s_No" value="1"/>
				<input type="hidden" name="myid" value="myid"/>
				<input type="hidden" name="store" value="맥도날드"/>
				<input type="hidden" name="sfile_Savname" value="sfile_Savname"/>
				<input type="hidden" name="m_category" value="m_category"/>
				<input type="hidden" name="m_No" value="2"/>
				<input type="hidden" name="m_Name" value="빅맥"/>
				<input type="hidden" name="m_Price" value="5000"/>
				<input type="hidden" name="m_Savname" value="m_Savname"/>
				<input type="hidden" name="m_Ea" value="1"/>
				
				<input type="submit" name="basket" value="장바구니 담기" />
			</form>
				
			<form action="my_inputForm.action" mothod="post">
				<input type="hidden" name="s_No" value="1"/>
				<input type="hidden" name="myid" value="myid"/>
				<input type="hidden" name="store" value="맥도날드"/>
				<input type="hidden" name="sfile_Savname" value="sfile_Savname"/>
				<input type="hidden" name="m_category" value="m_category"/>
				<input type="hidden" name="m_No" value="2"/>
				<input type="hidden" name="m_Name" value="빅맥"/>
				<input type="hidden" name="m_Price" value="5000"/>
				<input type="hidden" name="m_Savname" value="m_Savname"/>
				<input type="hidden" name="m_Ea" value="1"/>
				
				<input type="button" onclick=ck(this.form) value="주문하기"/>
			 </form>
		</div>
		<div class="buy" align="center">
			<p>장바구니1</p>
			<p>장바구니2</p>
			<p>장바구니3</p>
			<p>장바구니4</p>
			<p>장바구니5</p>
			<p>장바구니6</p>
			<p>장바구니7</p>
			<p>장바구니8</p>
			<p></p>
			<a href="#top"><font size="3">Top</font></a>
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