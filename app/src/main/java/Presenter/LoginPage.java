package Presenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.dev.TP2_Mobile.R;

import View.LoginPageView;

public class LoginPage extends AppCompatActivity {

    LoginPageView loginPageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginPageView = new LoginPageView(this);
    }
}
