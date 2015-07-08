// JavaScript Document
/*分类登录*/
function login(){
	if(document.getElementById('usertype').value== "user" )
		$('#login').attr('action','membLoginCheck');
		else if(document.getElementById('usertype').value == "expe" )
			$('#login').attr('action','expeLoginCheck');
		else
			$('#login').attr('action','instLoginCheck');
	$('#login').submit();
}

/*搜索类型切换*/
function SetSearchType(str){
	$('.on').removeClass();
	$('#'+str).addClass('on');
	$('#searchForm').attr('action',str);
}
function displaySubMenu() { 
	var subMenu = document.getElementById("submenu");
	subMenu.style.display = "block"; 
	} 
function hideSubMenu() { 
	var subMenu = document.getElementById("submenu"); 
	subMenu.style.display = "none"; 
	} 
function showWin(){
			document.getElementById("div-mask").style.display="block";
			document.getElementById("div-mask").style.height=document.body.clientHeight+"px";
			showDiv($('#div-login'));
			}
//居中显示
function showDiv(obj){
 $(obj).show();
 center(obj);
 $(window).scroll(function(){
  center(obj);
 });
 $(window).resize(function(){
  center(obj);
 }); 
}
function center(obj){
	 var windowWidth = document.documentElement.clientWidth;   
	 var windowHeight = document.documentElement.clientHeight;   
	 var popupHeight = $(obj).height();   
	 var popupWidth = $(obj).width();    
	 $(obj).css({   
	  "position": "absolute",   
	  "top": (windowHeight-popupHeight)/2+$(document).scrollTop(),   
	  "left":(windowWidth-popupWidth)/2   
	 });  
	}
function closeWin(){
			document.getElementById("div-mask").style.display="none";
			document.getElementById("div-login").style.display="none";
			}
function doClick(o){
 //当前被中的对象设置css
  o.className="nav_current";
  var j;
  var id;
  var e;
  //遍历所有的页签，没有被选中的设置其没有被选中的css
  for(var i=1;i<=2;i++){ //i<7 多少个栏目就填多大值
    id ="nav"+i;
    j = document.getElementById(id);
    e = document.getElementById("sub"+i);
    if(id != o.id){
      j.className="nav_link";
      e.style.display = "none";
    }else{
   e.style.display = "block";
    }
  }
 }

$(document).ready(function(){
    var tabsList = $('#tabs-con').find('li');
    var tabsCon = $('.tabs-ul');
    var oindex = tabsList.index();
    tabsList.on('mouseenter',function(){
    	$(this).find('.tabs-ul').show();       
    });
    tabsList.on('mouseleave',function(){
        tabsCon.hide();
    });
});