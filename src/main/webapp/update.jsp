<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/5/7
  Time: 14:53
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
                    $("[name='medType']").append("<option>--请选择--</option>");
                    for ( var i in obj) {
                        $("[name='medType']").append("<option value="+obj[i].medType+">"+obj[i].medType+"</option>");
                    }
                },"json"
            );
        })
        //验证名称不能为空
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
        //进货
        function jisuan(){
           var proCount =  $("[name='proCount']").val();
           var stockCount =  $("[name='stockCount']").val();
           //3.设置文本框的value值
            $("[name='proCount']").val(parseInt(proCount)+parseInt(stockCount))
        }
    </script>
</head>
<body>
<form action="/updateMed" method="post">
    <table>
        <tr>
            <input type="hidden" value="${medicine.yid}" name="yid">
            <td>项目编号</td>
            <td>
                <input type="text" name="projectNumber" value="${medicine.projectNumber}">
            </td>
        </tr>
        <tr>
            <td>药品名称</td>
            <td>
                <input type="text" name="projectName" value="${medicine.projectName}" onblur="verifyName()"><span id="projectName"></span>
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
                <input type="text" name="price" value="${medicine.price}">
            </td>
        </tr>
        <tr>
            <td>进货价</td>
            <td>
                <input type="text" name="costPrice" value="${medicine.costPrice}">
            </td>
        </tr>
        <tr>
            <td>数量</td>
            <td>
                <input type="text" name="proCount" value="${medicine.proCount}" readonly>
            </td>
        </tr>
        <tr>
            <td>进货数量</td>
            <td>
                <input type="text" name="stockCount" onblur="jisuan()">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改药品">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
