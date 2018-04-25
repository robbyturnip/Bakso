package robbyturnip333.gmail.com.bakso;

/**
 * Created by robby on 24/04/18.
 */

public class Menu {
    private String id;
    private String judul;
    private String harga;
    public  Menu(){}
    public Menu(String id,String judul,String harga){
        this.id=id;
        this.judul=judul;
        this.harga=harga;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setJudul(String judul){
        this.judul=judul;
    }
    public void setHarga(String harga){
        this.harga=harga;
    }
    public String getId(){
        return id;
    }
    public String getJudul(){
        return judul;
    }
    public String getHarga(){
        return harga;
    }
}
