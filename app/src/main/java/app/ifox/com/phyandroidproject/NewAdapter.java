package app.ifox.com.phyandroidproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import app.ifox.com.phyandroidproject.model.New;

/**
 * Created by 13118467271 on 2017/11/30.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewView>{

    private Context context;
    private New aNew;

    public NewAdapter(Context context,New aNew){
        this.context = context;
        this.aNew = aNew;
    }
    @Override
    public NewView onCreateViewHolder(ViewGroup parent, int viewType) {
        NewView newViewHolder = new NewView(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false));
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(NewView holder, int position) {
        final View view = holder.mView;
        RelativeLayout newItemAll  = view.findViewById(R.id.new_item_all);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NewView extends RecyclerView.ViewHolder{
        public View mView;
        public NewView(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}
