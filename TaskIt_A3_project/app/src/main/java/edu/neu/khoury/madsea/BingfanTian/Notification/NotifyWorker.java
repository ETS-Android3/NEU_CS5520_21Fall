package edu.neu.khoury.madsea.BingfanTian.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import edu.neu.khoury.madsea.BingfanTian.R;
import edu.neu.khoury.madsea.BingfanTian.Utils.MainActivity;

public class NotifyWorker extends Worker {
    public static final String KEY_TASK_TITLE = "taskTitle";
    public static final String KEY_TASK_DETAILS = "taskDetails";

    private static final String TAG = NotifyWorker.class.toString();

    public NotifyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String title = getInputData().getString(KEY_TASK_TITLE);
        String details = getInputData().getString(KEY_TASK_DETAILS);
        triggerNotification(title, details);
        return Result.success();
    }

    private void triggerNotification(String title, String details) {
        Bitmap largeIcon = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ic_launcher_foreground);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), intent, 0);
        Notification.Builder notificationBuilder = new Notification.Builder(getApplicationContext(), AppNotificationSetting.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(details)
                .setColor(Color.RED)
                .setStyle(new Notification.BigPictureStyle().bigLargeIcon(largeIcon))
                .setAutoCancel(true)
                .setContentIntent(pIntent);


        NotificationManager notificationManager = (NotificationManager)
                getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1 /* ID of notification */, notificationBuilder.build());
    }
}
