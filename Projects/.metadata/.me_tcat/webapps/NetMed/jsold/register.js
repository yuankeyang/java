$().ready(function() {
		jQuery.validator.addMethod("isMobile",function(value,element){
			var length=value.length;
			var mobile=/^1[3|4|5|8][0-9]\d{4,8}$/;
			return this.optional(element)||(length == 11 && mobile.test(value));
		},"请正确填写您的手机号码");
		jQuery.validator.addMethod("isMail",function(value,element){
			var mail=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
			return this.optional(element)|| mail.test(value);
		},"请正确填写正确的邮箱地址");
		jQuery.validator.addMethod("isFixedphone",function(value,element){
			var mail=/^(((13[0-9]{1})|(15[0-9]{1}))|(18[0-9]{1})+\d{8})$/;
			return this.optional(element)|| mail.test(value);
		},"请正确填写正确的固定电话号码");
		
        $("#user-reg").validate({
			rules:{username: {
					required: true,
					minlength: 2,
					maxlength:18
				},
				password: {
					required: true,
					minlength: 5
				},confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},email: {
					required: true,
					isMail: true
				}
				},
			messages:{
				username: {
					required: "请输入昵称",
					minlength: "最少{0}个字"
				},
				password: {
					required: "请输入密码",
					minlength: "最少{0}个字"
				},
				confirm_password: {
					required: "请输入密码",
					minlength: "最少{0}个字",
					equalTo: "你的输入不相同"
				},
				email: {
					required:"请输入邮箱地址",
				}
					}
			});
        
        //.....................................
        $("#offlineConsult").validate({
			rules:{realname: {
					required: true,
					minlength: 2,
					maxlength:6
				},id_card_numb:{
					required:true,
					minlength:18,
					maxlength:18
				},phone:{
					required:true
				},telephone:{
					required:true,
					isMobile:true
				},
			},
				/*password: {
					required: true,
					minlength: 5
				},confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},email: {
					required: true,
					isMail: true
				}
				},
				*/
			messages:{
				realname: {
					required: "请输入名字",
					minlength: "最少{0}个字"
				},phone:{
					required:"请输入固定电话号码"
				},telephone:{
					required:"请输入移动电话号码"
				}
					}
			});
        //........................................
        
        $("#login").validate({
        	rules:{
        		username: {
					required: true,
					minlength: 2,
					maxlength:18},
				password:{
					required: true,
					minlength: 5,
					maxlength:15
					}
        	},
        	messages:{
        		username: {
					required: "请输入用户名",
					minlength: "最少{0}个字"
				}
        	}
        });
        /********专家注册**********/
        function deleteType(){
        	var selectId=$(this).parent().val();
        	var selectType=$(this).parent()
        	.find("#type").text();
        	$("#selectType").append("<option value='"+selectId+"'>"+selectType+"</option>");
        	$("#typeUl").find("li[value='"+selectId+"']").remove();
        }
        //增加注册类型
        $("#expe-reg").find("#addType").click(function(){
        	var selectType=$("#expe-reg").find("#selectType").find("option:selected").text();
        	var typeId=$("#expe-reg").find("#selectType").val();
        	$("#typeUl").append("<li value='"+typeId+"'><lable id='type'>"+selectType+"</lable><br/>" +
        			"<lable>执业资格证编号：</lable><input name='"+typeId+"' type='text'/><br>" +
        			"<lable>资格证照片：</lable><input type='file'/><br/>"+
        			"<button id='deleteType' value='"+typeId+"'>删除</button><br/></li>");
        	$("#selectType option:selected").remove();
        	$("#deleteType[value='"+typeId+"']").click(deleteType);
        });
        $("#expe-reg").validate({
			rules:{
				username: {
					required: true,
					minlength: 2,
					maxlength:18
				},realname:{
					required:true,
					minlength:2,
					maxlength:4
				},id_card_numb:{
					required:true,
					minlength:18,
					maxlength:18
				},id_pict:{
					required:true
				},phone:{
					required:true
				},telephone:{
					required:true,
					isMobile:true
				},email:{
					required:true,
					isMail:true
				},referrer:{
					required:true
				},password: {
					required: true,
					minlength: 5
				},confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				}},
			messages:{
					username: {
					required: "请输入昵称",
					minlength: "最少{0}个字"
				},realname:{
					required:"请输入真实的姓名",
					minlength:"姓名最小长度为{0}",
					maxlength:"姓名最大长度为{0}"
				},id_card_numb:{
					required:"请输入身份证号码",
					minlength:"身份证号码为{0}位",
					maxlength:"身份证号码为{0}位"
				},id_pict:{
					required:"请上传身份证件照"
				},phone:{
					required:"请输入固定电话号码"
				},telephone:{
					required:"请输入移动电话号码"
				},password: {
					required: "请输入密码",
					minlength: "最少{0}个字"
				},referrer:{
					required:"请输入推荐人"
				},
				confirm_password: {
					required: "请输入密码",
					minlength: "最少{0}个字",
					equalTo: "你的输入不相同"
				},
				email: {
					required:"请输入邮箱地址",
				}}
			});
        $("#inst-reg").validate({
			rules:{
				inst_id:{
					required:true
				},
				inst_name: {
					required: true,
				},inst_clas:{
					required:true,
				},busi_scop:{
					required:true,
					maxlength:20
				},lega_repr_name:{
					required:true,
					minlength:2,
					maxlength:4
				},lega_repr_id:{
					required:true,
					minlength:18,
					maxlength:18
				},busi_lice:{
					required:true
				},orga_code:{
					required:true
				},inst_prov:{
					required:true
				},inst_city: {
					required: true
				},inst_coun: {
					required: true
				},inst_over:{
					required: true,
					maxlength:100
				},phone:{
					required:true
				},telephone:{
					required:true,
					isMobile:true
				},email:{
					required:true,
					isMail:true
				},password: {
					required: true,
					minlength: 5
				},confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				}},
			messages:{
				busi_scop:{
					required:"请输入经营范围",
					maxlength:"{0}字以内"
				},password: {
					required: "请输入密码",
					minlength: "最少{0}个字"
				},confirm_password: {
					required: "请输入密码",
					minlength: "最少{0}个字",
					equalTo: "你的输入不相同"
				},
				email: {
					required:"请输入邮箱地址",
				}}
			});
        
        $("#newFamilyMember").validate({
			rules:{username: {
				required: true,
				minlength: 2,
				maxlength:4,
			  },birthday: {
				required: true,
			  },mobile:{
				required:true,
				isMobile:true,
			  }},
		messages:{
			username: {
				required:"请输入真实的姓名",
				minlength:"姓名最小长度为{0}",
				maxlength:"姓名最大长度为{0}"
			},
			birthday: {
				required: "请输入生日",
			},
			mobile: {
				required:"请输入正确的移动电话号码"
			},
		    }
		});
        
    });