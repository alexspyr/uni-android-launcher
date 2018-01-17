package it15225.launcher.android.androidlauncher;

/**
 * Created by Alex on 1/17/2018.
 */

public class AppClass {

    //private variables
    int _id;
    String _name;

    // Empty constructor
    public AppClass() {

    }

    // constructor
    public AppClass(int id, String name) {
        this._id = id;
        this._name = name;
    }

    // constructor
    public AppClass(String name) {
        this._name = name;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

}
