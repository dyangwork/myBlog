var mditor;
var attach_url = $('#attach_url').val();

Dropzone.autoDiscover = false;

$(document).ready(function(){

    mditor =  Mditor.fromTextarea(document.getElementById('md-editor'));

 // Tags Input
    $('#tags').tagsInput({
        width: '100%',
        height: '35px',
        defaultText: '请输入文章标签'
    });

    $('.toggle').toggles({
        on: true,
        text: {
            on: '开启',
            off: '关闭'
        }
    });

    $("#multiple-sel").select2({
        width: '100%'
    });

    $('div.allow-false').toggles({
        off: true,
        text: {
            on: '开启',
            off: '关闭'
        }
    });

    if($('#thumb-toggle').attr('thumb_url') != ''){
        $('#thumb-toggle').toggles({
            off: true,
            text: {
                on: '开启',
                off: '关闭'
            }
        });
        $('#thumb-toggle').attr('on', 'true');
        $('#dropzone').css('background-image', 'url('+ $('#thumb-container').attr('thumb_url') +')');
        $('#dropzone').css('background-size', 'cover');
        $('#dropzone-container').show();
    } else {
        $('#thumb-toggle').toggles({
            off: true,
            text: {
                on: '开启',
                off: '关闭'
            }
        });
        $('#thumb-toggle').attr('on', 'false');
        $('#dropzone-container').hide();
    }

    var thumbdropzone = $('.dropzone');

     $("#dropzone").dropzone({
        url:"/file/upload"
     });


});


function allow_comment(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_comment').val('N');
    }
    if (off == 1) {
        $('#allow_comment').val('Y');
    }
}

function allow_ping(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_ping').val('N');
    }
    if (off == 1) {
        $('#allow_ping').val('Y');
    }
}


function allow_feed(obj) {
    var this_ = $(obj);
    var on = this_.find('.toggle-on.active').length;
    var off = this_.find('.toggle-off.active').length;
    if (on == 1) {
        $('#allow_feed').val('N');
    }
    if (off == 1) {
        $('#allow_feed').val('Y');
    }
}

/**
* 缩略图显示上传
*/
function add_thumbimg(obj){
   var _this = $(obj);
   var on = _this.attr("on");
   if(on ==true){
        _this.attr("on",false);
        $("#dropzone-container").addClass('hide');
        $("#dropzone-container").hide();
        $("#allow_imgs").val("N");
   }else{
        _this.attr("on",true);
       $("#dropzone-container").removeClass('hide');
       $("#dropzone-container").show();
       $("#allow_imgs").val("Y");
   }

}

/**
*提交文章
*/
function subArticle(status){
    if(!$("input[name='articleTitle']").val()){
        alert("请填写标题");
        return;
    }
    var content = mditor.value;
    if(!content){
        alert("请填写文章内容");
        return;
    }
    $("#content-editor").val(content);
    $("#status").val(status);
    $("#categories").val($("#multiple-sel").val());
    var params = $("#articleForm").serialize();
    $.ajax({
        url:"/article/publishOrSaveArticle",
        type:"post",
        data:params,
        dataType:"json",
        success:function(result){
            console.log(result);
        }
    })


}