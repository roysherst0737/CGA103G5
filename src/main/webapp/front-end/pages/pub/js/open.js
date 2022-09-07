function aa(open) {
    const m1 = open.substring(0, 1 * 24)
    const m2 = open.substring(1 * 24, 2 * 24)
    const m3 = open.substring(2 * 24, 3 * 24)
    const m4 = open.substring(3 * 24, 4 * 24)
    const m5 = open.substring(4 * 24, 5 * 24)
    const m6 = open.substring(5 * 24, 6 * 24)
    const m7 = open.substring(6 * 24, 7 * 24)
    function checkOpenTime(m) {
        let str = "";
        let check = true;

        lable: for (let i = 0; i < 25; i++) {
            if (check) {
                if (i == 0 && m.indexOf(1, i) == -1) {
                    str = "未營業";
                    break lable;
                }
                if (m.indexOf(1, i) !== -1) {
                    i = m.indexOf(1, i)
                } else {
                    break lable;
                }

                if (i < 10) {
                    str += "0" + (i) + ":00~";
                } else {
                    str += i + ":00~";
                }
                check = !check;
            } else {
                if (m.indexOf(0, i) == -1) {
                    str += "24:00";
                    break lable;
                } else {
                    i = m.indexOf(0, i)
                }
                if (i < 10) {
                    str += "0" + (i) + ":00  \\  ";
                } else {
                    str += (i) + ":00  \\  ";
                }
                check = !check;
            }
        }
        return str.trim().lastIndexOf('\\') + 1 == str.trim().length ? str.substring(0, str.length - 5) : str;
    }
    const week = ['禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
        let a = new Array();
        var vars = {};
    for (i = 0; i < 7; i++) {
	      vars['m'+i] = open.substring(i*24, (i+1) * 24)
        a[i] = week[i] + ' : ' + checkOpenTime( vars['m'+i]);
//        console.log( vars['m'+i]);
    }
    return a;
}