package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.notes.model.Note;

public class NotesActivity extends AppCompatActivity {

    private static final String TAG = "NotesActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        if(getIntent().hasExtra("selected_note")){
            Note note = getIntent().getParcelableExtra("selected_note");

            Log.d(TAG, "onCreate: "+ note.toString());
        }
    }
}