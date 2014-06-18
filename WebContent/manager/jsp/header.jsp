
    <header  class="all_header">
        <img src="<s:url value="/member/images/logo.png" />" id="reg_logo" />

        <div class="btn-group navbar-btn btn_header ">
            <a  class="btn btn-primary ">
                <s:property value="#session.username_manager"/>
            </a>
            <Button class="btn btn-primary  dropdown-toggle" data-toggle="dropdown" style="height:34px;">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </Button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="<s:url value="Manager_LogoutAction.action" />">Logout</a></li>

            </ul>
        </div>

    </header>
    <div id="header_nav">
        <ul class="nav nav-pills nav_header">
            <li class="active"><a  class="header_li" id="nav_age">Age</a></li>       
            <li><a  class=" header_li" id="nav_gender">Gender</a></li>
            <li><a  class=" header_li" id="nav_address">Address</a></li>
            <li><a  class=" header_li" id="nav_state">State</a></li>
            
            <li><a  class=" header_li" id="nav_coach">Coach</a></li>
            <li><a  class=" header_li" id="nav_site">Site</a></li>
            <li><a  class=" header_li" id="nav_persionnumber_day">Daily active users</a></li>
        </ul>

    </div>
