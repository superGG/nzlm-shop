$(function(){
	$('.first_class > ul > li').each(function(j){
		var $this = $(this);
		//console.log(this);
		$this.bind('mouseover',j,function(){
			$('.section').eq(j).show().siblings('div').hide();
			$(this).siblings("li").css("background-image","");
			$(this).css("background-image","url(img/gnb_banner_line.gif)");
		})
	});
	$(" .main_nav").bind("mouseleave",function(){
		$(" .section").each(function(){
			var $this = $(this);
			//console.log(this);
				$(this).slideUp();
		});
		$('.first_class > ul > li').each(function(j){
			var $this = $(this);
				$(this).css("background-image","");
			})
	});

	//$('.section').each(function(){
	//	var $this = $(this);
	//	console.log(this);
	//	$this.bind('mouseleave',function(){
	//		$(this).slideUp();
	//	})
	//})
})