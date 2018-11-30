package hr.krkec.zadatak10;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static hr.krkec.zadatak10.Utils.AppConstants.KEY_1;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    private static final int reqCode = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=null;
                if( et1.getText().toString().length()>0& et2.getText().toString().length()>0){
                    Integer broj1 = Integer.parseInt(et1.getText().toString());
                    Integer broj2 = Integer.parseInt(et2.getText().toString());
                    if(broj1>broj2){
                        i = new Intent(MainActivity.this,SecondActivity.class);
                        i.putExtra(KEY_1,broj2);
                    }
                    else {
                        i = new Intent(MainActivity.this,SecondActivity.class);
                        i.putExtra(KEY_1,broj1);
                    }
                    startActivityForResult(i,reqCode);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==reqCode&resultCode==RESULT_OK){
            Toast.makeText(this, ""+data.getIntExtra(KEY_1,0), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Operacija nije ispravno izvršena", Toast.LENGTH_SHORT).show();
        }
    }
}
