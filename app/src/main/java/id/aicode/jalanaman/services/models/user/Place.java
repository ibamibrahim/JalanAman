
package id.aicode.jalanaman.services.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("point_a_lat")
    @Expose
    private String pointALat;
    @SerializedName("point_a_long")
    @Expose
    private String pointALong;
    @SerializedName("point_b_lat")
    @Expose
    private String pointBLat;
    @SerializedName("point_b_long")
    @Expose
    private String pointBLong;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("owner")
    @Expose
    private Integer owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPointALat() {
        return pointALat;
    }

    public void setPointALat(String pointALat) {
        this.pointALat = pointALat;
    }

    public String getPointALong() {
        return pointALong;
    }

    public void setPointALong(String pointALong) {
        this.pointALong = pointALong;
    }

    public String getPointBLat() {
        return pointBLat;
    }

    public void setPointBLat(String pointBLat) {
        this.pointBLat = pointBLat;
    }

    public String getPointBLong() {
        return pointBLong;
    }

    public void setPointBLong(String pointBLong) {
        this.pointBLong = pointBLong;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

}
