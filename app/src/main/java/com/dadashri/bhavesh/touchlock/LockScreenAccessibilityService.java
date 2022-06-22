package com.dadashri.bhavesh.touchlock;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

public class LockScreenAccessibilityService extends AccessibilityService {

    /* renamed from: a */
    private static LockScreenAccessibilityService f0a;

    /* renamed from: a */
    public static void m0a() {
        LockScreenAccessibilityService lockScreenAccessibilityService = f0a;
        if (lockScreenAccessibilityService != null) {
            lockScreenAccessibilityService.mo1b();
        }
    }

    @TargetApi(28)
    /* renamed from: b */
    public void mo1b() {
        performGlobalAction(8);
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onInterrupt() {
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        super.onServiceConnected();
        f0a = this;
    }

    public boolean onUnbind(Intent intent) {
        f0a = null;
        return super.onUnbind(intent);
    }
}
