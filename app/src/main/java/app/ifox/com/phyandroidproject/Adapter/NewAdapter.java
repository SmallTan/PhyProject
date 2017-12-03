package app.ifox.com.phyandroidproject.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import app.ifox.com.phyandroidproject.R;
import app.ifox.com.phyandroidproject.model.New;

/**
 * Created by 13118467271 on 2017/11/30.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewView> {

    private Context context;
    private List<New> aNew;
    private String newTitleText;
    private String newSynopsisText;
    private String newAuthorText;
    private int newReplayNum;
    private OnItemClickListener mOnItemClickListener;

    public NewAdapter(Context context, List<New> aNew) {
        this.context = context;
        this.aNew = aNew;
    }

    public NewAdapter(Context context, List<New> aNew, String newTitleText, String newSynopsisText, String newAuthorText, int newReplayNum) {
        this.aNew = aNew;
        this.context = context;
        this.newTitleText = newTitleText;
        this.newAuthorText = newAuthorText;
        this.newSynopsisText = newSynopsisText;
        this.newReplayNum = newReplayNum;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);

    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public NewView onCreateViewHolder(ViewGroup parent, int viewType) {
        NewView newViewHolder = new NewView(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(final NewView holder, final int position) {
        if (aNew != null) {
            holder.newTitle.setText(aNew.get(position).getTitle());
            holder.newSynopsis.setText(aNew.get(position).getSynopsis());
            holder.newAuthor.setText(aNew.get(position).getAuthor());
            holder.newTime.setText(aNew.get(position).getTime());
            holder.newReplay.setText("" + aNew.get(position).getReplayNum());
        }
        if (mOnItemClickListener != null) {
            holder.newItemAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.newItemAll, pos);
                }
            });
            holder.newItemAll.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.newItemAll, pos);
                    return false;
                }
            });
        }
    }
    @Override
    public int getItemCount () {
        return aNew.size();
    }
    class NewView extends RecyclerView.ViewHolder{
        public View mView;
        RelativeLayout newItemAll;
        TextView newTitle;
        TextView newSynopsis;
        TextView newAuthor;
        TextView newTime;
        TextView newReplay;
        public NewView(View itemView) {
            super(itemView);
            mView = itemView;
            newItemAll  = mView.findViewById(R.id.new_item_all);//整体点击的事件
            newTitle = mView.findViewById(R.id.new__item_title);
            newSynopsis = mView.findViewById(R.id.new_item_synopsis);
            newAuthor = mView.findViewById(R.id.new_item_author);
            newTime = mView.findViewById(R.id.new_item_time);
            newReplay = mView.findViewById(R.id.new_item_replay_number);
        }
    }
}




