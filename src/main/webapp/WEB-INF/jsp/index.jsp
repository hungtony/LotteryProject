<!DOCTYPE html>
<html>
<head>
    <meta name="charset" content="UTF8">
    <title></title>
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
                account: $("#inputName").val()
            },
            success: function (result) {
                alert(result.realName + "～你好啊！")
            }
        })
    })
</script>
</body>
</html>
