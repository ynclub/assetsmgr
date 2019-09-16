<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--head banner--%>
<script type="text/javascript">
    try{ace.settings.check('navbar' , 'fixed')}catch(e){}
</script>
<div class="navbar navbar-default" id="navbar">
    <%--<script type="text/javascript">--%>
        <%--try{ace.settings.check('navbar' , 'fixed')}catch(e){}--%>
    <%--</script>--%>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    <font size="5">挂账资产管理</font><font size="2">---测试持续集成CI-war包自动部署到tomcat容器并运行</font>
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue">
                    <a data-toggle="dropdown">
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
                            <small>欢迎测试</small>
                            持续集成CI
                        </span>
                    </a>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>
