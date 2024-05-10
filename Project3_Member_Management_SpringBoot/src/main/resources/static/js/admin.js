const hamBurger = document.querySelector(".toggle-btn");
hamBurger.addEventListener("click", function () {
    document.querySelector("#sidebar").classList.toggle("expand");
});
$(document).ready(function () {
    $('.sidebar-item .sidebar-link').on("click", function (e) {

        // Remove 'active' class from all sidebar links
        $('.sidebar-link').removeClass('active');

        // Add 'active' class to the clicked sidebar link
        $(this).addClass('active');
    });
    var path = window.location.pathname;
    // Loop through each <a> tag in the sidebar
    $('.sidebar-item .sidebar-link').each(function () {
        var href = $(this).attr('href');
        console.log(href);
        // Check if the href attribute matches the current path
        if (href == path) {
            // Add the 'active' class to the parent <li> of the matching <a> tag
            $(this).addClass('active');
        }
    });
});

const getStatictisDevice = () => {
    const searchDeviceVal = $('#inputSearchDevice').val();
    const selectDeviceVal = $('#selectDevice').val();
    const startDateDevice = $('#inputDateStartDevice').val();
    const endDateDevice = $('#inputDateEndDevice').val();
    // call ajax
    $.ajax({
        url: '/admin/device/statictis',
        type: 'GET',
        data: {
            search: searchDeviceVal,
            select: selectDeviceVal,
            startDate: startDateDevice,
            endDate: endDateDevice
        },
        success: function (data) {
            console.log(data)
        }
    });
}

function CheckFineReadonly() {
    var isBoiThuong = $("#hinhThucXuLy2").val() === "Bồi thường" || $("#hinhThucXuLy2").val() === "Khóa thẻ 1 tháng và bồi thường";
    $("#soTien2").prop('readonly', !isBoiThuong).val(!isBoiThuong ? '' : $("#soTien2").val());
}

$(document).ready(CheckFineReadonly);

$(document).on("change", "#hinhThucXuLy2", CheckFineReadonly);

function handleDeleteDiscipline(id) {
    window.location.href = `/deleteDiscipline?id=${id}`
}

document.getElementById('soTien2').addEventListener('input', function (e) {
    e.target.value = e.target.value.replace(/[^0-9]/g, '');
});

