/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import BookModel.DisplayViewController;

/**
 *
 * @author dhanush
 */
public class DatabaseManager {
        DatabaseImpInterface imp = new RelationalDatabaseImpl();

    public void Display(){
        imp.Display();
    }

    public void InsertBook(BookDescriptions b) {
        //System.out.println(b.Isbn);
        imp.InsertBook(b);
    }

    public void UpdateBook(BookDescriptions b) {
        imp.UpdateBook(b);
    }

    public void DeleteBook(int Isbn) {
        imp.DeleteBook(Isbn);
    }

    public BookDescriptions RetriveBook(int Isbn) {
        return imp.RetriveBook(Isbn);
    }

    public void UndoOperation() {
        imp.UndoOperation();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void RedoOperation() {
        imp.RedoOperation();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
