<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- a입니다. -->
<html>
	<head>
		<title>미니웹사이트</title>
		<meta charset="utf-8"/>
		<link rel="stylesheet" type="text/css" href="view/ms_Main.css"/>
		<script type="text/javascript">
	<!--
	function MM_swapImgRestore() { //v3.0
  	var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
	}
	function MM_preloadImages() { //v3.0
  	var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    	var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    	if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
	}

	function MM_findObj(n, d) { //v4.01
  	var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  	if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  	if(!x && d.getElementById) x=d.getElementById(n); return x;
	}

	function MM_swapImage() { //v3.0
 	 var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
  	 if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
	}
	-->
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
	</font>
	</div>
	<div id="header">
		안녕하세요.
			<p>제가 만든 웹사이트입니다. 예쁘게 봐주세요.</p>
			<p>오늘은 CSS스타일 적용하는방법을 알아보고 있답니다.</p>
			
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
			  <table id="Table_" width="960" border="0" cellpadding="0" cellspacing="0" align="left">
    
    <tr>
      <tr width="200" height="200"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image71','','images/menubar_02.jpg',1)"><img src="images/menubar_2.jpg" name="Image71" width="160" height="65" border="0" id="Image71" /></a></tr>
      <tr width="160"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image81','','images/menubar_03.jpg',1)"><img src="images/menubar_3.jpg" name="Image81" width="160" height="65" border="0" id="Image81" /></a></tr>
      <tr width="160"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image9','','images/menubar_04.jpg',1)"><img src="images/menubar_4.jpg" name="Image9" width="160" height="65" border="0" id="Image9" /></a></tr>
      <tr width="160"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image10','','images/menubar_05.jpg',1)"><img src="images/menubar_5.jpg" name="Image10" width="160" height="65" border="0" id="Image10" /></a></tr>
      <tr width="160"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','images/menubar_06.jpg',1)"><img src="images/menubar_7.jpg" name="Image12" width="160" height="65" border="0" id="Image12" /></a></tr>
    </tr>
  </table>
  <center>
		</div>
		<div id="siderbar">
			<p>테두리<a href="#">margin</a>는 구분을 위해 그대로 놔둠.테두리는 구분을 위해 그대로 놔둠.테두리는 구분을 위해 그대로 놔둠.</p><p>테두리는 구분을 위해 그대로 놔둠.</p><p>테두리는 구분을 위해 그대로 놔둠.테두리는 구분을 위해 그대로 놔둠.테두리는 구분을 위해 그대로 놔둠.</p>
			<p>한식</p>
			<div class="box1">매장1</div>
			<div class="box1">매장2</div>
			<div class="box1">매장3</div>
			<div class="box1">매장4</div>
			<p>중식</p>
			<div class="box2">매장1</div>
			<div class="box2">매장2</div>
			<div class="box2">매장3</div>
			<div class="box2">매장4</div>
			<p>일식</p>
			<div class="box3">매장1</div>
			<div class="box3">매장2</div>
			<div class="box3">매장3</div>
			<div class="box3">매장4</div>
			<p>양식</p>
			<div class="box4">매장1</div>
			<div class="box4">매장2</div>
			<div class="box4">매장3</div>
			<div class="box4">매장4</div>
			<p>기타</p>
			<div class="box5">매장1</div>
			<div class="box5">매장2</div>
			<div class="box5">매장3</div>
			<div class="box5">매장4</div>
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