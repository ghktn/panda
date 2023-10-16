
    $(document).ready(function () {
    $("#categoryMainId").on("change", function () {
        const categoryMainId = $("#categoryMainId").val();
        var queryData = {"category_main_id": $("#categoryMainId").val()}

        const categorySubId = $("#categorySubId");
        if(!categoryMainId) {
            categorySubId.html("<option value=''>선택</option>");
            return;
        }

        $.ajax({
            url: "/category-sub",
            type: "get",
            data: queryData,
            success: success_run,
            error: error_run
        })
    })
});

    function success_run(resultData) {

    let result = "";
    result += "<option value=''>선택</option>"
    resultData.forEach(function(data) {
    result += "<option value=" + data.category_sub_id + ">" + data.category_sub_name + "</option>"

});
    $("#categorySubId").html(result);
}

    function error_run(obj, resMsg, errorMsg) {
    console.log("error");
    console.log(obj);
    console.log(resMsg);
    console.log(errorMsg);
}