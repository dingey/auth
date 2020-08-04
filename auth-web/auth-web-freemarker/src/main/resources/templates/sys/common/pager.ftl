<#if (pager?exists)>
    <div class="row">
        <div class="col-sm-12 col-md-5" style="padding-left: 5px;">
            <p><span>每页
    <select id="pageSize" class="form-control input-sm" style="width: 75px;display: inline-block;" onchange="page(1)">
        <option value="2" <#if (pager.pageSize==2)>selected</#if>>2</option>
        <option value="10" <#if (pager.pageSize==10)>selected</#if>>10</option>
        <option value="20" <#if (pager.pageSize==20)>selected</#if>>20</option>
        <option value="50" <#if (pager.pageSize==50)>selected</#if>>50</option>
        <option value="100" <#if (pager.pageSize==100)>selected</#if>>100</option>
    </select>项&nbsp;,&nbsp;共&nbsp;${(pager.pages)!}&nbsp;页&nbsp;${(pager.total)!}&nbsp;项
    </span>
            </p>
        </div>

        <div class="col-sm-12 col-md-7" style="padding-right: 0px;">
            <ul class="pagination float-right">
                <li class="page-item previous disabled">
                    <a href="#" <#if (pager.pageNum>1)>onclick="page(1)"</#if> class="page-link">«</a>
                </li>
                <#list pager.navigatepageNums as num>
                    <li class="page-item <#if (pager.pageNum==num)>active</#if>">
                        <a href="#" onclick="page(${num})" class="page-link">${num}</a>
                    </li>
                </#list>
                <li class="page-item next">
                    <a href="#" <#if (pager.pageNum<pager.pages)>onclick="page(${pager.pageNum})"</#if>
                       class="page-link">»</a>
                </li>
            </ul>
        </div>
    </div>
    <script>
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
            $("#t").load(url + " #tb", "pageNum=" + num + "&pageSize=" + size + "&" + serialize(form), function () {
                try {
                    if (init && typeof (init) == "function") {
                        init();
                    }
                    pageNum = num;
                } catch (e) {
                    //console.error(e.message)
                }
            });
        }

        function serialize(id) {
            const parmStr = $(id).serialize();
            return parmStr.split("&").filter(str => !str.endsWith("=")).join("&");
        }
    </script>
</#if>