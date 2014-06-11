function callback(args) {
	if(args.status == "begin") {
	    showLoader();
    }
	
	if(args.status == "success") {
		hideLoader();
	}
}


function showLoader() {
	$("body").append($("<div id=\"loader\" />").css({
	      "opacity":0,
	      "height":$(window).height()+"px"
	}));
	$("#loader").animate({"opacity":.6},300);
}


function hideLoader() {
	$("#loader").remove();
}