package pith.itdev.pithtraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pithnb025 on 11/19/2015.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context objContext;
    private int[] iconInts;
    private String[] titleStrings;

    //Constructor
    public MyAdapter( Context objContext, int[] iconInts, String[] titleString) {
        this.iconInts = iconInts;
        this.objContext = objContext;
        this.titleStrings = titleString;
    }

    @Override
    //Cout ListView
    public int getCount() {
        return titleStrings.length; //ใส่ค่า เพื่อให้นับ
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Open Service เพื่อให้ add เข้าใช้งาน xml ได้
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView = objLayoutInflater.inflate(R.layout.traffic_listview, parent, false);

        //Setup Icon
        ImageView iconImageView = (ImageView) objView.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconInts[position]);

        //Set Title
        TextView titleTextView = (TextView) objView.findViewById(R.id.txtShowTitle);
        titleTextView.setText(titleStrings[position]);

        return objView;
    }
}

  // Main  Class
