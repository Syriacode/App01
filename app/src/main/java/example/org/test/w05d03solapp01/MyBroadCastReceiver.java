package example.org.test.w05d03solapp01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!= null){
            String receivedString = intent.getStringExtra("message");
            if(receivedString != null){
                Toast.makeText(context, "String passed = " + receivedString, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
