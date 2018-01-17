package it15225.launcher.android.androidlauncher.Adapters;

/**
 * Created by Alex on 1/17/2018.
 */

public class NewsList {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;

    public NewsList(String author, String title, String description, String url, String urlToImage) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
