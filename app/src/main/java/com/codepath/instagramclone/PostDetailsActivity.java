package com.codepath.instagramclone;

        import android.content.Context;
        import android.content.res.Configuration;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import com.bumptech.glide.Glide;

        import org.parceler.Parcels;

        import java.util.Date;

        import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class PostDetailsActivity extends AppCompatActivity {

    Post post;

    TextView post_creator;
    TextView post_caption;
    ImageView post_image;
    TextView post_timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        // resolve the view objects
        post_creator = (TextView) findViewById(R.id.post_creator);
        post_caption = (TextView) findViewById(R.id.post_caption);
        post_timestamp = (TextView) findViewById(R.id.post_timestamp);
        post_image = (ImageView) findViewById(R.id.post_image);

        // unwrap the movie passed in via intent, using its simple name as a key
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Log.d("PostDetailsActivity", String.format("Showing details for '%s'", post.getUser().getUsername()));

        // set the title and overview
        post_caption.setText(post.getDescription());
        post_creator.setText(post.getUser().getUsername());

        //Get date object from Parse and call calculateTimeAgo function
        //to convert date object into string, then set timestamp to the
        //new string

        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        post_timestamp.setText(timeAgo);

        //Glide for image
        if (post.getImage() != null) {

            Glide.with(this).load(post.getImage().getUrl()).into(post_image);

        }

    }
}