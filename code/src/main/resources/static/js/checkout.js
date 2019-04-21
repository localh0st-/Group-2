$(document).ready(function () {
    var id = window.location.href.split("?").pop().split("=").pop();
    var movietitle = "test";
    $.ajax({
        url: 'http://localhost:8080/api/search?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            movietitle = data.title;
            $("#movieId").text(movietitle + " showtimes:");
        }
    });
    console.log(movietitle);

    $.ajax({
        url: 'http://localhost:8080/api/showtimes?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log('CheckOut returned', data);
            $.each(data, function (index,val) {
                $("#movieTime").append('<option value=' + val.start_time + '>' + val.start_time + '</option>');
                $("#theater").text(val.theater.name);
                $("#moviePrice").text('$' + val.);
            });


        }
    });
});


