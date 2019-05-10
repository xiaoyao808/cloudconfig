<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/5/7
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $.post(
                "getAllType",
                {},
                function(obj){
                    for ( var i in obj) {
                        $("[name='medType']").append("<option value="+obj[i].medType+">"+obj[i].medType+"</option>");
                    }
                },"json"
            );
        })
        function verifyName(){
          var projectName =  $("[name='projectName']").val();
          if (projectName==""){
              $("#projectName").html("不能为空");
              $('[value="添加药品"]').attr("disabled",true);
          }else{
              $("#projectName").html("");
              $('[value="添加药品"]').attr("disabled",false);
          }
        }
    </script>
</head>
<body>
<form action="addMedMethod">
    <table>
        <tr>
            <td>项目编号</td>
            <td>
                <input type="text" name="projectNumber">
            </td>
        </tr>
        <tr>
            <td>药品名称</td>
            <td>
                <input type="text" name="projectName" onblur="verifyName()"><span id="projectName"></span>
            </td>
        </tr>
        <tr>
            <td>种类</td>
            <td>
                <select name="medType">

                </select>
            </td>
        </tr>
        <tr>
            <td>定价</td>
            <td>
                <input type="text" name="price">
            </td>
        </tr>
        <tr>
            <td>进货价</td>
            <td>
                <input type="text" name="costPrice">
            </td>
        </tr>
        <tr>
            <td>数量</td>
            <td>
                <input type="text" name="proCount">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="添加药品">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
