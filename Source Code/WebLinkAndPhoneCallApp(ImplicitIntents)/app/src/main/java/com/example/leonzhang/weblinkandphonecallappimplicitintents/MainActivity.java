package com.example.leonzhang.weblinkandphonecallappimplicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "Activity Start", Toast.LENGTH_SHORT).show();
        Button btn_web = (Button) findViewById(R.id.button_1);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb();
            }
        });
        Button btn_call = (Button) findViewById(R.id.button_2);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               goCall();
            }
        });
        Button btn_close = (Button) findViewById(R.id.button_3);
        btn_close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        });
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "Activity Restart", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Activity Resume", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Activity Pause", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Activity Stop", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Activity Destroy", Toast.LENGTH_SHORT).show();
    }
    private void goWeb() {
        //Get input String web address
        EditText webText = (EditText) findViewById(R.id.text_web);
        String url = webText.getText().toString();
        Uri uriUrl = Uri.parse(url);
        //Use ACTION_VIEW open Browser
        Intent openBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(openBrowser);
    }

    public void goCall() {
        //Get input String numbers
        EditText numCall = (EditText) findViewById(R.id.num_phone);
        String num = numCall.getText().toString();
        //Make Phone call through android ACTION_DIAL
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+num));
        startActivity(callIntent);
    }
}
