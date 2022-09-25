(() => {
    const div = document.createElement("div");
    div.classList.add('theme-setting-wrapper');
    div.innerHTML = `
    <div id="settings-trigger"><i class="typcn typcn-cog-outline"></i></div>
        <div id="theme-settings" class="settings-panel">
            <i class="settings-close typcn typcn-delete-outline"></i>
            <p class="settings-heading">側欄顏色</p>
            <div class="sidebar-bg-options" id="sidebar-light-theme">
                <div class="img-ss rounded-circle bg-light border mr-3"></div>
                白
            </div>
            <div class="sidebar-bg-options selected" id="sidebar-dark-theme">
                <div class="img-ss rounded-circle bg-dark border mr-3"></div>
                黑
            </div>
            <p class="settings-heading mt-2">導覽列顏色</p>
            <div class="color-tiles mx-0 px-4">
                <div class="tiles success"></div>
                <div class="tiles warning"></div>
                <div class="tiles danger"></div>
                <div class="tiles primary"></div>
                <div class="tiles info"></div>
                <div class="tiles dark"></div>
                <div class="tiles default border"></div>
            </div>
        </div>`;
    const div1 = document.querySelector('.page-body-wrapper.container-fluid');
    div1.insertBefore(div, div1.firstChild);
})();