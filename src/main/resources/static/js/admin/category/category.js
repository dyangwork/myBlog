/**
 * 保存分类信息
 */
$("#save-category-btn").click(function(){
	var formData = $("#cform").serialize();
	$.ajax({
		url:"/admin/metas/saveOrUpdateMates",
		type:"post",
		data:formData,
		dataType:"json",
		success: function(result){
			if(result.code=="success"){
				alert("保存成功");
				resetForm();
				window.location.reload();
			}else{
				alert("保存失败");
			}
		}
	})
})

/**
 * 修改分类
 */
$(".edit-category").click(function(){
	var cid = $(this).attr("cid");
	var cname = $(this).attr("cname");
	var cdescrition =$(this).attr("cdescrition");
	$("#cid").val(cid);
	$("#name").val(cname);
	$("#description").val(cdescrition);
})


/**
 * 删除分类
 */
$(".del-category").click(function(){
	var cid = $(this).attr("cid");
	$.ajax({
		url:"/admin/metas/deleteMetas",
		type:"post",
		data:{cid:cid},
		dataType:"json",
		success:function(result){
			if(result.code=="success"){
				alert("删除成功");
				window.location.reload();
			}
		}
	})
})


/**
 * 重置form 表单
 */
function resetForm(){
	$("#cid").val("");
	$("#name").val("");
	$("#description").val("");
}