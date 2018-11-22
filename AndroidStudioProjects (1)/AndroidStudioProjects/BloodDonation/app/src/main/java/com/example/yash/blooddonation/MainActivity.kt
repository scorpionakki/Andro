package com.example.yash.blooddonation

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.firebase.ui.auth.AuthUI
import java.util.*
import java.util.Arrays.asList
import com.firebase.ui.auth.AuthUI.IdpConfig
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {
    //try convert from val to var
    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // User is signed in
        } else {
            val whitelistedCountries = ArrayList<String>()
            whitelistedCountries.add("+91")
            val phoneConfigWithWhitelistedCountries = IdpConfig.PhoneBuilder()
                .setWhitelistedCountries(whitelistedCountries)
                .build()
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setIsSmartLockEnabled(false)
                    .setAvailableProviders(
                        Arrays.asList(
                            AuthUI.IdpConfig.GoogleBuilder().build(),
                            AuthUI.IdpConfig.FacebookBuilder().build(),
                            AuthUI.IdpConfig.EmailBuilder().build(),
                            AuthUI.IdpConfig.PhoneBuilder().build()
                        )
                    )
                    .setTosAndPrivacyPolicyUrls("https://superapp.example.com/terms-of-service.html",
                    "https://superapp.example.com/privacy-policy.html")
                    .build(),
                RC_SIGN_IN
            )

        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
            if (requestCode == RC_SIGN_IN) {
                val response = IdpResponse.fromResultIntent(data)

                // Successfully signed in
                if (resultCode == Activity.RESULT_OK) {
                    val intent = Intent(this, Main2Activity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Sign in failed
                    if (response == null) {
                        // User pressed back button
                        Toast.makeText(this,R.string.sign_in_cancelled, Toast.LENGTH_LONG)
                        return
                    }

                    if (response.error!!.errorCode == ErrorCodes.NO_NETWORK) {
                        Toast.makeText(this,R.string.no_internet_connection, Toast.LENGTH_LONG)
                        return
                    }

                    Toast.makeText(this,response.error.toString(),Toast.LENGTH_LONG)
                    Log.e("ERROR", "Sign-in error: ", response.error)
                }
            }
        }

    }

    fun signOut(v: View) {

            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(object : OnCompleteListener<Void> {
                    override fun onComplete(task: Task<Void>) {
                        // user is now signed out
                        startActivity(Intent(this@MainActivity, MainActivity::class.java))
                        finish()
                    }
                })
        Toast.makeText(this,"Not in IF", Toast.LENGTH_LONG)
    }


}
