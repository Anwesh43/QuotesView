package com.anwesome.ui.quotesview;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by anweshmishra on 20/01/17.
 */
public class QuotesView extends View{
    private Bitmap backgroundImage,profile;
    private String text;
    private int color = Color.BLACK;

    public Bitmap getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Bitmap backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Bitmap getProfile() {
        return profile;
    }

    public void setProfile(Bitmap profile) {
        this.profile = profile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public QuotesView(Context context, Bitmap backgroundImage, Bitmap profile,String text,int color) {
        super(context);
        this.backgroundImage = backgroundImage;
        this.profile = profile;
        this.text = text;
        this.color = color;
    }
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int w = canvas.getWidth(),h = canvas.getHeight();
        if(backgroundImage!=null) {
            canvas.drawBitmap(backgroundImage,new Rect(0,0,backgroundImage.getWidth(),backgroundImage.getHeight()),new RectF(0,0,w,h),paint);
        }
        int r = Color.red(color),g = Color.green(color),b = Color.blue(color);
        paint.setColor(Color.argb(170,r,g,b));
        canvas.drawRect(0,0,w,h,paint);
        String tokens[] = text.split(" ");
        String msg = "\"";
        paint.setTextSize(w/9);
        paint.setColor(Color.parseColor("#E0E0E0"));
        int x = w/6,y = h/4;
        for(String token:tokens) {
            if(paint.measureText(msg+token) > 2*w/3) {
                canvas.drawText(msg,x,y,paint);
                y+=w/8;
                msg = token+" ";
            }
            else {
                msg = msg+token+" ";
            }
        }
        msg = msg+"\"";
        canvas.drawText(msg,x,y,paint);
        y+=w/8;
        if(profile!=null) {
            Path path = new Path();
            path.addCircle(w/2,y,profile.getWidth()/2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.drawBitmap(profile,w/2-profile.getWidth()/2,y-profile.getHeight()/2,paint);
        }
    }
}
