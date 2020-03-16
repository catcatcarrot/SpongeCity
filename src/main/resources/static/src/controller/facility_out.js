/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
	var e = (layui.$, layui.admin),
		i = layui.view,
		n = layui.table,
		l = layui.form;
	n.render({
		elem: "#LAY-app-content-comm",
		url: "/getFacility",
		method:"GET",
		where:{"status":2},
		cols: [
			[{
					field: 'id',
					title: "序号",
					width: 100,
					align: "center"
				}, {
					field: "name",
					title: "设施名称",
					align: "center"
				},
				{
					field: "number",
					title: "设施编号",
					align: "center"
				}, {
					field: "region",
					title: "所属片区",
					align: "center"
				},
				{
					field: "type",
					title: "设施类型",
					align: "center"
				}, {
					field: "buyMan",
					title: "采购人",
					align: "center"
				},
				{
					field: "dumpTime",
					title: "报废日期",
					align: "center",
					templet:"<div>{{layui.util.toDateString(d.dumpTime,'yyyy-MM-dd')}}</div>"
				},
				{
					title: "操作",
					minWidth: 150,
					align: "center",
					fixed: "right",
					toolbar: "#table-facility-scrap"
				}
			]
		],
		page: !0,
		limit: 10,
		limits: [10, 15, 20, 25, 30],
		text: "对不起，加载出现异常！"
	}), n.on("tool(LAY-app-content-comm)", function(t) {
		var n = t.data;
		"sea" === t.event && e.popup({
			title: "查看信息",
			area: ["420px", "450px"],
			id: "LAY-popup-content-comm",
			success: function(t, e) {
				i(this.id).render("facility/outInfo", n).done(function() {
					l.render(null, "layuiadmin-form-comment")
				})
			}
		})
	}), t("facility_out", {})
});
