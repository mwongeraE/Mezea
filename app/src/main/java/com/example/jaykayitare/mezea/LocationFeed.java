package com.example.jaykayitare.mezea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import io.fabric.sdk.android.Fabric;

public class LocationFeed extends AppCompatActivity {

    String[] crimes = {"Robbery", "murder", "carjacking", "fire"};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_feed);

        list = (ListView)findViewById(R.id.list);

        TwitterSession session = Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("yGhy4c9S3Oy3laXHISaGeuZLq", "COTzl4B7SUkUiTiF2GzodHpeVtFmrXglG4SxfxqFxYHdnEwZer");
        Fabric.with(this, new Twitter(authConfig));
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();

        StatusesService statusesService = twitterApiClient.getStatusesService();
        statusesService.show(726092532363452417L, null, null, null, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(getApplicationContext(),"failure",Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,crimes);
        list.setAdapter(adapter);

    }
}
