package it15225.launcher.android.androidlauncher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import it15225.launcher.android.androidlauncher.Adapters.NewsAdapter;
import it15225.launcher.android.androidlauncher.Adapters.NewsList;

public class Extra extends Fragment {
    String TAG = "Extra";
    RecyclerView recyclerView;
    ArrayList<NewsList> news;
    NewsAdapter newsadapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    public Extra() {
    }

    public static Extra newInstance() {
        Extra fragment = new Extra();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extra, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        news = new ArrayList<>();

        newsadapter = new NewsAdapter(getContext(), news);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newsadapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        retrievedata();

        ImageView share = (ImageView) view.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Share.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void retrievedata() {
        String news_url = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=eba63c1fe6ac431fa1318ce2dbdbf0ca";

        // a potentially  time consuming task
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest newrequest = new StringRequest(Request.Method.GET, news_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "news response: " + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray arr = obj.getJSONArray("articles");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject mJsonObject = arr.getJSONObject(i);
                        String author = mJsonObject.getString("author");
                        String title = mJsonObject.getString("title");
                        String description = mJsonObject.getString("description");
                        String url = mJsonObject.getString("url");
                        String urlToImage = mJsonObject.getString("urlToImage");
                        news.add(new NewsList(author, title, description, url, urlToImage));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                newsadapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(newrequest);
    }
}
