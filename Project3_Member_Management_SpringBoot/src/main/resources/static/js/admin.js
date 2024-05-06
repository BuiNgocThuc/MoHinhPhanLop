const hamBurger = document.querySelector(".toggle-btn");
hamBurger.addEventListener("click", function () {
    document.querySelector("#sidebar").classList.toggle("expand");
});
$(document).ready(function () {
    $('.sidebar-item .sidebar-link').on("click", function (e) {
        e.preventDefault(); // Prevent default link behavior

        // Remove 'active' class from all sidebar links
        $('.sidebar-link').removeClass('active');

        // Add 'active' class to the clicked sidebar link
        $(this).addClass('active');
    });
});