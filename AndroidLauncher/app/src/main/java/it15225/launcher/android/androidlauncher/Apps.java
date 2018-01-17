package it15225.launcher.android.androidlauncher;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import it15225.launcher.android.androidlauncher.Adapters.AppAdapter;

public class Apps extends Fragment {
    String TAG = "Apps";
    GridView gridview;
    private AppAdapter appAdapter;
    ArrayList<String> names_list = new ArrayList<>();
    ArrayList<String> packagename_list = new ArrayList<>();

    public Apps() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps, container, false);

        gridview = (GridView) view.findViewById(R.id.gridView1);


        List<ApplicationInfo> packs = getActivity().getPackageManager().getInstalledApplications(0);
        for (int i = 0; i < packs.size(); i++) {
            ApplicationInfo p = packs.get(i);
            if (p.packageName != null) {
                String packageName = p.packageName;
                PackageManager packageManager = getActivity().getApplicationContext().getPackageManager();
                String appName = null;
                try {
                    appName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                if (appName != null) {
                    Log.d(TAG, "packageName: " + packageName + " , appName: " + appName);
                    names_list.add(appName);
                    packagename_list.add(packageName);
                }
            }

        }

        appAdapter = new AppAdapter(getContext(), names_list, packagename_list);
        gridview.setAdapter(appAdapter);

        return view;
    }


}
