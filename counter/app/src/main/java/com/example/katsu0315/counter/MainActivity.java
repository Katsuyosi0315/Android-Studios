package com.example.katsu0315.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

// 追加
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 追加
    int count = 0;
    private TextView counter_text;
    private TextView count_text;
    private Button countButton;
    private Button resetButton;

    //上限値
    private static int limit = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 追加：画面のアイテムと紐付け
        count_text = (TextView)findViewById(R.id.counter);
        counter_text = (TextView)findViewById(R.id.countNumber);
        countButton = (Button)findViewById(R.id.countButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setEnabled(false);

        // 追加：カウントボタンクリック
        countButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                counter_text.setText(String.valueOf(count));
                if (!resetButton.isEnabled()) {
                    resetButton.setEnabled(true);
                }
                if (count == limit) {
                    count_text.setText("Congratulation!");
                    countButton.setEnabled(false);
                }
            }
        });

        // 追加：リセットボタンクリック
        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count = 0;
                counter_text.setText(String.valueOf(count));
                countButton.setEnabled(true);
                count_text.setText("push the button!");
                resetButton.setEnabled(false);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}