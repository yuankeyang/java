function LayerShow(name,type){
	var s = $("#HidContent");
	//s.load(name+".html");
	var offset = $("#"+name).offset();
	var left = offset.left+100;
	var top = offset.top+35;
	var right =offset.right;
	if(type==1){
		s.animate({left:left+'px',top:top+'px'}, "slow");
	}else{
		s.animate({left:(left-300)+'px',top:top+'px'}, "slow");
	}
	//s.fadeIn();
	s.show();
}
function closeDiv(){
	var s = $("#HidContent");
	//s.fadeOut();
	s.hide();
} 


$(document).ready(function (e) { 
$("#HidContent").mousedown(function (e) { 
iDiffX = e.pageX - $("#HidContent").offset().left; 
iDiffY = e.pageY - $("#HidContent").offset().top; 
$(document).mousemove(function (e) { 
$("#HidContent").css({ "left": (e.pageX - iDiffX), "top": (e.pageY - iDiffY) }); 
}); 
}); 
$("#HidContent").mouseup(function () { 
$(document).unbind("mousemove"); 
}); 
}); 