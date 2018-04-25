package robbyturnip333.gmail.com.bakso;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by robby on 19/04/18.
 */

public class Simpan {
    public SharedPreferences simpan;
    public SharedPreferences.Editor edit;

    public Simpan(Context hal){
        this.simpan=hal.getSharedPreferences("app",Context.MODE_PRIVATE);
        this.edit=edit;
    }

    public String getLogin(){
        return simpan.getString("Login","Belum");
    }
}
