<%--
  Created by IntelliJ IDEA.
  User: 红菱
  Date: 2018/1/2
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    function reloadCode() {
        var time = new Date().getTime();
        document.getElementById("imagecode").src="<%=request.getContextPath()%>/servlet/ImageServlet?d="+time;

    }

</script>

<!--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册_电子邮箱</title>
    <link type="text/css" rel="stylesheet" href="/css/register-by-email.css">
</head>
<body>
<div class="header">
    <div class="header-center">
        <div class="huawei-logo">
            <img src="/images/head-top.png"/>
        </div>
        <!--<div class="logo-line"></div>-->
        <div class="huawei-shoppingmall">
            <span class="vertical-line">|&nbsp;&nbsp;</span>
            <span class="shoppingmall-text">华为商城</span>
        </div>
    </div>
</div>
<div class="bodyer">
    <div class="bodyer-center">
        <div class="register-type">
            <a href="register-by-phone.jsp">
                <div class="register-by-telphone">
                    <img src="/images/phone.png"/>
                    <span>手机号</span>
                </div>
            </a>
            <a href="">
                <div class="register-by-email">
                    <img src="/images/email.png">
                    <span>电子邮箱</span>
                </div>
            </a>
            <div class="jump-to-login">
                <span>已有华为帐号</span>
                <a href="/html/login.html">登录></a>
            </div>
        </div>
        <div class="register-body">
            <div class="register-body-center">
                <form method="post" action="/servlet/RegisterByEmailServlet">
                    <div class="country">
                        <div class="text">
                            <span>国
                                <span style="display:inline-block;width: 50px;"></span>
                            家</span>
                        </div>
                        <div class="value">
                            <span>中国</span>
                            <img src="/images/triangle-gray.png" class="value-image" />
                        </div>
                    </div>
                    <div class="email">
                        <div class="text">
                            <span>邮&nbsp;&nbsp;箱&nbsp;&nbsp;地&nbsp;&nbsp;址</span>
                        </div>
                        <div class="value">
                            <input type="text" id="email" name="email" placeholder="请输入邮箱地址"/>
                        </div>
                    </div>
                    <div class="graphic-verification">
                        <div class="text">
                            <span>图&nbsp;形&nbsp;验&nbsp;证&nbsp;码</span>
                        </div>
                        <div class="value">
                            <input type="text" id="graphic-verification" name="graphic-verification" placeholder="请输入图形验证码" />
                            <span>
                                <a href="javascript:reloadCode();">
                                    <img src="<%=request.getContextPath()%>/servlet/ImageServlet"
                                         id="imagecode" alt="验证码"/>
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="email-verification">
                        <div class="text">
                            <span>邮&nbsp;件&nbsp;验&nbsp;证&nbsp;码</span>
                        </div>
                        <div class="value">
                            <input type="text" id="email-verification" name="email-verification" placeholder="请输入邮件验证码"/>
                            <input type="button" value="获取验证码" class="get-verification" />
                        </div>
                    </div>
                    <div class="password">
                        <div class="text">
                            <span>密<span style="display:inline-block;width: 60px;"></span>码</span>
                        </div>
                        <div class="value">
                            <input type="password" id="password" value="" name="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="confirm-password">
                        <div class="text">
                            <span>确&nbsp;&nbsp;认&nbsp;&nbsp;密&nbsp;&nbsp;码</span>
                        </div>
                        <div class="value">
                            <input type="password" id="confirm-password" name="confirm-password" placeholder="请再次输入密码">
                        </div>
                    </div>
                    <div class="telphone">
                        <div class="text">
                            <span>+86(中国)</span>
                            <span>
                                <img src="/images/triangle-gray.png"/>
                            </span>
                        </div>
                        <div class="value">
                            <input type="text" id="telphone" name="telphone" placeholder="请输入手机号"/>
                        </div>
                    </div>
                    <div class="message-verification">
                        <div class="text">
                            <span>短&nbsp;信&nbsp;验&nbsp;证&nbsp;码</span>
                        </div>
                        <div class="value">
                            <input type="text" id="message-verification" name="message-verification" placeholder="请输入短信验证码"/>
                            <input type="button" value="获取验证码" class="get-verification" />
                        </div>
                    </div>
                    <div class="botton">
                        <input type="submit" name="register" value="注册"/>
                    </div>

                </form>
            </div>
        </div>
        <div class="bottom-line"></div>
    </div>
</div>
<div class="footer">
    <div class="footer-center">
        <div class="agreement-policy-problem">
            <a href="#" class="agreement">用户协议</a>
            <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
            <a href="#" class="policy">隐私政策</a>
            <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
            <a href="#" class="problem">常见问题</a>
        </div>
        <div class="copy">
            <span class="copy-text">Copyright&copy;2011-2017&nbsp;华为技术有限公司&nbsp;
                版权所有&nbsp;保留一切权利&nbsp;苏B2-20070200号&nbsp;
                |&nbsp;苏ICP备09062682号-9</span>
        </div>
    </div>
</div>
</body>
</html>