let baseUrl="http://localhost:8081/easycarrental/"

const sign_in_btn = document.querySelector("#sign-in-btn");
const login = document.querySelector("#btnLogin");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");




sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});



login.addEventListener("click", () =>{

    let userType = $("#userType1").val();

    if (userType==='admin'){
        //  Admin logic
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();
        $.ajax({
            url:baseUrl + "admin/check?username="+username+"&password="+password,
            method:"post",
            data: "",
            dataType: "",
            success: function (res) {
                document.getElementById("adminDash").click();

                alert(res.message);
            },
            error: function (error) {
                alert(res.message);
            }
        });
    } else if (userType === 'customer') {
        //  Customer
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();

        $.ajax({
           url: baseUrl + "customer/check?username="+username+"&password="+password,
            method: "post",
            data: "",
            dataType: "",
            success: function (res) {

                document.getElementById("CustomerDash").click();

                alert(res.message);
            },
            error: function (error) {
                alert(res.message);
            }
        });

    } else if (userType === 'driver') {
        let username = $('input[type="text"]').val();
        let password = $('input[type="password"]').val();

        $.ajax({
           url: baseUrl + "driver/check?username="+username+"&password="+password,
            method: "post",
            data: "",
            dataType: "",
            success: function (res) {
               document.getElementById("driverDash").click();

                alert(res.message);

            },
            error: function (error) {
                alert(res.message);
            }
        });
    }
});


