package hr.krkec.zadatak10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static hr.krkec.zadatak10.Utils.AppConstants.KEY_1;

public class SecondActivity extends AppCompatActivity {
    int broj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        broj = i.getIntExtra(KEY_1,0);
        Button btn3 = findViewById(R.id.btn3);
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("Preneseni broj je {"+broj+"]");
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ri = new Intent();
                int b = broj*broj*10;
                ri.putExtra(KEY_1,b);
                setResult(RESULT_OK,ri);
                finish();
            }
        });
    }
}
