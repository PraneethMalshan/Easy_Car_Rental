// let baseUrl="http://localhost:8081/easycarrental/"

$("#btnLogIn").click(function () {
    let formData = $("#LoginForm").serialize();
    let formDataObject = {};

    $.each(formData.split('&'), function(index, field) {
        var fieldArray = field.split('=');
        formDataObject[fieldArray[0]] = fieldArray[1];
    });

    $.ajax({
        url: baseUrl + "login",
        method: "post",
        data: formData,
        dataType: "json",
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});


/*
#btnLogIn
#LoginForm*/
