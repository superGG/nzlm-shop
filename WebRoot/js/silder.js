// $(function(){
// 	var ool = $('#wrap ol li');
// 	var nowX = 0;
// 	var index;
// 	var oul = $('#wrap ul');
// 	ool.bind('click',function(){
// 		index = $(this).index();
// 		// alert(index);
// 		if(index === 0){
// 			index = -1;
// 		}else if(index === 1){
// 			index = 1;
// 		}


// 		if(!((nowX === 0 || nowX ===5)&& index === -1) && !(nowX === 4 && index === 1)){
// 			nowX = nowX + index;
// 			oul.animate({'left':-nowX*100 + '%'},500);
// 		}

// 		console.log(nowX);
// 	});

// 	function silder(){
// 		if(nowX==4){
// 			oul.find(':first').css({
// 					'position': 'relative',
// 					'left':'300%'
// 			});
// 		}

// 		oul.animate({'left':-nowX*100 + '%'},1000,function(){
// 			console.log(nowX);
// 			if(nowX>4){
// 				oul.find(':first').css({
// 					'position': 'static',
// 				});
// 				oul.css('left',0);
// 				nowX = 0;
// 			}
// 		});

// 		nowX++;

// 	};

// 	timeId = setInterval(silder,3000);

// 	// $('#wrap').bind({
// 	// 	'mouseover':function(){clearInterval(timeId)},
// 	// 	'mouseout':function(){timeId = setInterval(silder,1500)}
// 	// });
// });


(function($){

	$.fn.silder = function(options){

		var defaults = {
			nowIndex : 0,
			timeId : 0,
			me : null,
			flag: false
		};


		var options = $.extend(defaults,options);

		var startShow = function(){

			console.log(defaults.nowIndex);
			defaults.nowIndex++;
			var $this = $(this);

			$this.animate({'left':-defaults.nowIndex*100 + '%'},1000,function(){

				if(defaults.nowIndex === defaults.imgNum){

					$this.css({
						'left': '0'
					});

					defaults.nowIndex = 0;
				}
			});
		}
		
		var me = this;

		defaults.timeId = setInterval(function(){
			startShow.call(me.find('ul'));
		},3000);

		me.find('ol li').each(function(i){
			$(this).bind('click',function(){

				var myUl = me.find('ul');

				if(i === 0 && defaults.nowIndex !== 0){

					defaults.nowIndex--;
					myUl.animate({'left':-defaults.nowIndex*100 + '%'});
				}else if(i === 1 ){

					console.log(defaults.nowIndex);
					defaults.nowIndex++;

					if(defaults.nowIndex === defaults.imgNum){
						defaults.nowIndex = 0;
					}
					myUl.stop().animate({'left':-defaults.nowIndex*100 + '%'});
				}
			})
		}); 

		me.find('ol li').bind({
			'mouseover':function(){
				clearInterval(defaults.timeId);
			},
			'mouseleave':function(){
				defaults.timeId = setInterval(function(){
					startShow.call(me.find('ul'));
				},3000);
			}
		})
	}

})(jQuery);

$('#wrap').silder({imgNum:4});