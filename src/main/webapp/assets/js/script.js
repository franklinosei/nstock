// Get the current URL
    var currentUrl = window.location.href;

    // Get all the nav links inside the sidebar
    var navLinks = document.querySelectorAll('.sidebar .nav-link');

    // Find the closest parent with the 'nav-item' class and add the menu-active class to it
    navLinks.forEach(function (link) {
        if (currentUrl.includes(link.href)) {
            var parentNavItem = link.closest('.nav-link');
            if (parentNavItem) {
                parentNavItem.classList.add('menu-active');
            }
        }
    });