<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>孔夫子旧书网</title>
<%@include file="../common/common.jsp"%>
</head>
<script src="js/myTimeFormat.js"></script>
<script src="js/formEdit.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/mg/common.css">
<script type="text/javascript" src="js/mng/bookInfo/bookInfo.js"></script>
<style type="text/css">
	.select{
		    margin-top: 18px;
    		margin-left: 89px;
    		width:81px;
	}
	.selectInfo tr{
		line-height:33px;
	}
	.selectInfo tr td{
		text-align:right;
	}
	#searchWin{
		margin-top:19px;
		margin-left: 65px;
	}
</style>
<body class="easyui-layout">

	<div data-options="region:'north',border:false"
		style="height: 60px;padding-top: 15px"
		class="header">
		<form id="searchForm" method="post">
			<laber>关键词选择:</laber>
			<input id="bookCombobox" name="book" class="easyui-combobox" data-options="valueField: 'status',textField: 'value',data: [{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k4e2dk56fdk53e4k5178k5c0fk8bf4w',value: '中国古典小说',selected:true
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k4e2dk56fdk73b0k4ee3k5c0fk8bf4kff08k31k39k31k39k5e74k2dk31k39k34k39k5e74kff09w',value: '中国现代小说'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k4e2dk56fdk5f53k4ee3k5c0fk8bf4kff08k31k39k34k39k5e74k4ee5k540ekff09w',value: '中国当代小说'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k56dbk5927k540dk8457w',value: '四大名著'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k4e16k754ck540dk8457w',value: '世界名著'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k5916k56fdk5c0fk8bf4w',value: '外国小说'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k4fa6k63a2k2fk60ack7591k2fk63a8k7406w',value: '侦探/悬疑/推理'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k79d1k5e7bw',value: '科幻'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k60c5k611fk2fk5bb6k5eadk2fk5a5ak59fbw',value: '情感/家庭/婚姻'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k7a7fk8d8ak2fk91cdk751fw',value: '穿越/重生'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k6b66k4fa0w',value: '武侠'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k60cak609ak2fk6050k6016w',value: '惊悚/恐怖'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k9b54k5e7bk2fk5947k5e7bk2fk7384k5e7bw',value: '魔幻/奇幻/玄幻'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k9752k6625k2fk5f71k89c6w',value: '青春/影视'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k5386k53f2w',value: '历史'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k5b98k573aw',value: '官场'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k804ck573aw',value: '职场'
			},{
				status: 'http://item.kongfz.com/Cxiaoshuo/y0tag_k793ek4f1aw',value: '社会'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9002w',value: '文学'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9008w',value: '艺术'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9010w',value: '教育'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9006w',value: '军事'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9004w',value: '地理'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9009w',value: '童书'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9014w',value: '体育'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9020w',value: '管理'
			},{
				status: 'http://item.kongfz.com/Czhexue/tag_k5fc3k7406k5b66w',value: '心理学'
			},{
				status: 'http://item.kongfz.com/Cyishu/tag_k97f3k4e50w',value: '音乐'
			},{
				status: 'http://item.kongfz.com/Cyishu/tag_k7ed8k753bw',value: '绘画'
			},{
				status: 'http://item.kongfz.com/Cshenghuo/tag_k65f6k5c1ak2fk7f8ek5986w',value: '时尚/美妆'
			},{
				status: 'http://item.kongfz.com/Cshenghuo/tag_k4eb2k5b50k2fk5bb6k6559w',value: '亲子/家教'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k8ba1k7b97k673ak7406k8bbaw',value: '计算机理论'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k7f16k7a0bk4e0ek5f00k53d1w',value: '编程与开发'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k64cdk4f5ck7cfbk7edfw',value: '操作系统'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k5927k6570k636ek4e0ek4e91k8ba1k7b97w',value: '大数据与云计算'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k56fek5f62k56fek50cfk2fk591ak5a92k4f53w',value: '图形图像/多媒体'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k7f51k7ad9k8bbek8ba1k4e0ek7f51k9875k5f00k53d1w',value: '网站设计与网页开发'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k7f51k7edck4e0ek901ak8bafw',value: '网络与通讯'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k786ck4ef6k3001k5d4ck5165k5f0fk5f00k53d1w',value: '硬件/嵌入式开发'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k529ek516ck8f6fk4ef6w',value: '办公软件'
			},{
				status: 'http://item.kongfz.com/Cjisuanji/tag_k4fe1k606fk5b89k5168w',value: '信息安全'
			},{
				status: 'http://item.kongfz.com/Cguoxue/tag_k8bd7k7c7bw',value: '诗类'
			},{
				status: 'http://item.kongfz.com/Cguoxue/tag_k5112k5bb6w',value: '儒家'
			},{
				status: 'http://item.kongfz.com/Cguoxue/tag_k5175k5bb6w',value: '兵家'
			},{
				status: 'http://item.kongfz.com/Cguoxue/tag_k793ck7c7bw',value: '礼类'
			},{
				status: 'http://item.kongfz.com/Cguoxue/tag_k4e50k7c7bw',value: '乐类'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k7ecfk6d4ek5b66k7406k8bbaw',value: '经济学理论'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k4e2dk56fdk7ecfk6d4ew',value: '中国经济'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k4e16k754ck7ecfk6d4ew',value: '世界经济'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k91d1k878dw',value: '金融'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k4fddk9669w',value: '保险'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k8d38k6613w',value: '贸易'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k6295k8d44k7406k8d22w',value: '投资理财'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k5e02k573ak8425k9500w',value: '市场营销'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k7ecfk6d4ek7ba1k7406w',value: '经济管理'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k8bc1k5238k2fk80a1k7968w',value: '证券/股票'
			},{
				status: 'http://item.kongfz.com/Cjingji/tag_k91d1k878dk94f6k884ck4e0ek8d27k5e01w',value: '金融银行与货币'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9016w',value: '自然科学'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9013w',value: '宗教'
			},{
				status: 'http://book.kongfz.com/Cminguo/cat_9015w',value: '工程技术'
			},{
				status: 'http://item.kongfz.com/Cshwh/tag_k6587k5316w',value: '文化'
			},{
				status: 'http://item.kongfz.com/Cshwh/tag_k6863k6848k5b66w',value: '档案学'
			},{
				status: 'http://item.kongfz.com/Cscyjs/tag_k4e66k753bk7bc6k523bw',value: '书画篆刻'
			},{
				status: 'http://item.kongfz.com/Cscyjs/tag_k7389k77f3w',value: '玉石'
			},{
				status: 'http://item.kongfz.com/Cscyjs/tag_k9676k74f7w',value: '陶瓷'
			},{
				status: 'http://item.kongfz.com/Cscyjs/tag_k94b1k5e01w',value: '钱币'
			},{
				status: 'http://item.kongfz.com/Cscyjs/tag_k90aek7968w',value: '邮票'
			},{
				status: 'http://item.kongfz.com/Ctiyu/tag_k7530k5f84k2fk4f53k64cdw',value: '田径/体操'
			},{
				status: 'http://item.kongfz.com/Ctiyu/tag_k7403k7c7bk8fd0k52a8w',value: '球类运动'
			},{
				status: 'http://item.kongfz.com/Ctiyu/tag_k68cbk724cw',value: '棋牌'
			}],editable:false" ></input>
			<laber>输入关键词页码：</laber>
			<input class="easyui-numberspinner" id = "count" name="count" data-options="prompt:'1'"/> 
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',increment:1" onclick="selectUrl()">关键词爬取数据存储到数据库</a>
		</form>

	</div>
	<div data-options="region:'center'">
		<table id="customerTable"></table>
	</div>
	<!-- 查询弹出模态框-->
	<div id="win" class="easyui-window" title="条件查询" style="width:400px;height:300px"
    data-options="iconCls:'icon-save',modal:true,closed:true">
    <div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center'">
			<form id="searchWin" method="post">
				<table class="selectInfo">
					<tr>
						<td><label>书名：</label></td>
						<td><input class="easyui-textbox" type="text" name="title"></td>
					</tr>
					<tr>
						<td><label>作者：</label></td>
						<td><input class="easyui-textbox" type="text" name="author"></td>
					</tr>
					<tr>
						<td><label>出版社：</label></td>
						<td><input class="easyui-textbox" type="text" name="press"></td>
					</tr>
					<tr>
						<td><label>出版时间：</label></td>
						<td><input class="easyui-textbox" type="text" name="pressDate"></td>
					</tr>
					<tr>
						<td><label>价格：</label></td>
						<td><input class="easyui-textbox" type="text" name="price"></td>
					</tr>
				</table>
				<a href="javascript:void(0)" class="easyui-linkbutton select" data-options="iconCls:'icon-search',increment:1" onclick="operation.search();">查询</a>
			</form>
		</div>
    </div>
</div>
</body>
</html>