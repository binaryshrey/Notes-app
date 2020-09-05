package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notes.Utils.VerticalHeightItemDecorator;
import com.example.notes.adapters.NotesRecyclerAdapter;
import com.example.notes.model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        //fakeData();
        
    }

//    private void fakeData(){
//        for(int i=0;i<10;i++){
//            Note note = new Note("New Note","This is a new note","Sep 2020");
//            mNotes.add(note);
//        }
//        mAdapter.notifyDataSetChanged();
//    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        VerticalHeightItemDecorator verticalHeightItemDecorator = new VerticalHeightItemDecorator(8);
        mRecyclerView.addItemDecoration(verticalHeightItemDecorator);

        mAdapter = new NotesRecyclerAdapter(mNotes);
        mRecyclerView.setAdapter(mAdapter);
    }

}