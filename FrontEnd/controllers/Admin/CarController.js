let baseUrl="http://localhost:8081/easycarrental/"


/*Save Car*/
$("#btnSaveCar").click(function () {
   let formData = $("#carForm").serialize();

   $.ajax({
       url:baseUrl+"car",
       method:"post",
       data:formData,
       dataType: "json",
       success:function (res) {
           //Invoked if the response status code is in 200 range
           console.log("Success Method Invoked");
           console.log(res);
           alert(res.message);
           // getAllCars();
       },
       error:function (error) {
           //Invokes if status code range is 500 range or 400 range
           console.log("Error Method Invoked");
           console.log(JSON.parse(error.responseText));
           alert(JSON.parse(error.responseText).message);
       }
   });

});



