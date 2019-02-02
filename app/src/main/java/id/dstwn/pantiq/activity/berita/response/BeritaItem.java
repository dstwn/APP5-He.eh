package id.dstwn.pantiq.activity.berita.response;

import com.google.gson.annotations.SerializedName;

public class BeritaItem{

	@SerializedName("id_berita")
	private String idBerita;

	@SerializedName("gambar_berita")
	private String gambarBerita;

	@SerializedName("judul_berita")
	private String judulBerita;

	@SerializedName("isi_berita")
	private String isiBerita;

	public void setIdBerita(String idBerita){
		this.idBerita = idBerita;
	}

	public String getIdBerita(){
		return idBerita;
	}

	public void setGambarBerita(String gambarBerita){
		this.gambarBerita = gambarBerita;
	}

	public String getGambarBerita(){
		return gambarBerita;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"id_berita = '" + idBerita + '\'' + 
			",gambar_berita = '" + gambarBerita + '\'' + 
			",judul_berita = '" + judulBerita + '\'' + 
			",isi_berita = '" + isiBerita + '\'' + 
			"}";
		}
}