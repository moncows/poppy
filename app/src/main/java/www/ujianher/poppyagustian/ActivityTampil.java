package www.ujianher.poppyagustian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ujianher.poppyagustian.model.TampilData;
import www.ujianher.poppyagustian.model.TampilDataResp;
import www.ujianher.poppyagustian.network.Services;
import www.ujianher.poppyagustian.network.Utils;

public class ActivityTampil extends AppCompatActivity {
    private Services services;
    private String NIK, nama_karyawan, jenis_kelamin, shiftkerja, statuperkawinan;
    private int upah_pokok, tunjangan;
    private TextView tv_nik, tv_nama, tv_jeniskelamin, tv_shift, tv_status, tv_upah;
    private Button btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        services = Utils.getClient().create(Services.class);
        tv_nik = findViewById(R.id.tvnik);
        tv_nama = findViewById(R.id.tv_namakaryawan);
        tv_jeniskelamin = findViewById(R.id.tv_jeniskelamin);
        tv_shift = findViewById(R.id.tv_shiftkerja);
        tv_status = findViewById(R.id.tv_status);
        tv_upah = findViewById(R.id.tvupahtunjangan);
        btnkembali = findViewById(R.id.btnkembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tampildata();
    }

    private void tampildata() {
        services.getdata("hasda").enqueue(new Callback<TampilData>() {
            @Override
            public void onResponse(Call<TampilData> call, Response<TampilData> response) {
                List<TampilDataResp> list = response.body().getData();
                showdata(list);
            }

            @Override
            public void onFailure(Call<TampilData> call, Throwable t) {

            }
        });
    }

    private void showdata(List<TampilDataResp> list) {
        NIK = list.get(0).getNik();
        nama_karyawan = list.get(0).getNamaKaryawan();
        jenis_kelamin = list.get(0).getJenisKelamin();
        shiftkerja = list.get(0).getShiftKerja();
        statuperkawinan = list.get(0).getStatusPerkawinan();

        if (shiftkerja.equals("Shift Pagi")) {
            if (statuperkawinan.equals("Menikah")) {
                upah_pokok = 1000000;
                tunjangan = upah_pokok * 25 / 100;
            } else if (statuperkawinan.equals("Belum Menikah")) {
                upah_pokok = 1000000;
                tunjangan = upah_pokok * 20 / 100;
            }
        } else if (shiftkerja.equals("Shift Malam")) {
            if (statuperkawinan.equals("Menikah")) {
                upah_pokok = 1500000;
                tunjangan = upah_pokok * 30 / 100;
            } else if (statuperkawinan.equals("Belum Menikah")) {
                upah_pokok = 1500000;
                tunjangan = upah_pokok * 25 / 100;

            }
        }

        tv_nik.setText(NIK);
        tv_nama.setText(nama_karyawan);
        tv_jeniskelamin.setText(jenis_kelamin);
        tv_shift.setText(shiftkerja);
        tv_status.setText(statuperkawinan);
        tv_upah.setText("" + (upah_pokok + tunjangan));


    }
}
