var titleInit = document.title, isShine = true;
//窗体失焦的时候，标题就会闪。
setInterval(function() {
    var title = document.title;
    if (isShine == true) {
        if (/新/.test(title) == false) {
            document.title = '【你有新消息】';
        } else {
            document.title = '【　　　　　】';
        }
    } else {
        document.title = titleInit;
    }
}, 500);


window.onfocus = function() {
    isShine = false;
};
window.onblur = function() {
    isShine = true;
};

// for IE
document.onfocusin = function() {
    isShine = false;
};
document.onfocusout = function() {
    isShine = true;
};