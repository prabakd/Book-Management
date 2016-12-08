/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookModel;

import java.util.ArrayList;

/**
 *
 * @author dhanush
 */
public class UndoRedoList {
    static ArrayList<String> Undoarrlist = new ArrayList<String>(10);
    static ArrayList<String> Redoarrlist = new ArrayList<String>(10);
    public static int PosIndex=-1;
    //public static int RedoIndex=0;
    public UndoRedoList() {
        //UndoRedoList.arrlist = new ArrayList<>(10);
    }
    
    public boolean isUndoStackEmpty(){
    return Undoarrlist.isEmpty();
    }
     public boolean isRedoStackEmpty(){
    return Redoarrlist.isEmpty();
    }
    public String GetUndoItem(){
    //System.out.println((String)Undoarrlist.get(PosIndex));
    return (String) Undoarrlist.get(PosIndex);
    }
    public String GetRedoItem(){
    //System.out.println((String)Redoarrlist.get(PosIndex));
    return (String) Redoarrlist.get(PosIndex);
    }
    public void SetUndoItem(String S){
    Undoarrlist.add(S);
    
    }
    public void SetRedoItem(String S){
    Redoarrlist.add(S);
    
    }
    //public void printlist(){
    //System.out.println(Undoarrlist);
    //System.out.println(Redoarrlist);
    //}
    
    public int UndoListSize(){
    return Undoarrlist.size()-1;
    }
     public int RedoListSize(){
    return Redoarrlist.size()-1;
    }
}
