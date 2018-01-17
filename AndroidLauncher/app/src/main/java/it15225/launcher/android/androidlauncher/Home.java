package it15225.launcher.android.androidlauncher;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class Home extends Fragment {
    RelativeLayout relativeLayout;
    List<AppClass> apps;

    public Home() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);

        relativeLayout.post(new Runnable() {

            @Override
            public void run() {
                relativeLayout.setBackground(wallpaperDrawable);
            }
        });

        DatabaseHandler db = new DatabaseHandler(getContext());
        apps = db.getAlApps();

        // Ο σκοπός είναι να δείχνει τις πιο χρησιμοποιημενες εφαρμογες.
        // Καθε φορά που ο χρήστης πατα για να ανοίξει μια εφαρμογη απο το fragment Apps, εγγραφετε στην βασει
        // μια εγγραφη με το packagename, ώστε σε αυτο το fragment να δειχνει τις 4 πιο συχνα χρησιμοποιημενες εφαρμογες

        // Αν δεν υπαρχουν δεδομενα στην βαση, δλδ δεν υπαρχουν τουλαχιστον 4 ξεχωριστες εγγραφες με εφαρμογες
        // δειχνει τα 4 πρωτα αππς που θα βρει που ειναι στην συσκευη.

        Log.d("Home", "apps.size(): " + apps.size());

        if (apps.size() < 4) {
            Log.d("Home", "μπηκε μεσα στο if");


            List<ApplicationInfo> packs = getActivity().getPackageManager().getInstalledApplications(0);
            for (int i = 0; i < packs.size(); i++) {
                ApplicationInfo p = packs.get(i);
                if (p.packageName != null) {
                    String packageName = p.packageName;
                    AppClass app = new AppClass();
                    app.setName(packageName);
                    apps.add(app);
                }
                if (apps.size() > 4) {
                    break;
                }
            }


//            List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
//            for (int i = 0; i < packs.size(); i++) {
//                PackageInfo p = packs.get(i);
//                String installer = getActivity().getPackageManager().getInstallerPackageName(p.packageName);
//                if (installer != null) {
//                    String packageName = p.packageName;
//                    AppClass app = new AppClass();
//                    app.setName(packageName);
//                    apps.add(app);
//                }
//
//                if (apps.size() > 4) {
//                    break;
//                }
//            }

            Log.d("Home", "NEW apps.size(): " + apps.size());
        }
        if (apps.size() > 3) {
            // app 1
            TextView app_name_1 = (TextView) view.findViewById(R.id.app_name_1);
            try {
                final String packageName_1_helper = apps.get(0).getName();
                PackageManager packageManager = getContext().getPackageManager();
                String app_name_helper_1 = null;
                app_name_helper_1 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName_1_helper, PackageManager.GET_META_DATA));
                app_name_1.setText(app_name_helper_1);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            ImageView app_icon_1 = (ImageView) view.findViewById(R.id.app_icon_1);
            try {
                Drawable icon = getContext().getPackageManager().getApplicationIcon(apps.get(0).getName());
                app_icon_1.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            app_icon_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(apps.get(0).getName());
                    if (launchIntent != null) {
                        getContext().startActivity(launchIntent);
                    }
                }
            });


            // app 2
            TextView app_name_2 = (TextView) view.findViewById(R.id.app_name_2);
            try {
                final String packageName_2_helper = apps.get(1).getName();
                PackageManager packageManager = getContext().getPackageManager();
                String app_name_helper_2 = null;
                app_name_helper_2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName_2_helper, PackageManager.GET_META_DATA));
                app_name_2.setText(app_name_helper_2);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            ImageView app_icon_2 = (ImageView) view.findViewById(R.id.app_icon_2);
            try {
                Drawable icon = getContext().getPackageManager().getApplicationIcon(apps.get(1).getName());
                app_icon_2.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            app_icon_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(apps.get(1).getName());
                    if (launchIntent != null) {
                        getContext().startActivity(launchIntent);
                    }
                }
            });

            // app 3
            TextView app_name_3 = (TextView) view.findViewById(R.id.app_name_3);
            try {
                final String packageName_3_helper = apps.get(2).getName();
                PackageManager packageManager = getContext().getPackageManager();
                String app_name_helper_3 = null;
                app_name_helper_3 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName_3_helper, PackageManager.GET_META_DATA));
                app_name_3.setText(app_name_helper_3);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            ImageView app_icon_3 = (ImageView) view.findViewById(R.id.app_icon_3);
            try {
                Drawable icon = getContext().getPackageManager().getApplicationIcon(apps.get(2).getName());
                app_icon_3.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            app_icon_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(apps.get(2).getName());
                    if (launchIntent != null) {
                        getContext().startActivity(launchIntent);
                    }
                }
            });

            // app 4
            TextView app_name_4 = (TextView) view.findViewById(R.id.app_name_4);
            try {
                final String packageName_4_helper = apps.get(3).getName();
                PackageManager packageManager = getContext().getPackageManager();
                String app_name_helper_4 = null;
                app_name_helper_4 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName_4_helper, PackageManager.GET_META_DATA));
                app_name_4.setText(app_name_helper_4);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            ImageView app_icon_4 = (ImageView) view.findViewById(R.id.app_icon_4);
            try {
                Drawable icon = getContext().getPackageManager().getApplicationIcon(apps.get(3).getName());
                app_icon_4.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            app_icon_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(apps.get(3).getName());
                    if (launchIntent != null) {
                        getContext().startActivity(launchIntent);
                    }
                }
            });
        }

        return view;
    }

}
