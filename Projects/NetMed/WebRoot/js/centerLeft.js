function $$$(id){
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

function blockAndNone(){
	var sel1 = $$$("sel1");
	var sel2 = $$$("sel2");
	var sel3 = $$$("sel3");
	var sel4 = $$$("sel4");
	var sel5 = $$$("sel5");
	var selD1 = $$$("selD1");
	var selD2 = $$$("selD2");
	var selD3 = $$$("selD3");
	var selD4 = $$$("selD4");
	var selD5 = $$$("selD5");
	Event.add(sel1,"click",function(event){
		event = Event.getEvent(event);
		if(!(selD1.className)){
			selD1.setAttribute("class","vanish");
		}else{
			selD1.removeAttribute("class");
		}
	});
	Event.add(sel2,"click",function(event){
		event = Event.getEvent(event);
		if(!(selD2.className)){
			selD2.setAttribute("class","vanish");
		}else{
			selD2.removeAttribute("class");
		}
	});
	Event.add(sel3,"click",function(event){
		event = Event.getEvent(event);
		if(!(selD3.className)){
			selD3.setAttribute("class","vanish");
		}else{
			selD3.removeAttribute("class");
		}
	});
	Event.add(sel4,"click",function(event){
		event = Event.getEvent(event);
		if(!(selD4.className)){
			selD4.setAttribute("class","vanish");
		}else{
			selD4.removeAttribute("class");
		}
	});
	Event.add(sel5,"click",function(event){
		event = Event.getEvent(event);
		if(!(selD5.className)){
			selD5.setAttribute("class","vanish");
		}else{
			selD5.removeAttribute("class");
		}
	});
}

if($("sel1") && $("sel2") && $("sel3")){
	addEventLoad(blockAndNone);
}