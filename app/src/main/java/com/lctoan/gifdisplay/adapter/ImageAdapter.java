package com.lctoan.gifdisplay.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lctoan.gifdisplay.R;
import com.lctoan.gifdisplay.model.MyImage;

import java.util.List;
import java.util.Random;

/**
 * Created by hehe on 18/03/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    List<MyImage> myImageList;
    Context mContext;
    int mWidth;

    public ImageAdapter(Context context, List<MyImage> myImages, int width) {
        myImageList = myImages;
        mContext = context;
        mWidth = width;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        DraweeController controller =
//                Fresco.newDraweeControllerBuilder()
//                        .setUri("http://i.imgur.com/szktB.gif")
//                        .setAutoPlayAnimations(true)
//                        .build();
//        holder.simpleDraweeView.setController(controller);
        //500x278
        Glide.with(mContext)
                .load("http://i.imgur.com/szktB.gif")
                .asGif()
                .into(holder.imgView);

//        android.view.ViewGroup.LayoutParams layoutParams = holder.imgView.getLayoutParams();
//        Random r = new Random();
//        int i1 = r.nextInt(3 - 0) + 0;
//        layoutParams.height = (mWidth / 500) * 278*i1;
//        holder.imgView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return myImageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//                SimpleDraweeView simpleDraweeView;
        ImageView imgView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.my_drawee_view);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
        }
    }
}
