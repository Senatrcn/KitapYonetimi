import javax.swing.*;

public class AnaMenu extends KitapIslemleri{
    public static void anaGirisEkrani(){

        while (true){

            String tercih = JOptionPane.showInputDialog(null, "Kitap eklemek icin 1\n" +
                    "Kitap no ile arama icin 2\n" +
                    "Kitap bilgisi ile arama icin 3\n" +
                    "Numara ile kitap silme icin 4\n" +
                    "Cıkmak icin 5'i tuşlayın" );
            new KitapIslemleri().tumKitaplariListele();
            switch(tercih){
                case "1": new KitapIslemleri().kitapEkle(); break;
                case "2": new KitapIslemleri().kitapNoIleKitap(); break;
                case "3": new KitapIslemleri().bilgiIleKitap(); break;
                case "4": new KitapIslemleri().numaraIleKitapSil(); break;
                case "5": cikisEkrani();

            }
        }
    }

    public static void cikisEkrani() {
        JOptionPane.showMessageDialog(null, "*** YİNE BEKLERİZ ***");
        System.exit(0);
    }
}
