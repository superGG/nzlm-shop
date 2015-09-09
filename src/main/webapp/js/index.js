$(function(){
	$('.first_class > ul > li').each(function(j){
		var $this = $(this);
		$this.bind('mouseover',j,function(){
			$('.section').eq(j).show().siblings('div').hide();
		})
	});

	$('.section').each(function(){
		var $this = $(this);
		$this.bind('mouseleave',function(){
			$(this).slideUp();
		})
	})
})

