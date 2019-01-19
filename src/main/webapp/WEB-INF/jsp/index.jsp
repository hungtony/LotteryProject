<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<input type="text" id="inputName">
<button type="button" id="query">查詢</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    $("#query").click(function () {
        $.get({
            url: "http://localhost:8090/user/getUserByAccount",
            method: "GET",
            data: {
                account: $("#query").val()
            },
            success: function (result) {
                alert(result.name + "～你好啊！")
            }
        })
    })
</script>
</body>
</html>
