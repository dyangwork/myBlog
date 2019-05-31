Dropzone.autoDiscover = false;
/**
 * 文件初始化设置
 */
$("#dropzone").dropzone({
	url:"/admin/file/uploadFiles",
	uploadMutiple: true,
	maxFileSize: 2,
	init:function(){
		this.on("success",function(file,result){
			console.log(result);
			console.log(file);
		})
	}
})