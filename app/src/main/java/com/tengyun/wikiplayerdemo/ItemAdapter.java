package com.tengyun.wikiplayerdemo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/1/7.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VideoViewHolder>{

    private Context context;
    private List<Entity.ItemsEntity> list;

    public ItemAdapter(Context context, List<Entity.ItemsEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        VideoViewHolder holder = new VideoViewHolder(view);
        
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

        Entity.ItemsEntity entity = list.get(position);
        holder.content.setText(entity.getContent());
        holder.pic.setImageURI(Uri.parse(entity.getPic_url()));

    }

    public void addAll(Collection<? extends Entity.ItemsEntity> collection){
        int size = list.size();
        list.addAll(collection);
        notifyItemRangeInserted(size,collection.size());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{

        private  TextView content;
        private  SurfaceView surfaceView;
        private SimpleDraweeView pic;

        public VideoViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.item_text);
            surfaceView = (SurfaceView) itemView.findViewById(R.id.surface);
            pic = (SimpleDraweeView) itemView.findViewById(R.id.item_pic);
            //设置图片资源
            pic.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
            //设置高宽比
            pic.setAspectRatio(1);
        }
    }
}
