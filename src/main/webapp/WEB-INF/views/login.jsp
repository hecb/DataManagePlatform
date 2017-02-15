<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE HTML >
<html>
<head>
	<title>用户登录</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0,user-scalable=no">  
                                     
                                     
                                     
<style>
span.required {
 color: red; 
 font-size: 150%;
}
</style>
	<%@ include file="/commons/basejs.jsp" %>
<script type="text/javascript">
	if (window.top.location != window.location) {
		window.top.location = window.location;
	}
</script>
<script type="text/javascript">
	function login(){
			
			var username = $("#username").val();
			var password = $("#password").val();
			 var prts =  document.getElementById("message");   
			if(username==""){
				  prts.style.color="red";  
			      //prts.innerHTML = "请输入账号！"; 
			      //$("#password").val("请输入账号！")
			      layer.alert("请输入账号或密码");
				return ;
				} else if(password==""){
					 prts.style.color="red";  
				      //prts.innerHTML = "请输入密码！";
				      layer.alert("请输入账号或密码");
				     return ;
					} 
			$.ajax({
				type: "POST",
				url: basePath + '/login',
		    	data: {'username':username,'password':password},
				dataType:'json',
				cache: false,
				success: function(data){
		            if (data.success) {
		                window.location.href = basePath + '/index';
		            }else if(data.msg!=null){
		            	layer.alert("用户不存在！");
		            	 
			        }
				}
			});
	  		
						
	}
	   function show_box(id) {
		    jQuery('.widget-box.visible').removeClass('visible');
		    jQuery('#'+id).addClass('visible');
		    re_set();
	 }

	
	function register(){ 
		//alert("到这个函数了");
		 var rex  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var rusername = $("#rusername").val();
		
		var rdep = $("#rdep").val();
		var remail = $("#remail").val();
		var rphone = $("#rphone").val();
		var rcompany = $("#rcompany").val();
		var regx= /^1\d{10}$/;
		 var msg =  document.getElementById("msg"); 
     if(rusername==""||rcompany==""||remail==""||rdep==""||rphone==""){
			//msg.style.color="red";  
			layer.alert("请填写完整信息!");
		      //msg.innerHTML = "请填写完整信息!"; 
		      //$("#password").val("请输入账号！")
			return ;
			}else if(rusername.length>6){
				//msg.innerHTML = "账号长度不超过6，请重新输入！";
				//layer.alert("账号长度不超过6，请重新输入！");
				layer.tips('账号长度不超过6，请重新输入！', $("#rusername"), {
						  tipsMore: true
					});
				document.getElementById("rusername").value="";
				//createCode();
				return false;
				} else if(!regx.test(rphone)){
					//layer.alert("手机格式错误，请重新输入！");
					//msg.innerHTML = "手机格式错误，请重新输入！";
					layer.tips('手机格式错误，请重新输入', $("#rphone"), {
						  tipsMore: true
					});

				}else if(!rex.test(remail)){
					layer.tips('邮箱格式错误，请重新输入！', $("#remail"), {
						  tipsMore: true
					});
						//msg.innerHTML = "邮箱格式错误，请重新输入！";
						//layer.alert("邮箱格式错误，请重新输入！");
						return false;
						}
				else{
					re_set();
					//msg.innerHTML = "注册成功，请登录！！";
					layer.alert("注册成功，请登录！！");
					return true;
					}
		}
/* 	function keyLogin(){
		 //alert("使用了键盘");
		 if (event.keyCode==13) 
			 //alert("用键盘登录");
  document.getElementById("bu_t").onclick();
		 //调用登录按钮的登录事件
} */
function keydownEvent() {
    var e = window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 13 ) {
    	document.getElementById("bu_t").onclick();
    }
}
	function re_set(){
		var msg1 =  document.getElementById("msg");
		if(msg.innerHTML!=null){
			msg.innerHTML = "";
		return;
		}
		}
</script>
</head>
<body class="login-layout"   onkeydown="keydownEvent();">
 <div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
					   <div id="all">
						<div class="center">
							<h1>
								<h3 class="white">华夏企业数据服务门户</h3>
							</h1>
						</div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>
										   <h6 style="text-align: center" class="green">账号：admin  密码：111111</h6>
                                            <h4 id="message" style="text-align: center;color: red"></h4> 
                                             <span style="color: red">${error}</span>
										<div class="space-6"></div>
										<form action="" method="post" >
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="username"
														name="username" type="text" class="form-control"
														placeholder="请输入账号" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="password"
														name="password" type="password" class="form-control"
														placeholder="请输入密码" /> <i class="icon-lock"></i>
												</span>
												</label>
                                               
												<div class="clearfix">
											<div>
												<a href="#" onclick="show_box('signup-box');"class="icon-key">
													立即注册
													
												</a>
											</div> 
                                                
                                                  
													<button type="button" id="bu_t" onclick="login()" 
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
                                            		<br> 
											
									</div>

								</div>

							</div>
							<div>

                 <div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												企业用户注册
											</h4>

											<div class="space-6"></div>
											<form>
												<fieldset id="fieldset">
													<label >
													<!-- <span class="required">*</span> -->
														<span >
															企业名称: 
															<input type="text" class="input" id="rcompany" placeholder="请填写企业名称" style="width:170px;"/>
															<span class="required">*</span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right" >
															联系人员:
															<input type="text" id="rusername" class="input" placeholder="请填写联系人"style="width:170px;" />
															<span class="required">*</span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															联系电话:
															<input type="text" class="input" id="rphone" placeholder="请填写联系人电话" style="width:170px;"/>
															<span class="required">*</span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															办公地址:
															<input type="text" class="input"  placeholder="请填写办公地址" style="width:170px;"/>
															
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															联系传真:
															<input type="text" class="input"  placeholder="请填写联系人传真" style="width:170px;"/>
															
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															联系邮箱:
															<input type="email" class="input" id="remail" placeholder="请填写联系人邮箱" style="width:170px;"/>
															<span class="required">*</span>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															业务意愿:
															<textarea id="rdep" rows="2" cols="20" id="dep" class="input"  placeholder="请填写业务意愿" style="width:170px;" ></textarea>
															<span class="required">*</span>
														</span>
													</label>

													

													

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															重置
														</button>

														<button type="button"  onclick="register()" class="width-65 pull-right btn btn-sm btn-success">
															立即注册
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												返回登录
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
					</div>

				</div>
			</div>

		</div>
</div>
</body>
</html>
