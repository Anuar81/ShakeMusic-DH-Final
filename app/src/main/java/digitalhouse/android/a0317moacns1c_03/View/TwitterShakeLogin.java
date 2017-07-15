package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

import digitalhouse.android.a0317moacns1c_03.R;

public class TwitterShakeLogin extends AppCompatActivity {

    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);

        setContentView(R.layout.activity_twitter_shake_login);

        loginButton = (TwitterLoginButton) findViewById(R.id.botonTweet);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession twitterSession = result.data;
                Toast.makeText(TwitterShakeLogin.this,twitterSession.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(TwitterShakeLogin.this,exception.toString(),Toast.LENGTH_LONG).show();
            }
        });

/*
        Button buttonTweet = (Button)findViewById(R.id.botonTweet);
        buttonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                        .getActiveSession();
                final Intent intent = new ComposerActivity.Builder(TwitterShakeLogin.this)
                        .session(session)
                        .text("Love where you work")
                        .hashtags("#twitter")
                        .createIntent();
                startActivity(intent);
            }
        });
*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }




}
