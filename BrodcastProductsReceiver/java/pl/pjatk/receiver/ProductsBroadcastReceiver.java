package pl.pjatk.receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.NotificationCompat;

public class ProductsBroadcastReceiver extends BroadcastReceiver {

    public static int ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        ID += 1;
        NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder(context);

        PackageManager packageManager = context.getPackageManager();
        String applicationPack = "pl.pjatk.kn_miniprojekt1";
        Intent launchIntent = packageManager.getLaunchIntentForPackage(applicationPack);

        String name = intent.getExtras().getString("name");
        String price = intent.getExtras().getString("price");
        String amount = intent.getExtras().getString("amount");

        notificationCompatBuilder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Dodano nowy produkt")
                .setContentText("Nazwa: " + name + ", cena: " + price + ", ilosc: " + amount);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(launchIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationCompatBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(ID, notificationCompatBuilder.build());
    }
}
