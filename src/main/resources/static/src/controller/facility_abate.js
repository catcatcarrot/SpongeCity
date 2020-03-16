/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
	var e = (layui.$, layui.admin),
		i = layui.view,
		n = layui.table,
		l = layui.form;
	n.render({
		elem: "#LAY-app-content-list",
		url: "/getFacility",
		method:"GET",
		where:{"status":1},
		cols: [
			[{
					field: "id",
					title: "序号",
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
					field: "buyTime",
					title: "采购日期",
					align: "center",
					templet:"<div>{{layui.util.toDateString(d.buyTime,'yyyy-MM-dd')}}</div>"
				},
				{
					title: "操作",
					minWidth: 150,
					align: "center",
					fixed: "right",
					toolbar: "#table-content-facilityControl"
				}
			]
		],
		page: !0,
		limit: 10,
		limits: [10, 15, 20, 25, 30],
		text: "对不起，加载出现异常！"
	}), n.on("tool(LAY-app-content-list)", function(t) {
		var n = t.data;
		"del" === t.event ? layer.confirm("确定报废此设备？", function(e) {
			var number=n.number;
			$.ajax({
				url:"/updateOutFacility",
				data:{"num":number},
				dataType: "json",
				success:function(data){
					if(data.code==0){
						layer.msg(data.msg);
						layui.table.reload('LAY-app-content-list');
					}else{
						layer.msg(data.msg);
					}
				}
			});
			//l.render(null, "layuiadmin-app-form-list"),
			layer.close(e)
		}) : "sea" === t.event && e.popup({
			title: "查看设备",
			area: ["420px", "450px"],
			id: "LAY-popup-content-edit",
			success: function(t, e) {
				i(this.id).render("facility/abateInfo", n).done(function() {
					l.render(null, "layuiadmin-app-form-list"), l.on("submit(layuiadmin-app-form-submit)", function(t) {
						//t.field;
						//layui.table.reload("LAY-app-content-list"), layer.close(e)
					})
				})
			}
		})
	}), t("facility_abate", {})
});
