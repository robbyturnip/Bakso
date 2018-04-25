package robbyturnip333.gmail.com.bakso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahBakso extends AppCompatActivity {
    EditText eJudul,eHarga;
    Button tombol;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bakso);
        eJudul=findViewById(R.id.e1);
        eHarga=findViewById(R.id.e2);
        tombol=findViewById(R.id.b2);
        database=Database.getInstance(getApplicationContext());

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu menu=new Menu();
                menu.setJudul(eJudul.getText().toString());
                menu.setHarga(eHarga.getText().toString());

                database.TambahMenu(menu);
                Intent baru=new Intent(TambahBakso.this,Bakso2.class);
                startActivity(baru);
            }
        });

    }
}
