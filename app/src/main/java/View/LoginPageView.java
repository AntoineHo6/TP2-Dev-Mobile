package View;

import android.graphics.drawable.AnimationDrawable;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dev.TP2_Mobile.R;

public class LoginPageView {

    AppCompatActivity activity;

    public LoginPageView(AppCompatActivity activity) {
        this.activity = activity;

        ConstraintLayout constraintLayout = activity.findViewById(R.id.loginpage_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

}
