package com.dadashri.bhavesh.touchlock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;

public class LockActivity extends AppCompatActivity {

    /* renamed from: a */
    DevicePolicyManager f1a;

    /* renamed from: b */
    ComponentName f2b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 28) {
            this.f1a = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName componentName = new ComponentName(this, LockScreenDeviceAdminReceiver.class);
            this.f2b = componentName;
            if (this.f1a.isAdminActive(componentName)) {
                this.f1a.lockNow();
            } else {
                Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
                intent.putExtra("android.app.extra.DEVICE_ADMIN", this.f2b);
                intent.putExtra("android.app.extra.ADD_EXPLANATION", R.string.msg_info_device_admin_expl);
                intent.putExtra("android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME", "com.dadashri.bhavesh.touchlock");
                startActivity(intent);
            }
            finishAffinity();
        } else if (!m2a(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), R.string.msg_info_accessibility_setting_off, Toast.LENGTH_LONG).show();
            startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            Toast.makeText(getApplicationContext(), R.string.msg_info_accessibility_setting_guide, Toast.LENGTH_LONG).show();
            finishAffinity();
        }else{
            LockScreenAccessibilityService.m0a();
            finishAffinity();
        }

    }

    private boolean m2a(Context context) {
        int i;
        String string;
        String str = getPackageName() + "/" + LockScreenAccessibilityService.class.getCanonicalName();
        try {
            i = Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i == 1 && (string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void onResume() {
        super.onResume();
        if (isTaskRoot()) {
            finishAffinity();
        }
    }
}