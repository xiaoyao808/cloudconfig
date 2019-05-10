<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/5/7
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //全选 反选
            $("#qx").click(function(){
                $(".ck").prop("checked",true);
            })
            $("#fx").click(function(){
                $(".ck").each(function(){
                    $(this).prop("checked",!$(this).prop("checked"));
                })
            })
        })
        function getIds(){
            var arr="";
            $("[name='yid']:checked").each(function(){
                arr+=","+this.value;
            });
            arr=arr.substring(1);
            return arr;
        }
        function delAll(){
            var ids=getIds();
            $.post(
                "delAll",{ids:ids},function(obj){
                    if(obj.success){
                        alert(obj.message);
                        location="list";
                    }else{
                        alert(obj.message);
                    }
                },"json"
            );
        }
        function stockMed(yid){
            location.href="/stockMed?yid="+yid;
        }
        function addMed(){
            location.href="add.jsp";
        }
        function exportList(){

        }

    </script>
</head>
<body>
    <table align="center">
        ${pu.mohuPage}
        <tr>
            <td><input type="checkbox"></td>
            <td>项目编号</td>
            <td>项目名称</td>
            <td>单价</td>
            <td>项目数量</td>
            <td>项目成本价格</td>
            <td>药物种类</td>
            <td>
                <input type="button" value="新增药品"  onclick="addMed()">
                <input type="button" value="批量删除"  onclick="delAll()">
                <input type="button" value="导出列表"  onclick="exportList()">
            </td>
        </tr>
        <c:forEach items="${MedicineList}" var="a">
            <tr>
                <td><input type="checkbox" class="ck" value="${a.yid}"></td>
                <td>${a.projectNumber }</td>
                <td>${a.projectName }</td>
                <td>${a.price }</td>
                <td>${a.proCount }</td>
                <td>${a.costPrice}</td>
                <td>${a.medType}</td>
                <td>
                    <input type="button" value="进货"  onclick="stockMed(${a.yid})">
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="10">
                <input type="button" value="全选" id="qx">
                <input type="button" value="反选" id="fx">
                ${pu.page}
            </td>
        </tr>
    </table>
</body>
</html>
