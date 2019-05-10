<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019/5/7
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript">
        function verify(uname){
            $.post(
                "verifyUname",
                {uname:uname},
                function(obj){
                    if(obj.success){
                        alert("用户名存在,可用")
                    }else{
                        alert("用户名不存在")
                    }
                },
              "json"
            );
        }
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
                "delAll.do",{ids:ids},function(obj){
                    if(obj.success){
                        alert(obj.message);
                        location="list";
                    }else{
                        alert(obj.message);
                    }
                },"json"
            );
        }
        function addMed(){
            location.href="/add.jsp";
        }
       $(function () {
            var  uname = $.cookie("uname",uname);
            var password = $.cookie("password",password);
            $("[name='uname']").val(uname);
            $("[name='password']").val(password);
            login();
        })
        function login(){
            //获取多选框状态
            /*var a = $("[name='remenber']").is(":checked");
            var uname =$("[name='uname']").val();
            var password = $("[name='password']").val();
            if (a){
                //设置名称为name,值为value的Cookie
                var expdate = new Date();   //初始化时间
                expdate.setTime(expdate.getTime() + 30 * 60 * 1000);
                document.cookie = name+"="+uname+";expires="+expdate.toGMTString()+";path=/"
                document.cookie = name+"="+password+";expires="+expdate.toGMTString()+";path=/"
                document.cookie = name+"="+a+";expires="+expdate.toGMTString()+";path=/"
            }*/
            var uname = $("[name='uname']").val();
            var password = $("[name='password']").val();
            $.post(
                "/login",
                $("form").serialize(),
                function(obj){
                    if(obj.success){
                        if($(":checkbox:checked").val()){
                            $.cookie("uname",uname,{expires:7});
                            $.cookie("password",password,{expires:7});
                        }
                        location.href="/getMedList";
                    }else{
                       //location.reload();
                    }
                },
                "json"
            );
        }
    </script>
</head>
<body>
      <div align="center">
          <form method="post" >
              <h1>医院门诊系统</h1>
              <input type="text" name="uname" onblur="verify(this.value)"><br>
              <input type="text" name="password"><br>
              <input type="checkbox" value="true">记住用户和密码<br>
              <input type="button" value="提交" onclick="login()">
          </form>
      </div>
</body>
</html>
