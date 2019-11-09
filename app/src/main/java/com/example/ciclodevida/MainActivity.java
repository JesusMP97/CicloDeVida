package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "xyz";
    TextView tvHistorial;
    Button b1;
    String history = "";
    int messageCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getStringExtra("history") != null) {
            history = getIntent().getStringExtra("history");
            messageCount = getIntent().getIntExtra("messageCount", 0);
        }

        if(savedInstanceState != null){
            history = savedInstanceState.getString("history");
            messageCount = savedInstanceState.getInt("messageCount");
        }

        messageCount++;
        Log.v(TAG, "Activity 1 OnCreate launched");
        history += messageCount + ". Activity 1 OnCreate launched\n";

        initComponents();
        initEvents();
    }

    private void initComponents() {
        tvHistorial = findViewById(R.id.tvHistorial);
        b1 = findViewById(R.id.btAct2);
    }


    private void initEvents() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad(Main2Activity.class);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle guardaEstado) {
        super.onSaveInstanceState(guardaEstado);
        guardaEstado.putString("history", history);
        guardaEstado.putInt("messageCount", messageCount);
    }

    private void actualizarHistorial() {
        tvHistorial.setText(history);
    }

    private void lanzarActividad(Class clase) {
        Intent i = new Intent(this, clase);
        i.putExtra("history", history);
        i.putExtra("messageCount", messageCount);
        startActivity(i);
    }

    protected void onStart() {
        super.onStart();
        Log.v(TAG, "Activity 1 onStart launched");
        messageCount++;
        history += messageCount + ". Activity 1 OnStart launched\n";
    }

    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Activity 1 onResume launched");
        messageCount++;
        history += messageCount + ". Activity 1 OnResume launched\n- - - - - - - - - - - - -\n";
        actualizarHistorial();
    }

    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Activity 1 onPause launched");
        messageCount++;
        history += messageCount + ". Activity 1 OnPause launched\n";
    }

    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Activity 1 onPause launched");
        messageCount++;
        history += messageCount + ". Activity 1 OnStop launched\n";
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Activity 1 onDestroy launched");
        messageCount++;
        history += messageCount + ". Activity 1 OnDestroy launched\n";
    }

}
