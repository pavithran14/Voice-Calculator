package com.example.firstone;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
public class VoiceCalc extends Fragment {
    public ImageView mic; public TextView f1,f2;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v1 = inflater.inflate(R.layout.voice_layout, null);

        f1 = v1.findViewById(R.id.txt_input);
        f2 = v1.findViewById(R.id.txt_result);
        mic = v1.findViewById(R.id.btn_mic);


        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speech();
            }
        });
        return v1;
    }

    private void speech() {
        f2.setText("");
        Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something");
        try
        {
            startActivityForResult(i,2000);
        }
        catch (Exception ex)
        {
            Toast.makeText(getActivity(),"Speech Not Available",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2000 && resultCode==RESULT_OK && data!=null)
        {
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String str = result.get(0);
            f1.setText(str);
            calculation(str);
            Log.e("ARRAY LIST", "onActivityResult: "+result.toString() );
        }
    }

    private void calculation(String str) {
        try {
            String value[] = str.split(" ");
            if(value[value.length - 1].equalsIgnoreCase("prime"))
            {
                float num1 = Float.parseFloat(value[0]);
                int result = isPrime(num1);
                if(result == 0)
                    f2.setText("YES");
                else
                    f2.setText("NO");
            }
            else {
                float num1 = Float.parseFloat(value[0]);
                float num2 = Float.parseFloat(value[value.length - 1]);
                Log.e("Numbers Check ", "Number 1 : " + num1);
                Log.e("Numbers Check ", "Number 2 : " + num2);
                Log.e("Value[1]", "calculation: " + value[1]);

                if (value[1].equalsIgnoreCase("sum") || value[1].equalsIgnoreCase("plus") || value[1].equalsIgnoreCase("+"))
                    f2.setText((num1 + num2) + "");
                else if (value[1].equalsIgnoreCase("subtraction") || value[1].equalsIgnoreCase("minus") || value[1].equalsIgnoreCase("-"))
                    f2.setText((num1 - num2) + "");
                else if (value[1].equalsIgnoreCase("times") || value[1].equalsIgnoreCase("multiply") || value[1].equalsIgnoreCase("x"))
                    f2.setText((num1 * num2) + "");
                else if (value[1].equalsIgnoreCase("divide") || value[1].equalsIgnoreCase("divided") || value[1].equalsIgnoreCase("/"))
                    f2.setText((num1 / num2) + "");
                else if (value[1].equalsIgnoreCase("power")) {
                    double ans = Math.pow(num1, num2);
                    f2.setText(ans + "");
                } else if (value[1].equalsIgnoreCase("mod")) {
                    f2.setText((num1 % num2) + "");
                }
            }
        }
        catch (Exception e)
        {
            f2.setText("Try Again");
        }
    }

    private int isPrime(float num1) {
        int i,flag=0;

        for(i=2;i*i<=num1;i++)
            if(num1%i==0)
            {
                flag = 1;
                break;
            }
        return flag;
    }
}
