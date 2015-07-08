		var setting = {
			view: {
				dblClickExpand: false,
				showLine: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeExpand: beforeExpand,
				onExpand: onExpand,
				onClick: onClick
			}
		};
		
		var zNodes =[
			{ id:1, pId:0, name:"症状类及症状名"}, /*open:true*/
			{ id:11, pId:1, name:"始因等"},
			{ id:111, pId:11, name:"新近感受风寒"},
			{ id:112, pId:11, name:"气候环境潮湿"},
			{ id:113, pId:11, name:"感受暑热"},
			{ id:114, pId:11, name:"气候环境干燥"},
			{ id:115, pId:11, name:"淋雨下水"},	
			{ id:116, pId:11, name:"饮食不慎"},
			{ id:117, pId:11, name:"活动或劳累病重"},
			{ id:118, pId:11, name:"病情与情志有关"},
			{ id:119, pId:11, name:"外伤所致"},
			{ id:12, pId:1, name:"寒热"},
			{ id:121, pId:12, name:"新起微发热"},
			{ id:122, pId:12, name:"微热风寒"},
			{ id:123, pId:12, name:"新起恶寒重"},
			{ id:124, pId:12, name:"寒战"},
			{ id:13, pId:1, name:"汗出"},
			{ id:131, pId:13, name:"自汗"},
			{ id:132, pId:13, name:"盗汗"},
			{ id:133, pId:13, name:"新病无汗"},
			{ id:134, pId:13, name:"寒战"},
			{ id:14, pId:1, name:"疼痛部位"},
			{ id:141, pId:14, name:"头痛"},
			{ id:142, pId:14, name:"颠顶痛"},
			{ id:143, pId:14, name:"面痛"},
			{ id:144, pId:14, name:"鼻痛"},
			{ id:2, pId:0, name:"疾病类及疾病名"},
			{ id:21, pId:2, name:"胎、产及其疾病"},
			{ id:211, pId:21, name:"早孕"},
			{ id:212, pId:21, name:"假孕"},
			{ id:213, pId:21, name:"多胎"},
			{ id:214, pId:21, name:"异位妊娠"},
			{ id:215, pId:21, name:"恶阻"},
			{ id:216, pId:21, name:"葡萄胎"},
			{ id:22, pId:2, name:"皮肤病类"},
			{ id:221, pId:22, name:"热(气)疮 "},
			{ id:222, pId:22, name:" 蛇串疮"},
			{ id:223, pId:22, name:" 疣"},
			{ id:224, pId:22, name:" 臊疣 "},
			{ id:225, pId:22, name:" 黄水疮 "},
			{ id:23, pId:2, name:"肝系病类"},
			{ id:231, pId:23, name:"肝积 "},
			{ id:232, pId:23, name:" 肝瘤"},
			{ id:233, pId:23, name:" 肝癌"},
			{ id:234, pId:23, name:" 鼓胀 "},
			{ id:235, pId:23, name:" 肝痨 "},
			{ id:24, pId:2, name:"肺系病类"},
			{ id:241, pId:24, name:"肺热病 "},
			{ id:242, pId:24, name:" 肺咳"},
			{ id:243, pId:24, name:" 肺胀"},
			{ id:244, pId:24, name:" 鼓癌 "},
			{ id:245, pId:24, name:" 肝痨 "},
			{ id:246, pId:24, name:" 肝水 "},
			{ id:3, pId:0, name:"症型"},
			{ id:31, pId:3, name:"基本虚症类"},
			{ id:311, pId:31, name:"气焰证"},
			{ id:312, pId:31, name:"气脱证"},
			{ id:313, pId:31, name:"气虚证"},
			{ id:314, pId:31, name:"亡阳证"},
			{ id:32, pId:3, name:"基本实症类"},
			{ id:321, pId:32, name:"寒凝证"},
			{ id:322, pId:32, name:"外燥证"},
			{ id:323, pId:32, name:"气置证"},
			{ id:324, pId:32, name:"气闭证"}	,	
			{ id:33, pId:3, name:"虚实夹杂症类"},
			{ id:331, pId:33, name:"气虚夹杂证类"},
			{ id:332, pId:33, name:"血虚夹杂证类"},
			{ id:333, pId:33, name:"阴虚夹杂证类"},
			{ id:334, pId:33, name:"阳虚夹杂证类"},	
			{ id:335, pId:33, name:"余毒未清证"},
			{ id:34, pId:3, name:"基本实症类"},
			{ id:341, pId:34, name:"寒凝证"},
			{ id:342, pId:34, name:"外燥证"},
			{ id:343, pId:34, name:"气置证"},
			{ id:344, pId:34, name:"气闭证"}	,	
			{ id:4, pId:0, name:"症素"},
			{ id:41, pId:4, name:"心"},
			{ id:42, pId:4, name:"肺"},	
			{ id:43, pId:4, name:"肝"},
			{ id:44, pId:4, name:"胆"},
			{ id:45, pId:4, name:"胃"},	
			{ id:46, pId:4, name:"肾"},
			{ id:47, pId:4, name:"小肠"},
			{ id:5, pId:0, name:"治法类与治法"},
			{ id:51, pId:5, name:"解表法"},
			{ id:511, pId:51, name:"急则治标"},
			{ id:512, pId:51, name:"缓则治本"},
			{ id:513, pId:51, name:"标本兼治"},
			{ id:514, pId:51, name:"因地制宜"},
			{ id:515, pId:51, name:"因时制宜"},
			{ id:52, pId:5, name:"涌吐法"},
			{ id:521, pId:52, name:"辛温解表"},
			{ id:522, pId:52, name:"辛凉解热"},
			{ id:523, pId:52, name:"舒表通经"},
			{ id:524, pId:52, name:"理气解表"},	
			{ id:525, pId:52, name:"扶正解表"},
			{ id:526, pId:52, name:"祛湿解表"},
			{ id:53, pId:5, name:"攻下法"},
			{ id:531, pId:53, name:"涌吐痰涎 "},
			{ id:532, pId:53, name:"涌吐风痰"},
			{ id:533, pId:53, name:"涌吐痰食"},
			{ id:534, pId:53, name:"涌吐宿食"},	
			{ id:535, pId:53, name:"开关涌吐"},
			{ id:54, pId:5, name:"表里双解法"},
			{ id:541, pId:54, name:"清热[泻火]攻下[通腑][通便] "},
			{ id:542, pId:54, name:" 泻结行滞"},
			{ id:543, pId:54, name:"温下实寒"},
			{ id:544, pId:54, name:" 润燥[肠]通便"},
						{ id:6, pId:0, name:"基本处方"},
			{ id:61, pId:6, name:"解表剂"},
			{ id:611, pId:61, name:"麻黄汤"},
			{ id:612, pId:61, name:"麻黄加术汤"},
			{ id:613, pId:61, name:"麻杏苡甘汤"},
			{ id:614, pId:61, name:"大青龙汤"},
			{ id:615, pId:61, name:"华盖散"},
			{ id:616, pId:61, name:"桂枝汤"},
			{ id:617, pId:61, name:"桂枝加桂汤"},
			{ id:618, pId:61, name:"小青龙汤"},
			{ id:62, pId:6, name:"泻下剂"},
			{ id:621, pId:62, name:"大承气汤"},
			{ id:622, pId:62, name:"小承气汤"},
			{ id:623, pId:62, name:"调味承气汤"},
			{ id:624, pId:62, name:"复大方承气汤"},	
			{ id:625, pId:62, name:"大黄附子汤"},
			{ id:626, pId:62, name:"五仁丸"},
			{ id:63, pId:6, name:"和解剂"},
			{ id:631, pId:63, name:"小柴胡汤 "},
			{ id:632, pId:63, name:"四逆散"},
			{ id:633, pId:63, name:"逍遥散"},
			{ id:634, pId:63, name:"黄连汤"},	
			{ id:635, pId:63, name:"大柴胡汤"},
			{ id:64, pId:6, name:"清热剂"},
			{ id:641, pId:64, name:"白虎汤 "},
			{ id:642, pId:64, name:"竹叶石膏汤"},
			{ id:643, pId:64, name:"神犀丹"},
			{ id:644, pId:64, name:" 凉膈散"},
			{ id:645, pId:64, name:"仙方活命饮 "},
			{ id:646, pId:64, name:"导赤散"},
			{ id:647, pId:64, name:"清心莲子饮"},
			{ id:648, pId:64, name:" 凉膈散"},
		];


		var curExpandNode = null;
		function beforeExpand(treeId, treeNode) {
			var pNode = curExpandNode ? curExpandNode.getParentNode():null;
			var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
				if (treeNode !== treeNodeP.children[i]) {
					zTree.expandNode(treeNodeP.children[i], false);
				}
			}
			while (pNode) {
				if (pNode === treeNode) {
					break;
				}
				pNode = pNode.getParentNode();
			}
			if (!pNode) {
				singlePath(treeNode);
			}

		}
		function singlePath(newNode) {
			if (newNode === curExpandNode) return;
			if (curExpandNode && curExpandNode.open==true) {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				if (newNode.parentTId === curExpandNode.parentTId) {
					zTree.expandNode(curExpandNode, false);
				} else {
					var newParents = [];
					while (newNode) {
						newNode = newNode.getParentNode();
						if (newNode === curExpandNode) {
							newParents = null;
							break;
						} else if (newNode) {
							newParents.push(newNode);
						}
					}
					if (newParents!=null) {
						var oldNode = curExpandNode;
						var oldParents = [];
						while (oldNode) {
							oldNode = oldNode.getParentNode();
							if (oldNode) {
								oldParents.push(oldNode);
							}
						}
						if (newParents.length>0) {
							zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
						} else {
							zTree.expandNode(oldParents[oldParents.length-1], false);
						}
					}
				}
			}
			curExpandNode = newNode;
		}

		function onExpand(event, treeId, treeNode) {
			curExpandNode = treeNode;
		}

		function onClick(e,treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.expandNode(treeNode, null, null, null, true);
			if(treeNode.id>100)
			     showLog(treeNode.name,treeNode.id);
		     if(treeNode.getParentNode().id==4){
			$("#log2").append(treeNode.name+",");
				 
				 }
			  
		}
	
		function showLog(str,id) {
			if(id<200)
			$("#log2").append(str+",");
			else if(id<300)
		    $("#log1").append(str+",");
			else if(id<400)
		    $("#log2").append(str+",");
			else if(id<600)
		    $("#log5").append(str+",");
			else if(id<700)
		    $("#log6").append(str+",");
		}

	

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});