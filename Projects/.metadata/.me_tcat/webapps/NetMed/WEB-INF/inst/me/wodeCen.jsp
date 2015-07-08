<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script language="javascript">
$(document).ready(function(){
    $(".userinfo_box .userpic span").hover(function(){
        $(this).find("a").show();
    },function(){
        $(this).find("a").hide();
    })
});
</script>
<div class="userinfo_box">
                    <div class="userpic">
                        <span id="abc">
                            <img alt="" src="http://i1.hdfimg.com/space/images/iconuser96.gif">
                            <a href="javascript:void(0);" onclick="index_update_doctor_headphoto(this)" style="display: none;">修改图片</a>
                        </span>
                    </div>
                    <div class="userinfo">
                        <div class="welcome"><%=session.getAttribute("username") %>>&nbsp;欢迎！
                                                        <a target="_blank" id="aa" href="http://www.haodf.com/info/mobile/hdf_mobile.php"><img width="110" height="35" src="http://i1.hdfimg.com/userspace/images/nousedphone.png" title="下载手机客户端，随时随地联系好大夫"></a>
                                    </div>
                        <div class="num">
                            <span class="black">0&nbsp;</span>封感谢信&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="black">0&nbsp;</span>件心意礼物
                        </div>
                        <div class="num">
                                                          <div>
                                     <span>座机号码：87****401</span>
                                     <span><a class="blue" href="/index/changemobile">更换座机号 </a></span>
                                 </div>
                                                                          </div>
                    </div>
                </div>
                
          <script language="javascript">
    function index_update_doctor_headphoto(el){
        space_pop_windows(el, 'index_doctor_photo', '/index/ajaxphoto?window_id=00', {title: '图片设置'});
    }

    $(function(){/*{{{*/
        $('.todocheckup').fancybox({
            onComplete:function(){/*{{{*/
                var uploadContent = $('#uploadimagediv').html();
                $('#boxmanualentering').fancybox({
                    padding:0,
                        onComplete:function(){/*{{{*/
                            $('#reportboxsave').click(function(){/*{{{*/
                                alert('提交成功');
                            });/*}}}*/
                        },/*}}}*/
                    onCleanup:function(){/*{{{*/
                        var inputSerialize = $('#ticketid').serialize() + "&" + $('#inputlistbox').find(':input').serialize();
                        $.post('/myhealth/ajaxbatchaddstructedreport', inputSerialize, function(){
                            if(window.location.pathname == '/myhealth/checkuphistory')
                            {
                                showReportList();
                            }
                        })
                    }/*}}}*/
                });

                $('#boxuploadimage').fancybox({
                    type:'iframe',
                    scrolling:'no'    
                });
            }/*}}}*/
        });
    });/*}}}*/

    function addCheckupReportLeft(ticketId, patientAttachmentId)
    {/*{{{*/
        $.fancybox.close();
        $.post('/myhealth/ajaxaddcheckupreport4patientattachment', {ticketid:ticketId, patientattachmentid:patientAttachmentId}, function(data){
            alert('上传成功');
            //$('.todocheckup:first').click();
        });
    }/*}}}*/

    </script>