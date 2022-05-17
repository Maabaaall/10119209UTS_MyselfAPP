package com.example.a10119209uts;

//09 April 2022, 10119209, Muhammad Iqbal Rosyidin, IF5

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    ImageButton wa_btn,ig_btn,map_btn,info_btn;
    String num = "6282217080988";
    String text = "Hello";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        wa_btn = rootView.findViewById(R.id.wa_btn);
        ig_btn = rootView.findViewById(R.id.ig_btn);
        map_btn = rootView.findViewById(R.id.map_btn);
        info_btn = rootView.findViewById(R.id.about_btn);


        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), "Iqbal App merupakan aplikasi yang dibuat oleh \n Muhammad Iqbal Rosyidin A\n 10119209\n Untuk memenuhi salah satu tugas UTS \n Matkul AKB");
            }
        });

        wa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text"+text));
                startActivity(browserIntent);
            }
        });

        ig_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/maabaaall"));
                startActivity(browserIntent);
            }
        });
        map_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://goo.gl/maps/qTztehiMEJxNcHgv6"));
                startActivity(browserIntent);
            }
        });
        return rootView;
    }
    private boolean isAppInstalled(String s){
        PackageManager packageManager = getActivity().getPackageManager();
        boolean is_installed;
        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;

        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}