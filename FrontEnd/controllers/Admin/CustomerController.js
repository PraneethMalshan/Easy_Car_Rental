// let baseUrl="http://localhost:8081/easycarrental/"

getAllCustomers();




/*GetAll Customers*/
$("#btnGetAllCustomer").click(function () {
    getAllCustomers();
});

function getAllCustomers() {

    $("#tblCustomers").empty();
    $.ajax({
        url:baseUrl+"customer",
        dataType: "json",
        success:function (res) {
            for (let c of res.data){
                let cusNicNo=c.nicNo;
                let cusLicenceNo=c.licenceNo;
                let cusName=c.name;
                let cusAddress=c.address;
                let cusContactNo=c.contactNo;
                let cusEmail=c.email;
                let cusUserName=c.username;
                let cusPassword=c.password;

                let cusNICFrontImg=c.nicFrontImg;
                let cusNicBackImg=c.nicBackImg;

                let row= "<tr><td>"+cusNicNo+"</td><td>"+cusLicenceNo+"</td><td>"+cusName+"</td><td>"+cusAddress+"</td><td>"+cusContactNo+"</td><td>"+cusEmail+"</td><td>"+cusUserName+"</td><td>"+cusPassword+"</td><td>"+cusNICFrontImg+"</td><td>"+cusNicBackImg+"</td></tr>";
                $("#tblCustomers").append(row);

            }
            bindRowClickEvents();
            setTextFieldValues("","","","","","","","","","");

        },
        error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

//Bind events for the table rows function
function bindRowClickEvents() {
    $("#tblCustomers>tr").click(function () {
        let nicNo = $(this).children(":eq(0)").text();
        let licenceNo = $(this).children(":eq(1)").text();
        let name = $(this).children(":eq(2)").text();
        let address = $(this).children(":eq(3)").text();
        let contactNo = $(this).children(":eq(4)").text();
        let email = $(this).children(":eq(5)").text();
        let username = $(this).children(":eq(6)").text();
        let password = $(this).children(":eq(7)").text();

        let nicFrontImg = $(this).children(":eq(8)").text();
        let nicBackImg = $(this).children(":eq(9)").text();

        //Setting table details values to text fields
        $('#txtCustomerNicId').val(nicNo);
        $('#txtCustomerLicId').val(licenceNo);
        $('#txtCustomerName').val(name);
        $('#txtCustomerAddress').val(address);
        $('#txtCustomerContactNo').val(contactNo);
        $('#txtCustomerEmail').val(email);
        $('#txtCustomerUserName').val(username);
        $('#txtCustomerPassword').val(password);

        $('#cusNicFrontImg').val(nicFrontImg);
        $('#cusNicBackImg').val(nicBackImg);

    });
}

function setTextFieldValues(nicNo, licenceNo, name, address, contactNo, email, username, password, nicFrontImg, nicBackImg) {
    $("#txtCustomerNicId").val(nicNo);
    $("#txtCustomerLicId").val(licenceNo);
    $("#txtCustomerName").val(name);
    $("#txtCustomerAddress").val(address);
    $("#txtCustomerContactNo").val(contactNo);
    $("#txtCustomerEmail").val(email);
    $("#txtCustomerUserName").val(username);
    $("#txtCustomerPassword").val(password);

    $("#imgNicFrontImg").val(nicFrontImg);
    $("#imgNicBackImg").val(nicBackImg);

}




/*nicNo
             licenceNo
             name
             address
             contactNo
             email
             username
             password*/
                    <!--nicFrontImg nicBackImg  -->
                    /* imgNicFrontImg  imgNicBackImg */
