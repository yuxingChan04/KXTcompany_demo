 
// banner pc轮播图
jQuery(".slideBox1").slide({mainCell:".bd ul",titCell:".hd ul",autoPage:true,autoPlay:true,easing:"easeOutCirc"});
// banner phone轮播图
TouchSlide({ 
    slideCell:"#focus",
    titCell:".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
    mainCell:".bd ul", 
    effect:"left", 
    autoPlay:true,//自动播放
    autoPage:true, //自动分页
    switchLoad:"_src" //切换加载，真实图片路径为"_src" 
});
// 新闻切换
jQuery(".slideTxtBox").slide({mainCell:".bd"});
// 新闻图片切换
jQuery(".slideImgBox").slide({mainCell:".bd ul"});


