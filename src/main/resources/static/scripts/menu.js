$(document).ready(function () {
    var path = window.location.pathname;
    if(path == "/index"){
        $("#menu ul li:nth-child(1) a").addClass("active");

    }else if(path == "/employee"){
        $("#menu ul li:nth-child(2) a").addClass("active");

    }else if(path == "/children"){
        $("#menu ul li:nth-child(3) a").addClass("active");

    }else if(path == "/waitingList"){
        $("#menu ul li:nth-child(4) a").addClass("active");

    }
    $("#openEditPassWord").click(function () {
        $("#overlay, #editPassword").show();
        $("#overlay-user, .popup-formular-user").hide();
    });

    $("#cancelEditPassWord, #overlay").click(function () {
        $("#overlay, .popup-formular").hide();
        $("#overlay-user, #user").show();
    });
    //Validation password
    $(document).on('click', 'form input[name=savePassWord]', function(e) {
        var isValid = true;
        if ($("#currentPassword").val().length == 0) {
            $(".currentPasswordFail").show();
            isValid = false;
        } else {
            $(".currentPasswordFail").hide();
        }
        if ($("#newPassword").val().length == 0) {
            $(".newPasswordFail").show();
            isValid = false;
        } else {
            $(".newPasswordFail").hide();
        }
        if ($("#newPasswordCheck").val().length == 0) {
            $(".passwordCheckFail").show();
            isValid = false;
        } else {
            $(".passwordCheckFail").hide();
        }
        e.preventDefault();
    });

    $("#openUserInfo").click(function (e) {
        $("#overlay-user, #user").show();
        $("#openUserInfo").removeClass('selected');
        $(this).addClass('selected');
        e.preventDefault();
    });

    $("#cancelUser, #overlay-user").click(function () {
        $("#overlay-user, .popup-formular-user").hide();
        $("#openUserInfo").removeClass('selected');
    });
});