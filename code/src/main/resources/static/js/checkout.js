$(document).ready(function () {
    var id = window.location.href.split("?").pop().split("=").pop();
    var movietitle = "test";
    $.ajax({
        url: 'http://localhost:8080/api/search?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            movietitle = data.title;
            $("#movietitle").text(movietitle + " showtimes:");
        }
    });
    console.log(movietitle);

    $('#movieTime').change(function(){
        var data = {};
        $('#movieTime option').each(function(i,el) {
            data[$(el).data("value")] = $(el).val();
        });
        var value = $('#movieTime').val();
        $('#movieprice').text('$' + $('#movieTime [value="' + value + '"]').data('value'));
    })

    $.ajax({
        url: 'http://localhost:8080/api/showtimes?id=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log('CheckOut returned', data);
            $.each(data, function (index,val) {
                $("#movieTime").append('<option value=' + val.start_time + ' data-value=' + val.theater.price +'>' + val.start_time + '</option>');
                $("#theater").text(val.theater.name);
            });


        }
    });


});


