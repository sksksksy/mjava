function RequestSend(method,data,url) {
    console.log(method);
    $.ajax({
        url:url,
        type:method,
        data:data,
        success: function f(data) {
            alert(data);
        },
        error: function f(data) {
            alert("error");
        }
    });
}