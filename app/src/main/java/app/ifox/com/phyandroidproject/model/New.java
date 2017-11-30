package app.ifox.com.phyandroidproject.model;

/**
 * Created by 13118467271 on 2017/11/30.
 */

public class New {
    private String title;//新闻的标题
    private String introduction;//新闻的简介
    private String htmlContent;//新闻的地址

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
