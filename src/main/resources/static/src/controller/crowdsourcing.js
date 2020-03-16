/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
	var e = (layui.$, layui.admin),
		i = layui.view,
		n = layui.table,
		l = layui.form;
	n.render({
		elem: "#LAY-app-content-list",
		url: "/getTask",
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
				templet:"<div>{{layui.util.toDateString(d.collectTime,'yyyy-MM-dd HH时')}}</div>"
			}, {
				field: 'total',
				title: '数据总数',
				align: 'center'
			}, ]
		],
		page: !0,
		limit: 10,
		limits: [10, 15, 20, 25, 30],
		text: "对不起，加载出现异常！"
	}), t("crowdsourcing", {})
});
