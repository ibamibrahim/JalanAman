package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/30/2017.
 */

public class EventData {

    private String title;
    private String point_lat;
    private String point_lang;
    private String time;
    private String created_at;
    private String photo_url;

    public EventData(String title, String point_lat, String point_lang, String time, String created_at, String photo_url) {
        this.title = title;
        this.point_lat = point_lat;
        this.point_lang = point_lang;
        this.time = time;
        this.created_at = created_at;
        this.photo_url = photo_url;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoint_lat() {
        return point_lat;
    }

    public void setPoint_lat(String point_lat) {
        this.point_lat = point_lat;
    }

    public String getPoint_lang() {
        return point_lang;
    }

    public void setPoint_lang(String point_lang) {
        this.point_lang = point_lang;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}