let baseUrl="http://localhost:8081/easycarrental/"


// getAllDrivers();

/*Add Drivers*/
$("#btnSaveDriver").click(function () {
    let formData = $("#driverForm").serialize();

    $.ajax({
        url:baseUrl+"driver",
        method:"post",
        data:formData,
        dataType: "json",
        success:function (res) {
            //Invoked if the response status code is in 200 range
            console.log("Success Method Invoked");
            console.log(res);
            alert(res.message);
            getAllDrivers();
        },
        error:function (error) {
            //Invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);
        }
    });
});


// /*GetAll Drivers*/
// $("#btnGetAllDriver").click(function () {
//     getAllDrivers();
// });
// //GetAll drivers function
// function getAllDrivers() {
//     $("#tblRegisteredDrivers").empty();
//     $.ajax({
//         url: baseUrl+"driver",
//         success:function (res) {
//             // console.log(res)
//             for (let d of res.data) {
//                 let driID=d.driverId;
//                 let driName=d.driverName;
//                 let driTel=d.driverTel;
//                 let driEmail=d.driverEmail;
//                 let driPassword=d.driverPassword;
//                 let driNicId=d.driverNicId;
//                 let driLicenceId=d.driverLicenceId;
//
//                 /*let driLicenceImg=d.driverLicenceImg;
//                 let driNicImg=d.driverNicImg;*/
//
//                 // let row= "<tr><td>"+driID+"</td><td>"+driName+"</td><td>"+driTel+"</td><td>"+driEmail+"</td><td>"+driPassword+"</td><td>"+driNicId+"</td><td>"+driLicenceId+"</td><td>"+driLicenceImg+"</td><td>"+driNicImg+"</td></tr>";
//                 let row= "<tr><td>"+driID+"</td><td>"+driName+"</td><td>"+driTel+"</td><td>"+driEmail+"</td><td>"+driPassword+"</td><td>"+driNicId+"</td><td>"+driLicenceId+"</td></tr>";
//                 $("#tblRegisteredDrivers").append(row);
//             }
//             bindRowClickEvents();
//             // setTextFieldValues("","","","","","","","","");
//             setTextFieldValues("","","","","","","");
//         },
//         error:function (error) {
//             let message= JSON.parse(error.responseText).message;
//             alert(message);
//         }
//     });
// }
//
// //Bind events for the table rows function
// function bindRowClickEvents() {
//     $("#tblRegisteredDrivers>tr").click(function () {
//         let driverId = $(this).children(":eq(0)").text();
//         let driverName = $(this).children(":eq(1)").text();
//         let driverTel = $(this).children(":eq(2)").text();
//         let driverEmail = $(this).children(":eq(3)").text();
//         let driverPassword = $(this).children(":eq(4)").text();
//         let driverNicId = $(this).children(":eq(5)").text();
//         let driverLicenceId = $(this).children(":eq(6)").text();
//
//         /*let driverLicenceImg = $(this).children(":eq(7)").text();
//         let driverNicImg = $(this).children(":eq(8)").text();*/
//
//         //Setting table details values to text fields
//         $('#txtDriverId').val(driverId);
//         $('#txtDriverName').val(driverName);
//         $('#txtDriverContactNo').val(driverTel);
//         $('#txtDriverEmail').val(driverEmail);
//         $('#txtDriverPassword').val(driverPassword);
//         $('#txtDriverNICNo').val(driverNicId);
//         $('#txtLicenceNo').val(driverLicenceId);
//
//         /* $('#driverLicenceImg').val(driverLicenceImg);
//          $('#driverNicImg').val(driverNicImg);*/
//
//     });
// }
// //Set text fields values function
// // function setTextFieldValues(driverId, driverName, driverTel, driverEmail, driverPassword, driverNicId, driverLicenceId, driverLicenceImg, driverNicImg) {
// function setTextFieldValues(driverId, driverName, driverTel, driverEmail, driverPassword, driverNicId, driverLicenceId) {
//     $("#txtDriverId").val(driverId);
//     $("#txtDriverName").val(driverName);
//     $("#txtDriverContactNo").val(driverTel);
//     $("#txtDriverEmail").val(driverEmail);
//     $("#txtDriverPassword").val(driverPassword);
//     $("#txtDriverNICNo").val(driverNicId);
//     $("#txtLicenceNo").val(driverLicenceId);
//
//     /*$("#driverLicenceImg").val(driverLicenceImg);
//     $("#driverNicImg").val(driverNicImg);*/
// }
//
// <!-- txtDriverId txtDriverName txtDriverContactNo  txtDriverEmail txtDriverPassword
//     txtDriverNICNo  txtLicenceNo  driverLicenceImg  driverNicImg
// -->
//
