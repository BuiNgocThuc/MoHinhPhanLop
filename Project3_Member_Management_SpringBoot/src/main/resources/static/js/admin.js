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