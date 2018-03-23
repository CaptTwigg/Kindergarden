$(document).ready(function () {
    $(".openEditChild").click(function () {
        $("#overlay, #editChild").show();
    });

    if($("#success").text() != "") {
        $("#success").css({"margin-left": "-"+($("#success").outerWidth()/2)+"px"});
        $("#success").fadeIn(500).delay(3000).fadeOut(500);
    }

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
            $(".childaddressFail").show();
            isValid = false;
        } else {
            $(".childaddressFail").hide();
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
});

function printer(id) {
    $("#formid").attr("action", "detailsChild?id=" + id).submit();
}