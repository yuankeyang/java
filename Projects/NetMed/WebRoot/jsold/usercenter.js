$(function(){
	$(".usercenter_nav").find(".listtitle").click(function(){
		$(this).toggleClass("on").next(".item_list").slideToggle(300)
		});
	$("a").click(function(){
		var id=$(this).attr("id");
		htmlobj=$.ajax({
			url:id,
			success:function(){},
			error:function(){alert("这个还没实现");},
			async:false
			});
		$(".usercenter_con").html(htmlobj.responseText);
	});
	
});