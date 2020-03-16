/** layuiAdmin.pro-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form", "element"], function(e) {
    var t = (layui.$, layui.admin),
        i = layui.view,
        r = layui.table,
        l = layui.form,
        o = layui.element;
    r.render({
        elem: "#deal-task",
        url: "/getTasksByDealStatus",
		where:{"dealStatus":"待处理"},
        method:"GET",
        cols: [
            [{
                field: "id",
                width: 80,
                title: "序号",
                align: "center"
            },{
                field: "taskId",
				hide:true,
                title: "realId",
            }, {
                field: "site",
                minwidth: 200,
                align: "center",
                title: "位置"
            }, {
                field: "deep",
                minWidth: 100,
                title: "水深",
                align: "center"
            }, {
                field: "faultName",
                title: "故障等级",
                width: 100,
                align: "center",
				toolbar:"#changeColor"
            }, {
                field: "checkTime",
                minWidth: 100,
                align: "center",
                title: "审核时间",
				templet:"<div>{{layui.util.toDateString(d.checkTime,'yyyy-MM-dd')}}</div>"
            }, {
                field: "dealStatus",
                width: 100,
                align: "center",
                title: "处理状态"
            }, {
                field: "operation",
                title: "操作",
                align: "center",
                width: 100,
				toolbar:"#table-deal-task"
            }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！",
        done: function() {
            o.render("progress")
        }
    }), r.on("tool(deal-task)", function(e) {
		"deal" ===layer.confirm("确定处理此任务？", function(z) {
			var id = e.data.taskId;
			$.ajax({
				url:"/updateTasksByDealStatus",
				data:{"id":id,
					"dealStatus":"待分配"},
				dataType: "json",
				success:function(data){
					if(data.code==0){
						layer.msg("处理成功");
						layui.table.reload('deal-task');
					}else{
						layer.msg("处理失败");
					}
				}
			});
			layer.close(z)
		})
    }), r.render({
        elem: "#assign-task",
        url: "/getTasksByDealStatus",
		where:{"dealStatus":"待分配"},
        method:"GET",
        cols: [
            [{
                field: "id",
                width: 80,
                title: "序号",
                align: "center"
            },{
                field: "taskId",
				hide:true,
                title: "realId",
            }, {
                field: "site",
                minwidth: 200,
                align: "center",
                title: "位置"
            }, {
                field: "faultName",
                title: "故障等级",
                width: 200,
                align: "center",
				toolbar:"#changeColor"
            }, {
                field: "assignTime",
                minWidth: 100,
                align: "center",
                title: "分配时间",
				templet:"<div>{{layui.util.toDateString(d.assignTime,'yyyy-MM-dd')}}</div>"
            }, {
                field: "operation",
                title: "操作",
                align: "center",
                width: 100,
            	toolbar:"#table-assign-task"
            }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！",
        done: function() {
            o.render("progress")
        }
    }), r.on("tool(assign-task)", function(e) {
        "assign" ===layer.confirm("确定分配此任务？", function(z) {
			var id = e.data.taskId;
			$.ajax({
				url:"/updateTasksByDealStatus",
				data:{"id":id,
					"dealStatus":"已分配"},
				dataType: "json",
				success:function(data){
					if(data.code==0){
						layer.msg("分配成功");
						layui.table.reload('assign-task');
					}else if(data.code==-1){
						layer.msg("分配失败,该片区没有运维人员!");
					}else{
						layer.msg("分配失败");
					}
				}
			});
        	layer.close(z)
        })
    }), r.render({
        elem: "#already-assign-task",
        url: "/getAllTaskPerson",
		//where:{"dealStatus":"已分配"},
        method:"GET",
        cols: [
           [{
               field: "id",
               width: 80,
               title: "序号",
               align: "center"
           },{
               field: "site",
               minwidth: 200,
               align: "center",
               title: "位置"
           }, {
               field: "faultName",
               title: "故障等级",
               width: 100,
               align: "center",
			   toolbar:"#changeColor"
           }, {
               field: "accept",
               width: 100,
               align: "center",
               title: "任务状态",
			   toolbar:"#isAccept"
           }, {
               field: "ompName",
               Width: 100,
               align: "center",
               title: "处理人"
           }, {
               field: "phone",
               title: "联系方式",
               align: "center",
               minWidth: 100
           }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！",
        done: function() {
            o.render("progress")
        }
    }), e("dispatcher", {})
});