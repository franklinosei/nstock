//
//
//
//let currentUrl = window.location.href;
//
//let toHighlight = {
//    Dashboard: ["/nstock/dashboard"],
//    "Item Management": ["/nstock/newItem"],
//    Orders: ["orders"],
//    Profile: ["profile"],
//    // Add more menu items and corresponding URLs as needed
//};
//
//alert(toHighlight["Item Management"])
//
//// Get all the nav links inside the sidebar
//let navLinks = document.querySelectorAll('.sidebar .nav-link');
//
//// Find the closest parent with the 'nav-item' class and add the menu-active class to it
//navLinks.forEach(function (link) {
//    if (currentUrl.includes(link.href)) {
//        let parentNavItem = link.closest('.nav-item');
//
//        if (parentNavItem) {
//            parentNavItem.classList.add('menu-active');
//        }
//    }
//
//    // Check if the current URL matches any of the values in the 'toHighlight' object
//    Object.entries(toHighlight).forEach(([menuItem, urls]) => {
//        urls.forEach(url => {
//            if (currentUrl.includes(url)) {
//                let menuItemLink = link.closest('.nav-item');
//                if (menuItemLink && menuItemLink.innerText === menuItem) {
//                    menuItemLink.classList.add('menu-active');
//                }
//            }
//        });
//    });
//});
