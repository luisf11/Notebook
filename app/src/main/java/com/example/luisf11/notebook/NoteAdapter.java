package com.example.luisf11.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by luisf11 on 20/10/16.
 */

public class NoteAdapter extends ArrayAdapter<Note>{

    public static class ViewHolder{
        TextView title;
        TextView note;
        ImageView noteIcon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0 ,  notes);
    }
    public View getView (int position, View convertView, ViewGroup parent){
        //get the date item for this position
        Note note = getItem(position);

        // check if an existing view is being reused, otherwise inflate a new view from custom row layout
        ViewHolder viewHolder;
        if (convertView == null){

            //if we dont have a view that is being used create one, and make sure you create a
            // view holder along with it to save our view references to.
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row,parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.note = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //use set tag to remenber our view holder which is holding our references to our widgets
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }




        //fill each new referenced view with data associated with note it's referencing
        viewHolder.title.setText(note.getTitle());
        viewHolder.note.setText(note.getMessage());
        viewHolder.noteIcon.setImageResource(note.getAssociatedDrawable());

        // now that we modified the view to display appropiate data,
        //return it so it will be displayed

        return convertView;
    }
}
