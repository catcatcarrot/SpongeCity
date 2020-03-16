/**

 @Name：layuiAdmin 设置
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL
    
 */
 
layui.define(['form', 'upload'], function(exports){
  var $ = layui.$
  ,layer = layui.layer
  ,laytpl = layui.laytpl
  ,setter = layui.setter
  ,view = layui.view
  ,admin = layui.admin
  ,form = layui.form
  ,upload = layui.upload;

  var $body = $('body');
  
  form.render();
  
  //自定义验证
  form.verify({
    nickname: function(value, item){ //value：表单的值、item：表单的DOM对象
      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
        return '用户名不能有特殊字符';
      }
      if(/(^\_)|(\__)|(\_+$)/.test(value)){
        return '用户名首尾不能出现下划线\'_\'';
      }
      if(/^\d+\d+\d$/.test(value)){
        return '用户名不能全为数字';
      }
    }
    
    //我们既支持上述函数式的方式，也支持下述数组的形式
    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    
    //确认密码
    ,repass: function(value){
      if(value !== $('#LAY_password').val()){
        return '两次密码输入不一致';
      }
    }
  });
  
  //设置密码
  form.on('submit(setmypass)', function(obj){
    //layer.msg(JSON.stringify(obj.field));
    var oldPassword = obj.field.oldPassword;
		var newPassword = obj.field.repassword;
		
    //提交修改
    /*
    admin.req({
      url: ''
      ,data: obj.field
      ,success: function(){
        
      }
    });
    */
		  $.ajax({
			url:"/admin/changePwd",
			data:obj.field,
			dataType: "json",
			success:function(data){	
				  if(data.code==0){
						layer.msg(data.msg, {
							time: 2000 //2秒关闭（如果不配置，默认是3秒）
						}, function(){
							location.href="/logout"
						});
					}else{
						layer.msg(data.msg);
						$("input[name='oldPassword']").val("");
						$("input[name='password']").val("");
						$("input[name='repassword']").val("");
					}
			}
		 }); 
    return false;
  });
  
  //对外暴露的接口
  exports('set', {});
});