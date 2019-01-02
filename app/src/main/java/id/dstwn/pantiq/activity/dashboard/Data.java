package id.dstwn.pantiq.activity.dashboard;

public class Data {

    String namaKab;
    int gambarKab;

    public Data(String namaKab, int gambarKab){
        this.namaKab = namaKab;
        this.gambarKab = gambarKab;
    }
    public String getNamaKab() {
        return namaKab;
    }

    public void setNamaKab(String namaKab) {
        this.namaKab = namaKab;
    }

    public int getGambarKab() {
        return gambarKab;
    }

    public void setGambarKab(int gambarKab) {
        this.gambarKab = gambarKab;
    }

}
