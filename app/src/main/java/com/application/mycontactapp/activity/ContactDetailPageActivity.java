package com.application.mycontactapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.mycontactapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ContactDetailPageActivity extends AppCompatActivity {


    private ImageView userProfilePictureImageView, closeImageView;
    private TextView userProfileNameTextView, userProfileGroupTextView, userProfilePhoneTextView, userProfileRingtoneTextView, userProfileEmailTextView, userProfileIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail_page);
        init();
        addListener();
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        assert bundle != null;
        String url = bundle.getString("url");
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String phone = bundle.getString("phone");
        String id = bundle.getString("id");
        String ringtone = bundle.getString("ringtone");
        String group = bundle.getString("group");
        if (url != null) {
            Glide.with(ContactDetailPageActivity.this)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(userProfilePictureImageView);
        } else {

            Glide.with(ContactDetailPageActivity.this)
                    .load(R.drawable.ic_user)
                    .apply(RequestOptions.circleCropTransform())
                    .into(userProfilePictureImageView);

        }
        if (name != null)
            userProfileNameTextView.setText(name);
        if (email != null)
            userProfileEmailTextView.setText("\t\t\t\t\tEmail\t\t\t:\t" + email);
        else
            userProfileEmailTextView.setText("\t\t\tEmail\t\t:\t" + "Not Found");
        if (id != null)
            userProfileIdTextView.setText("ID\t\t\t:\t" + id);
        else
            userProfileIdTextView.setText("\t\t\tID\t\t:\t" + "Not Found");
        if (phone != null)
            userProfilePhoneTextView.setText("\t\t\t\tPhone\t\t\t:\t" + phone);
        else
            userProfileIdTextView.setText("\t\t\tPhone\t\t:\t" + "Not Found");
        if (ringtone != null)
            userProfileRingtoneTextView.setText("\t\t\tRingtone\t\t\t:\t" + ringtone);
        else
            userProfileRingtoneTextView.setText("\t\t\t\t\tRingtone\t\t:\t" + "Default Ringtone");
        if (group != null)
            userProfileGroupTextView.setText("In Visible Group\t\t\t\t\t\t->\t" + group);
        else
            userProfileRingtoneTextView.setText("In Visible Group\t\t\t\t->" + "Default");

    }

    private void init() {
        userProfilePictureImageView = findViewById(R.id.userProfilePictureImageView);
        closeImageView = findViewById(R.id.closeImageView);
        userProfileNameTextView = findViewById(R.id.userProfileNameTextView);
        userProfileEmailTextView = findViewById(R.id.userProfileEmailTextView);
        userProfileIdTextView = findViewById(R.id.userProfileIdTextView);
        userProfilePhoneTextView = findViewById(R.id.userProfilePhoneTextView);
        userProfileRingtoneTextView = findViewById(R.id.userProfileRingtoneTextView);
        userProfileGroupTextView = findViewById(R.id.userProfileGroupTextView);

    }

    private void addListener() {
        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactDetailPageActivity.this, ContactListPageActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
