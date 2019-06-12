package com.example.musicplayerwithlogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText Login;
    private EditText Password;
    private TextView Info;
    private Button bLogin;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = (EditText)findViewById(R.id.Login);
        Password = (EditText)findViewById(R.id.Password);
        Info = (TextView)findViewById(R.id.Info);
        bLogin= (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Login.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String username, String userPW){
        if((username.equals("admin") && userPW.equals("admin"))){
            Intent intent = new Intent(MainActivity.this, Music.class);
            startActivity(intent);
        }
        else{
            counter--;
            Info.setText("Количество оставшихся попыток: " + String.valueOf(counter));

            if(counter == 0){
                bLogin.setEnabled(false);
            }
        }
    }
}
