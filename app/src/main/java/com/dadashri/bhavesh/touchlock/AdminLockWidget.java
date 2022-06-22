package com.dadashri.bhavesh.touchlock;

import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class AdminLockWidget extends AppWidgetProvider {
    private static final String TAG = "AdminLockWidget";
    public static String APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_ENABLED";
    public static String ACTION_CLICK = "com.dadashri.bhavesh.touchlock.ACTION_CLICK";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        /*PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm.isScreenOn()) {
            DevicePolicyManager policy = (DevicePolicyManager)
                    context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            try {
                policy.lockNow();
            } catch (SecurityException ex) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.admin_lock_widget);
                Intent configIntent = new Intent(context, AdminLockActivity.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

                remoteViews.setOnClickPendingIntent(R.id.appwidget_admin_lock, configPendingIntent);
                appWidgetManager.updateAppWidget(R.id.appwidget_admin_lock, remoteViews);
            }
        }*//*
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.admin_lock_widget);
        Intent configIntent = new Intent(context, AdminLockActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, appWidgetId, configIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.appwidget_admin_lock, configPendingIntent);
        appWidgetManager.updateAppWidget(R.id.appwidget_admin_lock, remoteViews);*/
        // Instruct the widget manager to update the widget
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate: appWidgetIds.length = " + appWidgetIds.length);
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        /*PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm.isScreenOn()) {
            DevicePolicyManager policy = (DevicePolicyManager)
                    context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            try {
                policy.lockNow();
            } catch (SecurityException ex) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.admin_lock_widget);
                Intent configIntent = new Intent(context, AdminLockActivity.class);

                PendingIntent configPendingIntent = PendingIntent.getActivity(context, 32148654, configIntent, PendingIntent.FLAG_IMMUTABLE);

                remoteViews.setOnClickPendingIntent(R.id.appwidget_admin_lock, configPendingIntent);
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
            }
        }*/

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.admin_lock_widget);
        Intent configIntent = new Intent(context, AdminLockActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 32148654, configIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.appwidget_admin_lock, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled: ");
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled: ");
        // Enter relevant functionality for when the last widget is disabled
    }

}