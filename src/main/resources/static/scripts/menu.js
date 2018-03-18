$(document).ready(function () {
  var path = window.location.pathname;
  if (path == "/index") {
    $("#menu ul li:nth-child(1) a").addClass("active");

  } else if (path == "/employee") {
    $("#menu ul li:nth-child(2) a").addClass("active");

  } else if (path == "/children") {
    $("#menu ul li:nth-child(3) a").addClass("active");

  } else if (path == "/waitingList") {
    $("#menu ul li:nth-child(4) a").addClass("active");

  }



  $("#openEditPassWord").click(function () {
    $("#editPassword").show();
    $("#overlay").css("background", "rgba(0, 0, 0, 0.5)");
    $("#user").hide();
  });

  $("#cancelUser, #cancelEditPassWord, #overlay").click(function () {

console.log("pass vis: " + $("#editPassword").is(":visible"));
console.log("user vis: " + $("#user").is(":visible"));
    if($("#editPassword").is(":visible")) {
      $("#editPassword").hide();
      $("#overlay").css("background", "none");
      $("#overlay, #user").show();
      console.log(1);
    }
    else{
      $("#overlay").css("background", "rgba(0, 0, 0, 0.5)");
      $("#overlay, #user").hide();
      $("#openUserInfo").removeClass('selected');
      console.log(3);
    }

  });


  $("#openUserInfo").click(function () {
    $("#overlay").css("background", "none");
    $("#overlay, #user").show();
    $(this).addClass('selected');

    $("#userForm").attr("action", "saveUserInfo?path=" + (window.location.pathname));

  });

  //Validation password
  $(document).on('click', 'form input[name=savePassWord]', function (e) {
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

});