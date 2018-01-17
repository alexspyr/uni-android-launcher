package it15225.launcher.android.androidlauncher.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it15225.launcher.android.androidlauncher.AppClass;
import it15225.launcher.android.androidlauncher.DatabaseHandler;
import it15225.launcher.android.androidlauncher.R;

/**
 * Created by Alex on 1/16/2018.
 */

public class AppAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<String> names_list = new ArrayList<>();
    ArrayList<String> packagename_list = new ArrayList<>();
    private static final String TAG = "AppAdapter";
    private LayoutInflater layoutInflater;

    public AppAdapter(Context c, ArrayList<String> names_list, ArrayList<String> packagename_list) {
        mContext = c;
        this.names_list = names_list;
        this.packagename_list = packagename_list;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return names_list.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View grid;
        if (convertView == null) {
            grid = new View(mContext);
            grid = layoutInflater.inflate(R.layout.app_row, null);
        } else {
            grid = (View) convertView;
        }

        TextView app_name = (TextView) grid.findViewById(R.id.app_name);
        app_name.setText(names_list.get(position));

        ImageView app_icon = (ImageView) grid.findViewById(R.id.app_icon);
        try {
            Drawable icon = mContext.getPackageManager().getApplicationIcon(packagename_list.get(position));
            app_icon.setImageDrawable(icon);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        app_icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(mContext);
                db.addApp(new AppClass(packagename_list.get(position)));

                Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packagename_list.get(position));
                if (launchIntent != null) {
                    mContext.startActivity(launchIntent);
                }
            }
        });

        return grid;
    }

}
