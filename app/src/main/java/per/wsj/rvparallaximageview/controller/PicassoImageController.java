package per.wsj.rvparallaximageview.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import per.wsj.lib.controller.BaseImageController;


/**
 * 使用Picasso加载图片
 */

public class PicassoImageController extends BaseImageController {

    private Context mContext;

    private String imageUrl;

    public PicassoImageController(Context context, String imageUrl) {
        this.mContext = context;
        this.imageUrl = imageUrl;
    }

    @Override
    protected void loadImage(int viewWidth) {
        if (imageUrl.isEmpty()) {
            return;
        }

        Picasso.with(mContext)
                .load(imageUrl)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        handleBitmap(viewWidth, bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }

}
