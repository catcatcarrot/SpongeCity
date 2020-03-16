/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
	var e = (layui.$, layui.admin),
		i = layui.view,
		n = layui.table,
		l = layui.form;
	n.render({
		elem: "#analysis-data",
		url: "/getTask",//"./json/content/analysisdata.js",
		method:"GET",
		cols: [
			[{
				field: 'id',
				title: '序号',
				align: 'center',
				width: 100
			}, {
				field: 'deep',
				title: '水深(m)',
				minWidth: 100,
				align: 'center'
			}, {
				field: 'site',
				title: '位置',
				minWidth: 100,
				align: 'center'
			}, {
				field: 'collectTime',
				title: '采集时间',
				align: 'center',
				templet:"<div>{{layui.util.toDateString(d.collectTime,'yyyy-MM-dd')}}</div>"
			}, {
				field: 'total',
				title: '数据总数',
				align: 'center'
			}, ]
		],
		page: !0,
		limit: 5,
		limits: [5, 10, 15, 20],
		text: "对不起，加载出现异常！"
	}), t("dataanalysis", {})
});
