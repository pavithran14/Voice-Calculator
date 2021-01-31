package com.example.firstone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

public class Calc extends Fragment {
    protected TextView t1,t2;
    protected Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,n00,add,mul,div,sub,eql,per,ac,dot,clear;
    public double a=1 ,s=1 ,m=1 ,d=1 ,p =1;
    public double num1,num2,res;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main,null);
        n1 = view.findViewById(R.id.one);
        n2 = view.findViewById(R.id.two);
        n3 = view.findViewById(R.id.three);
        n4 = view.findViewById(R.id.four);
        n5 = view.findViewById(R.id.five);
        n6 = view.findViewById(R.id.six);
        n7 = view.findViewById(R.id.seven);
        n8 = view.findViewById(R.id.eight);
        n9 = view.findViewById(R.id.nine);
        n0 = view.findViewById(R.id.z1);
        n00 = view.findViewById(R.id.z2);
        add = view.findViewById(R.id.add);
        sub = view.findViewById(R.id.sub);
        mul = view.findViewById(R.id.mul);
        div = view.findViewById(R.id.div);
        eql = view.findViewById(R.id.eq);
        per = view.findViewById(R.id.per);
        ac = view.findViewById(R.id.ac);
        t1=view.findViewById(R.id.txt_input);
        t2=view.findViewById(R.id.txt_result);
        dot = view.findViewById(R.id.dot);
        clear = view.findViewById(R.id.clear);
        ac = view.findViewById(R.id.ac);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"1");
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"2");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"3");
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"4");
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"5");
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"6");
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"7");
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"9");
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"0");
            }
        });
        n00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+"00");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(t2.getText()+".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= t2.getText().toString();
                if(s.length()>=1) {
                    String str = s.substring(0, s.length() - 1);
                    t2.setText(str);
                }
                else {
                    t2.setText("");
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                t2.setText("");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=0;
                num1 = Double.parseDouble(t2.getText().toString());
                t1.setText(t2.getText()+"+");
                t2.setText("");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=0;
                num1 = Double.parseDouble(t2.getText().toString());
                t1.setText(t2.getText()+"-");
                t2.setText("");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m=0;
                num1 = Double.parseDouble(t2.getText().toString());
                t1.setText(t2.getText()+"*");
                t2.setText("");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=0;
                num1 = Double.parseDouble(t2.getText().toString());
                t1.setText(t2.getText()+"/");
                t2.setText("");
            }
        });
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=0;
                num1 = Double.parseDouble(t2.getText().toString());
                t1.setText(t2.getText()+"%");
                t2.setText("");
            }
        });
        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0) {
                    num2 = Double.parseDouble(t2.getText() + "");
                    t1.setText(t1.getText()+""+t2.getText());t2.setText("");
                    res = num1 + num2; int r =(int) res;
                    if( (res % r)==0)
                        t2.setText( r+"");
                    else
                        t2.setText( res+"");
                    a = 1;
                }
                if (s == 0) {
                    num2 = Double.parseDouble(t2.getText() + "");
                    t1.setText(t1.getText()+""+t2.getText()); t2.setText("");
                    res = num1 - num2; int r =(int) res;
                    if( (res % r)==0)
                        t2.setText( r+"");
                    else
                        t2.setText( res+"");
                    s = 1;
                }
                if (m == 0) {
                    num2 = Double.parseDouble(t2.getText() + "");
                    t1.setText(t1.getText()+""+t2.getText());t2.setText("");
                    res = num1 * num2;  int r =(int) res;
                    if( (res % r)==0)
                        t2.setText( r+"");
                    else
                        t2.setText( res+"");
                    m = 1;
                }
                if (d == 0) {
                    num2 = Double.parseDouble(t2.getText() + "");
                    t1.setText(t1.getText()+""+t2.getText()); t2.setText("");
                    res = num1 / num2;
                    int r =(int) res;
                    if( (res % r)==0)
                        t2.setText( r+"");
                    else
                        t2.setText( res+""); d = 1;
                }
                if (p == 0) {
                    num2 = Double.parseDouble(t2.getText() + "")/100;
                    t1.setText(t1.getText()+""+t2.getText());
                    t2.setText("");
                    res = num1 * num2;
                    int r =(int) res;
                    if( (res % r)==0)
                        t2.setText( r+"");
                    else
                        t2.setText( res+"");
                    p = 1;
                }
            }
        });
        return view;
    }
}


