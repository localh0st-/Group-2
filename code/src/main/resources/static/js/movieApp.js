$(document).ready(function () {
    var id= window.location.href.split("?").pop().split("=").pop();
    $.ajax({
        url: 'http://localhost:8080/api/search?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // alert('<button type="button" href="/checkout?id=' + id + '" class="btn btn-primary  align-bottom">Get Ticket</button>');
            $('#result').empty();
            console.log('search returned', data);
            $(".title").text(data.title);
            $(".year").text(data.year);
            $(".image").text(data.imageURL);
            $(".rating").text(data.rating);
            $(".genre").text(data.genre);

            $(".showtimes").text(data.showtimes);
            $("#trailerIframe").attr("src",data.trailerUrl);
            $(".MovieTicket").append('<a type="button" href="/checkout?id=' + id + '" class="btn btn-primary  align-bottom">Get Ticket</a>');
        }
    });


    //This is an example of how to access the showtimes api, modify as needed. It is very much needed.

    $.ajax({
        url: 'http://localhost:8080/api/showtimes?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log('CheckOut returned', data);
            $.each(data, function (index,val) {
                $("#movieTime").append('<option value=' + val.start_time + '>' + val.start_time + '</option>');
                $("#theater").text(val.theater.name);
                $("#moviePrice").text('$' + val.theater.price);
            });


        }
    });
});
