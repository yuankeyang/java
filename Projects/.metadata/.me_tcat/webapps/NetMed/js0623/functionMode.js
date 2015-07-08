$(document).ready(function(){
	$('#login-btn').click(function(){
	$('.mask').show();
	$('.login-div').show();
	});
	$('.close-div a').click(function(){
	$('.mask').hide();
	$('.login-div').hide();
	});

	$("#turnBg li[id=choose1]").attr("class","addBg");
	
	$("#turnBg li").each(function(){
	$(this).click(function(){
	$(this).siblings(".addBg").removeClass("addBg");
	$(this).attr("class","addBg");
	});
	});
		
	$("#searchIn").find("input[type=button]").click(function(){
		var item=$("#turnBg .addBg").attr("value");
		if(item=="qiuyi"){
			$('#searchIn').attr('action','MediKnow?searchSelect='+'qiuyi');
		}else if(item=="wenyao"){
			$('#searchIn').attr('action','SearchMedicine?searchSelect='+'wenyao');
		}else{
			$('#searchIn').attr('action','SearchRegimen?searchSelect='+'yangsheng');
		}
		if($('#search_str').val()=='')
			alert('请输入搜索词条！');
		else{
		$('#searchIn').submit();}
	});
	
	$("#login-button").click(function(e){
		//登录用户名和密码不能为空
		if($("#loginForm input[name='username']").val()==""){
			alert("请输入用户名");return;
		}
		if($("#loginForm input[name='password']").val()==""){
			alert("请输入密码");return;
		}
		    e.preventDefault();
			$("#layer").hide();
		    if(document.getElementById('usertype').value== "user" )
		    	$('#loginForm').attr('action','membLoginCheck');
			else if(document.getElementById('usertype').value == "expe" )
				$('#loginForm').attr('action','expeLoginCheck');
			else
				$('#loginForm').attr('action','instLoginCheck');
		    $('#loginForm').submit();
		});
});