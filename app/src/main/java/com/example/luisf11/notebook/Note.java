package com.example.luisf11.notebook;

/**
 * Created by luisf11 on 20/10/16.
 */

public class Note {


    private String title,message;
    private long noteId ,dateCreatedMilli;
    private Category category;

    public enum Category {PERSONAL, TECHNICAL , QUOTE, FINANCE}

    public Note(String title,String message,Category category){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;

    }

    public Note(String title,String message,Category category, long noteId, long dateCreatedMilli){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;

    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getDate (){return dateCreatedMilli;}
    public long getId (){return noteId;}

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", noteId=" + noteId +
                ", dateCreatedmilli=" + dateCreatedMilli +
                ", category=" + category +
                '}';
    }

    public int getAssociatedDrawable(){
        return categoryToDrawable(category);

    }

    public static int categoryToDrawable (Category noteCategory){
        switch (noteCategory){
            case PERSONAL:
                return R.drawable.p;
            case TECHNICAL:
                return R.drawable.t;
            case FINANCE:
                return R.drawable.f;
            case QUOTE:
                return R.drawable.q;

        }
        return R.drawable.p;
    }

}
