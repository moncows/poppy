package www.ujianher.poppyagustian.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Insert{

    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("pesan")
    @Expose
    private String pesan;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

}
