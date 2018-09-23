package com.example.shubham.login_page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView attempt;
    private EditText username;
    private EditText password;
    private Button login;

    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick();
    }

    public void onClick(){
        attempt = (TextView)findViewById(R.id.textView6);
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);

        attempt.setText(Integer.toString(attempt_counter));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("root") && (password.getText().toString().equals("toor"))){
                    Toast.makeText(MainActivity.this," Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,User.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"wrong Username or Password",Toast.LENGTH_SHORT).show();
                    attempt_counter--;
                    attempt.setText(Integer.toString(attempt_counter));
                    if(attempt_counter == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });
    }
}
