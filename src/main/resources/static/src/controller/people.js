/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(e) {
	var i = (layui.$, layui.admin),
		t = layui.view,
		l = layui.table,
		r = layui.form;
		
	 l.render({
		elem: "#LAY-user-back-manage",
		url: "/getAllPeople",
		method:"GET",
		cols: [
			[{
					field: "id",
					title: "序号",
					minWidth: 100,
					align: "center"
				}, {
					field: "name",
					title: "姓名",
					minWidth: 100,
					align: "center"
				},
				{
					field: "sex",
					title: "性别",
					align: "center"
				}, {
					field: "entryTime",
					title: "入职时间",
					align: "center",
					templet:"<div>{{layui.util.toDateString(d.entryTime,'yyyy-MM-dd')}}</div>"
				},
				{
					field: "deptName",
					title: "所属部门",
					align: "center"
				}, {
					field: "levelName",
					title: "所属级别",
					align: "center"
				},
				{
					field: "number",
					title: "员工编号",
					align: "center"
				}, {
					field: "region",
					title: "所属片区",
					align: "center"
				},
				{
					title: "操作",
					width: 150,
					align: "center",
					fixed: "right",
					toolbar: "#table-useradmin-admin"
				}
			]
		],
		//不传分页条的话就是默认10
		page: !0,
		limit: 5,
		limits: [5, 10, 15, 20],
		text: "对不起，加载出现异常！"
	}), l.on("tool(LAY-user-back-manage)", function(e) {
		var l = e.data;//获得当前行数据
		"del" ===  layer.confirm("确定删除此管理员？", function(i) {		
				var number = l.number;
				$.ajax({
					url:"/deletePeopleByNum",
					data:{number},	
					dataType: "json",
					success:function(data){
						if(data.code==0){
							layer.msg(data.msg);
							layui.table.reload('LAY-user-back-manage');
						}else{
							layer.msg(data.msg);
						}
					},
					error:function(data){
						//权限不足
						layer.msg("权限不足");
					}
				});
				layer.close(i)
			}) 
	}), e("people", {})
});
