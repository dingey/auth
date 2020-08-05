<#import "/sys/common/layout.ftl" as layout />
<@layout.standard title="权限"
cssMap={"":"https://dingey.github.io/demo/ztree/zTreeStyle.css"}
jsMap={"":"https://dingey.github.io/demo/ztree/jquery.ztree.all.js,/js/permission.js"}>
    <div class="content-wrapper">
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>权限</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">权限</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>

        <section class="content" id="content">
            <div class="card" id="card">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </section>
    </div>
    <script>
        var zNodes = [<#list list as t>{id : ${t.id!},pId : ${t.pid!"0"},name : "${t.name!}",open : false<#if (t.pid==0)>,drag:true<#else></#if>}<#if (t_index!=(list?size-1))>,</#if></#list>];
    </script>
    <#include "/sys/permission/get.ftl"/>
</@layout.standard>