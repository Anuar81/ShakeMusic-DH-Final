package digitalhouse.android.a0317moacns1c_03.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuthException;

import digitalhouse.android.a0317moacns1c_03.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextpassword;
    private FirebaseAuthException mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}
