$(document).ready(function () {
  let path = window.location.pathname;
  let clickedChangePassword = false;
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
    $("#editPassword, #overlay").show();
    $("#user").hide();
    $("#openUserInfo").removeClass('selected');
    clickedChangePassword = true;
  });

  $("#openUserInfo").click(function () {
    $("#user").show();
    $(this).addClass('selected');
    $("#userForm").attr("action", "saveUserInfo?path=" + (window.location.pathname));
  });

  $("#cancelUser").click(function () {
    $("#user").hide();
    $("#openUserInfo").removeClass('selected');
  });

  $("#overlay, #cancelEditPassWord").click(function () {
    if (clickedChangePassword) {
      $("#user").show();
      $("#editPassword, #overlay").hide();
      $("#openUserInfo").addClass('selected');
    }
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