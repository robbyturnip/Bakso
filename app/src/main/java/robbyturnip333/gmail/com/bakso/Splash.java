package robbyturnip333.gmail.com.bakso;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    int waktu=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Simpan simpan=new Simpan(Splash.this);
        final String kondisi=simpan.getLogin();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(kondisi.equalsIgnoreCase("Belum")){
                    Intent baru=new Intent(Splash.this,MainActivity.class);
                    startActivity(baru);
                }
                else{
                    Intent baru=new Intent(Splash.this,Bakso2.class);
                    startActivity(baru);
                }
            }
        }, waktu);
    }
}
