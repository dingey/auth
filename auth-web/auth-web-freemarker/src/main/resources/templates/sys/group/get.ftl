<div class="modal fade" id="modal">
    <div class="modal-dialog modal-lg" id="getContainer">
        <div class="modal-content" id="getBody">
            <div class="modal-header">
                <h4 class="modal-title"><#if (group?exists)>编辑<#else>新增</#if>组织</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <input type="hidden" name="id" value="${(group.id)!}">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">*名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" value="${(group.name)!}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword3" class="col-sm-2 col-form-label">主管</label>
                        <div class="col-sm-4">
                            <select class="custom-select">
                                <option>option 1</option>
                                <option>option 2</option>
                            </select>
                        </div>
                        <label for="inputPassword3" class="col-sm-2 col-form-label">主管2</label>
                        <div class="col-sm-4">
                            <select class="custom-select">
                                <option>option 1</option>
                                <option>option 2</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="desc"></textarea>
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