$(document).ready(function () {
    $(".openEditChild").click(function () {
        $("#overlay, #editChild").show();
    });

    $("#cancelChildEdit, #overlay").click(function () {
        $("#overlay, .popup-formular").hide();
    });

    //Validation for edit child
    $(document).on('click', 'form input[name=saveEditEmployee]', function(e) {
        var isValid = true;

        if($("#editChildFirstName").val().length == 0) {
            $(".childFirstNameFail").show();
            isValid = false;
        } else {
            $(".childFirstNameFail").hide();
        }

        if($("#editChildLastName").val().length == 0) {
            $(".childLastNameFail").show();
            isValid = false;
        } else {
            $(".childLastNameFail").hide();
        }

        if($("#editChildAddress").val().length == 0) {
            $(".childStreetNameFail").show();
            isValid = false;
        } else {
            $(".childStreetNameFail").hide();
        }

        if($("#editChildAddressCity").val().length == 0) {
            $(".childCityFail").show();
            isValid = false;
        } else {
            $(".childCityFail").hide();
        }

        if($("#editChildAddressPostalCode").val() == 0 || $("#editChildAddressPostalCode").val().length != 4) {
            $(".childPostalCodeFail").show();
            isValid = false;
        } else {
            $(".childPostalCodeFail").hide();
        }

        if($("#editchildBirthDay").val() == 0) {
            $(".childBirthDayFail").show();
            isValid = false;
        } else {
            $(".childBirthDayFail").hide();
        }

        if(!isValid){e.preventDefault();}

    });
})