window.onload = function () {
    //普通材料的tabel
    $('#materialDetail').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: contextPath + "/findDetailMateriel", //要请求数据的文件路径
        dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true, //是否分页
        queryParams: queryParams, //请求服务器时所传的参数
        sidePagination: 'server', //指定服务器端分页client,server
        pageSize: 10, //单页记录数
        pageList: [10, 20, 50, 100], //分页步进值
        responseHandler: responseHandler, //请求数据成功后，渲染表格前的方法
        uniqueId: "detail_Materiel_Id", //标记唯一标识符，很重要
        columns: [{
            checkbox: true
        }, {
            field: 'detail_Materiel_Id',
            title: '物料号',
            align: 'center',
            formatter: function (value, row, index) {
                var value1 = value.toString(),
                    value2;
                switch (value1.length) {
                    case 1:
                        value2 = "000" + value1;
                        break;
                    case 2:
                        value2 = "00" + value1;
                        break;
                    case 3:
                        value2 = "0" + value1;
                        break;
                    case 4:
                        value2 = value1;
                        break;
                }
                return value2
            }
        }, {
            field: 'name',
            title: '材料名称',
            align: 'center'
        }, {
            field: 'density',
            title: '材料密度',
            align: 'center'
        }, {
            field: 'size',
            title: '厚度',
            align: 'center'
        }, {
            field: 'chargeunit',
            title: '计价单位',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == '1') {
                    return "元/平方米"
                } else if (value == '0') {
                    return "元/公斤"
                }
            }
        }, {
            field: 'unitprice',
            title: '单价',
            align: 'center'
        },
            {
                field: 'operation',
                title: "操作",
                align: 'center',
                formatter: function (value, row, index) {
                    var a = ('<a data-toggle="modal" href="#change" onclick="changedata(' + index + ');">修改</a>');
                    return a
                }
            }
        ]
    })
    //灯的table
    $('#LanternDetail').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: contextPath + "/findDetailMateriel", //要请求数据的文件路径
        dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true, //是否分页
        queryParams: queryParams2, //请求服务器时所传的参数
        sidePagination: 'server', //指定服务器端分页client,server
        pageSize: 10, //单页记录数
        pageList: [10, 20, 50, 100], //分页步进值
        responseHandler: responseHandler2, //请求数据成功后，渲染表格前的方法
        uniqueId: "detail_Materiel_Id", //标记唯一标识符，很重要
        columns: [{
            checkbox: true
        }, {
            field: 'detail_Materiel_Id',
            title: '灯号',
            align: 'center',
            formatter: function (value, row, index) {
                var value1 = value.toString(),
                    value2;
                switch (value1.length) {
                    case 1:
                        value2 = "000" + value1;
                        break;
                    case 2:
                        value2 = "00" + value1;
                        break;
                    case 3:
                        value2 = "0" + value1;
                        break;
                    case 4:
                        value2 = value1;
                        break;
                }
                return value2
            }
        }, {
            field: 'sort',
            title: '类型',
            align: 'center'
        }, {
            field: 'name',
            title: '名称',
            align: 'center'
        }, {
            field: 'chargeunit',
            title: '计价单位',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == '2') {
                    return "元/米"
                } else if (value == '3') {
                    return "元/套"
                }
            }
        }, {
            field: 'unitprice',
            title: '单价  ',
            align: 'center'
        }, {
            field: 'density',
            title: '总功率',
            align: 'center'
        }, {
            field: 'operation',
            title: "操作",
            align: 'center',
            formatter: function (value, row, index) {
                var a = ('<a data-toggle="modal" href="#change" onclick="changeLanterndata(' + index + ');">修改</a>');
                return a
            }
        }
        ]
    })
    //人工的table
    $('#laborDetail').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: contextPath + "/findDetailMateriel",//要请求数据的文件路径
        dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true, //是否分页
        queryParams: queryParams1, //请求服务器时所传的参数
        sidePagination: 'server', //指定服务器端分页client,server
        pageSize: 10, //单页记录数
        pageList: [10, 20, 50, 100], //分页步进值
        responseHandler: responseHandler1, //请求数据成功后，渲染表格前的方法
        uniqueId: "detail_Materiel_Id", //标记唯一标识符，很重要
        columns: [{
            checkbox: true
        }, {
            field: 'detail_Materiel_Id',
            title: '工号',
            align: 'center',
            formatter: function (value, row, index) {
                var value1 = value.toString(),
                    value2;
                switch (value1.length) {
                    case 1:
                        value2 = "000" + value1;
                        break;
                    case 2:
                        value2 = "00" + value1;
                        break;
                    case 3:
                        value2 = "0" + value1;
                        break;
                    case 4:
                        value2 = value1;
                        break;
                }
                return value2
            }
        }, {
            field: 'name',
            title: '名称',
            align: 'center'
        }, {
            field: 'density',
            title: '占比',
            align: 'center',
            formatter: function (value, row, index) {
                var value = value + "%";
                return value
            }
        }, {
            field: 'operation',
            title: "操作",
            align: 'center',
            formatter: function (value, row, index) {
                var a = ('<a data-toggle="modal" href="#change" onclick="changelabordata(' + index + ');">修改</a>');
                return a
            }
        }
        ]
    })

    //请求服务数据时所传参数
    function queryParams(params) {
        return {
            pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
            pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
            sort: $("#sort").val() //类别
        }
    }

    //请求成功方法
    function responseHandler(result) {
        return {
            total: result.count, //总页数,前面的key必须为"total"
            data: result.detailMaterielList //行数据，前面的key要与之前设置的dataField的值一致.
        }
    }

    //请求服务数据时所传参数
    function queryParams1(params) {
        return {
            pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
            pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
            sort: "人工"//类别
        }
    }

    //请求成功方法
    function responseHandler1(result) {
        //如果没有错误则返回数据，渲染表格
        return {
            total: result.count, //总页数,前面的key必须为"total"
            data: result.detailMaterielList //行数据，前面的key要与之前设置的dataField的值一致.
        }
    }

    //请求服务数据时所传参数
    function queryParams2(params) {
        return {
            pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
            pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
            sort: "灯"//类别
        }
    }

    //请求成功方法
    function responseHandler2(result) {
        //如果没有错误则返回数据，渲染表格
        return {
            total: result.count, //总页数,前面的key必须为"total"
            data: result.detailMaterielList //行数据，前面的key要与之前设置的dataField的值一致.
        }
    }

