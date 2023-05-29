<%-- 
    Document   : sidebar
    Created on : May 27, 2023, 2:50:34 PM
    Author     : iamdveloper
--%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/nstock/dashboard">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
    </a>

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/dashboard">
            <span>Dashboard</span>
        </a>
    </li>

    <!-- Nav Item - Item Management -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/stock">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Item Management</span>
        </a>
    </li>

    <!-- Nav Item - Lab Management -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/labs">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Lab Management</span>
        </a>
    </li>

    <!-- Nav Item - Employee Management -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/employee">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Employee Management</span>
        </a>
    </li>

    <!-- Nav Item - Report -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/report">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Report</span>
        </a>
    </li>

    <!-- Nav Item - Profile -->
    <li class="nav-item">
        <a class="nav-link" href="/nstock/profile">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Profile</span>
        </a>
    </li>
</ul>

<script>
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
</script>
