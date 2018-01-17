package it15225.launcher.android.androidlauncher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class Share extends AppCompatActivity {
//    Button sharehelper;
//    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Button sharetonwitter = (Button) findViewById(R.id.share_twitter);
        sharetonwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharetwitter();
            }
        });

//        sharehelper = (Button) findViewById(R.id.share_facebook);
//        sharehelper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sharefacebook();
//            }
//        });

//        shareDialog = new ShareDialog(this);


    }


    public void sharetwitter() {
        TweetComposer.Builder builder = new TweetComposer.Builder(getApplicationContext())
                .text("Check out this awesome launcher!");
        builder.show();
    }

//    public void sharefacebook() {
//        ShareLinkContent content = new ShareLinkContent.Builder()
//                .setContentTitle("Check out this awesome launcher!")
//                .build();
//        shareDialog.show(content);
//    }

}
