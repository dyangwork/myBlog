

/*
* 获取登录数据
*
*/
function getPostData(){
    var userName =  $("input[name='userName']").val();
    var pwd =  $("input[name='password']").val();
    var auto = $("input[name='auto']").val();
    return {
        userName: $("input[name='userName']").val(),
        password: hex_md5($("input[name='password']").val()),
        auto: auto
    }
}

/*校验登录数据*/
function validateData(){
    var userName =  $("input[name='userName']").val();
    var pwd =  $("input[name='password']").val();
    var auto = $("input[name='auto']").val();

    if(!userName){

    }

    if(!pwd){

    }

    return true;

}

/*登录操作*/
$("#loginBtn").click(function(){
    if(validateData()){
        $.ajax({
            url:"login",
            type:"post",
            dataType:"json",
            data: getPostData(),
            success:function(data){
                console.log(data);
                if("success"==data.code){
                    window.location.href="home";
                }
            }

        })
    }
})

