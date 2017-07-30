package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/30/2017.
 */

/**
 * {
 * "created_at": null,
 * "name": "",
 * "type": null,
 * "point_a_lat": null,
 * "point_a_long": null,
 * "point_b_lat": null,
 * "point_b_long": null,
 * "owner": null
 * }
 */
public class NewPlaceData {

    private String created_at;
    private String name;
    private String type;
    private double point_a_lat;
    private double point_a_long;
    private double point_b_lat;
    private double point_b_long;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public double getPoint_a_lat() {
        return point_a_lat;
    }

    public void setPoint_a_lat(double point_a_lat) {
        this.point_a_lat = point_a_lat;
    }

    public double getPoint_a_long() {
        return point_a_long;
    }

    public void setPoint_a_long(double point_a_long) {
        this.point_a_long = point_a_long;
    }

    public double getPoint_b_lat() {
        return point_b_lat;
    }

    public void setPoint_b_lat(double point_b_lat) {
        this.point_b_lat = point_b_lat;
    }

    public double getPoint_b_long() {
        return point_b_long;
    }

    public void setPoint_b_long(double point_b_long) {
        this.point_b_long = point_b_long;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public NewPlaceData(String created_at, String name, String type, double point_a_lat, double point_a_long, double point_b_lat, double point_b_long, String owner) {

        this.created_at = created_at;
        this.name = name;
        this.type = type;
        this.point_a_lat = point_a_lat;
        this.point_a_long = point_a_long;
        this.point_b_lat = point_b_lat;
        this.point_b_long = point_b_long;
        this.owner = owner;
    }

    private String owner;

    @Override
    public String toString() {
        return "NewPlaceData{" +
                "created_at='" + created_at + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", point_a_lat=" + point_a_lat +
                ", point_a_long=" + point_a_long +
                ", point_b_lat=" + point_b_lat +
                ", point_b_long=" + point_b_long +
                ", owner='" + owner + '\'' +
                '}';
    }
}
