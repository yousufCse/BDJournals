package com.yousufcsebd.topjournals;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xFF325F7F));

    }

    public void btnCloseClick(View view) {
        finish();
    }

    public void btnEmailClick(View view) {
            String emailId = "yousuf.stu@gmail.com";
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailId});
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Send mail to Developer"));

    }
}
