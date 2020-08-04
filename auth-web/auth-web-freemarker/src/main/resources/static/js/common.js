$(function () {

    var sidebarArray = ["no_navbar_border", "body_small_text", "navbar_small_text", "sidebar_nav_small_text",
        "footer_small_text", "sidebar_nav_flat_style", "sidebar_nav_legacy_style", "sidebar_nav_compact",
        "sidebar_nav_child_indent", "Main_Sidebar_disable", "brand_small_text"];

    var colorArray = ["NavbarVariants", "AccentColorVariants", "DarkSidebarVariants", "LightSidebarVariants", "BrandLogoVariants"];

    bindLocal();

    function bindLocal() {
        for (j = 0; j < sidebarArray.length; j++) {
            bindingSidebar(j);
            setSidebar(j);
        }
    }

    function setSidebar(i) {
        var v = localStorage.getItem(sidebarArray[i]);
        if (v != undefined) {
            $(".control-sidebar-content input").eq(i).click();
        }
    }

    function bindingSidebar(i) {
        $(".control-sidebar-content input").eq(i).click(function () {
            if ($(this).is(':checked')) {
                console.log(sidebarArray[i] + " checked !");
                localStorage.setItem(sidebarArray[i], 1);
            } else {
                localStorage.removeItem(sidebarArray[i]);
                console.log(sidebarArray[i] + " no checked !");
            }
        })
    }

    function bindingClolor(i) {
        $(".control-sidebar-content .flex-wrap div.elevation-2").click(function () {
            if ($(this).is(':checked')) {
                console.log(sidebarArray[i] + " checked !");
                localStorage.setItem(sidebarArray[i], 1);
            } else {
                localStorage.removeItem(sidebarArray[i]);
                console.log(sidebarArray[i] + " no checked !");
            }
        })
    }
})

var pageNum = 1;

function page(num, form, table, size) {
    if (form == undefined || form == "") {
        form = "form:eq(0)";
    }
    if (table == undefined || table == "") {
        table = "table:eq(0)";
    }
    if (size == undefined) {
        size = $("#pageSize").val();
    }
    if (num == undefined) {
        num = pageNum;
    } else {
        pageNum = num;
    }
    var url = $(form).attr("action");
    if (url == undefined) {
        url = window.location.pathname;
    }
    $("#t").load(url + " #tb", "pageNum=" + num + "&pageSize=" + size + "&" + serialize(form), function (response, status, xhr) {
        if (status == "success") {
            try {
                if (initList && typeof (initList) == "function") {
                    initList();
                }
                pageNum = num;
             } catch (e) {}
        } else {
            alert("页面载入失败");
        }
    });
}

function serialize(id) {
    var parmStr = $(id).serialize();
    return parmStr.split("&").filter(str=>!str.endsWith("=")).join("&");
}

function get(id) {
    $("#getContainer").load("get?id=" + id + " #getBody", function (response, status, xhr) {
        if (status == "success") {
            try {
                if (initGet && typeof (initGet) == "function") {
                    initGet();
                }
            } catch (e) {
            }
            $("#modal").modal();
        } else {
            alert("页面载入失败");
        }
    });
}

function save() {
    var param = $("form:eq(1)").serialize();
    $.post("save", param, function (data) {
        if (data.code == 0) {
            $("#modal").modal('hide');
            page();
        } else {
            layer.msg(data);
        }
    }, "json");
}