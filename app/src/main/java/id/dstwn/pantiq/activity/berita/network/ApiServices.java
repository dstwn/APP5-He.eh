package id.dstwn.pantiq.activity.berita.network;

import id.dstwn.pantiq.activity.berita.response.ResponseBerita;
import id.dstwn.pantiq.activity.panti.response.ResponsePanti;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("berita/api_berita.php")
    Call<ResponseBerita> request_show_all_berita();

    @GET("kota/list_panti.php")
    Call<ResponsePanti> request_show_panti();
}
