package id.aicode.jalanaman.comment;

/**
 * Created by Ibam on 7/18/2017.
 */

public class CommentModel {

    private String username;
    private String comment;
    private String timeStamp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
