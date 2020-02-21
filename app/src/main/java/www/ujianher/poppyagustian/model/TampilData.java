package www.ujianher.poppyagustian.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class TampilData {

        @SerializedName("data")
        @Expose
        private List<TampilDataResp> data = null;
        @SerializedName("pesan")
        @Expose
        private String pesan;

        public List<TampilDataResp> getData() {
            return data;
        }

        public void setData(List<TampilDataResp> data) {
            this.data = data;
        }

        public String getPesan() {
            return pesan;
        }

        public void setPesan(String pesan) {
            this.pesan = pesan;
        }

    }

