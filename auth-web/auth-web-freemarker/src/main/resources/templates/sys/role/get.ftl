<div class="modal fade" id="modal">
    <div class="modal-dialog modal-lg" id="getContainer">
        <div class="modal-content" id="getBody">
            <div class="modal-header">
                <h4 class="modal-title"><#if (role?exists)>编辑<#else>新增</#if>角色</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <input type="hidden" name="id" value="${(role.id)!}">
                    <div class="card-body">
                        <div class="form-role row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" value="${(role.name)!}">
                            </div>
                        </div>
                        <div class="form-role row">
                            <label for="inputPassword3" class="col-sm-2 col-form-label">主管</label>
                            <div class="col-sm-10">
                                <select class="custom-select">
                                    <option>option 1</option>
                                    <option>option 2</option>
                                    <option>option 3</option>
                                    <option>option 4</option>
                                    <option>option 5</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="save()">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    function get(id) {
        $("#getContainer").load("get?id=" + id + " #getBody", function () {
            $("#modal").modal();
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
</script>