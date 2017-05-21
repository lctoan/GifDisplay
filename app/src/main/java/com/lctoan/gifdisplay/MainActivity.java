package com.lctoan.gifdisplay;

import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Display;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.lctoan.gifdisplay.adapter.ImageAdapter;
import com.lctoan.gifdisplay.model.MyImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageAdapter mAdapter;
    List<MyImage> myImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvData = (RecyclerView) findViewById(R.id.rvData);
        myImageList = new ArrayList<>();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        mAdapter = new ImageAdapter(this, myImageList, width);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,1);
        rvData.setLayoutManager(layoutManager);
        rvData.setItemAnimator(new DefaultItemAnimator());
        rvData.setAdapter(mAdapter);

        for (int i = 0; i < 100; i++) {
            myImageList.add(new MyImage());
        }
        mAdapter.notifyDataSetChanged();
//        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_drawee_view);
//        DraweeController controller =
//                Fresco.newDraweeControllerBuilder()
//                        .setUri("http://s3.amazonaws.com/giphygifs/media/4aBQ9oNjgEQ2k/giphy.gif")
//                        .setAutoPlayAnimations(true)
//                        .build();
//
//        simpleDraweeView.setController(controller);
//        ImageView imgView = (ImageView) findViewById(R.id.imgView);
//        Glide.with(this)
//                .load("http://s3.amazonaws.com/giphygifs/media/4aBQ9oNjgEQ2k/giphy.gif")
//                .asGif()
//                .crossFade()
//                .into(imgView);
    }
}
