package id.dstwn.pantiq.activity.berita.network;

import id.dstwn.pantiq.activity.berita.response.ResponseBerita;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("api_berita.php")
    Call<ResponseBerita> request_show_all_berita();
}
