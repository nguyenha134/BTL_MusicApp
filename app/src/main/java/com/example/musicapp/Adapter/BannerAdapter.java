package com.example.musicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.Model.QuangCao;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @androidx.annotation.NonNull View view, @NonNull @androidx.annotation.NonNull Object o) {
        return view==o;
    }

    @NonNull
    @androidx.annotation.NonNull
    @Override
    public Object instantiateItem(@NonNull @androidx.annotation.NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_layout, null);

        ImageView imgbackgroundbanner = view.findViewById(R.id.imgviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imgviewbanner);
        TextView txttitlesongbanner = view.findViewById(R.id.textviewtitlebannerbaihat);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arrayListBanner.get(position).getHinhanh()).into(imgbackgroundbanner);
        Picasso.with(context).load(arrayListBanner.get(position).getHinhBaiHat()).into(imgsongbanner);
        txttitlesongbanner.setText(arrayListBanner.get(position).getTenBaiHat());
        txtnoidung.setText(arrayListBanner.get(position).getNoidung());
        return view;
    }

    @Override
    public void destroyItem(@NonNull @androidx.annotation.NonNull ViewGroup container, int position, @NonNull @androidx.annotation.NonNull Object object) {
        container.removeView((View) object);
    }
}
