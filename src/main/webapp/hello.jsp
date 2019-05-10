<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
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

    </script>
</head>
<body>
<body>
<div style="text-align: center">
        <h1>标题</h1>
</div>
</body>