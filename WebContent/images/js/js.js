$(function(){

	//--
	$('.navIco').click(function(){
		$('.navLayer').animate({right: "0",width:"100%"}, 500);
		$('.pageBg2').fadeIn(500);
		})
	$('.navLayer').find('.closeBtn').click(function(){
		$('.navLayer').animate({right: "-100%",width:0}, 500);
//		$('.subNav1').siblings(".navContent").slideUp(500);
		$('.subNav1').removeClass("currentDt");
		$('.pageBg2').fadeOut(500);
		})
	
	$(".subNav1").click(function(){
			$(this).next(".navContent").show();
			$(".subNav1").hide();
			$(".subNav2").hide();
	})

	$(".navContent").find('.back').click(function(){
			$(".navContent").hide();
			$(".subNav1").show();
			$(".subNav2").show();
	})
	$('.sideNav').find('li').each(function(i){
	if($(this).find('.list').length>0){
		$('.sideNav').find('li').eq(i).find('a:first').click(function(){
			if($(this).hasClass('aNow')){
					$(this).removeClass('aNow');
					$('.sideNav').find('li').eq(i).find('.list').slideUp(300);
				}else{
					$('.sideNav').find('a').removeClass('aNow');
					$('.sideNav').find('.list').slideUp(500);
					$(this).addClass('aNow');
					$('.sideNav').find('li').eq(i).find('.list').slideToggle(300);
					}
			})
		}
	})
	
});	





