package com.oooof.jonnyjonny.boccwilloughby;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    private ImageButton fBookImageBtn;
    private ImageButton callImageBtn;
    private TextView websiteLinkTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        websiteLinkTV=findViewById(R.id.websiteLinkTV);
        websiteLinkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.bodyofchristcommunity.org"));
                startActivity(webIntent);
            }
        });
        fBookImageBtn=findViewById(R.id.fBookImageBtn);
        fBookImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fBookIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.facebook.com/profile.php?id=377331148995997&ref=content_filter"));
                startActivity(fBookIntent);

            }
        });
        callImageBtn=(ImageButton)findViewById(R.id.callImageBtn);
        callImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"4409421985"));
                startActivity(callIntent);
            }
        });
    }
}
