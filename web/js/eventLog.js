$(document).ready(function () {
    $('.form_datetime').datetimepicker({
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
        $('#eventlogTable').bootstrapTable({
            method: 'post',
            contentType: "application/x-www-form-urlencoded", //一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            url: contextPath + "/findAllLog", //要请求数据的文件路径
            dataField: "data", //这是返回的json数组的key.默认好像是"rows".这里只有前后端约定好就行
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination: true, //是否分页
            queryParams: queryParams, //请求服务器时所传的参数
            sidePagination: 'server', //指定服务器端分页client,server
            pageSize: 10, //单页记录数
            pageList: [10, 20, 50, 100], //分页步进值
//		search:true,
//		searchAlign:"left",
            responseHandler: responseHandler, //请求数据成功后，渲染表格前的方法
            uniqueId: "createtime", //标记唯一标识符，很重要
            columns: [{
                field: 'createtime',
                title: '日期',
                align: 'center'
            }, {
                field: 'phone',
                title: '账号',
                align: 'center'
            }, {
                field: 'record',
                title: '内容',
                align: 'center'
            }]

        });

        //请求服务数据时所传参数
        function queryParams(params) {
            return {
                pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
                pageIndex: params.offset / params.limit + 1//当前页面,默认是上面设置的1(pageNumber)
            }
        }

        //请求成功方法
        function responseHandler(result) {
            //如果没有错误则返回数据，渲染表格
            return {
                total: result.num, //总页数,前面的key必须为"total"
                data: result.logList//行数据，前面的key要与之前设置的dataField的值一致.
            };
        }
    //查询
    $("#eventlog_searchtext").change(function () {
        var searchdata = $(this).val();
        var opt = {
            url: contextPath + '/findLogByTime',
            silent: true,
            query: {
                createtime: searchdata
            }
        };
        if (searchdata == "") {
            $("#eventlogTable").bootstrapTable('refreshOptions', {url: contextPath + '/findAllLog'});
        } else {
            $("#eventlogTable").bootstrapTable('refresh',opt);
        }
    });
});


