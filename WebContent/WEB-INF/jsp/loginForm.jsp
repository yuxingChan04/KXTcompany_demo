<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>后台管理</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">
function check_login()
{
 if(document.loginform.loginname.value=='')
 {
 alert("请检查用户名是否为空！");
 return false;
 }
 if(document.loginform.password.value==''){
 alert("请检查您的密码是否为空！");
 return false
 }
 if(document.loginform.password.value.length<6){
   alert("您的密码长度小于6！");
   return false
 }
}
</script>
<body>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>后台管理系统</p>
          </div>            
          <form action="login" method="post" id="loginForm" name="loginform" onSubmit="return check_login()">
              <input name="loginname" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
			  <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>			   
              <input value="登录" style="width:100%;" type="submit" >
          </form>
           <c:set var="mess" scope="session" value="${message}"/>
			  <c:if test="${mess!=null }">
			  <p>${message}</p>
			  </c:if>
			  
      </div>
      <div class="copyright">东莞科星泰科技服务有限公司 版权所有©2016-2020 技术支持电话：000-00000000</div>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
