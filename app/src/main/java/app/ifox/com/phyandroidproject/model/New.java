package app.ifox.com.phyandroidproject.model;

/**
 * Created by 13118467271 on 2017/11/30.
 */

public class New {
    private String title;//新闻的标题
    private String synopsis;//新闻的简介
    private String htmlContent;//新闻的地址
    private String author;//新闻的发布人
    private int replayNum;//新闻的回复条数
    private String time;//发布时间
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setIntroduction(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReplayNum() {
        return replayNum;
    }

    public void setReplayNum(int replayNum) {
        this.replayNum = replayNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
