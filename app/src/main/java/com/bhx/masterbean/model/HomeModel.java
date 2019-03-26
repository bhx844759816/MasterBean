package com.bhx.masterbean.model;

import java.util.List;

/**
 * 首页面布局
 */
public class HomeModel {
    public static final int ITME_BANNER = 0;
    public static final int ITME_HOME = 1;
    private HomeItem mHomeItem;
    private BannerItem mBannerItem;
    private int itemType;

    public HomeItem getHomeItem() {
        return mHomeItem;
    }

    public void setHomeItem(HomeItem mHomeItem) {
        this.mHomeItem = mHomeItem;
    }

    public BannerItem getBannerItem() {
        return mBannerItem;
    }

    public void setBannerItem(BannerItem mBannerItem) {
        this.mBannerItem = mBannerItem;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public static class HomeItem {
        private String name;
    }

    public static class BannerItem {
        List<String> urls;
        List<Integer> resIds;//资源ID

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public List<Integer> getResIds() {
            return resIds;
        }

        public void setResIds(List<Integer> resIds) {
            this.resIds = resIds;
        }
    }
}
