var ajaxConfirm = function () {

    var handle = function (json,str) {
        var data = (json.substring(1,json.length-1)).split(",");
        for (var k = 0; k < data.length; k++) {
            var entry = data[k].split(":");
            var key = entry[0];
            var value = entry[1];
            for (var i = 0; i < str.length; i++) {
                $("#" + key.split("\"")[1]).parent().next().remove();
                if (key == str[i]) {
                    $("#" + key.split("\"")[1]).parent().parent().attr("class", "form-group has-error");
                    $("#" + key.split("\"")[1]).parent().parent().append("<label class=\"col-sm-4 control-label\" >" + value.split("\"")[1] + "</label>");
                    break;
                }
            }
        }
    }

    return {

        handleJson: function (form,json) {
            var str=new Array();
            $.each($("#"+form).find("input"),function(index,value){
                param=value.name;
                if(param!="" && param!="id") {
                    str.push("\"" + param + "\"");
                }
            });
            var css="form-group has-success";
            var flag=true;

            if(json != null) {
                if(json == "" || json=="add_success") {
                    css = "form-group";
                    flag = false;
                }
            }
            for (var i = 0; i < str.length; i++) {
                $("#" + str[i].split("\"")[1]).parent().parent().attr("class", css);
                $("#" + str[i].split("\"")[1]).parent().next().remove();
            }

            if(flag){
                handle(json,str);
            }
        }
    }

}
