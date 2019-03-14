package example.org.test.w05d03solapp01;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SEND_BROADCAST = "example.org.test.w05d03solapp01.SEND_BROADCAST";
    EditText etProductName;
    EditText etProductIdNumber;
    EditText etProductInventoryCount;
    EditText etProductDescription;
    BroadcastReceiver receiver;
    MyBroadCastReceiver myBroadCastReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // binding views
        etProductName = findViewById(R.id.etProductName);
        etProductIdNumber = findViewById(R.id.etProductIdNumber);
        etProductInventoryCount = findViewById(R.id.etProductInventoryCount);
        etProductDescription = findViewById(R.id.etProductDescription);
        // intiate intent filter
        intentFilter = new IntentFilter();

        // initiation my receiver
        myBroadCastReceiver = new MyBroadCastReceiver();

        // adding an action to the filter
        intentFilter.addAction(SEND_BROADCAST);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // register the receiver
        registerReceiver(myBroadCastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCastReceiver);
    }

    public void onClick(View view) {
        String userInput = etProductName.getText().toString() + etProductIdNumber.getText().toString()
                + etProductInventoryCount.getText().toString() + etProductDescription.getText().toString();
            if (userInput!= null){
                Intent intent = new Intent(SEND_BROADCAST);
                intent.putExtra("message", userInput);
                sendBroadcast(intent);
        }

    }
}
