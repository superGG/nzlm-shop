
$(function () {

    console.log(window.location.href.substr(window.location.href.lastIndexOf("?")+1));
    tmptype3 = window.location.href.substr(window.location.href.lastIndexOf("?")+1);

    var attributename = tmptype3.substr(tmptype3.lastIndexOf("=")+1);
    var attributevalue = tmptype3.substr(0,tmptype3.lastIndexOf("="));
    console.log(attributename);
    console.log(attributevalue);

    var goodslist_htmlobj = $.ajax({url: "queryKeyWord.txt", async: false});

    var attributes_htmlobj = $.ajax({url: "getAttribute.txt", async: false});
    //var attributes_htmlobj = $.ajax({url: "http://localhost:8080/shoppingsolr2/goods_getAttrbutes.action?goodstype3="+tmptype3, async: false});

    var attributes = eval('(' + attributes_htmlobj.responseText + ")");

    var keyWordGoods = eval(goodslist_htmlobj.responseText);

    var postModel = [];

    postModel.push({ name : attributename, value : attributevalue});

    $.each(categories, function (i, data) {

        $.each(data.type2, function (i, data2) {

            $(".main .container .class_selection_container .class_selection ul").append(
                $("<li></li>").append(
                    $("<a></a>").attr("href", "javascript:;").html(data2.name).on("click", function () {
                        console.log(data2.name);
                    })));

            $.each(data2.type3, function (i, data3) {

                $(".main .container .class_selection_container .class_selection ol").append(
                    $("<li></li>").append(
                        $("<a></a>").attr("href", "javascript:;").html(data3)).on("click", function () {
                            console.log(data3);
                            goodslist_htmlobj = $.ajax({url: "queryKeyWord2.txt", async: false});
                            keyWordGoods = eval(goodslist_htmlobj.responseText);
                            $(".main .container .goods_list .goods_show ul").empty();
                            //console.log(keyWordGoods);
                            $.each(keyWordGoods, function (i, data) {
                                var goods = $("<li></li>").append(
                                    $("<div class='good_img'></div>").append(
                                        $("<img />").attr("src", "img/Q5423EFZ41_CGR0_N01.JPG"))).append(
                                    $("<a class='name'></a>").attr("href", data.goodspic).html(data.goodsname)).append(
                                    $("<span class='price'></span>").text(data.goodsprice)).append(
                                    $("<em></em>").append($("<img />").attr("src", "img/icon_cart.png/")).html("1000"));
                                $(".goods_show > ul").append(goods);
                            });
                        }));
            });
        });
    });

    $.each(attributes, function (keyname, data) {
        var myul = $("<ul></ul>");
        $.each(data, function (i, data2) {
            myul.append($("<li></li>").html(data2).on('click', function () {
                if ($(this).hasClass("press")) {
                    $(this).removeAttr("class");
                } else {
                    $(this).siblings().removeAttr("class");
                    $(this).attr("class", "press");

                }

                $(".classification_attr .press").parent().siblings().each(function (i, data2) {
                    var mydata = $(data2).html() + '_' + $(data2).siblings().find(".press").html();
                    postModel.push({ name : 'goodsAtributes', value : mydata});
                });
                //console.log(postModel);
                $.post('queryKeyWord.txt',postModel,function(data){
                    console.log(eval(data));
                    keyWordGoods = eval(data);
                    $(".main .container .goods_list .goods_show ul").empty();
                    $.each(keyWordGoods, function (i, data) {
                        var goods = $("<li></li>").append(
                            $("<div class='good_img'></div>").append(
                                $("<img />").attr("src", "img/Q5423EFZ41_CGR0_N01.JPG"))).append(
                            $("<a class='name'></a>").attr("href", data.goodspic).html(data.goodsname)).append(
                            $("<span class='price'></span>").text(data.goodsprice)).append(
                            $("<em></em>").append($("<img />").attr("src", "img/icon_cart.png/")).html("1000"));
                        $(".goods_show > ul").append(goods);
                    });
                });
            }));
        });

        $(".classification").append(
            $("<div></div>").attr("class", "classification_attr").append(
                $("<div></div>").attr("class", "attrname").html(keyname)).append(
                myul));
        //$(".classification")

    });

    $.each(keyWordGoods, function (i, data) {
        var goods = $("<li></li>").append(
            $("<div class='good_img'></div>").append(
                $("<img />").attr("src", "img/Q5423EFZ41_CGR0_N01.JPG"))).append(
            $("<a class='name'></a>").attr("href", data.goodspic).html(data.goodsname)).append(
            $("<span class='price'></span>").text(data.goodsprice)).append(
            $("<em></em>").append($("<img />").attr("src", "img/icon_cart.png/")).html("1000"));
        $(".goods_show > ul").append(goods);
    });

    $('.class_selection ul li').bind('click', function () {
        var $this = $(this);
        $this.addClass('focus').siblings().removeClass('focus');
    });

    $('.good_img img').bind({
        'mouseleave': function () {
            var $this = $(this);
            $this.addClass('imgdown').siblings().removeClass('imgdown');
        }
    })
});