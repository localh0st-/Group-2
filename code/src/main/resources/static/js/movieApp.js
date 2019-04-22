$(document).ready(function () {
    var id = window.location.href.split("?").pop().split("=").pop();
    $.ajax({
        url: 'http://localhost:8080/api/search?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // alert('<button type="button" href="/checkout?id=' + id + '" class="btn btn-primary  align-bottom">Get Ticket</button>');
            $('#result').empty();
            console.log('search returned', data);
            $(".title").text(data.title);
            $(".genre").text(data.genre);
            $(".year").text(data.year);
            $(".movieimage").append('<img src="img/movies/' + data.imageUrl + '.jpg" style="height: 454px;width: 345px;position: absolute">');
            $(".rating").text(data.rating);
            $(".showtimes").text(data.showtimes);
            $("#trailerIframe").attr("src", data.trailerUrl);
            $(".MovieTicket").append('<a type="button" href="/checkout?id=' + id + '" class="btn btn-primary  align-bottom">Get Ticket</a>');
        }
    });
});
