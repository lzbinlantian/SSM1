$(document).ready(function() {
window.checkUser=function(){
	var caa=ca();
		if(caa){
			return true
		}else{
			return false
		}
	};
	function ca(){
		$(".prompting p").text("");
		var b=true;
		b = b && $("#phone").checkInput();
		b = b && $("#userpwd").checkInput();
		return b
	}
});