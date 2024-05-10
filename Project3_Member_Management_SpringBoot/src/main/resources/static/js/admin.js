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
    const searchDeviceVal = $('#inputSearchDevice').val().trim();
    const selectDeviceVal = $('#selectDevice').val();
    const startDateDevice = $('#inputDateStartDevice').val().trim();
    const endDateDevice = $('#inputDateEndDevice').val().trim();

    // call ajax
    $.ajax({
        url: '/admin/dashboard/statisticDevice',
        type: 'POST',
        data: {
            search: searchDeviceVal,
            select: selectDeviceVal,
            startDate: startDateDevice,
            endDate: endDateDevice
        },
        success: function (data) {
            dataJSON = JSON.parse(data);
           updateTable(dataJSON);
           updateTotalDevices(dataJSON);
        },
        error: function (xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error(error);
            console.error(xhr.responseText);
        }
    });
};

$(document).ready(function () {
    $('#inputSearchDevice').on('keypress', function (e) {
        if (e.which === 13) {
            getStatictisDevice();
        }
    });
});

// Hàm cập nhật dữ liệu trên giao diện
const updateTable = (data) => {
   const tbody = $('#tableDevice tbody');
    tbody.empty(); // Xóa nội dung hiện tại của tbody
    
    $.each(data.device, function(index, item) {
        const row = $('<tr>');
        row.append($('<td>').text(index + 1)); // Số thứ tự
        row.append($('<td>').text(item.deviceID)); // ID của thiết bị
        row.append($('<td>').text(item.deviceName)); // Tên của thiết bị
        row.append($('<td>').text(item.deviceDescription)); // Mô tả của thiết bị
        row.append($('<td>').text(item.borrowedTime)); // Thời gian mượn
        tbody.append(row); // Thêm dòng mới vào tbody
    });
};

const updateTotalDevices = (data) => {
    $('#totalDevices').text(data.total);
};
