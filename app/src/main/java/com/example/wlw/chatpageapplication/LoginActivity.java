package com.example.wlw.chatpageapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttom= (Button) findViewById(R.id.action_login_send);

        buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String username=((EditText)findViewById(R.id.username)).getText().toString();
                String password=((EditText)findViewById(R.id.password)).getText().toString();
               boolean flag=false;

                for(int i=0;i<Data.USER.length;i++){
                    if(username.equals(Data.USER[i][0])){
                        if(password.equals(Data.USER[i][1])){

                            flag=true;
                            break;

                        }

                    }

                }
                if(flag){

                    Intent intent1=new Intent(LoginActivity.this,MainActivity.class);

                  startActivity(intent1);



                }else{

                    Toast.makeText(LoginActivity.this,"您输入的账号或密码错误",Toast.LENGTH_SHORT).show();

                }






            }
        });




    }
}
