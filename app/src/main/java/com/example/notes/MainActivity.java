package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.notes.Utils.VerticalHeightItemDecorator;
import com.example.notes.adapters.NotesRecyclerAdapter;
import com.example.notes.model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.onNoteClickListener{

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;

    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        fakeData();

        setSupportActionBar((Toolbar) findViewById(R.id.notes_toolbar));
        setTitle("Notes");
        
    }

    private void fakeData(){
        for(int i=0;i<20;i++){
            Note note = new Note("New Note","This is a new note","Sep 2020");
            mNotes.add(note);
        }
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        VerticalHeightItemDecorator verticalHeightItemDecorator = new VerticalHeightItemDecorator(8);
        mRecyclerView.addItemDecoration(verticalHeightItemDecorator);

        mAdapter = new NotesRecyclerAdapter(mNotes,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onNoteClick(int pos) {
        Log.d(TAG, "onNoteClick: " +pos);

        Intent intent = new Intent(this,NotesActivity.class);
        intent.putExtra("selected_note",mNotes.get(pos));
        startActivity(intent);
    }
}