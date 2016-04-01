package notification.com.mynotification;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationReader extends NotificationListenerService{

    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
         Drawable notificationIcon = sbn.getNotification().getSmallIcon().loadDrawable(getApplicationContext());

        Bitmap bitmap = ((BitmapDrawable)notificationIcon).getBitmap();
        int pixel = bitmap.getPixel(150, 150);

        int redValue = Color.red(pixel);
        int blueValue = Color.blue(pixel);
        int greenValue = Color.green(pixel);

        float[] hsv = new float[3];
        Color.RGBToHSV(redValue, greenValue, blueValue, hsv);

        float hue = hsv[0];
        float sat = hsv[1];
        float val = hsv[2];

        System.out.println(hue + ", " + sat + ", " + val);

       /* int outputColor = Color.HSVToColor(hsv);
        redValue = Color.red(outputColor);
        greenValue = Color.green(outputColor);
        blueValue = Color.blue(outputColor);
        System.out.println(red + ", " + green + ", " + blue);*/

    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn, RankingMap rankingMap) {
        super.onNotificationPosted(sbn, rankingMap);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn, RankingMap rankingMap) {
        super.onNotificationRemoved(sbn, rankingMap);
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
    }

    @Override
    public void onListenerHintsChanged(int hints) {
        super.onListenerHintsChanged(hints);
    }

    @Override
    public void onNotificationRankingUpdate(RankingMap rankingMap) {
        super.onNotificationRankingUpdate(rankingMap);
    }

    @Override
    public void onInterruptionFilterChanged(int interruptionFilter) {
        super.onInterruptionFilterChanged(interruptionFilter);
    }

    @Override
    public StatusBarNotification[] getActiveNotifications() {
        return super.getActiveNotifications();
    }

    @Override
    public StatusBarNotification[] getActiveNotifications(String[] keys) {
        return super.getActiveNotifications(keys);
    }

    @Override
    public RankingMap getCurrentRanking() {
        return super.getCurrentRanking();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }
}
