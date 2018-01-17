package it15225.launcher.android.androidlauncher;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            String installer = getActivity().getPackageManager().getInstallerPackageName(p.packageName);
            if (installer != null) {
                String appName = p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
                String packageName = p.packageName;
                names_list.add(appName);
                packagename_list.add(packageName);
            }
        }

        appAdapter = new AppAdapter(getContext(), names_list, packagename_list);
        gridview.setAdapter(appAdapter);

        return view;
    }


}
