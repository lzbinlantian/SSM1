$(document).ready(function () {
    'use strict';

    (function () {
        var $image = $('.img-container > img'),
            options = {
                aspectRatio: NaN,
                rotatable:false
            };

        $image.on({
            'build.cropper': function (e) {
                console.log(e.type);
            },
            'built.cropper': function (e) {
                console.log(e.type);
            },
            'dragstart.cropper': function (e) {
                console.log(e.type, e.dragType);
            },
            'dragmove.cropper': function (e) {
                console.log(e.type, e.dragType);
            },
            'dragend.cropper': function (e) {
                console.log(e.type, e.dragType);
            },
            'zoomin.cropper': function (e) {
                console.log(e.type);
            },
            'zoomout.cropper': function (e) {
                console.log(e.type);
            }
        }).cropper(options);


        // Methods
        $(document.body).on('click', '[data-method]', function () {
            var data = $(this).data(),
                $target,
                result;

            if (data.method) {
                data = $.extend({}, data); // Clone a new one

                if (typeof data.target !== 'undefined') {
                    $target = $(data.target);

                    if (typeof data.option === 'undefined') {
                        try {
                            data.option = JSON.parse($target.val());
                        } catch (e) {
                            console.log(e.message);
                        }
                    }
                }
                result = $image.cropper(data.method, data.option);

                if (data.method === 'getCroppedCanvas') {
                    var dataURL = result.toDataURL();
                    $(".img-container img").attr("src",dataURL);
                    document.getElementById('GetData').click();
                    document.getElementById('destroy').click();
                    $("#getCroppedCanvas").attr("disabled", true);
                    $("#quotation").attr("disabled", false);
                }

                if ($.isPlainObject(result) && $target) {
                    try {
                        $target.val(JSON.stringify(result));
                    } catch (e) {
                        console.log(e.message);
                    }
                }

            }
        }).on('keydown', function (e) {

            switch (e.which) {
                case 37:
                    e.preventDefault();
                    $image.cropper('move', -1, 0);
                    break;

                case 38:
                    e.preventDefault();
                    $image.cropper('move', 0, -1);
                    break;

                case 39:
                    e.preventDefault();
                    $image.cropper('move', 1, 0);
                    break;

                case 40:
                    e.preventDefault();
                    $image.cropper('move', 0, 1);
                    break;
            }

        });
        $('[data-toggle="tooltip"]').tooltip();
        // Import image
        var $inputImage = $('#inputImage'),
            URL = window.URL || window.webkitURL,
            blobURL;

        if (URL) {
            $inputImage.change(function () {
                var files = this.files,
                    file;

                if (files && files.length) {
                    file = files[0];

                    if (/^image\/\w+$/.test(file.type)) {
                        blobURL = URL.createObjectURL(file);
                        $image.one('built.cropper', function () {
                            URL.revokeObjectURL(blobURL); // Revoke when load complete
                            $("#getCroppedCanvas").attr("disabled", false);
                        }).cropper('reset', true).cropper('replace', blobURL);
                        window.formdata = new FormData($('#quotaform')[0]);
                        $inputImage.val('');
                    } else {
                        showMessage('Please choose an image file.');
                    }
                }
            });
        } else {
            $inputImage.parent().remove();
        }

    }());

    function changeImgSize(src) {

        var image = new Image();
        image.src = src;
        image.onload = function () {
            var getContainer = document.getElementById('return-image');
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

    //报价单 count
    window.ids = ["shell", "Pan", "resin", "PMMA", "Lantern", "Lantern", "labor"];
    var idsq = ["字壳", "底壳", "树脂", "亚克力", "灯带", "灯板", "人工"];
    window.datar = {records: []};
    for (var i = 0; i < idsq.length; i++) {
        $.ajax({
            async: false,
            type: "post",
            url: contextPath + "/main/findMateriel",
            data: {sort: idsq[i]},
            dataType: "json",
            success: function (result) {
                var data = {"data": result.detailMaterielList};
                if (data.data[0].sort == "灯带") {
                    for (var key in data.data) {
                        var options = ('<option value="灯带' + data.data[key].name + '">' + data.data[key].name + '</option>');
                        $("#" + ids[i] + " td").eq(1).find("select").append(options);
                    }
                } else if (data.data[0].sort == "灯板") {
                    for (var key in data.data) {
                        var options = ('<option value="灯板' + data.data[key].name + '">' + data.data[key].name + '</option>');
                        $("#" + ids[i] + " td").eq(1).find("select").append(options);

                    }
                } else {
                    for (var key in data.data) {
                        var options = ('<option value="' + data.data[key].name + '">' + data.data[key].name + '</option>');
                        $("#" + ids[i] + " td").eq(1).find("select").append(options);
                    }
                }

                datar.records.push(data);

            },
            error: function () {
                alert("请求错误！");
            }
        });
        if (datar.records.length == 7) {
            initialization();
        }
    }

    function initialization() {
        var shellvalue = $("#shell td").eq(1).find("select").val();
        selectchange("shell", shellvalue);
        var Panvalue = $("#Pan td").eq(1).find("select").val();
        selectchange("Pan", Panvalue);
        var resinvalue = $("#resin td").eq(1).find("select").val();
        selectchange("resin", resinvalue);
        var PMMAvalue = $("#PMMA td").eq(1).find("select").val();
        selectchange("PMMA", PMMAvalue);
        var Lanternvalue = $("#Lantern td").eq(1).find("select").val();
        Lachange("Lantern", Lanternvalue);
        var laborvalue = $("#labor td").eq(1).find("select").val();
        Lachange("labor", laborvalue);


    }


    //选择材料
    $("#shell td").eq(1).find("select").change(function () {
        var checkvalue = ($(this).val());
        selectchange("shell", checkvalue);
    });
    $("#Pan td").eq(1).find("select").change(function () {
        var checkvalue = ($(this).val());
        selectchange("Pan", checkvalue);
    });
    $("#resin td").eq(1).find("select").change(function () {
        var checkvalue = ($(this).val());
        selectchange("resin", checkvalue);
    });
    $("#PMMA td").eq(1).find("select").change(function () {
        var checkvalue = ($(this).val());
        selectchange("PMMA", checkvalue);
    });

    $("#Lantern td").eq(1).find("select").change(function () {
        var sd=document.getElementById("lanternname")
        var opindex = sd.selectedIndex;
        var checkvalue =sd.options[opindex].value;
        Lachange("Lantern", checkvalue);
    });
    $("#labor td").eq(1).find("select").change(function () {
        var checkvalue = ($(this).val());
        Lachange("labor", checkvalue);
    });

    function selectchange(id, checkvalue) {
        if (id == "shell") {
            var datalist = datar.records[0].data;
        } else if (id == "Pan") {
            var datalist = datar.records[1].data;
        } else if (id == "resin") {
            var datalist = datar.records[2].data;
        } else if (id == "PMMA") {
            var datalist = datar.records[3].data;
        } else {
            selectchange(id, checkvalue);
        }
        for (var d in datalist) {
            if (datalist[d].name == checkvalue) {
                $("#" + id + " td").eq(2).find("p span").text(datalist[d].density);
                $("#" + id + " td").eq(3).find("p span").text(datalist[d].size);
                if (datalist[d].chargeunit=="1"){
                    $("#" + id + " td").eq(5).find("p span").eq(0).text(datalist[d].unitprice);
                    $("#" + id + " td").eq(5).find("p span").eq(1).text("元/m");
                    $("#" + id + " td").eq(5).find("p sup").text("2");
                }else if(datalist[d].chargeunit=="0"){
                    $("#" + id + " td").eq(5).find("p span").eq(0).text(datalist[d].unitprice);
                    $("#" + id + " td").eq(5).find("p span").eq(1).text("元/kg");
                }

                $("#" + id + " input[name='chargeunit']").attr("value",datalist[d].chargeunit);
            }
        }

    }

    function Lachange(id, checkvalue) {
        if (id == "Lantern") {
            var lesort=checkvalue.substring(0,2);
            var lename=checkvalue.substring(2);
            if(lesort=="灯带"){
                var datalist = datar.records[4].data;
                for (var d in datalist) {
                    if (datalist[d].name == lename) {
                        $("#" + id + " td").eq(5).find("p span").eq(0).text(datalist[d].unitprice);
                        $("#" + id + " td").eq(5).find("p span").eq(1).text("元/m");
                        $("#lanternsort").attr("value", "灯带");
                        $("#power td").eq(1).find("p span").text("0");
                        $("#" + id + " input[name='chargeunit']").attr("value","1");
                    }
                }
            }else if(lesort=="灯板"){
                var datalist = datar.records[5].data;
                for (var d1 in datalist) {
                    if (datalist[d1].name == lename) {
                        $("#power td").eq(1).find("p span").text(datalist[d1].density);
                        $("#lanternsort").attr("value", "灯板");
                        $("#" + id + " td").eq(5).find("p span").eq(0).text(datalist[d1].unitprice);
                        $("#" + id + " td").eq(5).find("p span").eq(1).text("元/套");
                        $("#" + id + " input[name='chargeunit']").attr("value","0");
                    }
                }
            }
        } else if (id == "labor") {
            var datalist = datar.records[6].data;
            for (var d in datalist) {
                if (datalist[d].name == checkvalue) {
                    $("#" + id + " td").eq(5).find("p span").text(datalist[d].density);
                }
            }
        }

    }

    $("#quotation").click(function () {

        var cropperdata=$("#putData").val();
        formdata.append("cropperdata",cropperdata);
        var Luminoush = $("#Luminoush").val();
        var Customername = $("#Customername").val();
        var HTK = $("#HTK").val();
        formdata.append("Luminoush", Luminoush);
        formdata.append("Customername", Customername);
        formdata.append("HTK", HTK);
        var shellsort = $("#shell td").eq(0).find("p span").text();
        var shellname = $("#shell td").eq(1).find("select").val();
        var shelldensity = $("#shell td").eq(2).find("p span").text();
        var shellsize = $("#shell td").eq(3).find("p span").text();
        var shellunitprice = $("#shell td").eq(5).find("p span").eq(0).text();
        var shellchargeunit=$("#shell input[name='chargeunit']").attr("value");

        var shell = {
            sort: shellsort,
            name: shellname,
            density: shelldensity,
            size: shellsize,
            unitprice: shellunitprice,
            chargeunit:shellchargeunit
        }
        var Pansort = $("#Pan td").eq(0).find("p span").text();
        var Panname = $("#Pan td").eq(1).find("select").val();
        var Pandensity = $("#Pan td").eq(2).find("p span").text();
        var Pansize = $("#Pan td").eq(3).find("p span").text();
        var Panunitprice = $("#Pan td").eq(5).find("p span").eq(0).text();
        var Panchargeunit=$("#Pan input[name='chargeunit']").attr("value");

        var Pan = {
            sort: Pansort,
            name: Panname,
            density: Pandensity,
            size: Pansize,
            unitprice: Panunitprice,
            chargeunit:Panchargeunit
        }
        var resinsort = $("#resin td").eq(0).find("p span").text();
        var resinname = $("#resin td").eq(1).find("select").val();
        var resindensity = $("#resin td").eq(2).find("p span").text();
        var resinsize = $("#resin td").eq(3).find("p span").text();
        var resinunitprice = $("#resin td").eq(5).find("p span").eq(0).text();
        var resinchargeunit=$("#resin input[name='chargeunit']").attr("value");

        var resin = {
            sort: resinsort,
            name: resinname,
            density: resindensity,
            size: resinsize,
            unitprice: resinunitprice,
            chargeunit:resinchargeunit
        }
        var PMMAsort = $("#PMMA td").eq(0).find("p span").text();
        var PMMAname = $("#PMMA td").eq(1).find("select").val();
        var PMMAdensity = $("#PMMA td").eq(2).find("p span").text();
        var PMMAsize = $("#PMMA td").eq(3).find("p span").text();
        var PMMAunitprice = $("#PMMA td").eq(5).find("p span").eq(0).text();
        var PMMAchargeunit=$("#PMMA input[name='chargeunit']").attr("value");
        var PMMA = {
            sort: PMMAsort,
            name: PMMAname,
            density: PMMAdensity,
            size: PMMAsize,
            unitprice: PMMAunitprice,
            chargeunit:PMMAchargeunit
        }
        var Lanternsort = $("#lanternsort").attr("value");
        var Lanternname1 = $("#Lantern td").eq(1).find("select").val();
        var Lanternname=Lanternname1.substring(2);
        var power =$("#power td").eq(1).find("p span").text();
        var Lanternunitprice = $("#Lantern td").eq(5).find("p span").eq(0).text();
        var Lanternchargeunit=$("#Lantern input[name='chargeunit']").attr("value");
        var Lantern = {
            sort: Lanternsort,
            name: Lanternname,
            density:power,
            unitprice: Lanternunitprice,
            chargeunit:Lanternchargeunit
        }
        var laborsort = $("#labor td").eq(0).find("p span").text();
        var laborname = $("#labor td").eq(1).find("select").val();
        var laborunitprice = $("#Pan td").eq(5).find("p span").eq(0).text();
        var labor = {
            sort: laborsort,
            name: laborname,
            unitprice: laborunitprice
        }
        //JSON.stringify
        var datas = [];
        datas.push(shell);
        datas.push(Pan);
        datas.push(resin);
        datas.push(PMMA);
        datas.push(Lantern);
        datas.push(labor);
        formdata.append("datas",JSON.stringify(datas));
        $.ajax({
            url: contextPath + "/main/createDetailOrder",
            type: 'POST',
            cache: false,
            data: formdata,
            processData: false,
            contentType: false,
            success: function (result) {
                loadingdata(result.detailOrder);
                var img="http://localhost:8080/lantian/InOutputpic/"+result.uuid+"result.jpg";
                $("#return-image img").attr("src",img);
                changeImgSize(img);
                $(".total-t span").text(result.order.count);
            }, error: function () {
                alert("请求错误！")
            }
        })
    });

    function loadingdata(data) {

        $("#shell td").eq(4).find("p span").text(data.zikes);
        $("#shell td").eq(6).find("p span").text(data.zikep);

        $("#Pan td").eq(4).find("p span").text(data.dikes);
        $("#Pan td").eq(6).find("p span").text(data.dikep);


        $("#resin td").eq(4).find("p span").text(data.shuzhis);
        $("#resin td").eq(6).find("p span").text(data.shuzhip);

        $("#PMMA td").eq(4).find("p span").text(data.yakelis);
        $("#PMMA td").eq(6).find("p span").text(data.yakelip);

        $("#Lantern td").eq(6).find("p span").text(data.dengzongjia);

        $("#power td").eq(1).find("p span").text(data.dianyuanzonggonglv);
        $("#power td").eq(6).find("p span").text(data.dianyuanzongjia);

        $("#labor td").eq(6).find("p span").text(data.rengongzongjia);

    }
});