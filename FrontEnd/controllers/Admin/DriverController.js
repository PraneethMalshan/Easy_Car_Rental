let baseUrl="http://localhost:8081/easycarrental/"


getAllDrivers();

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


/*Delete Drivers*/
$("#btnDeleteDriver").click(function () {
   let licenceNo = $("#txtLicenceNo").val();
   $.ajax({
       url:baseUrl+"driver?licenceNo="+licenceNo,
       method: "delete",
       success:function (resp) {
           getAllDrivers();
           alert(resp.message);
       },
       error:function (error) {
           let message= JSON.parse(error.responseText).message;
           alert(message);
       }
   });
});

/* txtLicenceNo  txtDriverNICNo  txtDriverName
        txtDriverAddress txtDriverContactNo txtDriverUserName
         txtDriverPassword txtDriverAvailability */

/*  licenceNo nic name address  contactNo
username password availability  */

/*Update Driver*/
$("#btnUpdateDriver").click(function () {
   let licenceNo = $("#txtLicenceNo").val();
   let nic = $("#txtDriverNICNo").val();
   let name = $("#txtDriverName").val();
   let address = $("#txtDriverAddress").val();
   let contactNo = $("#txtDriverContactNo").val();
   let username = $("#txtDriverUserName").val();
   let password = $("#txtDriverPassword").val();
   let availability = $("#txtDriverAvailability").val();


   var driverOb={
       licenceNo:licenceNo,
       nic:nic,
       name:name,
       address:address,
       contactNo:contactNo,
       username:username,
       password:password,
       availability:availability
   }

   $.ajax({
       url:baseUrl+"driver",
       method:"put",
       contentType:"application/json",
       data: JSON.stringify(driverOb),
       dataType: "json",
       success:function (resp) {
           getAllDrivers();
           alert(resp.message);
       },
       error:function (error) {
           let message= JSON.parse(error.responseText).message;
           alert(message);
       }
   });
});


/*GetAll Drivers*/
$("#btnGetAllDriver").click(function () {
    getAllDrivers();
});
//GetAll drivers function
function getAllDrivers() {
    $("#tblRegisteredDrivers").empty();
    $.ajax({
        url: baseUrl+"driver",
        success:function (res) {
            // console.log(res)
            for (let d of res.data) {
                let driLicenceId=d.licenceNo;
                let driNicId=d.nic;
                let driName=d.name;
                let driAddress=d.address;
                let driContactNo=d.contactNo;
                let driUserName=d.username;
                let driPassword=d.password;
                let driAvailability=d.availability;

                let row= "<tr><td>"+driLicenceId+"</td><td>"+driNicId+"</td><td>"+driName+"</td><td>"+driAddress+"</td><td>"+driContactNo+"</td><td>"+driUserName+"</td><td>"+driPassword+"</td><td>"+driAvailability+"</td></tr>";
                $("#tblRegisteredDrivers").append(row);
            }
            bindRowClickEvents();
            setTextFieldValues("","","","","","","","");
        },
        error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

//Bind events for the table rows function
function bindRowClickEvents() {
    $("#tblRegisteredDrivers>tr").click(function () {
        let licenceNo = $(this).children(":eq(0)").text();
        let nic = $(this).children(":eq(1)").text();
        let name = $(this).children(":eq(2)").text();
        let address = $(this).children(":eq(3)").text();
        let contactNo = $(this).children(":eq(4)").text();
        let username = $(this).children(":eq(5)").text();
        let password = $(this).children(":eq(6)").text();
        let availability = $(this).children(":eq(7)").text();

        //Setting table details values to text fields
        $('#txtLicenceNo').val(licenceNo);
        $('#txtDriverNICNo').val(nic);
        $('#txtDriverName').val(name);
        $('#txtDriverAddress').val(address);
        $('#txtDriverContactNo').val(contactNo);
        $('#txtDriverUserName').val(username);
        $('#txtDriverPassword').val(password);
        $('#txtDriverAvailability').val(availability);

    });
}
//Set text fields values function
function setTextFieldValues(licenceNo, nic, name, address, contactNo, username, password, availability) {

    $("#txtLicenceNo").val(licenceNo);
    $("#txtDriverNICNo").val(nic);
    $("#txtDriverName").val(name);
    $("#txtDriverAddress").val(address);
    $("#txtDriverContactNo").val(contactNo);
    $("#txtDriverUserName").val(username);
    $("#txtDriverPassword").val(password);
    $("#txtDriverAvailability").val(availability);


}

/* txtLicenceNo  txtDriverNICNo  txtDriverName
        txtDriverAddress txtDriverContactNo txtDriverUserName
         txtDriverPassword txtDriverAvailability */

/*  licenceNo nic name address  contactNo
username password availability  */