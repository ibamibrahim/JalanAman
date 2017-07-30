package id.aicode.jalanaman.recent;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;

import java.util.List;

/**
 * Created by Ibam on 7/30/2017.
 */

public class AddEventDialog extends AlertDialog {

    Context context;
    public AddEventDialog(Context context){
        super(context);
        this.context = context;
    }
    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }
}
