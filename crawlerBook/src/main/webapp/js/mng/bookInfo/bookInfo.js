$(function(){
	initTableCss();
});
function initTableCss() {
	//条件查询
	/*点击页面上的查询按钮*/
	var operation = (function() {	
		var opt = {};
		opt.search = function() {
			$("#win").window("close");
			var params = $("#searchWin").serializeObject();
			$('#customerTable').datagrid('load', params);
	};
		return opt;
	})();
	window.operation = operation;
	
	
	var records_toolbar = [  '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				//选中一行的模型信息定义为row
				var row = $('#customerTable').datagrid('getSelected');
				if (row){  //如果选中了模型信息
					$.messager.confirm('提示','是否要删除选中的图书信息？',function(r){
					    if (r){
					    	$.ajax({
					    		url:'m/bookInfo/delete',
					    		data:{'id':row.id},
					    		type:'post',
					    		success:function(){
					    			
					    			$("#customerTable").datagrid('options').url = "m/bookInfo/findPage";
					    			$('#customerTable').datagrid('load');
					    		}
					    	})
					    	
					    }
					});
				}else{
					$.messager.alert('提示','请先选中模型信息再进行删除操作！');
				}
			}
		} , '-', '-',  {
			text : '刷新',
			iconCls : 'icon-reload',
			handler : function() {
				var params = $("#searchForm").serializeObject();
				$('#customerTable').datagrid('load', params);
			}
		} ,'-','-',  {
			text : '查询',
			iconCls : 'icon-search',
			handler : function() {
				//查询弹框
				$('#win').window('open'); 
				$("#searchWin").form('clear');
			}
		} ,'-' 
		
		];

	$('#customerTable').datagrid({
			width : '100%',
			url : 'm/bookInfo/findPage',
			fit : true,
			//nowrap : false,
			fitColumns : true, //以适应网格的宽度，防止水平滚动。
			singleSelect : true, //是否为单选
			toolbar:records_toolbar,
			rownumbers : true, //是否显示行号 
			queryParams: {   //向后台发送额外的参数 页数count和url
				count: 1,
				url:"http://item.kongfz.com/Cxiaoshuo/y0tag_k4e2dk56fdk53e4k5178k5c0fk8bf4w"
			},
			pagination:true,
			pageSize:20,
			pageList:[10,20,30,40,50],
			method:'post',
			onBeforeLoad:function(_post){
				_post.currentPage = _post.page;
				_post.pageSize = _post.rows;
				
				delete _post.page;
				delete _post.rows;
			},
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 100,
				hidden : true
			}, {
				field : 'title',
				title : '书名',
				width : 150,
				align:'center'
									
			}, {
				field : 'image',
				title : '图片',
				width : 150,
				align:'center',
				formatter:function(val,row){
						return "<img src='"+val+"' style='width:150px;height:150px'>"
					}
			}, {
				field : 'author',
				title : '作者',
				width : 150,
				align:'center'
			},  {
				field : 'price',
				title : '价格',
				align:'center',
				width : 150
			}, {
				field : 'press',
				title : '出版社',
				align:'center',
				width : 150
			},{
				field : 'pressDate',
				title : '出版时间',
				align:'center',
				width : 150,
									
			}, {
				field : 'link',
				title : '点击详情',
				align:'center',
				width : 150,
				formatter:function(val,row){
						return '<a href="'+val+'" class="easyui-linkbutton" data-options="iconCls:\'icon-ok\'"  onclick="ExportSumReport()">点击详情</a>'
					  }
			}, ] ],
		});
}

//点击查询按钮
function selectUrl(){
	isFind=true;
	countUrl();
}

//公共调用的方法
function countUrl(){
	var count = ""; //发送到后台的页数
	var pageSum = $('#count').val();  //获取分页框的页数
	if(pageSum==""){
		 count = 1;
	}else{
		count =pageSum;
	}
	var url=$("#bookCombobox").combobox('getValue');   //获取当前选中的书的url路径
	if(count<1 || count>100){
		$.messager.alert('操作提示', '请输入1~100之间！');
		return;
	}
	//向后台请求
	$("#customerTable").datagrid('options').url = "m/bookInfo/findPage";
	$('#customerTable').datagrid('reload', {count:count,url:url});  //更新页面
	
}
//条件查询
/*function select(){
	$("#searchWin").form('clear');
	$("#win").window("close");
	var params = $("#searchWin").serializeObject();
	$('#customerTable').datagrid('load', params);
	
}*/

