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
public class UpdateBookDB extends RDBImplCommand {
    private String sqlQuery = "UPDATE BookDescriptions set ISbn=?, Title=?, Author=?, Price=?, Publisher=?,edition=? WHERE Isbn=?";
    private String UndoQuery = "UPDATE BookDescriptions set ISbn=?, Title=?, Author=?, Price=?, Publisher=?,edition=? WHERE Isbn=?";
    private BookDescriptions b;
    private BookDescriptions b1;
    UndoRedoList URList = new UndoRedoList();
    //RetriveData R;

    

    UpdateBookDB(BookDescriptions b) {
        this.b=b;
    }
       
    

public void queryDB() throws SQLException{
        try{
            RetriveDataController obj=new RetriveDataController();
            b1=obj.Retrive(b.getIsbn()); 
            statement = conn.prepareStatement(UndoQuery);
            statement.setInt(1, b1.getIsbn());
            statement.setString(2, b1.getTitle());
            statement.setString(3, b1.getAuthor());
            statement.setFloat(4, b1.getPrice());
            statement.setString(5, b1.getPublisher());
            statement.setInt(6, b1.getEdition());
            statement.setInt(7, b1.getIsbn());
            String[] temp1=statement.toString().split(": ");
            
            
            statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1, b.getIsbn());
            statement.setString(2, b.getTitle());
            statement.setString(3, b.getAuthor());
            statement.setFloat(4, b.getPrice());
            statement.setString(5, b.getPublisher());
            statement.setInt(6, b.getEdition());
            statement.setInt(7,b.getIsbn());
            //System.out.println("Hi");
            //System.out.println(b.Isbn);
            //System.out.println(b.getIsbn());
            //System.out.println(statement);
            String[] temp=statement.toString().split(": ");
            URList.SetRedoItem(temp[1]);
            URList.SetUndoItem(temp1[1]);
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
        System.out.println("Update Failed");
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

