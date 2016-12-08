/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import bookmanagement.DisplayTable;
import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
public class GetBooks extends RDBImplCommand {
    /*private int Isbn;
    private String Title;
    private String Description;
    private float price;
    private String Publisher;
    private int edition;
    //private boolean expired;*/
         
    //private String sqlQuery = "SELECT (DATE_ADD(UserDatePasswordChanged, INTERVAL ? DAY) " +
    //        "< NOW()) as Expired FROM USER WHERE UserEmail = ?";
    private String sqlQuery = "SELECT * FROM BOOKDESCRIPTIONS";
    BookDescriptions b = new BookDescriptions();

    public GetBooks(){
    }
    
    public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            //statement.setInt(1, numberOfDays);
            //statement.setString(2, email);
            resultSet = statement.executeQuery();
            processResult();
        }
        catch(SQLException e){
        System.out.println("Display Failed");
            conn.close();
        } finally {
            statement.close();
        }
    }
    
    public void processResult(){
        try{
            int j=0;
            String[] ColumnNames = {"ISBN","TITLE","AUTHOR","EDITION","PRICE","PUBLISHER"};
            Object[][] Contents = new Object[100][6];
            result = "Invalid login";
            while (resultSet.next()){
                //Contents[j][0]= results.getString(1);
                //Contents[j][1] = results.getString(2);
                Contents[j][0] = resultSet.getInt("ISbn");
                Contents[j][1] = resultSet.getString("Title");
                Contents[j][2] = resultSet.getString("Author");
                Contents[j][3]= resultSet.getInt("Edition");
                Contents[j][4] = resultSet.getFloat("price");
                Contents[j][5]=resultSet.getString("Publisher");
                j++;
                            }
              DisplayTable obj = new DisplayTable(Contents, ColumnNames);
                obj.setVisible(true);
        }
        catch(SQLException e){
            System.out.println("Display failed");
            System.out.println(e);
        }
    }
    
}
