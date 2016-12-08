/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import BookModel.RetriveDataController;
import BookModel.UndoRedoList;
import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
class DeleteBookDB extends RDBImplCommand {
  BookDescriptions b = new BookDescriptions();
  // RDBImplCommand RetriveBookDB;
   //System.out.println(b.Isbn);
        
        
  private String sqlQuery = "DELETE FROM BookDescriptions WHERE Isbn=?";
  private String UndoQuery = "INSERT INTO BOOKDESCRIPTIONS VALUES(?,?,?,?,?,?)";
  //private String TempQuery = "SELECT * FROM BOOKDESCRIPTIONS WHERE Isbn=?";
  private int Isbn;
  UndoRedoList URList = new UndoRedoList();

    public DeleteBookDB(int Isbn) {
        //this.RetriveBookDB = new RetriveBookDB(Isbn);
        this.Isbn=Isbn;
        //RetriveBookDB R = new RetriveBookDB(Isbn);
    }

  public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1, Isbn);
            
            
            String[] temp=statement.toString().split(": ");
            URList.SetRedoItem(temp[1]);
            
            RetriveDataController obj=new RetriveDataController();
            b=obj.Retrive(Isbn); 
            //System.out.println(b);
            statement1 = conn.prepareStatement(UndoQuery);
            statement1.setInt(1, b.getIsbn());
            statement1.setString(2, b.getTitle());
            statement1.setString(3, b.getAuthor());
            statement1.setFloat(4, b.getPrice());
            statement1.setString(5, b.getPublisher());
            statement1.setInt(6, b.getEdition());
            String[] temp1=statement1.toString().split(": ");
            URList.SetUndoItem(temp1[1]);
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
        System.out.println("DELETE Failed");
        System.out.println(e);
            conn.close();
        } finally {
            statement.close();
        }
    }
    
    public void processResult(){
        //URList.UndoIndex=URList.ListSize();
        //URList.RedoIndex=URList.ListSize()-1;
        result="";
    }
    
}


