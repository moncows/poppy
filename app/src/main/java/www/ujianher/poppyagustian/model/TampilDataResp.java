package www.ujianher.poppyagustian.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TampilDataResp {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("nama_karyawan")
    @Expose
    private String namaKaryawan;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("shift_kerja")
    @Expose
    private String shiftKerja;
    @SerializedName("status_perkawinan")
    @Expose
    private String statusPerkawinan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getShiftKerja() {
        return shiftKerja;
    }

    public void setShiftKerja(String shiftKerja) {
        this.shiftKerja = shiftKerja;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

}
