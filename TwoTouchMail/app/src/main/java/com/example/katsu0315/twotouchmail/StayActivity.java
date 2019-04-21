package com.example.katsu0315.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StayActivity extends AppCompatActivity
        implements View.OnClickListener,View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_dinner);
        Button btnSend = (Button) this.findViewById(R.id.button);
        btnSend.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        EditText edit01 = (EditText) findViewById(R.id.editText_stay);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT,"今日泊まってくー！");
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View view) {
        EditText edit01 = (EditText) findViewById(R.id.editText_stay);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, "連絡遅くなった！¥n" + "今日泊まってくー！");
        startActivity(intent);
        return true;
    }
}
