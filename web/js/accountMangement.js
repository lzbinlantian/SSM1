$(document).ready(function () {

    //提示信息
    var notice1 = [],
        notice2 = [];
    notice1.push('<div class="alert alert-info" id="usernotice">你正在修改密码！</div>');
    notice2.push('<div class="alert alert-info" id="rolenotice">你正在修改权限！</div>');

    $('#userTable').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: contextPath + '/selectAll', //要请求数据的文件路径
        dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true, //是否分页
        queryParams: queryParams, //请求服务器时所传的参数
        sidePagination: 'server', //指定服务器端分页client,server
        pageSize: 10, //单页记录数
        pageList: [10, 20, 50, 100], //分页步进值
        responseHandler: responseHandler, //请求数据成功后，渲染表格前的方法
        uniqueId: "phone", //标记唯一标识符，很重要
        columns: [{
            checkbox: true
        },
            {
                field: 'phone',
                title: '手机号',
                align: 'center'
            }, {
                field: 'name',
                title: '昵称',
                align: 'center'
            }, {
                field: 'grant',
                title: '角色',
                align: 'center'
            },
            {
                field: 'changePassword',
                title: "修改密码",
                align: 'center',
                formatter: function (value, row, index) {
                    var a = ('<a data-toggle="modal" href="#changePasswordModal" onclick="changepassworddata(' + index + ',1);">修改密码</a>');
                    return a
                }
            },
            {
                field: 'changeRole',
                title: "修改权限",
                align: 'center',
                formatter: function (value, row, index) {
                    var r = '<a data-toggle="modal" href="#changeroleModal" onclick="changeroledata(' + index + ',2);">修改权限</a> ';
                    return r;
                }
            }
        ]
    })

    //请求服务数据时所传参数
    function queryParams(params) {
        return {
            pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
            pageIndex: params.offset / params.limit + 1,//当前页面,默认是上面设置的1(pageNumber)
        }
    }

    //请求成功方法
    function responseHandler(result) {
        //如果没有错误则返回数据，渲染表格
        return {
            total: result.countnum, //总页数,前面的key必须为"total"
            data: result.userList //行数据，前面的key要与之前设置的dataField的值一致.
        };
    }

    function getIdSelections() {
        return $.map($('#userTable').bootstrapTable('getSelections'), function (row) {
            return row.phone
        });
    }

    function getData() {
        return $.map($('#userTable').bootstrapTable('getData'), function (row) {
            return row
        });
    }

    //删除操作
    $("#remove").click(function () {

        var users = [];
        var ids = getIdSelections();
        if (ids.length == 0) {
            alert("请选择要删除的用户！");
        } else {
            for (var i = 0; i < (ids.length); i++) {
                users.push(ids[i]);
            }

            $.ajax({
                type: "post",
                url: contextPath + "/dropUser", //根据情况修改
                data: {"phoneList": users}, //按格式添加数据
                dataType: 'json',
                success: function (result) {
                    if (result.message == "删除成功") {
                        $("#userTable").bootstrapTable('remove', {
                            field: 'phone',
                            values: ids
                        });
                    } else if (result.message == "删除失败") {
                        window.alert("删除失败！请重新操作！");
                    } else {
                        window.alert("未知错误，请联系维护人员！");
                    }

                },
                error: function () {
                    window.alert("连接服务器失败！");
                }
            });
        }
    });
    //添加
    $('#add').click(function () {
        adddata();
    });
    $("#addphone").blur(function () {
        var regExp = /^(\\.[a-zA-Z0-9_-]+)+|[1][3589][0-9]{9}$/;
        if ($(this).val() == "" || !regExp.test($(this).val())) {
            $("#addnotice").attr("class", "alert alert-danger");
            $("#addnotice").text("请输入正确的密码!");
            $('#add').attr("disabled", true);
        } else {
            $("#addnotice").attr("class", "alert alert-info");
            $("#addnotice").text("你正在添加用户信息!");
            $('#add').attr("disabled", false);
        }
    });

    function adddata() {
        var userdata = $("#addphone").val();
        var passworddata = $("#addpassword").val();
        var name = $("#addname").val();
        var roledata = $("#addgrant").val();
        var adddata = {phone: userdata, name: name, password: passworddata, grant: roledata};
        var regExp = /^(\\.[a-zA-Z0-9_-]+)+|[1][3589][0-9]{9}$/;
        if (userdata == "" || !regExp.test(userdata)) {
            $("#addnotice").attr("class", "alert alert-danger");
            $("#addnotice").text("请输入正确的密码!");
            $('#add').attr("disabled", true);
        } else if (passworddata == "" || name == "") {
            $("#addnotice").attr("class", "alert alert-danger");
            $("#addnotice").text("昵称和密码不能为空!");
        } else {
            $("#addnotice").attr("class", "alert alert-info");
            $("#addnotice").text("你正在添加用户信息!");
            $('#add').attr("disabled", false);
            $.ajax({
                type: "post",
                url: contextPath + "/createUser",
                data: adddata,
                dataType: 'json',
                success: function (result) {
                    if (result.message == "添加成功") {

                        $("#addphone").val("");
                        $("#addname").val("");
                        $("#addpassword").val("");
                        $("#userTable").bootstrapTable('refreshOptions', {url: contextPath + '/selectAll'});
                        $('#addUserModal').modal('hide');
                    } else if (result.message == "添加重复") {
                        $("#addphone").val("");
                        $("#addname").val("");
                        $("#addpassword").val("");
                        $("#addnotice").attr("class", "alert alert-danger");
                        $("#addnotice").text("添加重复");

                    } else {
                        window.alert("未知错误，请联系维护人员！");
                        $('#addUserModal').modal('hide');
                    }

                },
                error: function () {
                    window.alert("连接服务器失败!");
                    $('#addUserModal').modal('hide');
                }
            });
        }
    }

