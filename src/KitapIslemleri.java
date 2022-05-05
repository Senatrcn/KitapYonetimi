import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class KitapIslemleri implements IKitapIslemleri{

    static Map<Integer, Kitap> tumKitaplar = new HashMap<>();
    static{
        Kitap k1 = new Kitap("HAYATIN KAYNAGI","AYN RAND",120);
        Kitap k2 = new Kitap("ANNA KARENINA","TOLSTOY",90);
        Kitap k3 = new Kitap("YUZYILLIK YALNIZLIK","GABRIEL GARCIA MARQUEZ",79);
        tumKitaplar.put(k1.getKitapNo(),k1);
        tumKitaplar.put(k2.getKitapNo(),k2);
        tumKitaplar.put(k3.getKitapNo(),k3);
    }

    @Override
    public void kitapEkle() {

        String kitapIsmi = JOptionPane.showInputDialog("Eklemek istediginiz kitap ismini girin").toUpperCase();
        String yazarAdi = JOptionPane.showInputDialog("Yazar adını girin").toUpperCase();
        int fiyat = Integer.parseInt(JOptionPane.showInputDialog("Fiyat girin"));
        Kitap k = new Kitap(kitapIsmi,yazarAdi,fiyat);
        tumKitaplar.put(k.getKitapNo(),k);

        JOptionPane.showMessageDialog(null,"Yeni kitap basarıyla eklendi.");


    }

    @Override
    public void kitapNoIleKitap() {
        int arananNo=-1;
        while (arananNo!=0) {
             arananNo = Integer.parseInt(JOptionPane.showInputDialog("Aradıgınız kitap numarasını girin\nCıkmak icin 0'ı tuşlayın : "));
            if(arananNo==0) break;
            else {
                int finalArananNo = arananNo;
                if (tumKitaplar.entrySet().stream().anyMatch(t->t.getKey().equals(finalArananNo))) {

                    JOptionPane.showMessageDialog(null,"\n** Aradıgınız Kitap **\n"+tumKitaplar.get(arananNo));
                }else {
                    JOptionPane.showMessageDialog(null,"\nAradıgınız kitap bulunamadı. Lütfen bilgileri kontrol edin.");
                }
            }

        }
    }

    @Override
    public void bilgiIleKitap() {
        while (true) {
            int secim=Integer.parseInt(JOptionPane.showInputDialog("\nKitap adı ile arama 1-> \nYazar adı ile arama -> 2\nMenüye dönme -> 0"));
            switch (secim) {
                case 1: kitapAdiIleAra(); break;
                case 2: yazarAdiIleAra(); break;
                case 0: AnaMenu.anaGirisEkrani(); break;
                default: JOptionPane.showMessageDialog(null,"Gecerli bir islem secin."); bilgiIleKitap();
            }
        }
    }

    @Override
    public void numaraIleKitapSil() {
        int silenecekKitapId=-1;
        while (silenecekKitapId!=0){
             silenecekKitapId = Integer.parseInt(JOptionPane.showInputDialog("Silmek istediginiz kitap numarasını girin\nCıkmak icin 0'ı tuşlayın"));
             if (silenecekKitapId == 0) break;
             else{
                 if (tumKitaplar.containsKey(silenecekKitapId)){
                     tumKitaplar.remove(silenecekKitapId);
                     JOptionPane.showMessageDialog(null,"Silme islemi basarıyla gerceklesti");
                 }else  JOptionPane.showMessageDialog(null,"Girdiginiz id numarasını kontrol edin.");
             }

        }

    }

    @Override
    public void tumKitaplariListele() {

        String kitaplar="";
        for (Map.Entry<Integer,Kitap> each: tumKitaplar.entrySet()){
            kitaplar += "Kitap No : "+each.getKey()+"   Kitap Adı : "+each.getValue().getKitapAdı() +"   Yazar Adı : "+ each.getValue().getYazar()+"   Fiyat : "+ each.getValue().getKitapFiyatı()+"\n";

        }
        JOptionPane.showMessageDialog(null,  kitaplar);
    }

    private void yazarAdiIleAra() {
        String arananYazarAdi = JOptionPane.showInputDialog("Yazar adı girin ");
        if (tumKitaplar.entrySet().stream().anyMatch(t->t.getValue().getYazar().equalsIgnoreCase(arananYazarAdi))){
            JOptionPane.showMessageDialog(null,tumKitaplar.get(Utilities.yazarAdiIleIdBul(arananYazarAdi)));

        }else {
            JOptionPane.showMessageDialog(null,"Bu yazara ait bir kitabımız bulunmamaktadır.");
        }

    }

    private void kitapAdiIleAra() {
        String arananKitapAdi = JOptionPane.showInputDialog("Kitap adı girin ");
        if (tumKitaplar.entrySet().stream().anyMatch(t->t.getValue().getKitapAdı().equalsIgnoreCase(arananKitapAdi))){
            JOptionPane.showMessageDialog(null,tumKitaplar.get(Utilities.kitapAdiIleIdBul(arananKitapAdi)));
        }else {
            JOptionPane.showMessageDialog(null,"Bu isimde bir kitabımız bulunmamaktadır.");
        }
    }

}
