package robbyturnip333.gmail.com.bakso;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama,pass;
    Button btn;

    SharedPreferences simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        btn=findViewById(R.id.b1);
        simpan=getSharedPreferences("app",MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nama.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {
                    if (nama.getText().toString().equals("Robby") && pass.getText().toString().equals("turnip")) {

                        SharedPreferences.Editor edit=simpan.edit();
                        edit.putString("Login","Sudah");
                        edit.commit();
                        Intent bakso2 = new Intent(MainActivity.this, Bakso2.class);
                        startActivity(bakso2);
                    } else {
                        Toast.makeText(MainActivity.this, "Username dan Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Username atau Password kosong ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
