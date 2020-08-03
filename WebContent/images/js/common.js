var menuHover="";
$(function(){
	
	initUI();
	initListener();
});

function initUI(){
	$(".bread_text").find("a:last").addClass("red");
	$(".submenu").find("dl:first").css("border","none");
	$(".recruit-list li:first").find("em").removeClass("arrow-down").addClass("arrow-up");
	$(".recruit-list li:first").find(".recruit-content").show();

	var menuLists = $(".mainlevel>a");
	var navText = $(".nav-title>h2").text();
	$.each(menuLists,function(i,v){

		if(this.innerText==navText){
			$(this).addClass("selected");
		}
	});

}


// 导航
function initListener(){
	
	$(".mainlevel").hover(function(){
		var $submenu=$(this).find(".submenu");
		menuHover=setTimeout(function(){
			$submenu.slideDown(300);
		},300);
	},function(){
		var $submenu=$(this).find(".submenu");
		clearTimeout(menuHover);
		$submenu.slideUp(100);
	})

	$(".flex").off("click").on("click",function(){
		var $this = $(this);
		$this.toggleClass("plus");
		$this.parent().next().slideToggle(100);
	});

	$(".recruit-title").off("click").on("click",function(){
		var $this = $(this);
		var $thisEm = $this.find("em");
		if($thisEm.hasClass("arrow-up")){
			return;
		}
		if($thisEm.hasClass("arrow-down")){
			$thisEm.removeClass("arrow-down").addClass("arrow-up");
		}
		$this.next().slideDown(200);
		var $siblings =$this.parent().siblings();
		$siblings.find(".recruit-content").slideUp(200);
		$siblings.find("em").removeClass("arrow-down").removeClass("arrow-up").addClass("arrow-down");

	});

	$(".search-close").off("click").on("click",function(){

		$(".search-true-false").animate({right:"-160px"},150,function(){
			$(".anti-btn").show().animate({right:0},150);
		});
	});

	$(".anti-btn").off("click").on("click",function(){

		$(this).animate({right:"-50px"},150,function(){
			$(".search-true-false").animate({right:"10px"},150);
		});
	});
	
	
}
