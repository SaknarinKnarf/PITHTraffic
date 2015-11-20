package pith.itdev.pithtraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private ImageView trafficImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bindWidget();

        //Show View
        showView();
    }//Main Method

    private void showView() {

        //Show Title
        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        //Show Image
        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        trafficImageView.setImageResource(intImage);

        //Show Detail
        int intIndex = getIntent().getIntExtra("Index", 0);
        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        detailTextView.setText(strDetail[intIndex]);
    }

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.textDetailTitle);
        detailTextView = (TextView) findViewById(R.id.textDetail);
        trafficImageView = (ImageView) findViewById(R.id.imvDetailView);
    }

}//Main Class
