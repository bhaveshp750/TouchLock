package com.dadashri.bhavesh.touchlock;

import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class TouchLockWidget extends AppWidgetProvider {
    private static final String TAG = "TouchLockWidget";
    
    void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Log.d(TAG, "updateAppWidget: ");
        
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.touch_lock_widget);
        views.setTextViewText(R.id.appwidget_lock, widgetText);


        if (Build.VERSION.SDK_INT > 28 && m2a(context.getApplicationContext())) {
            Log.d(TAG, "onUpdate: if(SDK_INT > 28 && m2a(context)) {");
            f1a = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName componentName = new ComponentName(context, LockScreenDeviceAdminReceiver.class);
            f2b = componentName;
            if (f1a.isAdminActive(componentName)) {
                f1a.lockNow();
            } else {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.touch_lock_widget);
                Intent configIntent = new Intent(context, LockActivity.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 12544456, configIntent, PendingIntent.FLAG_IMMUTABLE);

                remoteViews.setOnClickPendingIntent(R.id.appwidget_lock, configPendingIntent);
                appWidgetManager.updateAppWidget(R.id.appwidget_lock, remoteViews);
            }
        }else{
            Log.d(TAG, "onUpdate: start login activity");
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.touch_lock_widget);
            Intent configIntent = new Intent(context, LockActivity.class);

            PendingIntent configPendingIntent = PendingIntent.getActivity(context, 12544456, configIntent, PendingIntent.FLAG_MUTABLE);

            remoteViews.setOnClickPendingIntent(R.id.appwidget_lock, configPendingIntent);
            appWidgetManager.updateAppWidget(R.id.appwidget_lock, remoteViews);
        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate: appWidgetIds.length = " + appWidgetIds.length);
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


        if (Build.VERSION.SDK_INT > 28 && m2a(context.getApplicationContext())) {
            Log.d(TAG, "onUpdate: if(SDK_INT > 28 && m2a(context)) {");
            f1a = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName componentName = new ComponentName(context, LockScreenDeviceAdminReceiver.class);
            f2b = componentName;
            if (f1a.isAdminActive(componentName)) {
                f1a.lockNow();
            } else {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.touch_lock_widget);
                Intent configIntent = new Intent(context, LockActivity.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 12544456, configIntent, PendingIntent.FLAG_IMMUTABLE);

                remoteViews.setOnClickPendingIntent(R.id.appwidget_lock, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
            }
        }else{
            Log.d(TAG, "onUpdate: start login activity");
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.touch_lock_widget);
            Intent configIntent = new Intent(context, LockActivity.class);

            PendingIntent configPendingIntent = PendingIntent.getActivity(context, 12544456, configIntent, PendingIntent.FLAG_MUTABLE);

            remoteViews.setOnClickPendingIntent(R.id.appwidget_lock, configPendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        }

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        Log.d(TAG, "onEnabled: ");
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        Log.d(TAG, "onDisabled: ");
    }

    DevicePolicyManager f1a;

    ComponentName f2b;

    private boolean m2a(Context context) {
        int i;
        String string;
        String str = context.getPackageName() + "/" + LockScreenAccessibilityService.class.getCanonicalName();
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


}