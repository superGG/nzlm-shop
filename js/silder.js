$(function(){
	// var ool = $('#wrap ol li');
	var now = 0;
	var index;
	var oul = $('#wrap ul');
	// ool.bind('click',function(){
	// 	$(this).addClass('curr').siblings().removeClass();
	// 	index = $(this).index();
	// 	// alert(index);
	// 	now = index;
	// 	oul.animate({'left':-index*500},1000);
	// });

	function silder(){
		if(now==4){
			oul.find(':first').css({
					'position': 'relative',
					'left':'300%'
			});
		}

		oul.animate({'left':-now*100 + '%'},1000,function(){
			console.log(now);
			if(now==5){
				oul.find(':first').css({
					'position': 'static',
				});
				oul.css('left',0);
				now = 0;
			}
		});

		now++;

	};

	timeId = setInterval(silder,3000);

	// $('#wrap').bind({
	// 	'mouseover':function(){clearInterval(timeId)},
	// 	'mouseout':function(){timeId = setInterval(silder,1500)}
	// });
});