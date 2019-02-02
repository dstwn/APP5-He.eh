package id.dstwn.pantiq.activity.panti.response;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class PantiItem{

	@SerializedName("id_panti")
	private String idPanti;

	@SerializedName("nama_pemilik")
	private String namaPemilik;

	@SerializedName("alamat_panti")
	private String alamatPanti;

	@SerializedName("gambar_panti")
	private String gambarPanti;

	@SerializedName("nama_panti")
	private String namaPanti;

	@SerializedName("kontak_pemilik")
	private String kontakPemilik;

	@SerializedName("kategori_panti")
	private String kategoriPanti;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("lat")
	private String lat;

	@SerializedName("long")
	private String jsonMemberLong;

	public void setIdPanti(String idPanti){
		this.idPanti = idPanti;
	}

	public String getIdPanti(){
		return idPanti;
	}

	public void setNamaPemilik(String namaPemilik){
		this.namaPemilik = namaPemilik;
	}

	public String getNamaPemilik(){
		return namaPemilik;
	}

	public void setAlamatPanti(String alamatPanti){
		this.alamatPanti = alamatPanti;
	}

	public String getAlamatPanti(){
		return alamatPanti;
	}

	public void setGambarPanti(String gambarPanti){
		this.gambarPanti = gambarPanti;
	}

	public String getGambarPanti(){
		return gambarPanti;
	}

	public void setNamaPanti(String namaPanti){
		this.namaPanti = namaPanti;
	}

	public String getNamaPanti(){
		return namaPanti;
	}

	public void setKontakPemilik(String kontakPemilik){
		this.kontakPemilik = kontakPemilik;
	}

	public String getKontakPemilik(){
		return kontakPemilik;
	}

	public void setKategoriPanti(String kategoriPanti){
		this.kategoriPanti = kategoriPanti;
	}

	public String getKategoriPanti(){
		return kategoriPanti;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setJsonMemberLong(String jsonMemberLong){
		this.jsonMemberLong = jsonMemberLong;
	}

	public String getJsonMemberLong(){
		return jsonMemberLong;
	}

	@Override
 	public String toString(){
		return 
			"PantiItem{" + 
			"id_panti = '" + idPanti + '\'' + 
			",nama_pemilik = '" + namaPemilik + '\'' + 
			",alamat_panti = '" + alamatPanti + '\'' + 
			",gambar_panti = '" + gambarPanti + '\'' + 
			",nama_panti = '" + namaPanti + '\'' + 
			",kontak_pemilik = '" + kontakPemilik + '\'' + 
			",kategori_panti = '" + kategoriPanti + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",lat = '" + lat + '\'' + 
			",long = '" + jsonMemberLong + '\'' + 
			"}";
		}
}