package app.ifox.com.phyandroidproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment2 extends Fragment {
    private Context context;
    private RefreshLayout postRefreshLayout;
    private RecyclerView postRecycle;
    private FloatingActionButton fAButton;
    public MyFragment2() {
    }
    @SuppressLint("ValidFragment")
    public MyFragment2(Context context){
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_activity,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        postRefreshLayout = view.findViewById(R.id.post_refreshLayout);
        postRecycle = view.findViewById(R.id.post_rcycle);
        fAButton = view.findViewById(R.id.post_add);
        postRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //这里实现加载最新数据
                refreshlayout.finishRefresh(2000);
            }
        });
        postRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                //实现加载更多数据
                refreshlayout.finishLoadmore(2000);
            }
        });
    }
}
