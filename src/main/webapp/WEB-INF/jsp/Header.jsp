<head>
    <script type="text/javascript">
        function toggleSidebar(){
            document.getElementById("sidebar").classList.toggle('active');
        }
    </script>
</head>
<header class="header">
    <div id="sidebar">
        <div class="toggle-btn" onclick="toggleSidebar()">
            <a>
                <span></span>
                <span></span>
                <span></span>
            </a>
        </div>
        <ul>
            <li><a href="/home">AVAILABLE JOBS</a></li>
            <li><a href="/about">ABOUT US</a></li>
            <li><a href="/login">SIGN IN</a></li>
        </ul>
    </div>
</header>