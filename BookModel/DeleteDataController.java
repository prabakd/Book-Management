/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookModel;

import DataBase.DatabaseManager;

/**
 *
 * @author dhanush
 */
public class DeleteDataController {
    UndoRedoList URList = new UndoRedoList();
    DatabaseManager DM = new DatabaseManager();
    public void Delete (int Isbn){
        UndoRedoList.PosIndex+=1;
         //String Msg = "SUCCESS_MESSAGE";
         //System.out.println(Isbn);
     DM.DeleteBook(Isbn);
    }
    
}
