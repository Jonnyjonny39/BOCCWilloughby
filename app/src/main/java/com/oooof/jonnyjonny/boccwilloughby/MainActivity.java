package com.oooof.jonnyjonny.boccwilloughby;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private TextView textView;
    private TextView txtScripture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtScripture=findViewById(R.id.txtScript);
        txtScripture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FancyToast.makeText(MainActivity.this,"Therefore go and make disciples of all nations, baptizing them in the name of the Father, and of the Son and of the Holy Spirit and teaching them to obey everything I have commanded you. And surely I am with you always, to the very end of the age. \n" +
                        "                                             (Matthew 28:19-20)",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();

            }
        });
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.navigation);
        textView=findViewById(R.id.textView2);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:

                        break;
                    case R.id.aboutUs:
                        Intent aboutIntent=new Intent(MainActivity.this,AboutUsActivity.class);
                        startActivity(aboutIntent);
                        break;
                    case R.id.news:
                      Intent newsIntent=new Intent(MainActivity.this,NewsActivity.class);
                      startActivity(newsIntent);
                        break;
                    case R.id.calender:
                        Intent calenderIntent=new Intent(MainActivity.this,CalendarActivity.class);
                        startActivity(calenderIntent);

                        break;
                    case R.id.sermons:
                        Intent sermonIntent=new Intent(MainActivity.this,SermonActivity.class);
                        startActivity(sermonIntent);
                        break;




                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.share_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.share){
            Intent shareIntent=new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT," Come check us out! www.bodyofchristcommunity.org");
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent,"Share App To....."));





        }
        return true;
    }
}
