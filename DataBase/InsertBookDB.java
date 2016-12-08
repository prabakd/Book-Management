/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import BookModel.UndoRedoList;
import bookmanagement.DisplayTable;
import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
public class InsertBookDB extends RDBImplCommand {
    /*private int Isbn;
    private String Title;
    private String Description;
    private float price;
    private String Publisher;
    private int edition;
    //private boolean expired;*/
         
    //private String sqlQuery = "SELECT (DATE_ADD(UserDatePasswordChanged, INTERVAL ? DAY) " +
    //        "< NOW()) as Expired FROM USER WHERE UserEmail = ?";
     //"UPDATE user set user.UserEmail=?, user.UserPassword=?, 
    //user.UserName=?, user.UserDepartment=?, user.UserRank=? WHERE user.UserID=?";
    private String sqlQuery = "INSERT INTO BOOKDESCRIPTIONS VALUES(?,?,?,?,?,?)";
    private String UndoQuery = "DELETE FROM BOOKDESCRIPTIONS WHERE Isbn=?";
    private BookDescriptions b;
    UndoRedoList URList = new UndoRedoList();

    public InsertBookDB(){
        
    }

    InsertBookDB(BookDescriptions b) {
        this.b=b;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1, b.getIsbn());
            statement.setString(2, b.getTitle());
            statement.setString(3, b.getAuthor());
            statement.setFloat(4, b.getPrice());
            statement.setString(5, b.getPublisher());
            statement.setInt(6, b.getEdition());
            //System.out.println("Hi");
            //System.out.println(b.Isbn);
            //System.out.println(b.getIsbn());
            //System.out.println(statement);
            String[] temp=statement.toString().split(": ");
            URList.SetRedoItem(temp[1]);
            statement.execute();
            statement=conn.prepareStatement(UndoQuery);
            statement.setInt(1,b.getIsbn());
            String[] Undotemp=statement.toString().split(": ");
            URList.SetUndoItem(Undotemp[1]);
            processResult();
        }
        catch(SQLException e){
        System.out.println("Insert Failed");
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
