package pl.marcinos.kaczki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button buttonStart;
    Button buttonResult;
    Button buttonWyjdz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonStart=(Button)findViewById(R.id.buttonStart);
        buttonResult=(Button)findViewById(R.id.buttonResult);
        buttonWyjdz=(Button)findViewById(R.id.buttonWyjdz);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                Main2Activity.this.finish();
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,result.class);
                startActivity(intent);
                Main2Activity.this.finish();

            }
        });
        buttonWyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Main2Activity.this.finish();
            }
        });

    }


}

