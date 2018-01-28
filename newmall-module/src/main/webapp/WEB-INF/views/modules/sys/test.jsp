<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/4 0004
  Time: 下午 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>

<body>
<table id="treeTable1" style="width: 100%">
    <tr>
        <td style="width: 200px;">标题</td>
        <td>内容</td>
    </tr>
    <tr id="1">
        <td><span controller="true">1</span></td>
        <td>内容</td>
    </tr>
    <tr id="2" pid="1">
        <td><span controller="true">2</span></td>
        <td>内容</td>
    </tr>
    <tr id="3" pid="2">
        <td>3</td>
        <td>内容</td>
    </tr>
    <tr id="4" pid="2">
        <td><span controller="true">4</span></td>
        <td>内容</td>
    </tr>
    <tr id="5" pid="4">
        <td>4.1</td>
        <td>内容</td>
    </tr>
    <tr id="6" pid="1" haschild="true">
        <td>5</td>
        <td>注意这个节点是动态加载的</td>
    </tr>
    <tr id="7">
        <td>8</td>
        <td>内容</td>
    </tr>
</table>


<script src="../../../js/jquery-3.2.1.js"></script>
<script src="../../../js/jquery.treeTable.js"></script>

<script type="text/javascript">
    $(function(){
        var option = {
            theme:'vsStyle',
            expandLevel : 2,
            beforeExpand : function($treeTable, id) {
                //判断id是否已经有了孩子节点，如果有了就不再加载，这样就可以起到缓存的作用

                if ($('.' + id, $treeTable).length) { return; }
                //这里的html可以是ajax请求
                alert("11");
                var html = '<tr id="8" pId="6"><td>5.1</td><td>可以是ajax请求来的内容</td></tr>'
                    + '<tr id="9" pId="6"><td>5.2</td><td>动态的内容</td></tr>';

                $treeTable.addChilds(html);
            },
            onSelect : function($treeTable, id) {
                window.console && console.log('onSelect:' + id);

            }

        };
        $('#treeTable1').treeTable(option);
    });
</script>
</body>
</html>
