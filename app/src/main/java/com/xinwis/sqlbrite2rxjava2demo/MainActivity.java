package com.xinwis.sqlbrite2rxjava2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xinwis.sqlbrite2rxjava2demo.db.DBUtil;

public class MainActivity extends AppCompatActivity {


    private DBUtil dbUtil;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbUtil = DBUtil.getInstance(MainActivity.this);
        tv = (TextView) findViewById(R.id.tv);
        Button insert = (Button) findViewById(R.id.insert);
        Button query = (Button) findViewById(R.id.query);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbUtil.insertAccountInfo(new AccountInfo(1, 2, 3, "xinzhihui", "zhusha", "朱砂", "18986170640", "4", "5", "76", "ceshi", "nv", "www.baidu.com"));
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountInfo accountInfo = dbUtil.queryAccountInfo();
                if (accountInfo!=null){
                    tv.setText("数据库里查到的第一条信息："+accountInfo.toString());
                }else {
                    tv.setText("数据库里没有找到相应的信息");
                }
            }
        });




    }


}
