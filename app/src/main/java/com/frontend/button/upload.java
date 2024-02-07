package com.frontend.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class upload extends AppCompatActivity {
    private static final int REQUEST_FILE_CHOOSER= 1;
    private ImageView imageView;
    private Button chooseFileButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        imageView = findViewById(R.id.imageView);
        chooseFileButton = findViewById(R.id.chooseFileButton);

        chooseFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchChooseFileIntent();
            }
        });
    }

    private void dispatchChooseFileIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Set the MIME type of files to be selected. Adjust as needed.
        startActivityForResult(intent,REQUEST_FILE_CHOOSER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FILE_CHOOSER && resultCode == RESULT_OK && data != null) {
            Uri fileUri = data.getData();
            if (fileUri != null) {
                imageView.setImageURI(fileUri);
                Button button = findViewById(R.id.chooseFileButton);
                button.setText("    Proceed    ");
            }
        }
    }
}