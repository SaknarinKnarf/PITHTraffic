package pith.itdev.pithtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.LiveFolders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private Button aboutMeButton;
    private ListView trafficListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Button Controller
        buttonController();


    }   //Main Method

    private void buttonController() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer buttunMediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.horse); //getBase:จากภายใน getMedia:จากภายนอก
                buttunMediaPlayer.start();

                //Intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("https://youtu.be/HWb1m5PM6zI"));
                startActivity(objIntent);

            }   //event
        });

    }

    private void bindWidget() {

        aboutMeButton = (Button) findViewById(R.id.button);
        trafficListView = (ListView) findViewById(R.id.listView);

    }

}   // Main Class นี่คือ คลาสหลัก
