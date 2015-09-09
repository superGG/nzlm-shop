$(function(){
	var ool = $('#wrap ol li');
	var nowX = 0;
	var index;
	var oul = $('#wrap ul');
	ool.bind('click',function(){
		index = $(this).index();
		// alert(index);
		if(index === 0){
			index = -1;
		}else if(index === 1){
			index = 1;
		}


		if(!((nowX === 0 || nowX ===5)&& index === -1) && !(nowX === 4 && index === 1)){
			nowX = nowX + index;
			oul.animate({'left':-nowX*100 + '%'},500);
		}

		console.log(nowX);
	});

	function silder(){
		if(nowX==4){
			oul.find(':first').css({
					'position': 'relative',
					'left':'300%'
			});
		}

		oul.animate({'left':-nowX*100 + '%'},1000,function(){
			console.log(nowX);
			if(nowX>4){
				oul.find(':first').css({
					'position': 'static',
				});
				oul.css('left',0);
				nowX = 0;
			}
		});

		nowX++;

	};

	timeId = setInterval(silder,3000);

	// $('#wrap').bind({
	// 	'mouseover':function(){clearInterval(timeId)},
	// 	'mouseout':function(){timeId = setInterval(silder,1500)}
	// });
});