package com.travel.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.model.Menu;
import com.travel.service.CategoryManager;
import com.travel.service.MenuManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
public class AssetsControllor {
    @Autowired
    MenuManager menuManager;

    @Autowired
    CategoryManager categoryManager;

    Logger logger = Logger.getLogger(AssetsControllor.class);

    /**
     * 展示资产
     *
     * @param model
     * @param mid     资产id （查询用）
     * @param cid     资产分类id （查询用）
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetsList")
    public String assetsList(Model model,
                            @RequestParam(value = "mid", required = false) String mid,
                            @RequestParam(value = "cid", required = false) String cid,
                            @RequestParam(value = "useCookie", required = false) String useCookie,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        logger.info("mid = " + mid);
        logger.info("cid = " + cid);
        logger.info("useCookie = " + useCookie);

        //判断mid cid为空的情形
        if (mid == null || mid.equalsIgnoreCase("") || mid.equalsIgnoreCase("all")) {
            mid = "%";
        }
        if (cid == null || cid.equalsIgnoreCase("") || cid.equalsIgnoreCase("all")) {
            cid = "%";
        }

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        model.addAttribute("menus", menuManager.getMenusByMidCid(mid, cid));
        session.setAttribute("categoryManager", categoryManager);



        //配置cookie
        if(useCookie != null && useCookie.equalsIgnoreCase("on")){
            int expire = 3600 * 24 * 30; //如果使用cookie，则将过期时间设为1个月
            logger.info("用户选择使用cookie，进入使用cookies的控制逻辑！");
            Cookie ckUseCookie = new Cookie("ckUseCookie","on");
            Cookie ckCid = new Cookie("ckCid",cid);
            ckUseCookie.setMaxAge(expire);
            ckCid.setMaxAge(expire);

            response.addCookie(ckUseCookie);
            response.addCookie(ckCid);
        }else{
            int expire = -1; //如果使用cookie，则将过期时间设为-1 控制该cookie立刻过期
            logger.info("用户没有选择使用cookie，进入不使用cookies的控制逻辑！");
            Cookie ckUseCookie =new Cookie("ckUseCookie","");
            Cookie ckCid =new Cookie("ckCid","");
            ckUseCookie.setMaxAge(expire);
            ckCid.setMaxAge(expire);

            response.addCookie(ckUseCookie);
            response.addCookie(ckCid);
        }

        logger.info("Session Id = " + sessionId);
        return "jsp/assetsList.jsp";
        
    }
    
    /**
     * 展示资产
     *
     * @param model
     * @param mid     资产id （查询用）
     * @param cid     资产分类id （查询用）
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetsEditList")
    public String assetsEditList(Model model,
                            @RequestParam(value = "mid", required = false) String mid,
                            @RequestParam(value = "cid", required = false) String cid,
                            @RequestParam(value = "useCookie", required = false) String useCookie,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        logger.info("mid = " + mid);
        logger.info("cid = " + cid);
        logger.info("useCookie = " + useCookie);

        //判断mid cid为空的情形
        if (mid == null || mid.equalsIgnoreCase("") || mid.equalsIgnoreCase("all")) {
            mid = "%";
        }
        if (cid == null || cid.equalsIgnoreCase("") || cid.equalsIgnoreCase("all")) {
            cid = "%";
        }

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        model.addAttribute("menus", menuManager.getMenusByMidCid(mid, cid));
        session.setAttribute("categoryManager", categoryManager);



        //配置cookie
        if(useCookie != null && useCookie.equalsIgnoreCase("on")){
            int expire = 3600 * 24 * 30; //如果使用cookie，则将过期时间设为1个月
            logger.info("用户选择使用cookie，进入使用cookies的控制逻辑！");
            Cookie ckUseCookie = new Cookie("ckUseCookie","on");
            Cookie ckCid = new Cookie("ckCid",cid);
            ckUseCookie.setMaxAge(expire);
            ckCid.setMaxAge(expire);

            response.addCookie(ckUseCookie);
            response.addCookie(ckCid);
        }else{
            int expire = -1; //如果使用cookie，则将过期时间设为-1 控制该cookie立刻过期
            logger.info("用户没有选择使用cookie，进入不使用cookies的控制逻辑！");
            Cookie ckUseCookie =new Cookie("ckUseCookie","");
            Cookie ckCid =new Cookie("ckCid","");
            ckUseCookie.setMaxAge(expire);
            ckCid.setMaxAge(expire);

            response.addCookie(ckUseCookie);
            response.addCookie(ckCid);
        }

        logger.info("Session Id = " + sessionId);
        return "jsp/assetsEditList.jsp";
        
    }    
    

    /**
     * 展示编辑资产页
     *
     * @param model
     * @param mid     资产id
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetsEdit/{mid}", method = RequestMethod.GET)
    public String assetsEdit(Model model,
                           @PathVariable String mid,
                           HttpServletRequest request) {
        logger.info("Start assetsEdit!");
        Menu menu = menuManager.getMenuByMid(mid);
        HttpSession session = request.getSession();

        model.addAttribute("menu", menu);
        session.setAttribute("categoryManager", categoryManager);
        return "jsp/assetsEdit.jsp";
    }

    /**
     * 展示添加资产页
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetsAdd", method = RequestMethod.GET)
    public String assetsAdd(Model model, HttpServletRequest request) {
        logger.info("Start assetsAdd!");
        HttpSession session = request.getSession();

        session.setAttribute("categoryManager", categoryManager);
        return "jsp/assetsAdd.jsp";
    }

    /**
     * 保存资产 （新建或更新）
     * @param model
     * @param request
     * @param mid
     * @param cid
     * @param mname
     * @param mtype
     * @param beginusedate
     * @param assetcoding
     * @param orivalue
     * @param depreciation
     * @param netvalue
     * @param person
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/assetsSave", method = RequestMethod.POST)
    public String assetsSave(Model model,
                           HttpServletRequest request,
                           @RequestParam(value = "assetcoding", required = true) String assetcoding,
                           @RequestParam(value = "mid", required = true) int mid,
                           @RequestParam(value = "new_cid", required = true) int cid,
                           @RequestParam(value = "mname", required = true) String mname,
                           @RequestParam(value = "mtype", required = true) String mtype,
                           @RequestParam(value = "beginusedate", required = true) String beginusedate,
                           @RequestParam(value = "orivalue", required = true) float orivalue,
                           @RequestParam(value = "depreciation", required = true) float depreciation,
                           @RequestParam(value = "netvalue", required = true) float netvalue,
                           @RequestParam(value = "person", required = true) String person) throws UnsupportedEncodingException {
   	
    	
        if (mname != null && !mname.equalsIgnoreCase("")) {
            mname = new String(mname.getBytes("ISO-8859-1"), "utf8");
        }
        
        if (mtype != null && !mtype.equalsIgnoreCase("")) {
        	mtype = new String(mtype.getBytes("ISO-8859-1"), "utf8");
        }        

        if (mid >= 1) {
            logger.info("保存资产更新！");
            logger.info("Request Param: mid = " + mid);
            logger.info("Request Param: cid = " + cid);
            logger.info("Request Param: mname = " + mname);
            logger.info("Request Param: mtype = " + mtype);
            logger.info("Request Param: beginusedate = " + beginusedate);
            logger.info("Request Param: assetcoding = " + assetcoding);
            logger.info("Request Param: orivalue = " + orivalue);
            logger.info("Request Param: depreciation = " + depreciation);
            logger.info("Request Param: netvalue = " + netvalue);
            logger.info("Request Param: person = " + person);
            menuManager.updateMenuByMid(mid, cid, mname, mtype, beginusedate, assetcoding, orivalue, depreciation, netvalue, person);
        } else if (mid == -1) {
            logger.info("添加新资产！");
            logger.info("Request Param: cid = " + cid);
            logger.info("Request Param: mname = " + mname);
            logger.info("Request Param: mtype = " + mtype);
            logger.info("Request Param: beginusedate = " + beginusedate);
            logger.info("Request Param: assetcoding = " + assetcoding);
            logger.info("Request Param: orivalue = " + orivalue);
            logger.info("Request Param: depreciation = " + depreciation);
            logger.info("Request Param: netvalue = " + netvalue);
            logger.info("Request Param: person = " + person);
            menuManager.addMenu(cid, mname, mtype, beginusedate, assetcoding, orivalue, depreciation, netvalue, person);
        } else {
            logger.error("出错了，mid 不正确！");
        }

        HttpSession session = request.getSession();
        model.addAttribute("menus", menuManager.getAllMenus());
        session.setAttribute("categoryManager", categoryManager);
        return "jsp/assetsEditList.jsp";
    }

    /**
     * 删除资产
     *
     * @param model
     * @param mid     资产id
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetsDelete/{mid}", method = RequestMethod.GET) //按照ID展示
    public String assetsDelete(Model model,
                             @PathVariable int mid,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        menuManager.deleteMenuByMid(mid); //删除对应menu

        HttpSession session = request.getSession();
        model.addAttribute("menus", menuManager.getAllMenus());
        session.setAttribute("categoryManager", categoryManager);

        return "/assetsEditList";
    }

    /**
     * 展示所有资产分类
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/classificationList")
    public String classificationList(Model model) {
        model.addAttribute("categories", categoryManager.getAllCategories());
        return "jsp/classificationList.jsp";
    }
    
    /**
     * 展示所有资产分类(编辑按钮)
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/classificationEditList")
    public String classificationEditList(Model model) {
        model.addAttribute("categories", categoryManager.getAllCategories());
        return "jsp/classificationEditList.jsp";
    }    

    /**
     * 展示添加资产分类页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/classificationAdd", method = RequestMethod.GET)
    public String classificationAdd(Model model) {
        logger.info("Start addclassification!");
        return "jsp/classificationAdd.jsp";
    }

    /**
     * 修改资产分类
     *
     * @param model
     * @param cid   资产分类id
     * @return
     */
    @RequestMapping(value = "/classificationEdit/{cid}")
    public String classificationEdit(Model model, @PathVariable int cid) {
        model.addAttribute("category", categoryManager.getCategoryById(cid));
        return "jsp/classificationEdit.jsp";
    }

