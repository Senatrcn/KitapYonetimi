public class Kitap {
    private static int idCount=1000;
    private int kitapNo;
    private String kitapAdı;
    private String yazar;
    private double kitapFiyatı;

    public Kitap() {
        kitapNo = ++idCount;
    }

    public Kitap (String kitapAdı, String yazar, double kitapFiyatı) {
        kitapNo = ++idCount;
        this.kitapAdı=kitapAdı;
        this.yazar=yazar;
        this.kitapFiyatı=kitapFiyatı;
    }

    public int getKitapNo() {
        return kitapNo;
    }

    public void setKitapNo(int kitapNo) {
        this.kitapNo = kitapNo;
    }

    public String getKitapAdı() {
        return kitapAdı;
    }

    public void setKitapAdı(String kitapAdı) {
        this.kitapAdı = kitapAdı;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public double getKitapFiyatı() {
        return kitapFiyatı;
    }

    public void setKitapFiyatı(double kitapFiyatı) {
        this.kitapFiyatı = kitapFiyatı;
    }

    @Override
    public String toString() {
        return "Kitap No: " + kitapNo +
                ", Kitap Adı: " + kitapAdı +
                ", Yazar Adı: "+ yazar +
                ", Fiyatı: " + kitapFiyatı;
    }
}
