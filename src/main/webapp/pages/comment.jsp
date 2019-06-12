<%--
  Created by IntelliJ IDEA.
  User: April
  Date: 2019/6/5
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Comment</title>
        <link rel="stylesheet" href="../layui/css/layui.css">
    </head>
	
</head>
<body>
<script src="../layui/layui.js"></script>
<script src="../layui/jquery-3.2.1.min.js"></script>
<table id="demo" lay-filter="test" ></table>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        window.ins1 =table.render({
            elem: '#demo' //绑定table
            ,height: 400
            ,even: true  //隔行换色
            ,url: '${pageContext.request.contextPath}/operator/getcomment' //请求路径
            ,method:'POST'
            ,page: true //开启分页
            ,where:{
                appid:"wxbeebcb78fb226416"
            }
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'nickname', title: '微信昵称', width:260, sort: true, align: 'center'}
                ,{field: 'face', title: '头像', width:80, align: 'center',templet: '#usernameTpl'}
                ,{field: 'words', title: '留言内容', width:260, align: 'center'}
                ,{field: 'flag', title: '审核状态', width:100, align: 'center',templet: function(data){
                    if(data.flag==1){
                        return "未通过"
                    }
                    return "已通过"
                    }}
                ,{field: 'uuid', title: 'UUID', width: 80, hide:true, align: 'center'}
                ,{field: 'requesttime', title: '请求时间', width: 180, sort: true, align: 'center'}
                ,{field: 'updatetime', title: '修改时间', width: 180, sort: true, align: 'center'}
                ,{title: '操作', fixed: 'right', width: 120, align: 'center', toolbar: '#barDemo'}
            ]]
            ,response:{

            }
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除该记录吗？', function(index){
                    var load = null;
                    layer.close(index);
                    $.ajax({
                        url:'${pageContext.request.contextPath}/operator/delcomment',
                        data:{'uuid':data.uuid},
                        method:'POST',
                        dataType:"json",
                        //请求前执行，无论请求是否成功
                        beforeSend : function() {
                            //显示加载动画
                            load = layer.load(2);
                        },
                        complete : function() {
                            //关闭加载动画
                            layer.close(load);
                        },
                        success:function(data){
                            if(data.success){
                                layer.msg("删除成功");
                                window.location.reload();
                            }
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                if(data.flag==1){
                    $.ajax({
                        url:'${pageContext.request.contextPath}/operator/updatecomment',
                        data:{'uuid':data.uuid},
                        method:'POST',
                        dataType:"json",
                        //请求前执行，无论请求是否成功
                        beforeSend : function() {
                            //显示加载动画
                            load = layer.load(2);
                        },
                        complete : function() {
                            //关闭加载动画
                            layer.close(load);
                        },
                        success:function(data){
                            if(data.success){
                                layer.msg("该记录审核通过");
                                window.location.reload();
                            }
                        }
                    });
                }else{
                    layer.msg("该留言已通过审核！");
                }
            }
        });
    });
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">审核</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>
