$(function(){
	initFileUpload();
})

function initFileUpload(){
	$("#fileupload").fileinput({
		language:'zh',//设置语言
		uploadUrl:"/admin/file/uploadFiles",//上传地址
		allowedFileExtensions:["jpg","jepg","png","gif","webp","pcx","tif"],
		maxFilesNum:5, //上传文件最大文件数量
		rowseClass: "btn btn-primary", //按钮样式
		uploadAsync: false, //异步上传默认为true
		//previewClass:"aaa",
        //dropZoneEnabled: true,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        //maxFileCount: 10, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",

	});
	$("#fileupload").on("filebatchpreupload",function(event,data,previewId,index){
		var form = data.form,files=data.files,extra = data.extra,
		response = data.response,reader = data.reader;
		console.log("文件正在上传");
	});
	$("#fileupload").on("filebatchuploadsuccess",function(event,data,previewId,index){
		window.location.reload();
	});
	$("#fileupload").on("filebatchuploadcomplete",function(event,data,msg){
	});
	
}


//点击复制插件初始化
var clipbtn = new Clipboard(".copy", {
	text : function(trigger) {
		return $(trigger).attr('url');
	}
});
//Dropzone.autoDiscover = false;

/**
 * 复制成功
 */
clipbtn.on("success", function(e) {
	e.clearSelection();
})
/**
 * 复制失败
 */
clipbtn.on("error", function(e) {
	alert(e.action);
})

/**
 * 删除附件
 */
$(".fa-delete").click(function(){
	var fileId = $(this).attr("name");
	console.log(fileId);
	$.ajax({
		url:"/admin/file/delFile",
		type:"post",
		data:{
			fileId:fileId
		},
		dataType:"json",
		success:function(result){
			console.log(result);
		}
	})
})
