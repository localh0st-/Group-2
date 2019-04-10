$(document).ready(function () {
    var id= window.location.href.split("?").pop().split("=").pop();
    $.ajax({
        url: 'http://localhost:8080/api/search?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#result').empty();
            console.log('search returned', data);
            $(".title").text(data.title);
            $("#trailerIframe").attr("src",data.trailerUrl);
        }
    });
});
