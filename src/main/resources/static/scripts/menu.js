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