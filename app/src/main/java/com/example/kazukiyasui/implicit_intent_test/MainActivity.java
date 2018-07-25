package com.example.kazukiyasui.implicit_intent_test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //移動ボタン
       final EditText et_url = findViewById(R.id.et_URL);
       Button bt_toWeb = findViewById(R.id.btn_toWeb);
       bt_toWeb.setOnClickListener(new View.OnClickListener() {     //移動ボタン クリックリスナー
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setAction(Intent.ACTION_VIEW);

               String url = et_url.getText().toString();
               Uri uri = Uri.parse(url);
               intent.setData(uri);

               startActivity(intent);
           }
       });

        /* 電話ボタン */
        final EditText et_tel = findViewById(R.id.et_Tel);
        Button bt_call = findViewById(R.id.btn_Call);
        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String tel = et_tel.getText().toString();
                Uri uri = Uri.parse("tel:" + tel);
                intent.setAction(Intent.ACTION_DIAL).setData(uri);

                startActivity(intent);
            }
        });

    }
}
