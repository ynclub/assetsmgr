package com.travel.service;

import java.util.List;

import com.travel.model.Menu;

public interface MenuManager {
    public List<Menu> getAllMenus();

    public List<Menu> getMenusByMidCid(String mid, String cid);

    public Menu getMenuByMid(String mid);

    public int addMenu(int cid, String mname, String mtype, String beginusedate, String assetcoding, float orivalue, float depreciation, float netvalue, String person);

    public int updateMenuByMid(int mid, int cid, String mname, String mtype, String beginusedate, String assetcoding, float orivalue, float depreciation, float netvalue, String person);

    public int deleteMenuByMid(int mid);
}
