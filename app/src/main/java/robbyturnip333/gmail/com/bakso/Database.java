package robbyturnip333.gmail.com.bakso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robby on 24/04/18.
 */

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "DbHelper";
    private static final int VERSI = 1;
    private static final String DB = "Bakso";
    private static final String TABLE = "menu";
    private static final String ID = "id";
    private static final String JUDUL = "judul";
    private static final String HARGA = "harga";
    private static Database database;

    public Database(Context context) {

        super(context, DB, null, VERSI);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qr = "create table " + TABLE + " (" + ID + " integer primary key autoincrement not null, " +
                JUDUL + " text, " + HARGA + " text " + " );";
        sqLiteDatabase.execSQL(qr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int lama, int baru) {
        if (lama != baru) {
            sql.execSQL("DROP TABLE IF EXISTS " + TABLE);
            onCreate(sql);
        }
    }

    public static synchronized Database getInstance(Context konteks) {
        if (database == null) {
            database = new Database(konteks.getApplicationContext());
        }
        return database;
    }

    public void TambahMenu(Menu menu) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.beginTransaction();

        try {
            ContentValues nilai = new ContentValues();
            nilai.put(JUDUL, menu.getJudul());
            nilai.put(HARGA, menu.getHarga());

            sqLiteDatabase.insertOrThrow(TABLE, null, nilai);
            sqLiteDatabase.setTransactionSuccessful();
            Log.d(TAG, " BERHASIL TAMBAH");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "GAGAL TAMBAH " + e);
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

      public List<Menu> getMenu() {
        List<Menu> listMenu = new ArrayList<>();
        String QUERY= "SELECT * FROM " + TABLE;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(QUERY,null);

        try{
            if(cursor.moveToFirst()){
                do{
                    Menu menu=new Menu(
                            cursor.getString(cursor.getColumnIndex(ID)),
                            cursor.getString(cursor.getColumnIndex(JUDUL)),
                            cursor.getString(cursor.getColumnIndex(HARGA)));
                    Log.d(ID,cursor.getString(cursor.getColumnIndex(ID)));
                    listMenu.add(menu);
                }while(cursor.moveToNext());
            }
        }catch (SQLException e){
            Log.d(TAG,"GAGAL BACA DATA");
        }finally {
            if(cursor!=null && !cursor.isClosed()){
                cursor.close();
            }
        }
        return listMenu;
    }
        public  void hapusTabel(String id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL("DELETE FROM "+TABLE+" WHERE "+ID+" = '"+id+"'");
            sqLiteDatabase.setTransactionSuccessful();
            Log.d(TAG, "BERHASIL MENGHAPUS");
        }catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "GAGAL MENGHAPUS");
        }finally {
            sqLiteDatabase.endTransaction();
        }
    }

        public void updateDatabase(Menu menu){
            SQLiteDatabase sqLiteDatabase=getWritableDatabase();

            try{
                sqLiteDatabase.beginTransaction();
                sqLiteDatabase.execSQL("UPDATE "+TABLE+" SET "+ HARGA+" = '"+menu.getJudul()+"', "+
                HARGA+" = '"+menu.getHarga()+"' WHERE "+ID+" = '"+menu.getId()+"'");
                sqLiteDatabase.setTransactionSuccessful();
            }catch (SQLException e){
                e.printStackTrace();
                Log.d(TAG, "GAGAL UPDATE");
            }finally {
                sqLiteDatabase.endTransaction();
            }
        }
}
