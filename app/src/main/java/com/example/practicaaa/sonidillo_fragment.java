package com.example.practicaaa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sonidillo_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sonidillo_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sonidillo_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sonidillo_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sonidillo_fragment newInstance(String param1, String param2) {
        sonidillo_fragment fragment = new sonidillo_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;
    MediaPlayer mp;
    ImageButton playpause;
    ImageButton btnatras;
    ImageButton btnadelante;
    ImageButton btnstop;
    TextView tvGenero;
    ImageButton portada;
    TextView titulo;
    Boolean play = false;
    Integer contador = 0;
    String genero = "Ibai";
    String url = "";

    CountDownTimer timer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sonidillo_fragment,container,false);

        playpause = view.findViewById(R.id.playpause);
        tvGenero = view.findViewById(R.id.txvGenero);
        portada = view. findViewById(R.id.ImgPortada);
        titulo = view.findViewById(R.id.TituloCancion);

        btnatras = view.findViewById(R.id.imageButton);
        btnadelante = view.findViewById(R.id.imageButton3);
        btnstop = view.findViewById(R.id.imageButton4);

        tvGenero.setText(genero);
        mp = MediaPlayer.create(getActivity(),R.raw.cuarteto);
        Reproducir(contador,genero);

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playpause();
            }
        });
        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retroceder();
            }
        });
        btnadelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Avanzar();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stop();
            }
        });

        portada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/ibaillanos/?hl=es"));
                startActivity(intent);
            }
        });

        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        if(play)
        {
            playpause.setImageResource(R.drawable.play);
            play = false;
            mp.pause();
            timer.cancel();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        playpause.setImageResource(R.drawable.pausa);
        play = true;
        mp.start();
    }
    public void startTimer()
    {
        timer = new CountDownTimer(mp.getDuration(),1000) {
            @Override
            public void onTick(long l) { }
            @Override
            public void onFinish() { }
        }.start();
    }

    public void playpause() {
        if(play)
        {
            playpause.setImageResource(R.drawable.play);
            play = false;
            mp.pause();
            timer.cancel();
        }
        else
        {
            playpause.setImageResource(R.drawable.pausa);
            play = true;
            mp.start();

        }
    }
    public void Stop() {
        mp.seekTo(0);
        mp.pause();
        playpause.setImageResource(R.drawable.play);
        play = false;
    }

    public void Avanzar() {

        contador++;
        if(contador == 5)
            contador = 0;
        Reproducir(contador,genero);
    }
    public void Retroceder() {
        contador--;
        if(contador == -1)
            contador = 4;
        Reproducir(contador,genero);
    }
    public void play()
    {
        mp.start();
        playpause.setImageResource(R.drawable.pausa);
        play = true;
    }
    public void Reproducir(Integer nro,String genero)
    {
        switch (nro)
        {
            case 0:
            {
                mp.stop();
                mp = MediaPlayer.create(getActivity(),R.raw.cuarteto);
                play();
                portada.setImageResource(R.drawable.ibai1);
                titulo.setText("El Cuarteto De Ibai");

                url = "https://www.youtube.com/watch?v=NWMRx4G9zjo&ab_channel=Ibai";
                break;
            }
            case 1:
            {
                mp.stop();
                mp = MediaPlayer.create(getActivity(),R.raw.farsante);
                play();
                portada.setImageResource(R.drawable.ibai2);
                titulo.setText("Ibai - Farsante");
                break;
            }
            case 2:
            {
                mp.stop();
                mp = MediaPlayer.create(getActivity(),R.raw.curiosidad);
                play();
                portada.setImageResource(R.drawable.ibai3);
                titulo.setText("Ibai - La Curiosidad");
                break;
            }
            case 3:
            {
                mp.stop();
                mp = MediaPlayer.create(getActivity(),R.raw.amorfada);
                play();
                portada.setImageResource(R.drawable.ibai4);
                titulo.setText("Ibai - Amorfoda");
                break;
            }
            case 4:
            {
                mp.stop();
                mp = MediaPlayer.create(getActivity(),R.raw.monamour);
                play();
                portada.setImageResource(R.drawable.ibai5);
                titulo.setText("Ibai - Mon Amour");
                break;
            }
            default:{}
        }
        startTimer();
    }

}