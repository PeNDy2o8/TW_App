package com.example.twapp.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twapp.ChangeIcon.Myappicon;
import com.example.twapp.MainActivity;
import com.example.twapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logins extends AppCompatActivity {
    MyAPIService myAPIService;
    TextView account,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        Button btn_create = findViewById(R.id.createAccount);
        Button btn_login=findViewById(R.id.login_button);
        password=findViewById(R.id.passwordInput);
        account =findViewById(R.id.accountInput);
        myAPIService= RetrofitManager.getInstance().getAPI();
        Myappicon gv=(Myappicon)getApplicationContext();

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Logins.this,CreateAcount.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<UserData> call=myAPIService.getAlbumsByVerify(account.getText().toString(),password.getText().toString());
               call.enqueue(new Callback<UserData>() {
                   @Override
                   public void onResponse(Call<UserData> call, Response<UserData> response) {
                       if(response.code()==200){
                           gv.setName(response.body().getName());
                           gv.setAccount(response.body().getAccount());
                           gv.setTelephone(response.body().getTelephone());

                           Intent intent=new Intent(Logins.this, MainActivity.class);
                           startActivity(intent);
                       }else {
                           Toast.makeText(Logins.this,"Error account Please check your account or password",Toast.LENGTH_LONG).show();

                       }


                   }

                   @Override
                   public void onFailure(Call<UserData> call, Throwable t) {
                        //登入失敗
                       Toast.makeText(Logins.this,"Error account Please check your account or password",Toast.LENGTH_LONG).show();
                   }
               });

            }
        });


    }
}