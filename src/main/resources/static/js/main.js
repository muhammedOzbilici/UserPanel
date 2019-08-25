$(document).ready(function () {
    $('.createUserBtn, .table .updateUserBtn').on('click', function (event) {
            event.preventDefault();
            var href = $(this).attr('href');
            var text = $(this).text();
            if (text == 'Güncelle') {
                $.get(href, function (user, status) {
                    $('.myForm #id').val(user.id);
                    $('.myForm #name').val(user.name);
                    $('.myForm #surname').val(user.surname);
                    $('.myForm #phone').val(user.phone);
                    $('.myForm #exampleModal').modal();
                })

            } else {
                $('.myForm #id').val(randomNumber(10));
                $('.myForm #name').val('');
                $('.myForm #surname').val('');
                $('.myForm #phone').val('');
                $('.myForm #exampleModal').modal();
            }
        }
    );
    $('.table .deleteUserBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();

    });
});
function randomNumber(len) {
    var randomNumber;
    var n = '';

    for(var count = 0; count < len; count++) {
        randomNumber = Math.floor(Math.random() * 10);
        n += randomNumber.toString();
    }
    return new Date().valueOf();;
}
