package com.example.update;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupactivity extends AppCompatActivity {

    EditText name, address, email, password, code;

    private Button login;
    private  Button signup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        name=(EditText) findViewById(R.id.signup_name);
        address = (EditText) findViewById(R.id.signup_address);
        email = (EditText) findViewById(R.id.signup_email);
        password= (EditText) findViewById(R.id.signup_password);
        code= (EditText) findViewById(R.id.signup_code_car);
        login= (Button) findViewById(R.id.login_login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(signupactivity.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });


        signup= (Button) findViewById(R.id.signup2_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVariables.name1=name.getText().toString();
                GlobalVariables.addr=address.getText().toString();
                GlobalVariables.em=email.getText().toString();
                GlobalVariables.pass=password.getText().toString();
                GlobalVariables.co=code.getText().toString();

                if (validate(name)&&validate(address)
                        &&validate(email)&&validate(password)&&validate(code)&&pssw(password)&&pssw(code))
                {
                    Toast.makeText(getApplicationContext(),"SuccessFully Register",Toast.LENGTH_LONG).show();
                    if(v.getId()==R.id.signup2_button){
                        Intent intent= new Intent(signupactivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }



    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() < 1) {
            editText.setError("Please Fill This.!!!");
            editText.requestFocus();
            return false;
        }
        return true;
    }
    private boolean pssw(EditText editText) {
        if (editText.getText().toString().trim().length() < 6) {
            editText.setError("less than 6");
            editText.requestFocus();
            return false;
        }
        return true;
    }

}


