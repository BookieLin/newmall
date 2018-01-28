<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/13 0013
  Time: 下午 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微信</title>
    <jsp:include page="../../../inclueds/header.jsp"/>
</head>
<body>

    <input id="myurl" type="text" name="url" value="">
    <button id="scanQRCode">扫描二维码</button>


<jsp:include page="../../../inclueds/footer.jsp"/>
<script>
    var signature="";
    var jsapi_ticket="";
    var url="";
    var nonceStr="";
    var timestamp=0;
    $('#scanQRCode').click(function () {
        $("#myurl").val(location.href.split('#')[0]);

        $.ajax({
            type:'post',
            url:'weixin',
            data:'url='+"http%3A%2F%2F1964y433d1.iok.la%2Fweixin",
            success:function (message) {
                alert(message);
                var entrySet = message.split(",");
                signature=entrySet[0].split("=")[1];
                jsapi_ticket=entrySet[1].split("=")[1];
                url=entrySet[2].split("=")[1];
                nonceStr=entrySet[3].split("=")[1];
                timestamp=parseInt(entrySet[4].split("=")[1]);
                console.log("signature="+signature);
                console.log("jsapi_ticket="+jsapi_ticket);
                console.log("url="+url);
                console.log("nonceStr="+nonceStr);
                console.log("timestamp="+timestamp);
                wx.config({
                    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: 'wx318f0369778abec1', // 必填，公众号的唯一标识
                    timestamp: 1515923852, // 必填，生成签名的时间戳
                    nonceStr: "3fd0bc1b-08e9-48d8-805c-d3df5837fbab", // 必填，生成签名的随机串
                    signature: "f7cf53f516dc81d6ac94290be9c048ab33e6d6f7",// 必填，签名，见附录1
                    jsApiList: ['scanQRCode'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2

                });

                wx.ready(function () {

                    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
//        config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。

                });
                wx.error(function (res) {
                    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
                    alert("出错了：" + res.errMsg);

                });

                alert(encodeURIComponent(location.href.split('#')[0]));
                console.log(encodeURIComponent(location.href.split('#')[0]))

                wx.scanQRCode({
                    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                    scanType: ["qrCode", "barCode"], // 可以指定扫二维码还是一维码，默认二者都有
                    success: function (res) {
                        var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                        document.getElementById("wm_id").value = result;//将扫描的结果赋予到jsp对应值上
                        alert("扫描成功::扫描码=" + result);
                    },
                    error:function(res){
                        alert("扫描失败："+res.resultStr);
                    }
                });
            }
        })

    });//end_document_scanQRCode

    wx.config({
        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx318f0369778abec1', // 必填，公众号的唯一标识
        timestamp: 1515923852, // 必填，生成签名的时间戳
        nonceStr: "3fd0bc1b-08e9-48d8-805c-d3df5837fbab", // 必填，生成签名的随机串
        signature: "f7cf53f516dc81d6ac94290be9c048ab33e6d6f7",// 必填，签名，见附录1
        jsApiList: ['scanQRCode'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2

    });
    wx.error(function (res) {
        alert("出错了：" + res.errMsg);
    });
    wx.ready(function () {

        // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
//        config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
        alert(encodeURIComponent(location.href.split('#')[0]));
        wx.checkJsApi({
            jsApiList: ['scanQRCode'],
            success: function (res) {
                alert("check成功拉！");
            },
        });

        wx.scanQRCode({
            needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
            scanType: ["qrCode", "barCode"], // 可以指定扫二维码还是一维码，默认二者都有
            success: function (res) {
                var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                document.getElementById("wm_id").value = result;//将扫描的结果赋予到jsp对应值上
                alert("扫描成功::扫描码=" + result);
            },
        });

    });
    wx.error(function (res) {
        // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
        alert("出错了：" + res.errMsg);

    });
</script>
</body>
</html>
