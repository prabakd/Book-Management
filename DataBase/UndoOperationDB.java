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
class UndoOperationDB extends RDBImplCommand {
    UndoRedoList URList = new UndoRedoList();
    private String sqlQuery;
    public UndoOperationDB() {
    }

    @Override
    public void queryDB() throws SQLException {
        try{
            sqlQuery=URList.GetUndoItem();
            statement = conn.prepareStatement(sqlQuery);
            //statement.setInt(1, Isbn);
            statement.executeUpdate();
            processResult();
        }
        catch(SQLException e){
        System.out.println("UNDO Failed");
        System.out.println(e);
            conn.close();
        } finally {
            statement.close();
        }
    }
    
    public void processResult(){
       // URList.UndoIndex=URList.ListSize();
        //URList.PosIndex--;
        
        result="";
    }
    
}
