/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author dhanush
 */
public class BookDescriptions {
    public int Isbn;
    public String Title;
    public String Author;
    public float price;
    public String Publisher;
    public int edition;

    /*public BookDescriptions(){
        this.Isbn = 0;
        this.Title="";
        this.Description="";
        this.edition=0;
        this.price=0;
        this.Publisher="";
    }*/


public String getTitle(){
        return Title;
    }
public String getAuthor(){
        return Author;
    }
public String getPublisher(){
        return Publisher;
    }
public float getPrice(){
        return price;
    }
public int getEdition(){
        return edition;
    }
public int getIsbn(){
        return Isbn;
    }

    void initialize(int Isbn, String Title, String Author, float price, int edition, String Publisher) {
        this.Isbn=Isbn;
        this.Title=Title;
        this.Author=Author;
        this.edition=edition;
        this.price=price;
        this.Publisher=Publisher;

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}