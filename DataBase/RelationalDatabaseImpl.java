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
public class RelationalDatabaseImpl implements DatabaseImpInterface{
    public RelationalDatabaseImpl() {
        
    }
     //final String a="sucess";
    @Override
    public void Display() {
        RDBImplCommand GetBooks = new GetBooks();
        GetBooks.execute();
        //return a;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertBook(BookDescriptions b) {
           RDBImplCommand InsertBookDB = new InsertBookDB(b);
           //System.out.println(b.Isbn);
           InsertBookDB.execute();
           //return a;
    }

    @Override
    public void UpdateBook(BookDescriptions b) {
        RDBImplCommand UpdateBookDB = new UpdateBookDB(b);
        //System.out.println(b.Isbn);
        UpdateBookDB.execute();
        //return a;
    }

    @Override
    public void DeleteBook(int Isbn) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        RDBImplCommand DeleteBookDB = new DeleteBookDB(Isbn);
        //System.out.println(b.Isbn);
        DeleteBookDB.execute();
        //return a;
    }

    @Override
    public BookDescriptions RetriveBook(int Isbn) {
        RDBImplCommand RetriveBookDB = new RetriveBookDB(Isbn);
        //System.out.println(b.Isbn);
        RetriveBookDB.execute();
        return (BookDescriptions)RetriveBookDB.getResult();    
    }

    @Override
    public void UndoOperation() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        RDBImplCommand UndoOperationDB = new UndoOperationDB();
        //System.out.println(b.Isbn);
        UndoOperationDB.execute();
    }

    @Override
    public void RedoOperation() {
        RDBImplCommand RedoperationDB = new RedoperationDB();
        //System.out.println(b.Isbn);
        RedoperationDB.execute();        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
