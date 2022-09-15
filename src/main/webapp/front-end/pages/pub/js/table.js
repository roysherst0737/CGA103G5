(window.onload = function () {
    const div = document.querySelector('.mydiv');
    console.log(div)
    const week = [0, '禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
    for (let y = 1; y < 5; y++) {
        for (let i = 1; i < 8; i++) {
            const table_div = document.createElement('div');
            table_div.setAttribute("id", "day" + i);
            table_div.classList.add("myday")
            table_div.style.gridColumn = i;
            if (y == 1) {
                table_div.style.height = '33.3px';
                table_div.style.display = 'flex';
                table_div.style.justifyContent = 'center';
                table_div.style.alignItems = 'center';
                table_div.classList.add("div_title")

                table_div.textContent = week[i];

            };
            if (i > 5) {
                table_div.classList.add('week' + i);
            }

            table_div.style.gridRow = y;
            div.appendChild(table_div, div.lastChild);

        }
    }

})();