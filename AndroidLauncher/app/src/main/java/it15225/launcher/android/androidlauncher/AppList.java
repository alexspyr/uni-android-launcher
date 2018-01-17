package it15225.launcher.android.androidlauncher;

import android.graphics.drawable.Drawable;

/**
 * Created by Alex on 1/16/2018.
 */

public class AppList {

    private String name, packagename;
    Drawable icon;
    static Boolean state = false;

    public AppList(String name, String packagename, Drawable icon, Boolean ispushclicked) {
        this.name = name;
        this.icon = icon;
        this.packagename = packagename;
        this.state = ispushclicked;
    }


    public String getName() {
        return name;
    }

    public String getPackagename() {
        return packagename;
    }

    public Drawable getIcon() {
        return icon;
    }

    public static void setpushed(Boolean state2) {
        state = state2;
    }

    public static Boolean getpushed() {
        return state;
    }
}