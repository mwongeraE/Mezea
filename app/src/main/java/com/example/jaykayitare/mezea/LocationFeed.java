package com.example.jaykayitare.mezea;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class LocationFeed extends ListActivity {

    String[] crimes = {"Robbery", "murder", "carjacking", "fire"};
    ListView list;
    private static final String TWITTER_KEY = "yGhy4c9S3Oy3laXHISaGeuZLq";
    private static final String TWITTER_SECRET = "COTzl4B7SUkUiTiF2GzodHpeVtFmrXglG4SxfxqFxYHdnEwZer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("robbery OR crime OR murder OR rape AND nairobi -RT -1.2964, 36.894081,50mi")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getApplicationContext())
                .setTimeline(searchTimeline)
                .build();
        setListAdapter(adapter);
    }
}
