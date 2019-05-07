package tw.edu.ntut.sdtlab.crawler.testapp.testrandominput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private char[] specialCharacters;

    private Button loginButton;
    private EditText accountEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        specialCharacters = "!#$%‘()*+-′./:]^_`{|}~;<=>@[&\\\"\'?".toCharArray();

        loginButton = (Button) findViewById(R.id.login_button);
        accountEditText = (EditText) findViewById(R.id.account_editText);
        passwordEditText = (EditText) findViewById(R.id.password_editText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (containSpecialCharacter(accountEditText) || containSpecialCharacter(passwordEditText))
                    crash();
            }
        });
    }

    private boolean containSpecialCharacter(EditText editText) {
        char[] editTextCharacters = editText.getText().toString().toCharArray();
        for (char specialCharacter : specialCharacters)
            for (char editTextCharacter : editTextCharacters)
                if (editTextCharacter == specialCharacter)
                    return true;
        return false;
    }

    private void crash() {
        int i = 1 / 0;
    }

}
