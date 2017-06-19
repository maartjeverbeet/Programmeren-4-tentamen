package com.example.maartje.programmeren_4_tentamen.domain;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by maartje on 17-6-2017.
 */

public class FilmMapper{
    public static final String FilmTitle = "title";
    public static final String Year = "release_year";
    public static final String Rating = "rating";
    public static final String Film_Result = "result";

    public static ArrayList<Film> mapFilmList(JSONObject response){
        ArrayList<Film> result = new ArrayList<>();

        try{
            JSONArray jsonArray = response.getJSONArray(Film_Result);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Film film = new Film(
                        jsonObject.getString(FilmTitle),
                        jsonObject.getString(Rating),
                        jsonObject.getString(Year)
                );

                result.add(film);
            }
        } catch (JSONException ex) {
            Log.e("FilmMapper", "onPostExecute JSONExecption " + ex.getLocalizedMessage());
        }
        return result;
    }
}