//获取detail_Materiel_Id
    function getIdSelections() {
        var sort = $("#sort").val();
        if (sort == "灯") {
            return $.map($('#LanternDetail').bootstrapTable('getSelections'), function (row) {
                return row.detail_Materiel_Id
            });
        } else if (sort == "人工") {
            return $.map($('#laborDetail').bootstrapTable('getSelections'), function (row) {
                return row.detail_Materiel_Id
            });
        } else {
            return $.map($('#materialDetail').bootstrapTable('getSelections'), function (row) {
                return row.detail_Materiel_Id
            });
        }


    }

    window.changesort = function (thisid) {
        $("#sort").val(thisid.innerText);
        var thistext = thisid.innerText;

        $(".td-s").removeClass("td-s");
        $(thisid).addClass("td-s");
        if (thistext == "灯") {
            $(".material-table-b2").css("display", "block");
            $(".material-table-b1").css("display", "none");
            $(".material-table-b3").css("display", "none");
            $('#LanternDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
        } else if (thistext == "人工") {
            $(".material-table-b3").css("display", "block");
            $(".material-table-b2").css("display", "none");
            $(".material-table-b1").css("display", "none");
            $('#laborDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
        } else {
            $(".material-table-b1").css("display", "block");
            $(".material-table-b2").css("display", "none");
            $(".material-table-b3").css("display", "none");
            $('#materialDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
        }
    }
    //查询按钮事件
//
//	$('#searchbutton').click(function() {
//		var searchtext = $("#searchtext").val();
//		if(searchtext == "") {
//			alert("搜索框不能为空！");
//		} else {
//			$('#materialDetail').bootstrapTable('refresh', { url: '' }, { query: { searchtext: searchtext } });
//		}
//	})
    //添加
    $("#addmaterials").click(function () {
        var sort = $("#sort").val();
        $(".sort select").val(sort);
        addinitialization(sort);
    });

    $(".sort select").change(function () {
        addinitialization($(this).val());
    });

    //初始化
    function addinitialization(sort) {
        if (sort == "灯") {
            $(".addmaterialstable2").css("display", "block");
            $(".addmaterialstable1").css("display", "none");
            $(".addmaterialstable3").css("display", "none");
        } else if (sort == "人工") {
            $(".addmaterialstable3").css("display", "block");
            $(".addmaterialstable2").css("display", "none");
            $(".addmaterialstable1").css("display", "none");
        } else {
            $(".addmaterialstable1").css("display", "block");
            $(".addmaterialstable2").css("display", "none");
            $(".addmaterialstable3").css("display", "none");
        }
    }

    $("#addmaterial").click(function () {
        var sort1 = $(".sort select").val();
        if (sort1 == "灯") {
            addLantern();
        } else if (sort1 == "人工") {
            addlabor();
        } else {
            addmaterial();
        }
    })

//普通材料
    function addmaterial() {
        var materialsName1 = $("#materialsName").val();
        var materialsDensity1 = $("#materialsDensity").val();
        var size1 = $("#size").val();
        var chargeunit1 = $("#chargeunit").val();
        if (chargeunit1 == "元/平方米") {
            var chargeunit = "1";
        } else if (chargeunit1 == "元/公斤") {
            var chargeunit = "0";
        }
        var unitprice1 = $("#unitprice").val();
        var sort1 = $(".sort select").val();
        var unitprice = parseFloat(unitprice1);
        var adddata = {
            sort: sort1,
            name: materialsName1,
            density: materialsDensity1,
            size: size1,
            chargeunit: chargeunit,
            unitprice: unitprice
        }

        $.ajax({
            type: "post",
            url: contextPath + '/addMateriel',
            data: adddata,
            dataType: 'json',
            success: function (result) {
                $('#materialDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#addmaterialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#addmaterialsModal').modal('hide');
            }
        });
    }

//灯
    $("#addLantern select").change(function () {
        if ($(this).val() == "灯板") {
            $("#Lanternpower").attr("disabled", false);
            $("#Lanterntotalprice").attr("disabled", false);
            $("#Lanternchargeunit").val("元/套");
        } else if ($(this).val() == "灯带") {
            $("#Lanternpower").attr("disabled", true);
            $("#Lanternpower").val("0");
            $("#Lanternchargeunit").val("元/米");
        }
    })

    function addLantern() {
        var Lanternsort = $("#Lanternsort").val();
        var LanternName = $("#LanternName").val();
        var Lanternchargeunit1 = $("#Lanternchargeunit").val();
        if (Lanternchargeunit1 == "元/米") {
            var Lanternchargeunit = "2";
        } else if (Lanternchargeunit1 == "元/套") {
            var Lanternchargeunit = "3";
        }
        var Lanternunitprice1 = $("#Lanternunitprice").val();
        var Lanternunitprice = parseFloat(Lanternunitprice1);
        var Lanternpower = $("#Lanternpower").val();
        adddata = {
            sort: Lanternsort,
            name: LanternName,
            chargeunit: Lanternchargeunit,
            unitprice: Lanternunitprice,
            /*总功率*/
            density: Lanternpower
        };
        $.ajax({
            type: "post",
            url: contextPath + "/addMateriel",
            data: adddata,
            dataType: 'json',
            success: function (result) {
                $('#LanternDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#addmaterialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#addmaterialsModal').modal('hide');
            }
        });
    }

    //人工
    function addlabor() {
        var sort1 = $(".sort select").val();
        var laborName = $("#laborName").val();
        var laborproportion = $("#laborproportion").val();
        adddata = {
            sort: sort1,
            name: laborName,
            density: laborproportion
        };
        $.ajax({
            type: "post",
            url: contextPath + "/addMateriel",
            data: adddata,
            dataType: 'json',
            success: function (result) {
                $('#laborDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#addmaterialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#addmaterialsModal').modal('hide');
            }
        });
    }

//删除
    $("#materialsremove").click(function () {
        var sort = $("#sort").val();
        var users = [];
        var ids = getIdSelections();
        if(ids.length==0){
            alert("请选择要删除的材料！");
        }else {
            for (var i = 0; i < (ids.length); i++) {
                users.push(ids[i]);
            }
            $.ajax({
                type: "post",
                url: contextPath + '/deleteMateriel', //根据情况修改
                data: {genre: sort, detail_Materiel_IdList: users}, //按格式添加数据
                dataType: 'json',
                success: function (result) {
                    if (result.message == "删除成功") {
                        $('#materialDetail').bootstrapTable('remove', {
                            field: 'detail_Materiel_Id',
                            values: ids
                        });
                        $('#laborDetail').bootstrapTable('remove', {
                            field: 'detail_Materiel_Id',
                            values: ids
                        });
                        $('#LanternDetail').bootstrapTable('remove', {
                            field: 'detail_Materiel_Id',
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
    //修改
    window.changedata = function (index) {
        $("#changematerialsModal").modal("show");
        $(".changematerialstable1").css("display", "block");
        $(".changematerialstable2").css("display", "none");
        $(".changematerialstable3").css("display", "none");
        var uuid = $("#materialDetail tbody tr[data-index=" + index + "]").attr("data-uniqueid");
        $("#uuid").val(uuid);
        var originalname = $("#materialDetail tbody tr[data-index=" + index + "] td").eq(2).text();
        var originalDensity = $("#materialDetail tbody tr[data-index=" + index + "] td").eq(3).text();
        var originalsize = $("#materialDetail tbody tr[data-index=" + index + "] td").eq(4).text();
        var originalchargeunit = $("#materialDetail tbody tr[data-index=" + index + "] td").eq(5).text();
        var originalunitprice = $("#materialDetail tbody tr[data-index=" + index + "] td").eq(6).text();
        $("#changematerialsName").val(originalname);
        $("#changematerialsDensity").val(originalDensity);
        $("#changesize").val(originalsize);
        $("#changechargeunit").val(originalchargeunit);
        $("#changeunitprice").val(originalunitprice);
    }
    window.changeLanterndata = function (index) {
        $("#changematerialsModal").modal("show");
        $(".changematerialstable2").css("display", "block");
        $(".changematerialstable1").css("display", "none");
        $(".changematerialstable3").css("display", "none");
        var uuid = $("#LanternDetail tbody tr[data-index=" + index + "]").attr("data-uniqueid");
        $("#uuid").val(uuid);
        var originalLanternsort = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(2).text();
        var originalName = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(3).text();
        var originalchargeunit = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(4).text();
        var originalunitprice = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(5).text();
        var originalpower = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(6).text();
        var originaltotalprice = $("#LanternDetail tbody tr[data-index=" + index + "] td").eq(7).text();
        $("#changeLanternsort").val(originalLanternsort);
        $("#changeLanternName").val(originalName);
        $("#changeLanternchargeunit").val(originalchargeunit);
        $("#changeLanternunitprice").val(originalunitprice);
        $("#changeLanternpower").val(originalpower);
        $("#changeLanterntotalprice").val(originaltotalprice);
        changeinitialization(originalLanternsort);
    }
    window.changelabordata = function (index) {
        $("#changematerialsModal").modal("show");
        $(".changematerialstable3").css("display", "block");
        $(".changematerialstable2").css("display", "none");
        $(".changematerialstable1").css("display", "none");
        var uuid = $("#laborDetail tbody tr[data-index=" + index + "]").attr("data-uniqueid");
        $("#uuid").val(uuid);
        var originalname = $("#laborDetail tbody tr[data-index=" + index + "] td").eq(2).text();
        var originalproportion = $("#laborDetail tbody tr[data-index=" + index + "] td").eq(3).text();
        $("#changelaborName").val(originalname);
        $("#changelaborproportion").val(originalproportion);
    }
    $("#changematerial").click(function () {
        var sort1 = $("#sort").val();
        if (sort1 == "灯") {
            changeLantern();
        } else if (sort1 == "人工") {
            changelabor();
        } else {
            changematerial();
        }
    });

    //普通材料
    function changematerial() {
        var uuid = $("#uuid").val();
        var changematerialsName = $("#changematerialsName").val();
        var changematerialsDensity = $("#changematerialsDensity").val();
        var changesize = $("#changesize").val();
        var changechargeunit1 = $("#changechargeunit").val();
        if (changechargeunit1 == "元/平方米") {
            var changechargeunit = "1";
        } else if (changechargeunit1 == "元/公斤") {
            var changechargeunit = "0";
        }
        var changeunitprice = $("#changeunitprice").val();

        var changedata = {
            detail_Materiel_Id: uuid,
            name: changematerialsName,
            density: changematerialsDensity,
            size: changesize,
            chargeunit: changechargeunit,
            unitprice: changeunitprice
        };
        $.ajax({
            type: "post",
            url: contextPath + '/updateMateriel',
            data: changedata,
            dataType: 'json',
            success: function (result) {
                $('#materialDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#changematerialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#changematerialsModal').modal('hide');
            }
        });
    }

    //灯
    $("#changeLantern select").change(function () {
        changeinitialization($(this).val());
    })

    function changeinitialization(lanternsort) {
        if (lanternsort == "灯板") {
            $("#changeLanternpower").attr("disabled", false);
            $("#changeLanternchargeunit").val("元/套");
        } else if (lanternsort == "灯带") {
            $("#changeLanternpower").attr("disabled", true);
            $("#changeLanternpower").val("0");
            $("#changeLanternchargeunit").val("元/米");
        }
    }

    function changeLantern() {
        var uuid = $("#uuid").val();
        var changeLanternsort = $("#changeLanternsort").val();
        var changeLanternName = $("#changeLanternName").val();
        var changeLanternchargeunit1 = $("#changeLanternchargeunit").val();
        if (changeLanternchargeunit1 == "元/米") {
            var changeLanternchargeunit = "2";
        } else if (changeLanternchargeunit1 == "元/套") {
            var changeLanternchargeunit = "3";
        }
        var changeLanternunitprice1 = $("#changeLanternunitprice").val();
        var changeLanternpower = $("#changeLanternpower").val();
        var changeLanternunitprice = parseFloat(changeLanternunitprice1);
        adddata = {
            detail_Materiel_Id: uuid,
            sort: changeLanternsort,
            name: changeLanternName,
            chargeunit: changeLanternchargeunit,
            unitprice: changeLanternunitprice,
            density: changeLanternpower
        };
        $.ajax({
            type: "post",
            url: contextPath + '/updateMateriel',
            data: adddata,
            dataType: 'json',
            success: function (result) {
                $('#LanternDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#changematerialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#changematerialsModal').modal('hide');
            }
        });
    }

    //人工
    function changelabor() {
        var uuid = $("#uuid").val();
        var changelaborName = $("#changelaborName").val();
        var changelaborproportion = $("#changelaborproportion").val();
        adddata = {
            detail_Materiel_Id: uuid,
            name: changelaborName,
            density: changelaborproportion
        };
        $.ajax({
            type: "post",
            url: contextPath + '/updateMateriel',
            data: adddata,
            dataType: 'json',
            success: function (result) {
                $('#laborDetail').bootstrapTable('refreshOptions', {url: contextPath + "/findDetailMateriel"});
                $('#changematerialsModal').modal('hide');
            },
            error: function () {
                window.alert("请求服务器错误");
                $('#changematerialsModal').modal('hide');
            }
        });
    }

    //查询
    $("#searchtext").bind('input propertychange', function () {
        var searchdata = $(this).val();
        var opt = {
            url: contextPath + '/findAllDetailMaterielByName',
            silent: true,
            query: {
                name: searchdata
            }
        };
        var thistext = $("#sort").val();
        if (thistext == "灯") {
            if (searchdata == "") {
                $("#LanternDetail").bootstrapTable('refreshOptions', {url: contextPath + '/findDetailMateriel'});
            } else {
                $("#LanternDetail").bootstrapTable('refresh', opt);
            }
        } else if (thistext == "人工") {
            if (searchdata == "") {
                $("#laborDetail").bootstrapTable('refreshOptions', {url: contextPath + '/findDetailMateriel'});
            } else {
                $("#laborDetail").bootstrapTable('refresh', opt);
            }

        } else {
            if (searchdata == "") {
                $("#materialDetail").bootstrapTable('refreshOptions', {url: contextPath + '/findDetailMateriel'});
            } else {
                $("#materialDetail").bootstrapTable('refresh', opt);
            }
        }

    });
};