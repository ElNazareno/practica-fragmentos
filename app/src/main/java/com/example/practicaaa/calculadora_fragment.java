package com.example.practicaaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicaaa.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calculadora_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calculadora_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calculadora_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calculadora_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static calculadora_fragment newInstance(String param1, String param2) {
        calculadora_fragment fragment = new calculadora_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button a;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private FragmentHomeBinding binding;

    View view;

    TextView txt1;
    TextView txt2;
    String num1,num2;
    String op;
    Boolean operacion = false;
    Boolean decimal = false;
    int error = 0;

    Button punto;
    Button BorrarTodo;
    Button Borrar;
    Button porcentaje;
    Button division;
    Button multiplicar;
    Button menos;
    Button mas;
    Button igual;

    Button cero;
    Button uno;
    Button dos;
    Button tres;
    Button cuatro;
    Button cinco;
    Button seis;
    Button siete;
    Button ocho;
    Button nueve;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calculadora_fragment,container,false);

        txt2 = view.findViewById(R.id.textView1);
        txt1 = view.findViewById(R.id.textView2);

        punto = view.findViewById(R.id.btnPunto);
        BorrarTodo= view.findViewById(R.id.btnBorrarTodo);
        Borrar= view.findViewById(R.id.btnBorrar);
        porcentaje= view.findViewById(R.id.btnPorcentaje);
        division= view.findViewById(R.id.btnDivision);
        multiplicar= view.findViewById(R.id.btnMultiplicacion);
        menos= view.findViewById(R.id.btnResta);
        mas= view.findViewById(R.id.btnSuma);
        igual= view.findViewById(R.id.btnIgual);

        cero= view.findViewById(R.id.btn0);
        uno= view.findViewById(R.id.btn1);
        dos= view.findViewById(R.id.btn2);
        tres= view.findViewById(R.id.btn3);
        cuatro= view.findViewById(R.id.btn4);
        cinco= view.findViewById(R.id.btn5);
        seis= view.findViewById(R.id.btn6);
        siete= view.findViewById(R.id.btn7);
        ocho= view.findViewById(R.id.btn8);
        nueve= view.findViewById(R.id.btn9);

        num1 = "";
        num2 = "";
        txt1.setText("0");
        txt2.setText("La calculadora mas bonita desde 2021");
        op = "";

        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!decimal)
                {
                    num1 += ".";
                    decimal = true;
                }
                Escribir();
            }
        });
        BorrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = "";
                num2 = "";
                txt1.setText("0");
                op = "";
                operacion = false;
                decimal = false;
            }
        });
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1 != "")
                {
                    if(num1.substring(num1.length() - 1, num1.length()).equals("."))
                        decimal = false;
                    num1 = num1.substring(0, num1.length() - 1);
                    Escribir();
                }
            }
        });
        porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operacion && op.equals("x"))
                {
                    num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))*(Double.valueOf(num1)*0.01));
                    num2 = "";
                    Escribir();
                    operacion = false;
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opbasicas('/');
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opbasicas('x');
            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opbasicas('-');
            }
        });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opbasicas('+');
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operacion)
                {
                    switch (op)
                    {
                        case "/":
                        {
                            if(Double.valueOf(num1) == 0)
                            {
                                num1 = "NO / 0, Andina, No?";
                                error += 1;
                            }
                            else
                            {
                                num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))/Double.valueOf(num1));
                            }
                        }
                        break;
                        case "x":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))*Double.valueOf(num1));;
                            break;
                        case "-":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))-Double.valueOf(num1));
                            break;
                        case "+":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))+Double.valueOf(num1));;
                            break;
                        default:
                        {
                            num1 = "";
                            num2 = "";
                            txt1.setText("0");
                            op = "";
                            operacion = false;
                            decimal = false;
                            txt1.setText("SYNTAX ERROR");
                        }break;
                    }
                    num2 = "";
                    Escribir();
                    error += 1;
                    decimal = true;
                    operacion = false;
                }
            }
        });

        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='0';
                Escribir();
            }
        });
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='1';
                Escribir();
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='2';
                Escribir();
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='3';
                Escribir();
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='4';
                Escribir();
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='5';
                Escribir();
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='6';
                Escribir();
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='7';
                Escribir();
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='8';
                Escribir();
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1+='9';
                Escribir();
            }
        });


        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void Escribir()
    {
        if(error == 2)
        {
            num1 = "";
            num2 = "";
            txt1.setText("0");
            op = "";
            operacion = false;
            decimal = false;
            error = 0;
        }
        txt1.setText(num1);
        if(num2 != "")
        {
            txt2.setText(num2);
            decimal = false;
        }
        else
            txt2.setText("la calculadora mas bonita desde 2021");
    }
    public void opbasicas(Character ope)
    {
        if(num1.substring(num1.length() - 1, num1.length()).equals("."))
        {
            num1 = num1.substring(0, num1.length() - 1);
            decimal = false;
        }
        if(operacion)
        {
            num2 = num2.substring(0, num2.length() - 1);
            num2 += ope;
        }
        else
        {
            num2 = num1 + ope;
            num1 = "";
            operacion = true;
        }
        op = String.valueOf(ope);
        Escribir();
    }

}
















