$(document).ready(function () {
    var clickedSchedule;
    
    $(".allSchedules h2 span.remakeDate").each(function () {
        $(this).text($(this).text().split("-").reverse().join("-"));
    });

    if($("#success").text() != "") {
        $("#success").css({"margin-left": "-"+($("#success").outerWidth()/2)+"px"});
        $("#success").fadeIn(500).delay(3000).fadeOut(500);
    }

    if($("#deletedSchedules").length != 0) {
        $("#deletedSchedules").delay(10000).animate({"bottom": "-70px"}, 500);
    }

    $("#openCreateNewSchedule").click(function () {
        $("#overlay, #createNewSchedule").show();
    });

    $("#cancelScheduleCreate, #overlay, #cancelScheduleEdit").click(function () {
        $("#overlay, .popup-formular, .fail, #viewSingleSchedule").hide();
        $("#dateField, #fromField, #toField").val("");
    });

    $(".date").click(function () {
        $(this).parent().parent().find(".dateMenu").show();
    });

    $(".dateMenu").mouseleave(function () {
        $(this).hide();
    });

    $(".dateMenuClose").click(function () {
        $(this).parent().parent().hide();
    });

    $(".createScheduleAtDate").click(function () {
        document.getElementById("dateField").valueAsDate = new Date($(this).parents("td").data("date"));
        $(this).parents(".dateMenu").hide();
        $("#overlay, #createNewSchedule").show();
    });

    $("input[name=goToEditSchedule]").click(function () {
        $("input[name=editScheduleId]").val($("input[name=toEditScheduleId]").val());
        $("select[name=editEmployee]").val($("input[name=toEditEmployeeKey]").val());
        $("input[name=editDate]").val($("input[name=toEditDate]").val());
        $("input[name=editFromTime]").val($("input[name=toEditFromTime]").val());
        $("input[name=editToTime]").val($("input[name=toEditToTime]").val());
        ;
        $("#viewSingleSchedule").hide();
        $("#editSchedule").show();
    });

    $("#viewSingleSchedule input[name=closeSingleViewSchedule]").click(function () {
        $("#viewSingleSchedule, #overlay").hide();
    });

    $(".schedule:not(.seeMoreSchedules)").click(function () {
        clickedSchedule = $(this);
        var date = new Date($(clickedSchedule).data("schedule-date"));
        $("#viewSingleSchedule input[name=deleteSingleScheduleID]").val($(clickedSchedule).data("schedule-id"));
        $("#viewSingleSchedule h2").text($(clickedSchedule).data("employee"));
        $("#viewSingleSchedule #fromTimeInformation").text($(clickedSchedule).data("from-time"));
        $("#viewSingleSchedule #toTimeInformation").text($(clickedSchedule).data("to-time"));
        $("#viewSingleSchedule #dateInformation").text((date.getDate() < 10 ? "0"+date.getDate() : date.getDate())+"-"+(date.getMonth()+1 < 10 ? "0"+(date.getMonth()+1) : date.getMonth()+1)+"-"+date.getFullYear());
        transferHiddenInfoToView(clickedSchedule);
        $("#viewSingleSchedule, #overlay").show();
    });

    $(".multipleScheduleBlock").click(function () {
        clickedSchedule = $(this).parent();
        var date = new Date($(clickedSchedule).data("schedule-date"));
        $("#viewSingleSchedule input[name=deleteSingleScheduleID]").val($(clickedSchedule).data("schedule-id"));
        $("#viewSingleSchedule h2").text($(clickedSchedule).data("employee"));
        $("#viewSingleSchedule #fromTimeInformation").text($(clickedSchedule).data("from-time"));
        $("#viewSingleSchedule #toTimeInformation").text($(clickedSchedule).data("to-time"));
        $("#viewSingleSchedule #dateInformation").text((date.getDate() < 10 ? "0"+date.getDate() : date.getDate())+"-"+(date.getMonth()+1 < 10 ? "0"+(date.getMonth()+1) : date.getMonth()+1)+"-"+date.getFullYear());
        transferHiddenInfoToView(clickedSchedule);
        $(".allSchedules").hide();
        $("#viewSingleSchedule").show();
    });

    function transferHiddenInfoToView(clickedSchedule) {
        $("input[name=toEditScheduleId]").val($(clickedSchedule).data("schedule-id"));
        $("input[name=toEditEmployeeKey]").val($(clickedSchedule).data("employeekey"));
        $("input[name=toEditDate]").val($(clickedSchedule).data("schedule-date"));
        $("input[name=toEditFromTime]").val($(clickedSchedule).data("from-time"));
        $("input[name=toEditToTime]").val($(clickedSchedule).data("to-time"));
    }

    $("#calendar-table td").css({"height": ($("#calendar-table tbody").height() - 5) / 6 + "px"});
    
    $("#showCalendar").change(function () {
        document.getElementById("showCalendarForm").submit();
    });
    
    $(".allSchedules .checkboxSchedule .checkboxContainer input[type=checkbox]").change(function () {
        var parent = $(this).parent().parent().parent();
        var isAtleastOneChecked = false;

        $(parent.find("input[type=checkbox]")).each(function () {

            if(this.checked) {
                isAtleastOneChecked = true;
            }
        });

        if(isAtleastOneChecked) {
            $(parent).parent().find("input[name=deleteMultipleSchedule]").show();
        } else {
            $(parent).parent().find("input[name=deleteMultipleSchedule]").hide();
        }
    });
    
    $(".seeMoreSchedules").click(function () {
        $(this).parent().parent().parent().find(".allSchedules").show();
        $("#overlay").show();
    });

    $(".closeMultipleViewSchedule").click(function () {
        $(this).parent().parent().find("input[type=checkbox]").each(function () {
            this.checked = false;
        });

        $("#overlay").hide();
        $(this).parent().parent().parent().hide();
    });

    $(document).keyup(function(e) {
        if (e.keyCode == 27) {
            $("#overlay, .popup-formular").hide();
            $("#dateField, #fromField, #toField").val("");
        }
    });

    //Validation for Opret Vagt
    $(document).on('click', 'form input[name=saveNewSchedule]', function(e) {
        var isValid = true;

        if($("select[name=employee]").val() == 0) {
            $(".employeeFail").show();
            isValid = false;
        } else {
            $(".employeeFail").hide();
        }

        if($("input[name=date]").val().length ==  0) {
            $(".dateFail").show();
            isValid = false;
        } else {
            $(".dateFail").hide();
        }

        if($("input[name=fromTime]").val().length == 0) {
            $(".fromTimeFail").show();
            isValid = false;
        } else {
            $(".fromTimeFail").hide();
        }

        if($("input[name=toTime]").val().length == 0) {
            $(".toTimeFail").show();
            isValid = false;
        } else {
            $(".toTimeFail").hide();
        }

        if($("input[name=fromTime]").val().length != 0 && $("input[name=toTime]").val().length != 0 && $("input[name=toTime]").val() < $("input[name=fromTime]").val()) {
            $(".timeIsBeforeStartFail").show();
            isValid = false;
        } else {
            $(".timeIsBeforeStartFail").hide();
        }

        if(!isValid) {
            e.preventDefault();
        }
    });

    $(document).on('click', 'form input[name=saveEditSchedule]', function(e) {
        var isValid = true;

        if($("select[name=editEmployee]").val() == 0) {
            $(".editEmployeeFail").show();
            isValid = false;
        } else {
            $(".editEmployeeFail").hide();
        }

        if($("input[name=editDate]").val().length ==  0) {
            $(".editDateFail").show();
            isValid = false;
        } else {
            $(".editDateFail").hide();
        }

        if($("input[name=editFromTime]").val().length == 0) {
            $(".editFromTimeFail").show();
            isValid = false;
        } else {
            $(".editFromTimeFail").hide();
        }

        if($("input[name=editToTime]").val().length == 0) {
            $(".editToTimeFail").show();
            isValid = false;
        } else {
            $(".editToTimeFail").hide();
        }

        if($("input[name=editFromTime]").val().length != 0 && $("input[name=editToTime]").val().length != 0 && $("input[name=editToTime]").val() < $("input[name=editFromTime]").val()) {
            $(".editTimeIsBeforeStartFail").show();
            isValid = false;
        } else {
            $(".editTimeIsBeforeStartFail").hide();
        }

        if(!isValid) {
            e.preventDefault();
        }
    });
});

$(window).resize(function () {
    $("#calendar-table").css({"height": ($(document).height() - 120) + "px"});
    $("#calendar-table td").css({"height": $($("#calendar-table tbody").height() - 5) / 6 + "px"});
});