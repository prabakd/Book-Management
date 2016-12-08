/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import BookModel.UndoRedoList;
import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
class RedoperationDB extends RDBImplCommand {

    UndoRedoList URList = new UndoRedoList();
    private String sqlQuery;
    public RedoperationDB() {
    }

    @Override
    public void queryDB() throws SQLException {
        try{
            sqlQuery=URList.GetRedoItem();
            statement = conn.prepareStatement(sqlQuery);
            //statement.setInt(1, Isbn);
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
        System.out.println("REDO Failed");
        System.out.println(e);
            conn.close();
        } finally {
            statement.close();
        }
    }
    
    public void processResult(){
        //URList.PosIndex++;
        
        result="";
    }
    
}