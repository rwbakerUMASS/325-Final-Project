package com.team17.ilost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostingPage extends AppCompatActivity {

    ImageView image;
    ImageView rightArrow;
    ImageView leftArrow;
    TextView postingBody;

    int images[];
    ArrayList<Bitmap> imgs;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting_page);

        images = new int[]{R.drawable.laptop1, R.drawable.laptop1_brand, R.drawable.laptop1_label, R.drawable.laptop1_oof, R.drawable.laptop1_ski};
        imgs = new ArrayList<>();
        for (int img:images) {
            imgs.add(decodeSampledBitmapFromResource(getResources(),img,200,200));
        }

        postingBody=findViewById(R.id.postingBody);
        postingBody.setText("" +
                "Color: Silver\n" +
                "Brand: Lenovo\n" +
                "Location: Basement of Library\n" +
                "Description: Has ski and board club sticker and another sticker that says oof under the keyboard");

        image=findViewById(R.id.postingImage);
        rightArrow=findViewById(R.id.rightArrow);
        leftArrow=findViewById(R.id.leftArrow);
        image.setImageResource(R.drawable.laptop1);
        rightArrow.setImageResource(R.drawable.arrow_forward);
        leftArrow.setImageResource(R.drawable.arrow_back);

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i>=images.length){i=0;}
                image.setImageBitmap(imgs.get(i));
            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if(i<0){i=images.length-1;}
                image.setImageBitmap(imgs.get(i));
            }
        });


    }

    static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    static int calculateInSampleSize( BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int inSampleSize = 1;   //Default subsampling size
        // See if image raw height and width is bigger than that of required view
        if (options.outHeight > reqHeight || options.outWidth > reqWidth) {
            //bigger
            final int halfHeight = options.outHeight / 2;
            final int halfWidth = options.outWidth / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}