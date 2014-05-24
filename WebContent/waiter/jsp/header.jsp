
    <header  class="all_header">
        <img src="<s:url value="/member/images/logo.png" />" id="reg_logo" />

        <div class="btn-group navbar-btn btn_header ">
            <button  type="button" class="btn btn-primary ">
                <s:property value="#session.username_waiter"/>
            </button>
            <button type="button" class="btn btn-primary  dropdown-toggle" data-toggle="dropdown">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="<s:url value="W_logoutAction.action" />">Logout</a></li>

            </ul>
        </div>

    </header>
    <div id="header_nav">
        <ul class="nav nav-pills nav_header">
            <li><a href=W_HomepageAction.action class="header_li">Home page</a></li>       
            <li><a href=BeforeMakeActivity.action  class=" header_li">Make activity</a></li>
            <li><a href=BeforeMemberCenter.action class=" header_li">Member center</a></li>

        </ul>

    </div>
