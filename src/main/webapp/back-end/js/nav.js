(() => {
    //廣告
    const div = document.createElement('div');
    div.classList.add('d-none');

    // < !-- class row 播放 d - none 隱藏 -->
    div.id = "proBanner";
    div.innerHTML = `
    <div class="col-12">
        <span class="d-flex align-items-center purchase-popup">
        <p>Get tons of UI components, Plugins, multiple layouts, 20+ sample pages, and more!</p>
        <a href="https://www.bootstrapdash.com/product/celestial-admin-template/?utm_source=organic&utm_medium=banner&utm_campaign=free-preview"
            target="_blank" class="btn download-button purchase-button ml-auto">Upgrade To Pro</a>
        <i class="typcn typcn-delete-outline" id="bannerClose"></i>
        </span>
    </div>`;

    const nav = document.createElement('nav');
    nav.classList.add('navbar', 'col-lg-12', 'col-12', 'p-0', 'fixed-top', 'd-flex', 'flex-row');
    // <!-- partial:partials/_navbar.html -->
    nav.innerHTML = `
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
            <a class="navbar-brand brand-logo" href="index.html"><img src="back-end/images/logo.svg" alt="logo" /></a>
            <a class="navbar-brand brand-logo-mini" href="index.html"><img src="back-end/images/logo-mini.svg"
                alt="logo" /></a>
            <button class="navbar-toggler navbar-toggler align-self-center d-none d-lg-flex" type="button"
                data-toggle="minimize">
                <span class="typcn typcn-th-menu"></span>
            </button>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
            <ul class="navbar-nav mr-lg-2">
                <li class="nav-item  d-none d-lg-flex">
                    <a class="nav-link" href="#">
                        Calendar
                    </a>
                </li>
                <li class="nav-item  d-none d-lg-flex">
                    <a class="nav-link active" href="#">
                        Statistic
                    </a>
                </li>
                <li class="nav-item  d-none d-lg-flex">
                    <a class="nav-link" href="#">
                        Employee
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
                <li class="nav-item d-none d-lg-flex  mr-2">
                    <a class="nav-link" href="#">
                        Help
                    </a>
                </li>
                <li class="nav-item dropdown d-flex">
                    <a class="nav-link count-indicator dropdown-toggle d-flex justify-content-center align-items-center"
                        id="messageDropdown" href="#" data-toggle="dropdown">
                        <i class="typcn typcn-message-typing"></i>
                        <span class="count bg-success">2</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
                        aria-labelledby="messageDropdown">
                        <p class="mb-0 font-weight-normal float-left dropdown-header">Messages</p>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <img src="back-end/images/faces/face4.jpg" alt="image" class="profile-pic">
                            </div>
                            <div class="preview-item-content flex-grow">
                                <h6 class="preview-subject ellipsis font-weight-normal">David
                                    Grey</h6>
                                <p class="font-weight-light small-text mb-0">
                                    The meeting is cancelled
                                </p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <img src="back-end/images/faces/face2.jpg" alt="image" class="profile-pic">
                            </div>
                            <div class="preview-item-content flex-grow">
                                <h6 class="preview-subject ellipsis font-weight-normal">Tim Cook
                                </h6>
                                <p class="font-weight-light small-text mb-0">
                                    New product launch
                                </p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <img src="back-end/images/faces/face3.jpg" alt="image" class="profile-pic">
                            </div>
                            <div class="preview-item-content flex-grow">
                                <h6 class="preview-subject ellipsis font-weight-normal"> Johnson
                                </h6>
                                <p class="font-weight-light small-text mb-0">
                                    Upcoming board meeting
                                </p>
                            </div>
                        </a>
                    </div>
                </li>
                <li class="nav-item dropdown  d-flex">
                    <a class="nav-link count-indicator dropdown-toggle d-flex align-items-center justify-content-center"
                        id="notificationDropdown" href="#" data-toggle="dropdown">
                        <i class="typcn typcn-bell mr-0"></i>
                        <span class="count bg-danger">2</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
                        aria-labelledby="notificationDropdown">
                        <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <div class="preview-icon bg-success">
                                    <i class="typcn typcn-info-large mx-0"></i>
                                </div>
                            </div>
                            <div class="preview-item-content">
                                <h6 class="preview-subject font-weight-normal">Application Error</h6>
                                <p class="font-weight-light small-text mb-0">
                                    Just now
                                </p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <div class="preview-icon bg-warning">
                                    <i class="typcn typcn-cog mx-0"></i>
                                </div>
                            </div>
                            <div class="preview-item-content">
                                <h6 class="preview-subject font-weight-normal">Settings</h6>
                                <p class="font-weight-light small-text mb-0">
                                    Private message
                                </p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                                <div class="preview-icon bg-info">
                                    <i class="typcn typcn-user-outline mx-0"></i>
                                </div>
                            </div>
                            <div class="preview-item-content">
                                <h6 class="preview-subject font-weight-normal">New user registration</h6>
                                <p class="font-weight-light small-text mb-0">
                                    2 days ago
                                </p>
                            </div>
                        </a>
                    </div>
                </li>
                <li class="nav-item nav-profile dropdown">
                    <a class="nav-link dropdown-toggle  pl-0 pr-0" href="#" data-toggle="dropdown" id="profileDropdown">
                        <i class="typcn typcn-user-outline mr-0"></i>
                        <span class="nav-profile-name">Evan Morales</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                        <a class="dropdown-item">
                            <i class="typcn typcn-cog text-primary"></i>
                            Settings
                        </a>
                        <a class="dropdown-item">
                            <i class="typcn typcn-power text-primary"></i>
                            Logout
                        </a>
                    </div>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                data-toggle="offcanvas">
                <span class="typcn typcn-th-menu"></span>
            </button>
        </div>
        `;

    const body = document.querySelector('body');
    body.insertBefore(div, body.firstChild);
    const div1 = document.querySelector('.container-scroller');
    div1.insertBefore(nav, div1.firstChild);
})();