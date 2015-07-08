function $(id){
	return typeof id === "string" ? document.getElementById(id) : id;
}

function addEventLoad(func){
	var oldLoad = window.onload;
	if(typeof oldLoad !== "function"){
		window.onload = func;
	}else{
		window.onload = function(){
			oldLoad();
			func();
		}
	}
}

var Event = {
	add : function(element,type,func){
		if(element.addEventListener){
			element.addEventListener(type,func,false);
		}else if(element.attachEvent){
			element.attachEvent("on"+type,func);
		}else{
			element["on"+type] = func;
		}
	},
	remove : function(element,type,func){
		if(element.removeEventListener){
			element.removeEventListener(type,func,false);
		}else if(element.detachEvent){
			element.detachEvent("on"+type,func);
		}else{
			element["on"+type] = null;
		}
	},
	getEvent : function(event){
		return event ? event : window.event;
	},
	getTarget : function(event){
		return event.target || event.srcElement;
	},
	preventDefault : function(event){
		if(event.preventDefault){
			event.preventDefault();
		}else{
			event.returnValue = false;
		}
	}
};