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
public class RetriveDataController {
    DatabaseManager DM = new DatabaseManager();
    public BookDescriptions Retrive (int Isbn){
         //String Msg = "SUCCESS_MESSAGE";
         //System.out.println(Isbn);
    return DM.RetriveBook(Isbn);
    }
}
