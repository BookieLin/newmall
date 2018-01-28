function updateAttitude() {
    if($("#attitude").attr("class")=="fa fa-circle text-red") {
        $("#attitude").attr("class", "fa fa-circle text-green");
        $("#zaixian").html("<i id=\"attitude\" class=\"fa fa-circle text-green\"></i> 在线");
    }
}
