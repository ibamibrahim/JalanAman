package id.aicode.jalanaman.services;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/**
 * Created by Ibam on 7/16/2017.
 */

public class RemoteServices implements ServicesContract.RemoteContract {
    @Override
    public void login(String email, String password) {
        
    }

    @Override
    public void register(String email, String password) {

    }

    @Override
    public void getRecentDangers() {

    }

    @Override
    public void addMyPlace(String type, String name, String pointOne, @Nullable String pointTwo) {

    }

    @Override
    public void getComments(String eventId) {

    }

    @Override
    public void postEvent(String type, String description, String point, @Nullable Drawable photo) {

    }

    @Override
    public void postComments(String comment) {

    }
}
