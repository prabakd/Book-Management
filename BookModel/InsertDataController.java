/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookModel;

import DataBase.BookDescriptions;
import DataBase.DatabaseManager;
/**
 *
 * @author dhanush
 */
public class InsertDataController {
    DatabaseManager DM = new DatabaseManager();
    public void Insert (BookDescriptions b){
        UndoRedoList.PosIndex+=1;
         //String Msg = "SUCCESS_MESSAGE";
         //System.out.println(b.Isbn);
    DM.InsertBook(b);
    }
}