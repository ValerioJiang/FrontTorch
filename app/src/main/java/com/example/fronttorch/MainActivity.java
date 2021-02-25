package com.example.fronttorch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

//TODO
//1 InitViews quindi inizializziamo tutte le componenti messe dal xml nel onCreate
//2 Implementare i onclick tramite o metodo o lambda

public class MainActivity extends AppCompatActivity {

    private Button torchBtn;
    private ConstraintLayout primaryLayout;
    private boolean flagBtn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        torchBtn.setOnClickListener(v -> {
            torchFront();
        });
    }



    private void initViews(){
        torchBtn = findViewById(R.id.torchBtn);
        primaryLayout = findViewById(R.id.primaryLayout);
    }

    private void torchFront(){
        if (flagBtn){
            torchBtn.setBackgroundColor(Color.BLACK);
            setFlagBtn(!flagBtn);
            WindowManager.LayoutParams layout = getWindow().getAttributes();
            layout.screenBrightness = 1F;
            getWindow().setAttributes(layout);
        }
        else{
            torchBtn.setBackgroundColor(Color.RED);
            setFlagBtn(!flagBtn);
            WindowManager.LayoutParams layout = getWindow().getAttributes();
            layout.screenBrightness = 0F;
            getWindow().setAttributes(layout);
        }

    }

    public void setFlagBtn(boolean val){
        this.flagBtn = val;
    }

    public void setPrimaryLayout(ConstraintLayout primaryLayout) {
        this.primaryLayout = primaryLayout;
    }

}
