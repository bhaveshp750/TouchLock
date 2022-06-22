package com.dadashri.bhavesh.touchlock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Button lock = findViewById(R.id.lock);
        Button adminLock = findViewById(R.id.adminLock);

        lock.setOnClickListener(v -> {
            startActivity(new Intent(this, LockActivity.class));
        });

        adminLock.setOnClickListener(v -> {
            startActivity(new Intent(this, AdminLockActivity.class));
        });
    }


}
