package com.lipu.lipdroid.ofm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by WebHawks IT on 12/28/2015.
 */
public class IncomingCall extends BroadcastReceiver {
    static CustomPhoneStateListener phoneStateListener;
    Context context;
    Intent intent;

    public void onReceive(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
        // TODO Auto-generated method stub

        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        phoneStateListener = new CustomPhoneStateListener(context);
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_CALL_STATE);
    }

    }

class CustomPhoneStateListener extends PhoneStateListener {

    // private static final String TAG = "PhoneStateChanged";
    Context context; // Context to make Toast if required
    private AudioManager amanager;
    Intent i1;

    public CustomPhoneStateListener(Context context) {
        super();
        this.context = context;
        i1 = new Intent(context, CallActivity.class);
        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);

        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                Toast.makeText(context, "Phone state Idle", Toast.LENGTH_LONG)
                        .show();

                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:

                Toast.makeText(context, "Phone state Off hook", Toast.LENGTH_LONG)
                        .show();

                break;
            case TelephonyManager.CALL_STATE_RINGING:
                try {
                    Thread.sleep(3000);
                    i1.putExtra("Value", incomingNumber);
                    context.startActivity(i1);
                } catch (Exception e) {
                    e.getLocalizedMessage();
                }

            default:
                break;
        }
    }
}
