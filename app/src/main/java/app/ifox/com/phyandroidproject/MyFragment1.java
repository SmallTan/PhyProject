package app.ifox.com.phyandroidproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.ryane.banner_lib.AdPageInfo;
import com.ryane.banner_lib.AdPlayBanner;
import com.ryane.banner_lib.transformer.FadeInFadeOutTransformer;
import com.ryane.banner_lib.view.TitleView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import app.ifox.com.phyandroidproject.Adapter.NewAdapter;
import app.ifox.com.phyandroidproject.model.New;

import static com.ryane.banner_lib.AdPlayBanner.ImageLoaderType.GLIDE;
import static com.ryane.banner_lib.AdPlayBanner.IndicatorType.POINT_INDICATOR;
import static com.ryane.banner_lib.view.TitleView.Gravity.PARENT_TOP;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment1 extends Fragment {
    private RefreshLayout refreshLayout;
    private AdPlayBanner mAdPlayBanner;
    private RecyclerView newRecycle;
    private Context context;
    private List<New> newList;
    public MyFragment1() {
    }
    @SuppressLint("ValidFragment")
    public MyFragment1(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_activity, container, false);
//        Fresco.initialize(context);
        adPlayoutBanner(view);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        New[] new1 = new New[20];
        for (int i = 0; i < 20; i++) {
            new1[i] = new New();
            new1[i].setTitle("千年古镇迸发新活力 世界互联网大会乌镇峰会探营");
            new1[i].setAuthor("物理与电子工程学院");
            new1[i].setHtmlContent("http//:www.baidu.com");
            new1[i].setIntroduction("互联网基因植入千年水乡，浙江乌镇再一次汇集全球目光。第四届世界互联网大会将于12月3日至5日在乌镇举行，互联网进入乌镇时间。");
            new1[i].setReplayNum(i);
            new1[i].setTime("" + i + 1);
        }

        newList = new ArrayList<New>();
        for (int i = 0; i < 20; i++) {
            newList.add(new1[i]);
        }
    }

    //轮播图实现
    private void adPlayoutBanner(View view) {
        List<AdPageInfo> mDatas = new ArrayList<>();
        AdPageInfo info1 = new AdPageInfo("拜仁球场冠绝全球", "http://onq81n53u.bkt.clouddn.com/photo1.jpg", "http://www.bairen.com", 1);
        AdPageInfo info2 = new AdPageInfo("日落东单一起战斗", "http://onq81n53u.bkt.clouddn.com/photo2.jpg", "http://www.riluodongdan.com", 4);
        AdPageInfo info3 = new AdPageInfo("香港夜景流连忘返", "http://onq81n53u.bkt.clouddn.com/photo3333.jpg", "http://www.hongkong.com", 2);
        AdPageInfo info4 = new AdPageInfo("耐克大法绝顶天下", "http://7xrwkh.com1.z0.glb.clouddn.com/1.jpg", "http://www.nike.com", 3);

        mDatas.add(info1);
        mDatas.add(info2);
        mDatas.add(info3);
        mDatas.add(info4);

        mAdPlayBanner = view.findViewById(R.id.play_banner);


        mAdPlayBanner
                .setImageLoadType(GLIDE)
                .setOnPageClickListener(new AdPlayBanner.OnPageClickListener() {
                    @Override
                    public void onPageClick(AdPageInfo info, int postion) {
                        Toast.makeText(context, "你点击了图片 " + info.getTitle() + "\n 跳转链接为：" + info.getClickUlr() + "\n 当前位置是：" + postion +"\n 当前优先级是：" + info.getOrder(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setAutoPlay(true)
                .setIndicatorType(POINT_INDICATOR)
                .setNumberViewColor(0xcc00A600, 0xccea0000, 0xffffffff)
                .setInterval(3000)
                .addTitleView(new TitleView(context).setPosition(PARENT_TOP).setTitlePadding(5, 5, 5, 5).setTitleMargin(0, 0, 0, 25).setTitleSize(16).setViewBackground(0x55000000).setTitleColor(getResources().getColor(R.color.white)))
                .setBannerBackground(0xff000000)
                .setPageTransfromer(new FadeInFadeOutTransformer())
                .setInfoList((ArrayList<AdPageInfo>) mDatas)
                .setUp();

    }


    private void initView(View view) {
        refreshLayout = view.findViewById(R.id.refreshLayout);
        newRecycle = view.findViewById(R.id.news_message_relative);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //这里实现加载最新数据
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                //实现加载更多数据
                refreshlayout.finishLoadmore(2000);
            }
        });
        InitNew();
    }

    private void InitNew() {
        newRecycle.setLayoutManager(new LinearLayoutManager(context));
        newRecycle.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        newRecycle.setItemAnimator(new DefaultItemAnimator());
        NewAdapter newAdapter = new NewAdapter(context,newList);
        newRecycle.setAdapter(newAdapter);

    }
}
