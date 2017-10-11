package com.supermeetup.supermeetup.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codepath.oauth.OAuthLoginActionBarActivity;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.databinding.ActivityLoginBinding;
import com.supermeetup.supermeetup.network.MeetupClient;

/**
 * A login screen that offers login via meetup oauth.
 */
public class LoginActivity extends OAuthLoginActionBarActivity<MeetupClient> {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    public void attemptLogin() {
        // Show a progress spinner, and kick off a background task to
        // perform the user login attempt.
        showProgress(true);
        getClient().connect();
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            binding.llLoginLayout.setVisibility(show ? View.GONE : View.VISIBLE);
            binding.llLoginLayout.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    binding.llLoginLayout.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            binding.pbLoginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            binding.pbLoginProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    binding.pbLoginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            binding.pbLoginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            binding.llLoginLayout.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    @Override
    public void onLoginFailure(Exception e) {
        Toast.makeText(this, getString(R.string.login_fail), Toast.LENGTH_LONG).show();
    }

}

