$(document).ready(function () {
    var id= window.location.href.split("?").pop().split("=").pop();
    console.log(id);
    $.ajax({
        url: 'http://localhost:8080/api/theater?movieid=' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#resultCheckout').empty();
            console.log('CheckOut returned', data);
            $(".name").text(data.id);
           $(".startTime").text(data.startTime);
            $(".price").text(data.price);
            $(".theater").text(data.name);
            $.each(data, function (name) {
                $('#resultCheckout').find('#movieSelect').append('<br><select><option href="/movie?id=' +id + '"><h1>' + ' theater:' + name + '</h1>' + '</option></select>');
            });


        }
    });
});


