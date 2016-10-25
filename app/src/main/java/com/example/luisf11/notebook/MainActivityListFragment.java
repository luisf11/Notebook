package com.example.luisf11.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private NoteAdapter noteAdapter;
    private ArrayList<Note> notes;

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
    super.onActivityCreated(savedInstanceState);

   /*     String[] values = new String[]{"android","iphone","linux","windows","macOs",
                "solaris","webOs","Ubuntu","blackberry","windows phone"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,values);

        setListAdapter(adapter);
        */

        notes = new ArrayList<Note>();
        notes.add(new Note("this is a new note title","this is the body of the note",
                Note.Category.PERSONAL));
        notes.add(new Note("this  note title","this is how we do it",
                Note.Category.FINANCE));
        notes.add(new Note("So far so good","el perrequetengue intenso",
                Note.Category.PERSONAL));
        notes.add(new Note("Learning android as fast as we can","im fucking android up with my learning path",
                Note.Category.TECHNICAL));
        notes.add(new Note("Ser o no ser","A mi hay que darme banda de camion",
                Note.Category.QUOTE));
        notes.add(new Note("this is a new note title","this is the body of the note",
                Note.Category.PERSONAL));
        notes.add(new Note("this  note title","this is how we do it",
                Note.Category.FINANCE));
        notes.add(new Note("So far so good","el perrequetengue intenso",
                Note.Category.PERSONAL));
        notes.add(new Note("Learning android as fast as we can","im fucking android up with my learning path",
                Note.Category.TECHNICAL));
        notes.add(new Note("Ser o no ser","A mi hay que darme banda de camion",
                Note.Category.QUOTE));
        noteAdapter = new NoteAdapter(getActivity(),notes);

        setListAdapter(noteAdapter);
}

    @Override
    public void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        LaunchNoteActivity(position);
    }

    private void LaunchNoteActivity (int position){
        //grab the  note information associated with whatever note we clicked on
        Note note = (Note) getListAdapter().getItem(position);

        //create a new intent that launch our note ativity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        //pass along the information of the note we click on the noteDetailActivity

        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA,note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA,note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA,note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA,note.getId());

        startActivity(intent);
    }

}
