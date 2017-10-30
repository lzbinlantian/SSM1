var map={
	"phone":{
		regExp : /^(\.[a-zA-Z0-9_-]+)+|[1][3589][0-9]{9}$/,
		outputErrorText:"请输入正确的手机号！"
	},
	"userpwd":{
		regExp:/^\S*$/,
		outputErrorText:"密码不能为空！"
	}
}
$.fn.extend({
	checkInput:function(option){
		if(arguments.length == 0){
			var id=$(this).attr("id");
			var regExp = map[id].regExp;
			if($(this).val()==""||!regExp.test($(this).val())){
				$(".prompting p").append(map[id].outputErrorText);
				$(".prompting").attr("background-color","#ffebeb");
				$("#"+id).addClass("red");
				return false;
			}else{
				$("#"+id).removeClass("red");
				$(".prompting").attr("background-color","white");
				return true;
			}
			
		}
	}
	});