/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookModel;

import DataBase.BookDescriptions;
import DataBase.DatabaseManager;
import BookModel.UndoRedoList;
/**
 *
 * @author dhanush
 */
public class UpdateDataController {
    UndoRedoList URList = new UndoRedoList();
    DatabaseManager DM = new DatabaseManager();
    public void Update (BookDescriptions b){
        UndoRedoList.PosIndex+=1;
         //String Msg = "SUCCESS_MESSAGE";
         //System.out.println(b.Isbn);
     DM.UpdateBook(b);
    }

  
}
