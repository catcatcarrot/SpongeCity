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
		where:{"status":0},
		cols: [
			[{
				field: 'id',
				title: '序号',
				align: 'center',
				width: 100
			}, {
				field: 'name',
				title: '设施名称',
				minWidth: 240,
				align: 'center'
			}, {
				field: 'number',
				title: '设施编号',
				align: 'center'
			}, {
				field: 'region',
				title: '所属片区',
				align: 'center'
			}, {
				field: 'type',
				title: '设施类型',
				align: 'center',
			}, {
				field: 'buyMan',
				title: '采购人',
				align: 'center'
			}, {
				field: 'buyTime',
				title: '采购日期',
				align: 'center',
				templet:"<div>{{layui.util.toDateString(d.buyTime,'yyyy-MM-dd')}}</div>"
			}, {
				title: "操作",
				minWidth: 150,
				align: "center",
				fixed: "right",
				toolbar: "#table-content-facilitystore"
			}]
		],
		page: !0,
		limit: 10,
		limits: [10, 15, 20, 25, 30],
		text: "对不起，加载出现异常！"
	}), n.on("tool(LAY-app-content-comm)", function(t) {
		var n = t.data;
	    "sea" === t.event && e.popup({
			title: "查看设施",
			area: ["420px", "450px"],
			id: "LAY-popup-content-comm",
			success: function(t, e) {
				i(this.id).render("facility/putInfo", n).done(function() {
					l.render(null, "layuiadmin-form-comment"), l.on("submit(layuiadmin-app-com-submit)", function(t) {
						t.field;
						layui.table.reload("LAY-app-content-comm"), layer.close(e)
					})
				})
			}
		})
	}), t("facility_put", {})
});
