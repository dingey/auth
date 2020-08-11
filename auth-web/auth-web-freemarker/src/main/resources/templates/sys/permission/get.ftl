<div class="modal fade" id="modal">
    <div class="modal-dialog modal-lg" id="getContainer">
        <div class="modal-content" id="getBody">
            <div class="modal-header">
                <h4 class="modal-title"><#if (permission?exists)>编辑<#else>新增</#if>角色</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <input type="hidden" name="id" id="id" value="${(permission.id)!}">
                    <div class="card-body">
                        <div class="form-permission row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" id="name" value="${(permission.name)!}">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="update()">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    function update() {
        $.post("update",$("form:eq(1)").serialize(), function(data) {
            $(".modal").modal('hide');
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            var node = zTree.getNodeByParam("id", $("#id").val(), null);
            if (node != null) {
                node.name = $("#name").val();
                zTree.updateNode(node);
            }
        }, "text");
    }
</script>