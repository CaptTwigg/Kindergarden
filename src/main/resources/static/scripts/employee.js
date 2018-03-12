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
        $("input[name=roadNumber]").val($(employee).data("employee-roadnumber"));
        $("input[name=city]").val($(employee).data("employee-city"));
        $("input[name=postalCode]").val($(employee).data("employee-postalcode"));
        $("input[name=phoneNumber]").val($(employee).data("employee-phonenumber"));
        $("input[name=email]").val($(employee).data("employee-email"));

        $("#overlay, #editEmployee").show();
    });

    $("#cancelEmployeeEdit, #overlay").click(function () {
        $("#overlay, .popup-formular").hide();
    });
});