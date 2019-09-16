package com.travel.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.MenuDAO;
import com.travel.model.Menu;
import com.travel.service.MenuManager;

import java.util.Date;
import java.util.List;

@Service
public class MenuManagerImpl implements MenuManager {
    Logger logger = Logger.getLogger(MenuManagerImpl.class);

    @Autowired
    MenuDAO menuDAO;

    public List<Menu> getAllMenus() {
        return menuDAO.getAllMenus();
    }

    public List<Menu> getMenusByMidCid(String mid, String cid) {
        return menuDAO.getMenuByMidCid(mid, cid);
    }

    public Menu getMenuByMid(String mid) {
        List<Menu> menus = menuDAO.getMenuByMidCid(mid, "%");

        if (menus == null) { //如果是空直接返回null
            logger.info("查询assets无返回接口，请检查后台是否出错！");
            return null;
        }

        int size = menus.size();

        if (size == 0) {
            logger.info("资产查询返回结果为空 mid = " + mid);
            return null;
        } else if (size > 1) {
            logger.error("DB mid 重复 mid = " + mid);
            return null;
        }

        return menus.get(0);
    }

    public int addMenu(int cid, String mname, String mtype, String beginusedate, String assetcoding, float orivalue, float depreciation, float netvalue, String person) {
        logger.info("添加资产 cid = " + cid + ", mname = " + mname + ", netvalue = " + netvalue);
        return menuDAO.addMenu(cid, mname, mtype, beginusedate, assetcoding, orivalue, depreciation, netvalue, person);
    }

    public int updateMenuByMid(int mid,int cid,String mname,String mtype,String beginusedate,String assetcoding,float orivalue,float depreciation,float netvalue, String person) {
        logger.info("更新资产详情 cid = " + cid + ", mname = " + mname + ", netvalue = " + netvalue);
        return menuDAO.updateMenuByMid(mid,cid, mname, mtype, beginusedate, assetcoding, orivalue, depreciation, netvalue, person);
    }

    public int deleteMenuByMid(int mid) {
        int inpactRowNum = menuDAO.deleteMenuByMid(mid);
        if (inpactRowNum == 1) {
            logger.info("对应资产已被删除，mid = " + mid);
        } else {
            logger.info("对应资产删除失败, mid = " + mid);
        }
        return inpactRowNum;
    }
}
