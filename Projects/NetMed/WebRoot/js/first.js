
$(document).ready(function(e) {
	
	
	
	document.onkeyup = function (e) { 
		var theEvent = window.event || e; 
		var code = theEvent.keyCode || theEvent.which; 
		if (code == 13) { 
		} 
	};
    $("#loginbtn").click(function(){
		$("#layer").fadeIn(300);
		});
	$("#close").click(function(e){
		e.preventDefault();
		$("#layer").hide();
		});
	$("#f11").click(function(e){
		//登录用户名和密码不能为空
		if($("#loginForm .single input[name='username']").val()==""){
			alert("请输入用户名");return;
		}
		if($("#loginForm .single input[name='password']").val()==""){
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
	$("#searchIn").find('button').click(function(){
		var item=$("input:radio:checked");
		if(item.val()=="qiuyi"){
			$('#searchForm').attr('action','MediKnow');
		}else if(item.val()=="wenyao"){
			$('#searchForm').attr('action','SearchMedicine');
		}else{
			$('#searchForm').attr('action','SearchRegimen');
		}
		if($('#search_str').val()=='')
			alert('请输入搜索词条！');
		else{
		$('#searchForm').submit();}
	});
});

$(function(){		   
	//头页登录
	$("#navul > li").not(".navhome").hover(function(){
		$(this).addClass("navmoon");
	},function(){
		$(this).removeClass("navmoon");
	});
	
}); 


(function($){
    $.fn.capacityFixed = function(options) {
        var opts = $.extend({},$.fn.capacityFixed.deflunt,options);
        var FixedFun = function(element) {
            var top = opts.top;
            element.css({
                "top":top
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top: 0							
                        });
                    } else {
                        element.css({
                            top: scrolls
                        });
                    }
                }else {
                    element.css({
                        position: "absolute",
                        top: top
                    });
                }
            });
            element.find(".close-ico").click(function(event){
                element.remove();
                event.preventDefault();
            });
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed.deflunt={
		right : 0,//相对于页面宽度的右边定位
        top:0
	};
})(jQuery);