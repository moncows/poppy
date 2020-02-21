package www.ujianher.poppyagustian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ujianher.poppyagustian.model.Insert;
import www.ujianher.poppyagustian.network.Services;
import www.ujianher.poppyagustian.network.Utils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String NIK, nama_karyawan, jenis_kelamin, shiftkerja, statuperkawinan;
    private int upah_pokok, tunjangan;
    private EditText edtNIK, edtNamaKaryawa;
    private Spinner spn_jenis_kelamin;
    private RadioButton rbshiftpagi, rbshiftmalam, rbmenikah, rbbelumnikah;
    private Button btnsimpan, btntampil;
    private Services services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        services = Utils.getClient().create(Services.class);
        upah_pokok = 0;
        btnsimpan = findViewById(R.id.btnsimpan);
        btntampil = findViewById(R.id.btntampil);
        edtNIK = findViewById(R.id.edtnik);
        edtNamaKaryawa = findViewById(R.id.edt_nama_karyawan);
        spn_jenis_kelamin = findViewById(R.id.spn_jeniskelamin);
        rbmenikah = findViewById(R.id.rbmenikah);
        rbshiftpagi = findViewById(R.id.rbpagi);
        rbshiftmalam = findViewById(R.id.rbmalam);
        rbbelumnikah = findViewById(R.id.rbbelummenikah);
        rbmenikah.toggle();
        rbshiftpagi.toggle();
        btntampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTampil.class);
                startActivity(intent);
            }
        });
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama_karyawan = edtNamaKaryawa.getText().toString();
                NIK = edtNIK.getText().toString();
                jenis_kelamin = spn_jenis_kelamin.getSelectedItem().toString();
                if (rbmenikah.isChecked()) {
                    if (rbshiftpagi.isChecked()) {
                        upah_pokok = 1000000;
                        tunjangan = upah_pokok * 25 / 100;
                        shiftkerja = "Shift Pagi";
                        statuperkawinan = "Menikah";
                        Log.e(TAG, "upah pokok: " + upah_pokok + ", tunjangan : " + tunjangan);
                    } else if (rbshiftmalam.isChecked()) {
                        upah_pokok = 1500000;
                        tunjangan = upah_pokok * 30 / 100;
                        shiftkerja = "Shift Malam";
                        statuperkawinan = "Menikah";
                        Log.e(TAG, "upah pokok: " + upah_pokok + ", tunjangan : " + tunjangan);
                    }
                } else if (rbbelumnikah.isChecked()) {
                    if (rbshiftpagi.isChecked()) {
                        upah_pokok = 1000000;
                        tunjangan = upah_pokok * 20 / 100;
                        shiftkerja = "Shift Pagi";
                        statuperkawinan = "Belum Menikah";
                        Log.e(TAG, "upah pokok: " + upah_pokok + ", tunjangan : " + tunjangan);
                    } else if (rbshiftmalam.isChecked()) {
                        upah_pokok = 1500000;
                        tunjangan = upah_pokok * 25 / 100;
                        shiftkerja = "Shift Malam";
                        statuperkawinan = "Belum Menikah";
                        Log.e(TAG, "upah pokok: " + upah_pokok + ", tunjangan : " + tunjangan);
                    }
                }
                if (!NIK.equals("")) {
                    if (!nama_karyawan.equals("")) {
                        simpandata();
                    } else {
                        edtNamaKaryawa.setError("Nama Belum Diisi");
                    }
                } else {
                    edtNIK.setError("NIK Belum Diisi");
                }

            }
        });
    }

    private void simpandata() {
        services.insertData(NIK, nama_karyawan, jenis_kelamin, shiftkerja, statuperkawinan).enqueue(new Callback<Insert>() {
            @Override
            public void onResponse(Call<Insert> call, Response<Insert> response) {
                if (response.body().getPesan().equals("sukses")) {
                    Toast.makeText(MainActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Insert> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
