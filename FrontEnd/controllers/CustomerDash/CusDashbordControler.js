$("#btnUpdateCustomer").click(function () {
   let nicNo = $('#txtNicId').val();
   let name = $('#txtCusName').val();
   let address = $('#txtCusAddress').val();
   let email = $('#txtCusEmail').val();
   let contact = $('#txtCusContactNo').val();
   let password = $('#txtPassword').val();

   var customer = {
      customerId:nicNo,
      name: name,
      address: address,
      contactNo: contact,
      email: email,
      nicNo: password
   }

   $.ajax({
      url: baseUrl + "customer",
      method: "PUT",
      contentType: "application/json",
      data: JSON.stringify(customer),
      success:function (rep) {
         swal({
            title: "Confirmation!",
            text: "Customer Updated Successfully",
            icon: "success",
            button: "Close",
            timer: 2000
         });

      },
      error: function (rep) {
         swal({
            title: "Error!",
            text: "Customer Not Updated Successfully",
            icon: "error",
            button: "Close",
            timer: 2000
         });
      }

   });

});

//===================================Add rent================================
$('#sendRequest').click(function () {
   let registrationNO = $('#cmbRegistrationNo').find('option:selected').text();
   if (registrationNO != "" && registrationNO != "-Select Registration No-" && $('#txtCarPickupDate').val()!="" ) {
      searchCustomerById(username);
   } else {
      alert("Please fill rental fields");
   }
});

function searchCustomerById() {

   $.ajax({
      url: baseUrl + "customer/" + username,
      method: "GET",
      success: function (res) {
         let customer = res.data;
         console.log(customer);
         searchCurById(customer);
      }
   });
}

function searchCurById(customer) {
   let regisrId = $('#cmbRegistrationNo').find('option:selected').text();

   $.ajax

}








