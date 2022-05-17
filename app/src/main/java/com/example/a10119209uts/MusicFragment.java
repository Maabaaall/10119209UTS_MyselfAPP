package com.example.a10119209uts;

//09 April 2022, 10119209, Muhammad Iqbal Rosyidin, IF5

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MusicFragment extends Fragment {
    ListView listView;
    String mnama_video[] = {"C.H.R.I.S.Y.E", "Where Are You Now", "Light Switch", "Hati Hati di Jalan", "Runtuh"};
    String mtahun_video[] = {"Diskoria, Laleimanino, Eva Celia","Jack U and Skrillex ft. Justin Bieber", "Charlie Puth", "Tulus", "Feby Putri ft. Fiersa Besari"};
    int mimg_video[] = {R.drawable.diskoria, R.drawable.skrillex, R.drawable.lightswitch
            , R.drawable.tulus,R.drawable.runtuh};

    VideoView videoView;
    //deklarasi objek
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);
        videoView = rootView.findViewById(R.id.videoView);
        listView = rootView.findViewById(R.id.list_view_video);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        //inisialisasi object videoView
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.onepiece));
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoView.setMediaController(new MediaController(getActivity()));
        //menampilkan media controller video
        videoView.start();
        //memulai video

        Adapter_listview adapter_listview = new Adapter_listview(getActivity(),mnama_video, mtahun_video, mimg_video);

        listView.setAdapter(adapter_listview);

        return rootView;
    }

}