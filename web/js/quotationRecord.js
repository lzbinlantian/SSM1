$(document).ready(function () {
    $('.quotationRecord_search_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 0,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 3,
        forceParse: 0,
        minView:2,
        endDate : new Date()
    });
    $('#recordTable').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: contextPath + "/findAllOrder", //要请求数据的文件路径
        dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true, //是否分页
        queryParams: queryParams, //请求服务器时所传的参数
        sidePagination: 'server', //指定服务器端分页client,server
        pageSize: 10, //单页记录数
        pageList: [10, 20, 50, 100], //分页步进值
        responseHandler: responseHandler, //请求数据成功后，渲染表格前的方法
        uniqueId: "uuid", //标记唯一标识符，很重要
        columns: [{
            field: 'uuid',
            title: '报价单号',
            align: 'center'
        }, {
            field: 'createtime',
            title: '日期',
            align: 'center'
        }, {
            field: 'customer',
            title: '客户名称',
            align: 'center'
        }, {
            field: 'count',
            title: '合计金额',
            align: 'center'
        }, {
            field: 'height',
            title: '高度',
            align: 'center',
            visible: false
        }, {
            field: 'phone',
            title: '账号',
            align: 'center'
        }, {
            field: 'operation',
            title: "操作",
            align: 'center',
            formatter: function (value, row, index) {
                var a = ('<a data-toggle="modal" href="#check" onclick="check(' + index + ');">查看明细</a>');
                return a
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
            total: result.count, //总页数,前面的key必须为"total"
            data: result.order //行数据，前面的key要与之前设置的dataField的值一致.
        };
    }

    //查看明细
    window.check = function (id) {
        $('#Checkthedetailsmodal').modal('show');
        $('#Checkthedetailsmodal').css("display", "block");
        var odd = $("tr[data-index=" + id + "]").attr("data-uniqueid");
        var odddata = {id: odd};
        $.ajax({
            type: "post",
            url: contextPath + "/findDetailOrderById",
            data: odddata,
            dataType: 'json',
            success: function (result) {
                var data=result.detailOrder;
                $("#historyinput-image img").attr("src", "http://localhost:8080/lantian/InOutputpic/" + data.uuid + "input.jpg");
                $("#historyreturn-image img").attr("src", "http://localhost:8080/lantian/InOutputpic/" + data.uuid + "result.jpg");
                changeinputImgSize("http://localhost:8080/lantian/InOutputpic/" + data.uuid + "input.jpg");
                changereturnImgSize("http://localhost:8080/lantian/InOutputpic/" + data.uuid + "result.jpg");
                $("#historyLuminoush").val(result.order.height);
                $("#historyHTK").val(result.order.size);
                $("#historyCustomername").val(result.order.customer);
                $(".total-t span").text(result.order.count);
                loadingdata(data);


            },
            error: function () {
                alert("出现错误！")
            }
        });
    }

    function loadingdata(data) {
        $("#historyshell td").eq(1).find("p span").text(data.zikename);
        $("#historyshell td").eq(2).find("p span").text(data.zikemidu);
        $("#historyshell td").eq(3).find("p span").text(data.zikehoudu);
        $("#historyshell td").eq(4).find("p span").text(data.zikes);
        $("#historyshell td").eq(5).find("p span").text(data.zikedanjia);
        $("#historyshell td").eq(6).find("p span").text(data.zikep);

        $("#historyPan td").eq(1).find("p span").text(data.dikename);
        $("#historyPan td").eq(2).find("p span").text(data.dikemidu);
        $("#historyPan td").eq(3).find("p span").text(data.dikehoudu);
        $("#historyPan td").eq(4).find("p span").text(data.dikes);
        $("#historyPan td").eq(5).find("p span").text(data.dikedanjia);
        $("#historyPan td").eq(6).find("p span").text(data.dikep);

        $("#historyresin td").eq(1).find("p span").text(data.shuzhiname);
        $("#historyresin td").eq(2).find("p span").text(data.shuzhimidu);
        $("#historyresin td").eq(3).find("p span").text(data.shuzhihoudu);
        $("#historyresin td").eq(4).find("p span").text(data.shuzhis);
        $("#historyresin td").eq(5).find("p span").text(data.shuzhidanjia);
        $("#historyresin td").eq(6).find("p span").text(data.shuzhip);

        $("#historyPMMA td").eq(1).find("p span").text(data.yakeliname);
        $("#historyPMMA td").eq(2).find("p span").text(data.yakelidanjia);
        $("#historyPMMA td").eq(3).find("p span").text(data.yakelimidu);
        $("#historyPMMA td").eq(4).find("p span").text(data.yakelis);
        $("#historyPMMA td").eq(5).find("p span").text(data.yakelidanjia);
        $("#historyPMMA td").eq(6).find("p span").text(data.yakelip);

        $("#historyLantern td").eq(1).find("p span").text(data.dengname);
        $("#historyLantern td").eq(5).find("p span").text(data.dengdanjia);
        $("#historyLantern td").eq(6).find("p span").text(data.dengzongjia);

        $("#historypower td").eq(1).find("p span").text(data.dianyuanzonggonglv);
        $("#historypower td").eq(6).find("p span").text(data.dianyuanzongjia);

        $("#historylabor td").eq(1).find("p span").text(data.rengongname);
        $("#historylabor td").eq(6).find("p span").text(data.rengongzongjia);
        $("#historylabor td").eq(5).find("p span").text(data.rengongzhanbi);

    }

    function changereturnImgSize(src) {
        var image = new Image();
        image.src = src;
        image.onload = function () {
            var getContainer = document.getElementById("historyreturn-image");
            var getIMG = getContainer.getElementsByTagName('img')[0];
            var fw = getContainer.offsetWidth - (2 * getContainer.clientLeft);
            var fh = getContainer.offsetHeight - (2 * getContainer.clientTop);
            var iw = image.width;
            var ih = image.height;
            var m = iw / fw;
            var n = ih / fh;
            if (m >= 1 && n <= 1) {
                iw = Math.ceil(iw / m);
                ih = Math.ceil(ih / m);
                getIMG.width = iw;
                getIMG.height = ih;
            } else if (m <= 1 && n >= 1) {
                iw = Math.ceil(iw / n);
                ih = Math.ceil(ih / n);
                getIMG.width = iw;
                getIMG.height = ih;
            } else if (m >= 1 && n >= 1) {
                var getMAX = Math.max(m, n);
                iw = Math.ceil(iw / getMAX);
                ih = Math.ceil(ih / getMAX);
                getIMG.width = iw;
                getIMG.height = ih;
            }
            if (getIMG.height < fh) {
                var getDistance = Math.floor((fh - getIMG.height) / 2);
                getIMG.style.marginTop = getDistance.toString() + "px";
            }
        }
    }
    function changeinputImgSize(src) {
        var image = new Image();
        image.src = src;
        image.onload = function () {
            var getContainer = document.getElementById("historyinput-image");
            var getIMG = getContainer.getElementsByTagName('img')[0];
            var fw = getContainer.offsetWidth - (2 * getContainer.clientLeft);
            var fh = getContainer.offsetHeight - (2 * getContainer.clientTop);
            var iw = image.width;
            var ih = image.height;
            var m = iw / fw;
            var n = ih / fh;
            if (m >= 1 && n <= 1) {
                iw = Math.ceil(iw / m);
                ih = Math.ceil(ih / m);
                getIMG.width = iw;
                getIMG.height = ih;
            } else if (m <= 1 && n >= 1) {
                iw = Math.ceil(iw / n);
                ih = Math.ceil(ih / n);
                getIMG.width = iw;
                getIMG.height = ih;
            } else if (m >= 1 && n >= 1) {
                var getMAX = Math.max(m, n);
                iw = Math.ceil(iw / getMAX);
                ih = Math.ceil(ih / getMAX);
                getIMG.width = iw;
                getIMG.height = ih;
            }
            if (getIMG.height < fh) {
                var getDistance = Math.floor((fh - getIMG.height) / 2);
                getIMG.style.marginTop = getDistance.toString() + "px";
            }
        }
    }
    //查询
$("#quotationRecord_searchtext").change(function () {
        var searchdata = $(this).val();
        var opt = {
            url: contextPath + '/findOrderByTime',
            silent: true,
            query: {
                createtime: searchdata
            }
        };
        if (searchdata == "") {
            $("#recordTable").bootstrapTable('refreshOptions', {url: contextPath + '/findAllOrder'});
        } else {
            $("#recordTable").bootstrapTable('refresh',opt);
        }
});
});