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

<table id="demo" lay-filter="test" ></table>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        window.ins1 =table.render({
            elem: '#demo' //绑定table
            ,height: 400
            ,even: true  //隔行换色
            ,url: '/operator/getcomment' //请求路径
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
                    // obj.del();
                    layer.close(index);

                    $.ajax({
                        url:'${pageContext.request.contextPath}/operator/delcomment',
                        data:{'uuid':data.uuid},
                        method:'POST',
                        success:function(data){
                            var str = '<div style="text-align:center" >删除完成<br>';
                            var index = layer.open({
                                type:1,
                                title:'操作完成',
                                btn:'确定',
                                content:str,
                                end:function(){
                                    layer.close(index);
                                    table.reload('demo');
                                }
                            });
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>
