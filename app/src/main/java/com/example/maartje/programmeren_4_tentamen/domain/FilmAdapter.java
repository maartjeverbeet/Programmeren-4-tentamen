package com.example.maartje.programmeren_4_tentamen.domain;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maartje.programmeren_4_tentamen.R;

import java.util.ArrayList;

/**
 * Created by maartje on 17-6-2017.
 */

public class FilmAdapter extends BaseAdapter {

    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Film> filmArrayList;

    public FilmAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Film> filmArrayList) {
        this.mContext = context;
        this.mInflator = layoutInflater;
        this.filmArrayList = filmArrayList;
    }

    @Override
    public int getCount() {
        int size = filmArrayList.size();
        Log.i(TAG, "getCount() = " + size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "getItem() at " + position);
        return filmArrayList.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView at " + position);

        ViewHolder viewHolder;

        if (convertView == null) {
            Log.i(TAG, "convertView is NULL - nieuwe maken");

            convertView = mInflator.inflate(R.layout.filmlist_item, null);

            viewHolder = new ViewHolder();
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.filmTitle);

            convertView.setTag(viewHolder);
        } else {
            Log.i(TAG, "convertView BESTOND AL - hergebruik");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Film films = filmArrayList.get(position);
        viewHolder.textViewTitle.setText(films.getTitle());

        return convertView;
    }

    private static class ViewHolder {
        public TextView textViewTitle;
    }
}
