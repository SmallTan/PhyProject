package app.ifox.com.phyandroidproject.model;

/**
 * Created by 13118467271 on 2017/12/2.
 */

/**
 * 用来封装轮播图的实体类，用于加载数据时方便使用
 */
public class PlayBanner {
    private String title;
    private String picUrl;
    private String clickUrl;
    private int order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
