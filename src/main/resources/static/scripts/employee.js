$(document).ready(function () {
    $("#openCreateNewEmployee").click(function () {
        $("#overlay, #createNewEmployee").show();
    });

    $("#cancelEmployeeCreate, #overlay").click(function () {
        $("#overlay, .popup-formular").hide();
    });

    $(".openEditEmployee").click(function () {
        var employee = $(this).parent().parent().parent();

        $("input[name=id]").val($(employee).data("employee-id"));
        $("input[name=username]").val($(employee).data("employee-username"));
        $("input[name=password]").val($(employee).data("employee-password"));
        $("input[name=firstName]").val($(employee).data("employee-firstname"));
        $("input[name=lastName]").val($(employee).data("employee-lastname"));
        $("input[name=roadName]").val($(employee).data("employee-roadname"));
        $("input[name=city]").val($(employee).data("employee-city"));
        $("input[name=postalCode]").val($(employee).data("employee-postalcode"));
        $("input[name=phoneNumber]").val($(employee).data("employee-phonenumber"));
        $("input[name=email]").val($(employee).data("employee-email"));
        $("#overlay, #editEmployee").show();
    });

    $("#cancelEmployeeEdit, #overlay").click(function () {
        $("#overlay, .popup-formular").hide();
    });

    //Validation for new employee
    $(document).on('click', 'form input[name=saveEmployee]', function(e) {
        var isValid = true;

        if($("#employeeUsername").val().length == 0) {
            $(".employeeUsernameFail").show();
            isValid = false;
        } else {
            $(".employeeUsernameFail").hide();
        }

        if($("#employeePassword").val().length ==  0) {
            $(".employeePasswordFail").show();
            isValid = false;
        } else {
            $(".employeePasswordFail").hide();
        }

        if($("#employeeFirstName").val().length == 0) {
            $(".employeeFirstNameFail").show();
            isValid = false;
        } else {
            $(".employeeFirstNameFail").hide();
        }

        if($("#employeeLastName").val().length == 0) {
            $(".employeeLastNameFail").show();
            isValid = false;
        } else {
            $(".employeeLastNameFail").hide();
        }

        if($("#employeeAddress").val().length == 0) {
            $(".employeeStreetNameFail").show();
            isValid = false;
        } else {
            $(".employeeStreetNameFail").hide();
        }

        if($("#employeeAddressCity").val().length == 0) {
            $(".employeeCityFail").show();
            isValid = false;
        } else {
            $(".employeeCityFail").hide();
        }

        if($("#employeeAddressPostalCode").val() == 0 || $("#employeeAddressPostalCode").val().length != 4) {
            $(".employeePostalCodeFail").show();
            isValid = false;
        } else {
            $(".employeePostalCodeFail").hide();
        }

        if($("#employeePhoneNumber").val() == 0 || $("#employeePhoneNumber").val().length != 8) {
            $(".employeePhoneNumberFail").show();
            isValid = false;
        } else {
            $(".employeePhoneNumberFail").hide();
        }

        var email = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        if($("#employeeEmail").val().length == 0 || !($("#employeeEmail").val().match(email))) {
            $(".employeeEmailFail").show();
            isValid = false;
        } else {
            $(".employeeEmailFail").hide();
        }

        e.preventDefault();

        $.ajax({
            type : "POST",
            url : "/checkUsername",
            data : {
                "username" : $("#employeeUsername").val()
            }, success: function(data){
                if(data) {
                    $(".employeeUsernameTakenFail").show();
                    isValid = false;
                } else {
                    $(".employeeUsernameTakenFail").hide();
                }

                if(isValid) {
                    $("#createEmployeeForm").unbind('submit').submit();
                }
            }
        })
    });
});