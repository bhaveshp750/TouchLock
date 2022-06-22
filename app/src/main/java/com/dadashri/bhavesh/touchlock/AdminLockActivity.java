package com.dadashri.bhavesh.touchlock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;

public class AdminLockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adminLock();
    }

    private void adminLock() {
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        if (pm.isScreenOn()) {
            DevicePolicyManager policy = (DevicePolicyManager)
                    getSystemService(Context.DEVICE_POLICY_SERVICE);
            try {
                policy.lockNow();
            } catch (SecurityException ex) {
                Toast.makeText(this, "Must enable device administrator", Toast.LENGTH_LONG).show();
                ComponentName admin = new ComponentName(this, AdminReceiver.class);
                Intent intent = new Intent(
                        DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).putExtra(
                        DevicePolicyManager.EXTRA_DEVICE_ADMIN, admin);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}