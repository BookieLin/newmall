<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14 0014
  Time: 下午 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微信2</title>
    <jsp:include page="../../../inclueds/header.jsp"/>
</head>
<body>
<jsp:include page="../../../inclueds/footer.jsp"/>
    <script>
        wx.config({
            debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: 'wx318f0369778abec1', // 必填，公众号的唯一标识
            timestamp: parseInt(${timestamp}), // 必填，生成签名的时间戳
            nonceStr: '${nonceStr}', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: ['checkJsApi', 'scanQRCode'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2

        });
        wx.error(function (res) {
            alert("出错了：" + res.errMsg);
        });
        wx.ready(function () {

            // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
//        config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
            alert(location.href.split('#')[0]);
            alert(encodeURIComponent(location.href.split('#')[0]));
            wx.checkJsApi({
                jsApiList: ['scanQRCode'],
                success: function (res) {
                    alert("check成功拉！");
                },
                error: function (res) {
                    alert("check失败啦");
                }
            });


            wx.scanQRCode({
                needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                scanType: ["qrCode", "barCode"], // 可以指定扫二维码还是一维码，默认二者都有
                success: function (res) {
                    var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                    document.getElementById("wm_id").value = result;//将扫描的结果赋予到jsp对应值上
                    alert("扫描成功::扫描码=" + result);
                },
                error: function (res) {
                    alert("扫描失败！！！");
                }
            });

        });


        wx.error(function (res) {

            // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。


            alert("出错了：" + res.errMsg);

        });
    </script>
</body>
</html>
