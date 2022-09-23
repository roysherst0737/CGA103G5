setInterval("fun(show_time)", 1);
function fun(timeID) {
    var date = new Date();  //建立物件  
    var y = date.getFullYear();     //獲取年份  
    var m = date.getMonth() + 1;   //獲取月份  返回0-11  
    var d = date.getDate(); // 獲取日  
    var w = date.getDay();   //獲取星期幾  返回0-6   (0=星期天) 
    var ww = ' 星期' + '日一二三四五六'.charAt(new Date().getDay());//星期幾
    var h = date.getHours();  //時
    var minute = date.getMinutes()  //分
    var s = date.getSeconds(); //秒
    var sss = date.getMilliseconds(); //毫秒
    if (m < 10) {
        m = "0" + m;
    }
    if (d < 10) {
        d = "0" + d;
    }
    if (h < 10) {
        h = "0" + h;
    }

    if (minute < 10) {
        minute = "0" + minute;
    }

    if (s < 10) {
        s = "0" + s;
    }

    if (sss < 10) {
        sss = "00" + sss;
    } else if (sss < 100) {
        sss = "0" + sss;
    }


    document.getElementById(timeID.id).innerHTML = y + "-" + m + "-" + d + "   " + h + ":" + minute + ":" + s + "  " + ww;
}