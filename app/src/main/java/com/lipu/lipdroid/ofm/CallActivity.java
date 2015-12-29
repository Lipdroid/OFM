package com.lipu.lipdroid.ofm;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class CallActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        setContentView(R.layout.activity_call);
        String value = getIntent().getStringExtra("Value");
        Log.e("Extra",value);

    }
}
