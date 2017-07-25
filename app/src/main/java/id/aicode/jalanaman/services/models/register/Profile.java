
package id.aicode.jalanaman.services.models.register;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("places")
    @Expose
    private List<Object> places = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getPlaces() {
        return places;
    }

    public void setPlaces(List<Object> places) {
        this.places = places;
    }

}