    /**
     * 保存资产分类
     *
     * @param model
     * @param cid   资产分类id
     * @param cname 资产分类名称
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/classificationSave", method = RequestMethod.POST)
    public String classificationSave(Model model,
                               @RequestParam(value = "cid", required = true) int cid,
                               @RequestParam(value = "cname", required = true) String cname) throws UnsupportedEncodingException {
        if (cname != null && !cname.equalsIgnoreCase("")) {
            cname = new String(cname.getBytes("ISO-8859-1"), "utf8");
        }

        if (cid >= 1) {
            logger.info("更新保存资产分类！");
            logger.info("cid = " + cid);
            logger.info("cname = " + cname);
            categoryManager.updateCategoryById(cid, cname);
        } else if (cid == -1) {
            logger.info("添加新资产分类！");
            logger.info("cname = " + cname);
            categoryManager.addCategory(cname);
        } else {
            logger.info("出错了，id 不正确！");
        }
        model.addAttribute("categories", categoryManager.getAllCategories());
        return "jsp/classificationEditList.jsp";
    }

    /**
     * 删除资产分类
     *
     * @param model
     * @param cid   资产分类id
     * @return
     */
    @RequestMapping(value = "/classificationDelete/{cid}")
    public String classificationDeleteById(Model model,
                                     @PathVariable int cid,
                                     HttpServletRequest request) {
        try {
            categoryManager.deleteCategoryById(cid);
        } catch (Exception ex) {
            String errMsg = ex.getMessage();
            logger.info("发生错误无法删除！");
            logger.info(errMsg);
            if (errMsg.contains("MySQLIntegrityConstraintViolationException")) {
                logger.error("存在依赖，不能删除该值");
                String cname = categoryManager.getCategoryById(cid).getCname();
                HttpSession session = request.getSession();
                session.setAttribute("errMsg", "出错啦：\"" + cname + "\"下仍有资产，不能删除该分类！");
            }
        }
        model.addAttribute("categories", categoryManager.getAllCategories());
        return "jsp/classificationEditList.jsp";
    }

}
