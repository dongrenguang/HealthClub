
    <header  class="all_header">
        <img src="<s:url value="/member/images/logo.png" />" id="reg_logo" />

        <div class="btn-group navbar-btn btn_header ">
            <a href="profile.action" class="btn btn-primary ">
                <s:property value="#session.username"/>
            </a>
            <Button class="btn btn-primary  dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </Button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="<s:url value="profile.action" />">Profile</a></li>
                <li class="divider"></li>
                <li><a href="<s:url value="logout.action" />">Logout</a></li>

            </ul>
        </div>

    </header>
    <div id="header_nav">
        <ul class="nav nav-pills nav_header">
            <li id="home" class="active"><a href=homepage.action class="header_li">Home</a></li>       
            <li id="profile" ><a href=profile.action class=" header_li">Profile</a></li>
            <li id="payment"><a href=payment.action class=" header_li">Payment</a></li>


        </ul>

    </div>
