$(document).ready(function () {
    doneTypingInterval = 500;
    var typingTimer;
    var timeout = null;

    $('#searchMovie').keyup(function () {
        clearTimeout(typingTimer);
        typingTimer = setTimeout(searchMovie, doneTypingInterval);
        timeout = setTimeout(function () {
        }, 500);

    });

    $('#searchBM').click(function(){
        searchMovie();
    })
});

function searchMovie(){
    var search = $('#searchMovie').val();
    if ($.trim(search) === "") {
        console.log('Search is empty');
        // $('#result').html('<h1>enter a movie name</h1>');
        $('#searchresults').empty();
    } else {
        console.log('User searched', search);
        $.ajax({
            url: 'http://localhost:8080/api/search?title=' + search,
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                $('#searchresults').empty();
                console.log('search returned', data);
                let i=0;
                $.each(data, function (index, val) {
                    if(i<10) {
                        i++;
                        $('#searchresults').append('<option "/movie?id=' + val.id + '">' + val.title + '</option>');
                    }
                });
            }
        });
    }
}