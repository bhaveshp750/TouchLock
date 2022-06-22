package com.dadashri.bhavesh.touchlock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LockScreenDeviceAdminReceiver extends DeviceAdminReceiver {
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Toast.makeText(context, R.string.msg_info_grant_failed, Toast.LENGTH_LONG).show();
    }

    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Toast.makeText(context, R.string.msg_info_grant_success, Toast.LENGTH_LONG).show();
        Toast.makeText(context, R.string.msg_info_uninstall_guide, Toast.LENGTH_LONG).show();
    }
}
