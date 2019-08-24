$(document).ready(function () {
    $('.createUserBtn, .table .updateUserBtn').on('click', function (event) {
            event.preventDefault();
            var href = $(this).attr('href');
            var text = $(this).text();
            if (text == 'Güncelle') {
                $.get(href, function (user, status) {
                    $('.myForm #name').val(user.name);
                    $('.myForm #surname').val(user.surname);
                    $('.myForm #phone').val(user.phone);

                })
                $('.myForm #exampleModal').modal();
            } else {
                $('.myForm #name').val('');
                $('.myForm #surname').val('');
                $('.myForm #phone').val('');
                $('.myForm #exampleModal').modal();
            }
        }
    )

})