package app.ifox.com.phyandroidproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.ifox.com.phyandroidproject.model.New;

/**
 * Created by 13118467271 on 2017/11/30.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewView>{

    private Context context;
    private New[] aNew;
    private String newTitleText;
    private String newSynopsisText;
    private String newAuthorText;
    private int newReplayNum;

    public NewAdapter(Context context,New[] aNew){
        this.context = context;
        this.aNew = aNew;
    }
    public NewAdapter(Context context,New[] aNew,String newTitleText,String newSynopsisText,String newAuthorText,int newReplayNum){
        this.aNew = aNew;
        this.context =context;
        this.newTitleText = newTitleText;
        this.newAuthorText = newAuthorText;
        this.newSynopsisText = newSynopsisText;
        this.newReplayNum = newReplayNum;
    }
    @Override
    public NewView onCreateViewHolder(ViewGroup parent, int viewType) {
        NewView newViewHolder = new NewView(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false));
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(NewView holder, final int position) {
        final View view = holder.mView;
        RelativeLayout newItemAll  = view.findViewById(R.id.new_item_all);//整体点击的事件
        TextView newTitle = view.findViewById(R.id.new__item_title);
        TextView newSynopsis = view.findViewById(R.id.new_item_synopsis);
        TextView newAuthor = view.findViewById(R.id.new_item_author);
        TextView newTime = view.findViewById(R.id.new_item_time);
        TextView newReplay = view.findViewById(R.id.new_item_replay_number);
        if (aNew != null) {
            newTitle.setText(aNew[position].getTitle());
            newSynopsis.setText(aNew[position].getSynopsis());
            newAuthor.setText(aNew[position].getHtmlContent());
            newTime.setText(aNew[position].getTime());
            newReplay.setText(aNew[position].getReplayNum());
        }
        newItemAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "第" + position + "条新闻", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return aNew.length;
    }

    public static class NewView extends RecyclerView.ViewHolder{
        public View mView;
        public NewView(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}
