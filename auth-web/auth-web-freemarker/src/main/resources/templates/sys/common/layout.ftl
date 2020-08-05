<#macro standard title="" keywords="" description="" bodyclass="" jsMap={} cssMap={}>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://dingey.github.io/demo/adminlte3/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://dingey.github.io/demo/adminlte3/dist/css/adminlte.min.css">
    <#list cssMap?keys as key>
        <#if key==""&&cssMap[key]!="">
            <#list cssMap[key]?split(",") as val>
                <link href="${val}" rel="stylesheet">
            </#list>
        </#if>
    </#list>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link" href="#" title="退出登录">
                    <i class="fa fa-sign-out-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>

    <aside class="main-sidebar sidebar-light-lightblue elevation-4">
        <a href="#" class="brand-link">
            <img src="https://dingey.github.io/demo/adminlte3/dist/img/AdminLTELogo.png"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">管理后台</span>
        </a>

        <div class="sidebar">
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="https://dingey.github.io/demo/adminlte3/dist/img/user2-160x160.jpg"
                         class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block"> ${(Session["aa"])!"访客"}</a>
                </div>
            </div>

            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column nav-flat nav-compact" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <li class="nav-item has-treeview menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fa fa-cogs"></i>
                            <p>
                                系统管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/sys/group/list" class="nav-link">
                                    <i class="fa fa-sitemap nav-icon"></i>
                                    <p>组织</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/sys/role/list" class="nav-link">
                                    <i class="fa fa-users nav-icon"></i>
                                    <p>角色</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/sys/user/list" class="nav-link">
                                    <i class="fa fa-user nav-icon"></i>
                                    <p>用户</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/sys/permission/list" class="nav-link">
                                    <i class="fa fa-wrench nav-icon"></i>
                                    <p>权限</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </nav>
        </div>
    </aside>

    <#nested/>

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.0.5
        </div>
        <strong>Copyright &copy; 2020-2022 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
        reserved.
    </footer>

    <aside class="control-sidebar control-sidebar-dark">
    </aside>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="https://dingey.github.io/demo/adminlte3/dist/js/adminlte.min.js"></script>
<script src="https://dingey.github.io/demo/adminlte3/dist/js/demo.js"></script>
<script src="https://dingey.github.io/demo/layer/layer.js"></script>
<script src="/js/common.js"></script>
<#list jsMap?keys as key>
    <#if key==""&&jsMap[key]!="">
        <#list jsMap[key]?split(",") as val>
            <script src="${val}"></script>
        </#list>
    </#if>
</#list>
</body>
</html>
</#macro>