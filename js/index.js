$(function(){
	$('.first_class > ul > li').each(function(i){
		var $this = $(this);
		$this.bind('mouseover',i,function(){
			$('.section').eq(i).show().siblings('div').hide();
		})
	});

	$('.section').each(function(){
		var $this = $(this);
		$this.bind('mouseleave',function(){
			$(this).slideUp();
		})
	})
})