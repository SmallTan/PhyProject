package app.ifox.com.phyandroidproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment implements View.OnClickListener {
    private ImageView user_head_image;//头像
    private TextView user_name;//名字
    private RelativeLayout myself_data;//个人信息
    private RelativeLayout myself_comment;//我的评论
    private RelativeLayout myself_setup;
    private RelativeLayout myself_post;//帖子
    private TextView myself_post_num;
    private RelativeLayout myself_collection;//收藏
    private TextView myself_collection_num;
    private RelativeLayout myself_follow;//关注
    private TextView myself_follow_num;
    private RelativeLayout myself_fan;//粉丝
    private TextView myself_fan_num;
    private RelativeLayout myself_relative;//显示部分，同样可以查看自己信息
    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myself_activity,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        user_head_image = view.findViewById(R.id.user_head_image);
        user_name = view.findViewById(R.id.user_name);
        myself_collection = view.findViewById(R.id.myself_collection);
        myself_collection_num = view.findViewById(R.id.myself_collection_num);
        myself_post = view.findViewById(R.id.myself_post);
        myself_post_num = view.findViewById(R.id.myself_post_num);
        myself_follow = view.findViewById(R.id.myself_follow);
        myself_follow_num = view.findViewById(R.id.myself_follow_num);
        myself_fan = view.findViewById(R.id.myself_fan);
        myself_fan_num = view.findViewById(R.id.myself_fans_num);
        myself_data = view.findViewById(R.id.myself_data);
        myself_comment = view.findViewById(R.id.myself_comment);
        myself_setup = view.findViewById(R.id.myself_set_up);
        myself_relative = view.findViewById(R.id.myself_relative);
        myself_relative.setOnClickListener(this);
        user_head_image.setOnClickListener(this);
        myself_collection.setOnClickListener(this);
        myself_post.setOnClickListener(this);
        myself_follow.setOnClickListener(this);
        myself_fan.setOnClickListener(this);
        myself_data.setOnClickListener(this);
        myself_comment.setOnClickListener(this);
        myself_setup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myself_relative:
                Toast.makeText(getContext(), "myself_relative", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_head_image:
                Toast.makeText(getContext(), "userHeadImage", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_collection:
                Toast.makeText(getContext(), "mysefcollection", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_post:
                Toast.makeText(getContext(), "post", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_follow:
                Toast.makeText(getContext(), "follow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_fan:
                Toast.makeText(getContext(), "fan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_data:
                Toast.makeText(getContext(), "data", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_comment:
                Toast.makeText(getContext(), "comment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myself_set_up:
                Toast.makeText(getContext(),"setup",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
