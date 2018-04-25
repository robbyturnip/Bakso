package robbyturnip333.gmail.com.bakso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Bakso2 extends AppCompatActivity {
    RecyclerView daurUlang;
    Button tombol;
    private  Database databse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakso2);
        daurUlang=findViewById(R.id.r1);
        tombol=findViewById(R.id.b1);
        databse=Database.getInstance(getApplication());
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent baru=new Intent(Bakso2.this,TambahBakso.class);
                startActivity(baru);
            }
        });

        DaurUlang Daurulang=new DaurUlang(Bakso2.this,databse.getMenu());
        daurUlang.setLayoutManager(new LinearLayoutManager(Bakso2.this));
        daurUlang.setAdapter(Daurulang);
        Daurulang.notifyDataSetChanged();
    }
}
