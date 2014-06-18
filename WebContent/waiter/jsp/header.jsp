
    <header  class="all_header">
        <img src="<s:url value="/member/images/logo.png" />" id="reg_logo" />

        <div class="btn-group navbar-btn btn_header ">
            <a  href="" class="btn btn-primary ">
                <s:property value="#session.username_waiter"/>
            </a>
            <button type="button" class="btn btn-primary  dropdown-toggle" style="height:34px;" data-toggle="dropdown">
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
            <li id="home"><a href=W_HomepageAction.action class="header_li">Home</a></li>       
            <li id="activity"><a href=BeforeMakeActivity.action  class=" header_li">Make activity</a></li>
            <li id="member"><a href=BeforeMemberCenter.action class=" header_li">Member center</a></li>

        </ul>

    </div>
