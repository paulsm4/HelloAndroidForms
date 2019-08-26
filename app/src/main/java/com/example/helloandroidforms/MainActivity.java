package com.example.helloandroidforms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * REFERENCE:
 * Android Essentials: Creating Simple User Forms, Shane Conder & Lauren Darcey
 * https://code.tutsplus.com/tutorials/android-essentials-creating-simple-user-forms--mobile-1758
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTitle();
    }

    public void sendFeedback(View button) {
        // Read EditText fields
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String feedback = feedbackField.getText().toString();

        // Read spinner
        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String feedbackType = feedbackSpinner.getSelectedItem().toString();

        // Process e-mail
        final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean bRequiresResponse = responseCheckbox.isChecked();
        if (bRequiresResponse) {
            sendEmail(name, email, feedback, feedbackType);
        }

    }

    private void sendEmail(String name, String email, String feedback, String feedbackType) {
        ; // Send e-mail
    }

    private void updateTitle () {
        String version = "";
        try {
            Context context = this.getApplicationContext();
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = pInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView tv1 = (TextView)findViewById(R.id.TextViewTitle);
        String newTitle = tv1.getText() + " (v" + version + ")";
        tv1.setText(newTitle);
    }
}
