package com.googleplay.books;

public class Book {
    private String title;
    private String category;
    private String description;
    private int thumbnail;

    public static int countBooks = 0;

    public Book(){
        countBooks ++;
    }
    public Book(String title,String category,String description,int thumbnail){
        countBooks ++;
        this.title = title;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;

    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCountBooks() {
        return countBooks;
    }
}
