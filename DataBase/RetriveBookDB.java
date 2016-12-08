/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
class RetriveBookDB extends RDBImplCommand {
    private int Isbn;
    private String sqlQuery = "SELECT * FROM BOOKDESCRIPTIONS where Isbn=?";
    BookDescriptions b = new BookDescriptions();
    

    RetriveBookDB(int Isbn) {
        this.Isbn=Isbn;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void queryDB() throws SQLException{
        try{
            statement = conn.prepareStatement(sqlQuery);
            statement.setInt(1,Isbn);
            resultSet = statement.executeQuery();
            processResult();
        }
        catch(SQLException e){
        System.out.println("Retrive Failed");
        System.out.println(e);
            conn.close();
        } finally {
            statement.close();
        }
    }


   public void processResult(){
        try{
            
            if(resultSet.next()){
                int Isbn = resultSet.getInt("Isbn");
                String Title = resultSet.getString("Title");
                String Author = resultSet.getString("Author");
                int edition = resultSet.getInt("Edition");
                float price = resultSet.getInt("price");
                String Publisher = resultSet.getString("Publisher");

                result = new BookDescriptions();
                ((BookDescriptions)result).initialize(Isbn, Title, Author, price, edition, Publisher);
                //((AdvisorAccount)result).setTempPassword(resultSet.getString("UserPassword"));
            }
            else{
                result = null;
            }
        }
        catch(SQLException e){
            System.out.println("Get Book process failed");
        }
    }
}
