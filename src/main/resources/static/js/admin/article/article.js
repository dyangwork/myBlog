$(function(){
    querytables();
})

function querytables(){
    $("#articleTab").dataTable({
        paging:true, //分页默认为true
        searching:false, //开启搜索，默认禁止
        ordering:false, //开启排序，默认禁止
        serverSide: true,
        processing: true,//载入数据的时候是否显示“载入中”
        pageLength: 10,//首次加载的数据条数
        autowidth:true, //自适应宽度
        ajax: {
            url: '/article/queryArticleList',
            type:"post",
            dataFilter: function(data){
                var json = jQuery.parseJSON( data );
                json.recordsTotal = json.total;
                json.recordsFiltered = json.total;
                json.data = json.list;
                return JSON.stringify( json ); // return JSON string
            }
        },
        language : {
            processing : "载入中",//处理页面数据的时候的显示
            paginate : {//分页的样式文本内容。
                previous : "上一页",
                next : "下一页",
                first : "第一页",
                last : "最后一页"
            },
            zeroRecords : "没有内容",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//左下角的信息显示，大写的词为关键字。
            infoEmpty : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//筛选为空时左下角的显示。
            infoFiltered : ""//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
        },
        columns:[
            {data:"num"},
            {data:"articleTitle",searchable:true},
            {data:"category",searchable:true},
            {data:"tags",searchable:true},
            {data:"status",searchable:true},
            {data:"type"},
            {data:"allowComments"},
            {data:"allowImgs",render:function(data, type, row){

            }},
            {data:"createTime",searchable:true,render:function(data, type, row){

            }},
            {data:"operation",render:function(data, type, row){

            }}
        ]

    })

}