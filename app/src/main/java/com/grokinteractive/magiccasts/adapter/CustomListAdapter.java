package com.grokinteractive.magiccasts.adapter;

import com.grokinteractive.magiccasts.R;
import com.grokinteractive.magiccasts.app.AppController;
import com.grokinteractive.magiccasts.model.Video;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Video> videoItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Video> videoItems) {
        this.activity = activity;
        this.videoItems = videoItems;
    }

    @Override
    public int getCount() {
        return videoItems.size();
    }

    @Override
    public Object getItem(int location) {
        return videoItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView collection = (TextView) convertView.findViewById(R.id.collection);
        TextView length = (TextView) convertView.findViewById(R.id.length);

        // getting movie data for the row
        Video m = videoItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // description
        description.setText(String.valueOf(m.getDescription()));

        // collection
        String collectionStr = "";
        for (String str : m.getCollection()) {
            collectionStr += str + ", ";
        }
        collectionStr = collectionStr.length() > 0 ? collectionStr.substring(0,
                collectionStr.length() - 2) : collectionStr;
        collection.setText(collectionStr);

        // length of video
        length.setText(String.valueOf(m.getLength()));

        return convertView;
    }

}