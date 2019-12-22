var func = function () {
    var $file = $("input[name='file']").val();//用户文件内容(文件)
    // 判断文件是否为空
    if ($file == "") {
        alert("Please choose your file! ")
        return false;
    }
    //判断文件类型
    var fileName = $file.substring($file.lastIndexOf(".") + 1).toLowerCase();
    if(fileName != "owl" && fileName !="rdf"){
        alert("Please choose *.owl or *.rdf file!");
        return false;
    }
    //判断文件大小
    var size = $("input[name='file']")[0].files[0].size;
    if (size > 104857600) {
        alert("Your file cannot be larger than 100MB!");
        return false;
    }

    boo1 = true;
    var type = "file";
    var formData = new FormData();//这里需要实例化一个FormData来进行文件上传
    formData.append(type, $("#file")[0].files[0]);
    $.ajax({
        type : "post",
        url : "/coordinator/store",
        data : formData,
        processData : false,
        contentType : false,
        success : function(data){
            if (data=="error") {
                alert("Fail to submit the file!");
            }else{
                alert("File submitted!");
            }}
    });
}

$(document).ready(function(){
    $("#submitButton").click(func);
});