//修改
    window.changepassworddata = function (index) {
        var user = $("tr[data-index=" + index + "]").attr("data-uniqueid")
        $("#user").val(user);
        $(".usernotice").empty();
        $(".usernotice").append(notice1.join(''));
    }
    window.changeroledata = function (index) {
        var user = $("tr[data-index=" + index + "]").attr("data-uniqueid")
        $("#user").val(user);
        $(".rolenotice").empty();
        $(".rolenotice").append(notice2.join(''));
    }
    //修改密码
    $("#confirmchangepassword").click(function () {

        var username = $("#user").val();
        var password1 = $("#password1").val();
        var password2 = $("#password2").val();
        if (password1 == "" || password2 == "") {
            $("#usernotice").attr("class", "alert alert-warning");
            $("#usernotice").text("密码不能为空!");
        } else {
            if (password1 === password2) {
                var changepassworddata = {phone: username, password: password1};
                $.ajax({
                    type: "post",
                    url: contextPath + '/updatePassword',
                    data: changepassworddata,
                    dataType: 'json',
                    success: function (result) {
                        if (result.message == "修改成功") {
                            $("#user").val("");
                            $("#password1").val("");
                            $("#password2").val("");
                            $('#changePasswordModal').modal('hide');
                        } else if (result.message == "修改失败") {
                            $("#password1").val("");
                            $("#password2").val("");
                            $("#usernotice").text("修改失败！请重新操作！");
                        } else {
                            window.alert("未知错误，请联系维护人员！");
                            $('#changePasswordModal').modal('hide');
                        }
                    },
                    error: function () {
                        $("#user").val("");
                        $("#password1").val("");
                        $("#password2").val("");
                        $('#changePasswordModal').modal('hide');
                        window.alert("出现错误，未修改");
                    }

                });
            } else {
                $("#usernotice").attr("class", "alert alert-warning");
                $("#usernotice").text("两次的密码不相同!");
            }
        }
    });
    //修改权限
    $("#confirmchangerole").click(function () {
        var role = $("#changerole").val();
        var username = $("#user").val();
        var changeroledata = {phone: username, grant: role};
        $.ajax({
            type: "post",
            url: contextPath + '/grant',
            data: changeroledata,
            dataType: 'json',
            success: function (result) {
                if (result.message == "授权成功") {
                    $("#user").val("");
                    $('#userTable').bootstrapTable('refreshOptions', {url: contextPath + "/selectAll"});
                    $('#changeroleModal').modal('hide');
                } else if (result.message == "授权失败") {
                    $("#rolenotice").text("修改失败！请重新操作！");

                } else {
                    window.alert("未知错误，请联系维护人员！");
                    $('#changeroleModal').modal('hide');
                }
            },
            error: function () {
                $("#user").val("");
                $('#changeroleModal').modal('hide');
                window.alert("出现错误，未修改");
            }

        });
    });
    //搜索
    $("#search select").change(function () {
        var searchdata = $(this).val();
        var opt = {
            url: contextPath + '/findUserByGrant',
            silent: true,
            query: {
                grant: searchdata
            }
        };
        if (searchdata == "根据权限搜索") {
            $("#userTable").bootstrapTable('refreshOptions', {url: contextPath + '/selectAll'});
        } else {
            $("#userTable").bootstrapTable('refresh', opt);
        }
    });
});