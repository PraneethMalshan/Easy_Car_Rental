


// save Customer
$("#btnSignUp").click(function () {
    let formData = new FormData($("#newCusRegForm")[0]);
    $.ajax({
        url: baseUrl + "customer",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (rep) {
            alert(rep.message);

        },
        error: function (rep) {
            alert(rep.message);
        }
    })
})




























/*$("#btnSignUp").click(function () {
   let formData = $("#cusForm").serialize();

   $.ajax({
      url:baseUrl+"customer",
       method:"post",
       data:formData,
       dataType: "json",
       success:function (res) {
           //Invoked if the response status code is in 200 range
           console.log("Success Method Invoked");
           console.log(res);
           alert(res.message);
       },
       error:function (error) {
          console.log("Error Method Invoked");
          console.log(JSON.parse(error.responseText));
          alert(JSON.parse(error.responseText).message);
       }
   });
});*/


