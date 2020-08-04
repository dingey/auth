<#import "/sys/common/layout.ftl" as layout />
<@layout.standard title="用户" cssMap={} jsMap={}>
    <div class="content-wrapper">

        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>用户</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">用户</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>

        <section class="content" id="content">

            <div class="card" id="card">
                <div class="card-header">
                    <form class="form-inline" action="/sys/user/list">
                        <div class="form-user mx-sm-3 mb-2">
                            <input type="text" class="form-control" name="name" placeholder="用户名">
                        </div>
                        <button type="button" class="btn btn-light mb-2" onclick="page()">搜索</button>
                        <button type="reset" class="btn btn-light mb-2" onclick="page()">重置</button>
                    </form>
                </div>

                <div id="t">
                    <div id="tb">
                        <div class="card-body">

                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>组织</th>
                                    <th>昵称</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pager.list as t>
                                    <tr>
                                        <td>${t.id}</td>
                                        <td>${(t.username)!}</td>
                                        <td></td>
                                        <td>${t.name}</td>
                                        <td>
                                            <a href="#" onclick="get('${t.id}')"><i class="fa fa-edit"></i></a>
                                            <a href="#" onclick="get('${t.id}')"><i class="fa fa-times"></i></a>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer clearfix">
                            <#include "/sys/common/pager.ftl"/>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </div>
    <#include "/sys/user/get.ftl"/>
</@layout.standard>