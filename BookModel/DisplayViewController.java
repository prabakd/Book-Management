/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookModel;

import DataBase.RDBImplCommand;
import DataBase.DatabaseManager;
import DataBase.GetBooks;

/**
 *
 * @author dhanush
 */
public class DisplayViewController {
    DatabaseManager DM = new DatabaseManager();
    public void dis (){
        // String Msg = "SUCCESS_MESSAGE";
    DM.Display();
    }
  
}
