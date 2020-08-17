<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";

%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/orderlist.css">
</head>
<body>
<c:if test="${!empty sessionScope.isDelete}">
        <script>
            alert('${sessionScope.isDelete}');
        </script>
        <c:remove var="isDelete" scope="session"/>
    </c:if>
    <!--顶部-->
    <jsp:include page="/WEB-INF/jsp/top.jsp"></jsp:include>
    <!--头部-->
    <div class="header3">
        <a href="#"><img src="images/logo.png"></a>
        <div class="h3_center">
            <div class="search_box">
                <input type="text"/>
                <span>搜索</span>
            </div>

        </div>

    </div>
    <!--头部导航-->
    <div class="nav_top">
        <div class="nav_top_center">
            <div>
                订单列表
            </div>
        </div>
    </div>

    <!--内容-->
    <div class="container4">
        <table>
            <thead>
                <tr>
                    <th>序号</th>
                    <th>订单编号</th>
                    <th>订单金额</th>
                    <th>订单时间</th>
                    <th>收货人</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${orderlist}" var="orderForm">
                <tr>
                    <td align="center">${orderForm.id}</td>
                    <td>${orderForm.orderdate}</td>
                    <td>${orderForm.cost}</td>
                    <td>未付款</td>
                    <td>${orderForm.customer.name}</td>
                    <td><input type="button" value="删除" onclick="javascript:window.location='user/toDeleteOrderFormServlet?shopAddId=${orderForm.id}';"><input type="button" value="明细" onclick="javascript:window.location='user/toOrderDetailServlet?orderFormId=${orderForm.id}';">  </td>
                </tr>
            </c:forEach>
               
            </tbody>
        </table>

    </div>
    <!--脚部-->
    <div class="footer3">
        <div class="f3_top">
            <div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
            <ul class="f3_center">
                <li class="f3_mi_li01">
                    <h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                    <h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
            <p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a>
            </p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
            <img src="images/police.png">
        </div>
    </div>

</body>
</html>