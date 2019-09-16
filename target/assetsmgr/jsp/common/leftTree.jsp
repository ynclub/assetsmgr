<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String _currentMenu = (String) request.getAttribute("leftMenu");
    String _currentMenuOpen = (String) request.getAttribute("leftMenuOpen");
    System.out.println("_currentMenu = " + _currentMenu);
    System.out.println("_currentMenuOpen = " + _currentMenuOpen);
%>
<script type="text/javascript">
    try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<div class="sidebar-shortcuts" id="sidebar-shortcuts">
    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
        <button class="btn btn-success" onclick="window.location.href='/assetsList'">
            <i class="icon-signal"></i>
        </button>

        <button class="btn btn-info" onclick="window.location.href='/assetsAdd'">
            <i class="icon-pencil"></i>
        </button>    

        <button class="btn btn-warning" onclick="window.location.href='/classificationList'">
            <i class="icon-group"></i>
        </button>

        <button class="btn btn-danger" onclick="window.location.href='/assetsList'">
            <i class="icon-cogs"></i>
        </button>
    </div>

    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
        <span class="btn btn-success"></span>

        <span class="btn btn-info"></span>       

        <span class="btn btn-warning"></span>

        <span class="btn btn-danger"></span>
    </div>
</div>
<!-- #sidebar-shortcuts -->
<ul class="nav nav-list">
    <li <%if ("adControl".equalsIgnoreCase(_currentMenuOpen)) {%> class="active open" <%}%>>
        <a href="#" class="dropdown-toggle">
            <i class="icon-desktop"></i> <span class="menu-text"> 我的挂账资产 </span>
            <b class="arrow icon-angle-down"></b>
        </a>
        <ul class="submenu">
		    <li <%if ("assetsList".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
		        <a href="/assetsList">
		            <i class="icon-dashboard"></i>
		            <span class="menu-text"> 资产一览表</span>
		        </a>
		    </li>
		    <li <%if ("classificationList".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
		        <a href="/classificationList">
		            <i class="icon-table"></i>
		           	<span class="menu-text"> 查看资产分类</span>
		        </a>
		    </li>
        </ul>
    </li>

    <li <%if ("adControl".equalsIgnoreCase(_currentMenuOpen)) {%> class="active open" <%}%>>
        <a href="#" class="dropdown-toggle">
            <i class="icon-desktop"></i> <span class="menu-text"> 资产分类管理 </span>
            <b class="arrow icon-angle-down"></b>
        </a>

        <ul class="submenu">
            <li <%if ("classificationAdd".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
                <a href="/classificationAdd">
                    <i class="icon-plus"></i>添加资产分类
                </a>
            </li>
            <li <%if ("classificationEditList".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
                <a href="/classificationEditList">
                    <i class="icon-edit"></i>编辑资产分类
                </a>
            </li>            
        </ul>
    </li>
    
    <li <%if ("adControl".equalsIgnoreCase(_currentMenuOpen)) {%> class="active open" <%}%>>
        <a href="#" class="dropdown-toggle">
            <i class="icon-desktop"></i> <span class="menu-text"> 挂账资产管理 </span>
            <b class="arrow icon-angle-down"></b>
        </a>

        <ul class="submenu">
            <li <%if ("assetsAdd".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
                <a href="/assetsAdd">
                    <i class="icon-plus"></i>添加资产信息
                </a>
            </li>
            <li <%if ("assetsEditList".equalsIgnoreCase(_currentMenu)) {%> class='active' <%}%>>
                <a href="/assetsEditList">
                    <i class="icon-edit"></i>编辑资产信息
                </a>
            </li>
        </ul>
    </li>    
    
</ul><!-- /.nav-list -->