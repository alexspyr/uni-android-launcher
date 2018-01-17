package it15225.launcher.android.androidlauncher.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import it15225.launcher.android.androidlauncher.R;

/**
 * Created by Alex on 1/17/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private static final String TAG = "AppAdapterMainTrending";
    public String id;
    private List<NewsList> listStorage;
    public Context mContext;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;
        TextView description;
//        TextView author;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
//            author = (TextView) view.findViewById(R.id.author);
            description = (TextView) view.findViewById(R.id.description);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }


    public NewsAdapter(Context context, List<NewsList> customizedListView) {
        this.listStorage = customizedListView;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        NewsList story = listStorage.get(position);

        holder.title.setText(listStorage.get(position).getTitle());
//        holder.author.setText(listStorage.get(position).getAuthor());
        holder.description.setText(listStorage.get(position).getDescription());
        Picasso.with(mContext).load(listStorage.get(position).getUrlToImage()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open url with broswer
                String url = listStorage.get(position).getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listStorage.size();
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}



