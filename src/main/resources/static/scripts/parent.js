function printer(id) {
  $("#formid").attr("action", "parentDetails?id=" + id).submit();
}

$(document).ready(function () {
  $("#createParentButton").click(function () {
    $("#overlay, #createParent").show();
  })
  $("#editParentButton").click(function () {
    $("#overlay, #editParent").show();
  })
  $(".cancelParent, #overlay").click(function () {
    $("#overlay, .popup-formular").hide();
  });
  $(document).keyup(function (e) {
    if (e.keyCode == 27) {
      $("#overlay, .popup-formular").hide();
      $(".popup-formular input[type=text],.popup-formular input[type=number]").val("");
    }
  });
});
