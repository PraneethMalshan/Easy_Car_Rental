$("#btnUpdateCustomer").click(function () {
   let nicNo = $('#txtNicId').val();
   let name = $('#txtCusName').val();
   let address = $('#txtCusAddress').val();
   let email = $('#txtCusEmail').val();
   let contact = $('#txtCusContactNo').val();
   let password = $('#txtPassword').val();

   var customer = {
      nicNo:nicNo,
      name: name,
      address: address,
      contactNo: contact,
      email: email,
      password: password
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

   $.ajax({
      url: baseUrl+"car",
      success:function (res) {
         for (let c of res.data) {
            let carID=c.registrationNO;
            if (carID == regisrId) {
               let car=c;
               console.log(car)
               searchDriverByNic(customer, car)
            }
         }
      },
      error:function (error) {
         let message= JSON.parse(error.responseText).message;
         alert(message);
      }
   });
}


function searchDriverByNic(customer, car) {
   let licenceNo = $('#txtDriverNIC').val();
   if ($('#txtDriverNIC').val() === "") {
      licenceNo = null;
   }

   if (licenceNo != null){
      $.ajax({
         url: baseUrl+"driver",
         success:function (res) {
            for (let c of res.data) {
               let drNic=c.nic;
               if (drNic == licenceNo) {
                  let driver=c;
                  console.log(driver)
                  addCarRent(customer, car, driver);
               }
            }

         },
         error:function (error) {
            let message= JSON.parse(error.responseText).message;
            alert(message);
         }


      });
   } else {
      addCarRent(customer, car, null);

   }

}
/*
rentId advance dayCount pickUpDate rentType status
*/
function addCarRent(customer, car, driver) {
   let rentId = $('#txtCarRentId').val();
   let advance = $('#txtPaymentAmount').val();
   let dayCount = $('#txtRantDayCount').val();
   let pickUpDate = $('#txtCarPickupDate').val();
   let rentType = $('#cmbRentType').find('option:selected').text();
   let status = "Pending";

   let carRent = {
      rentId: rentId,
      advance: advance,
      dayCount:dayCount,
      pickUpDate:pickUpDate,
      rentType:rentType,
      status:status,
      customer:customer,
      car:car,
      driver:driver
   }

   let carData=JSON.stringify(carRent);

   $.ajax({
      url: baseUrl + "CarRent",
      method: "post",
      data: carData,
      dataType: "json",
      contentType: "application/json",
      success: function (rep) {
         alert(rep.message);
      },
      error: function (ob) {
         alert(ob.message);
      }


   });

}






