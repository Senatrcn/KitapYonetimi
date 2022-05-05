import javax.swing.*;
import java.util.Map;

public class Utilities extends KitapIslemleri{

    public static int kitapAdiIleIdBul(String girilenIsim) {
        int id=0;
        for (Map.Entry<Integer,Kitap> entry : tumKitaplar.entrySet()) {
            if (entry.getValue().getKitapAdı().equalsIgnoreCase(girilenIsim)) {
                id= entry.getKey();
            }
        }
        return id;
    }
    public static int yazarAdiIleIdBul(String girilenIsim) {
        int id=0;
        for (Map.Entry<Integer,Kitap> entry : tumKitaplar.entrySet()) {
            if (entry.getValue().getYazar().equalsIgnoreCase(girilenIsim)) {
                id= entry.getKey();
            }
        }
        return id;
    }
}
