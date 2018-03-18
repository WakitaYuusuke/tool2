/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yusuke
 */
class Log {
    static public void writeLog(String s) {
        try {
            File file = new File("C:\\Users\\Yusuke\\Desktop\\Log.txt");
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write(s + "\r\n------------------------------------\r\n");
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    static public void writeLog(ArrayList<Task> list) {
        try {
            File file = new File("C:\\Users\\Yusuke\\Desktop\\Log.txt");
            FileWriter filewriter = new FileWriter(file, true);
            String s = "";
            for(Task task: list){
                s += task.name +"[ ";
                for(String st: task.excperiencdMembers){
                    s += st + " ";
                }
                s += "]\r\n";
            }
            
            filewriter.write(s + "\r\n------------------------------------\r\n");
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
