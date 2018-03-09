$(document).ready(function () {
    var clickedSchedule;

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

    $("#cancelScheduleCreate, #overlay").click(function () {
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
        $("#viewSingleSchedule, #overlay").show();
    });

    $("#calendar-table td").css({"height": ($("#calendar-table tbody").height() - 5) / 6 + "px"});
    
    $("#showCalendar").change(function () {
        document.getElementById("showCalendarForm").submit();
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
});

$(window).resize(function () {
    $("#calendar-table").css({"height": ($(document).height() - 120) + "px"});
    $("#calendar-table td").css({"height": $($("#calendar-table tbody").height() - 5) / 6 + "px"});
});