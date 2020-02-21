package www.ujianher.poppyagustian.network;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import www.ujianher.poppyagustian.model.Insert;
import www.ujianher.poppyagustian.model.TampilData;


public interface Services {

    // ini codingan untuk mengatasi masalah API yang tidak bisa mengguanakan method body biasa
    @Headers("Accept: application/json")
    @FormUrlEncoded //masalah untuk penggunaan field buat php biasa(buka pyhton)
    @POST("insert.php?modul=view")
    Call<TampilData> getdata(@Field("haha") String haha);

    @Headers("Accept: application/json")
    @FormUrlEncoded //masalah untuk penggunaan field buat php biasa(buka pyhton)
    @POST("insert.php?modul=insert")
    Call<Insert> insertData(@Field("nik") String nik,
                            @Field("nama_karyawan") String nama_karyawan,
                            @Field("jenis_kelamin") String jenis_kelamin,
                            @Field("shift_kerja") String shift_kerja,
                            @Field("status_perkawinan")String status_perkawinan);


}