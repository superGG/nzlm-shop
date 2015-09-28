$(function(){
	var focusFlag = false;

	var index_htmlobj=$.ajax({url:"categories.txt",async:false});
//	var index_htmlobj = $.ajax({url:"http://localhost:8080/shoppingsolr2/goods_getCategory.action",async:false});
	window.categories = eval(index_htmlobj.responseText);

	$.each(categories,function(i,data) {
		var type1 = $("<li></li>");
		type1.text(data.name);
		$('.first_class > ul').append(type1).append("<div class='bd'></div>");
		var mytype1 = $("<div class='section'><div class='title_bg'> <div class='title'><img src='img/gnb_banner_line.gif' alt=''> <ul> </ul> </div> </div> <div class='other_class'> <div class='other_bg'> <img src='img/GNB_BANNER_DST_150807.jpg' alt=''> </div> </div> </div>");
		mytype1.attr("id","wrapper"+$(".show_class > div").length);
		$(".show_class").append(mytype1);
		$.each(data.type2,function(k,data2){

			var type2 = $("<li></li>");
				type2.text(data2.name);
				type2.on("click",function(){
					window.location.href ="goodslist.html?goodstype2 = " + data2.name;
				});
			$('.show_class .title ul').eq(i).append(type2);
			$(".other_class > div").eq(i).append("<ul></ul>");
			$.each(data2.type3,function(u,data3){
				var type3 = $("<li></li>");
				type3.text(data3);
				type3.on("click",function(){
					window.location.href ="goodslist.html?goodstype3 = " + data3;
				});
				$(".other_class").eq(i).find("div ul").eq(k).append(type3);
			});
		});
	});

	$('.first_class > ul> li ').each(function(j,n) {
		//console.log(j);
		var $this = $(this);

		$this.bind('mouseover', j, function () {
			if (focusFlag) {
				//console.log(focusFlag);
				$('.section').eq(j).show().siblings('div').hide();
			} else {
				$('.section').eq(j).slideDown(100);
				focusFlag = true;
			}

			$this.siblings("li").css("background-image", "");
			$this.css("background-image", "url(img/gnb_banner_line.gif)");
		})
	});

	$(" .main_nav").bind("mouseleave",function(){
		$(" .section").each(function(){
			var $this = $(this);
			//console.log(this);
			$(this).slideUp(100);
			focusFlag = false;
		});
		$('.first_class > ul > li').each(function(j){
			var $this = $(this);
				$(this).css("background-image","");
			})
	});

	$('.section').each(function(){
		var $this = $(this);
		$this.bind('mouseleave',function(){
			$(this).slideUp(100);
			focusFlag = false;
		})
	})
	//$('.section').each(function(){
	//	var $this = $(this);
	//	console.log(this);
	//	$this.bind('mouseleave',function(){
	//		$(this).slideUp();
	//	})
	//})
})