window.Notification.requestPermission().then(function (value) {
    // result可能是是granted, denied, 或default.
    //其中granted表示用户允许通知，denied表示用户嫌弃你，default表示用户目前还没有管你
    console.log(value);
    if (value == "granted") {
        var notification = new Notification("Hi，帅哥：", {
            body: '可以加你为好友吗？',
            icon: '/image/bg.jpg',
            silent:true,
            sound:"",

        });

        notification.onclick = function() {
            $("#msg").html('张小姐已于' + new Date().toTimeString().split(' ')[0] + '加你为好友！');
            notification.close();
        };

        notification.onerror=function (error) {

        };

        notification.onclose=function (ev) {

        };

        notification.onshow =function (ev) {

        };
    }else {
        console.log("please granted permission !!")
    }
});
