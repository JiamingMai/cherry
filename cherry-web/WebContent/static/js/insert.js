$(document).ready(function(){
    $("#submitButton").click(function () {
        $.ajax({
            type: "POST",
            url: "/coordinator/insert",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(GetJsonData()),
            dataType: "json",
            success: function (message) {
                alert("提交数据成功！");
            },
            error: function (message) {
                alert("提交数据失败！");
            }
        });
    });
});

function GetJsonData() {
    var json = {
        "rdfsText": $("#rdfsText").val()
    };
    return json;
}