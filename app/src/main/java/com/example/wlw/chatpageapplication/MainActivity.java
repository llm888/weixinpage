package com.example.wlw.chatpageapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private EditText meditext;
    private Button mbutton;
    private MsgAdapter mMsgAdapter;
    private List<Msg> mMsgList=new ArrayList<Msg>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            initMsgs();
            mMsgAdapter = new MsgAdapter(this, R.layout.list_item_msg, mMsgList);
            mListView = (ListView) findViewById(R.id.action_mail_tv_view);
            mListView.setAdapter(mMsgAdapter);
            mbutton = (Button) findViewById(R.id.action_main_btn_send);
            meditext = (EditText) findViewById(R.id.action_mail_tv_input);

            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content = meditext.getText().toString();
                    if (!"".equals(content)) {

                        Msg msg = new Msg(content, Msg.TYPE_SENT);
                        mMsgList.add(msg);
                        mMsgAdapter.notifyDataSetChanged();
                        mListView.setSelection(mMsgList.size());
                        meditext.setText("");


                    }
                }
            });


        }



    private void initMsgs() {
        mMsgList.add(new Msg("hahahahahahh",Msg.TYPE_RECEIVED));
        mMsgList.add(new Msg("nihao",Msg.TYPE_SENT));
    }
}
