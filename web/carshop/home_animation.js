/**
 * Created by Scalman on 27/09/16.
 */

jQuery(document).ready(function($) {

    var winHeight = $(window).height(),
        slideDownPage = $('.slide-down-page'),
        content = $('.content'),
        animSpeed = 1000;

    slideDownPage.css({
        height: winHeight + 'px',
        top: -winHeight + 'px'
    });

    $("#open").click(function(){
        slideDownPage.animate({'top': 0}, animSpeed);
        content.animate({'margin-top': winHeight},animSpeed);
    });

    $("#close").click(function(){

    });

    $(document).on('scroll', function(){
        if($(this).scrollTop() > slideDownPage.height() && slideDownPage.css('top') === '0px'){
            slideDownPage.css('top',-winHeight + 'px');
            content.css('margin-top',0);
        }
    });
});

