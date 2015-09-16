$(function(){
	$('.class_selection ul li').bind('click',function(){
			var $this = $(this);
 			$this.addClass('focus').siblings().removeClass('focus');
 	});

 	$('.good_img img').bind({
 		'mouseleave':function(){
	 		var $this = $(this);
	 		$this.addClass('imgdown').siblings().removeClass('imgdown');
 		}
 	})      
});