/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author dhanush
 */
public interface DatabaseImpInterface {
    public void Display();

    public void InsertBook(BookDescriptions b);

    public void UpdateBook(BookDescriptions b);

    public void DeleteBook(int Isbn);

    public BookDescriptions RetriveBook(int Isbn);

    public void UndoOperation();

    public void RedoOperation();
    
}
