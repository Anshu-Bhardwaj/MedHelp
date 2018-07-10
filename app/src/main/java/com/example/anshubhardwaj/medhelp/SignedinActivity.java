package com.example.anshubhardwaj.medhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignedinActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPhoneNumber;
    Button btnSignOut;
    Button button;
    RadioGroup genderRadioGroup;
    EditText name;
    EditText email;
    EditText age;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedin);

        findViews();
        setPhoneNumber();
        button.setOnClickListener(this);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SignedinActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void findViews() {
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        btnSignOut = findViewById(R.id.btn_sign_out);
        button = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        genderRadioGroup = findViewById(R.id.gender);
    }

    private void setPhoneNumber() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        try {
            tvPhoneNumber.setText(user.getPhoneNumber());
        } catch (Exception e) {
            Toast.makeText(this, "Phone number not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        Bundle b = new Bundle();

        b.putString("name", name.getText().toString());
        b.putString("email", email.getText().toString());
        b.putString("age", age.getText().toString());
        int id = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(id);
        b.putString("gender", radioButton.getText().toString());

        intent.putExtras(b);
        String user_name = name.getText().toString();
        startActivity(intent);

    }
}