/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Yusuke
 */
public class Tool2 {
    
    static ArrayList<Member> memberList = new ArrayList<>();
    static ArrayList<Member> selectedMemberList = new ArrayList<>();
    static ArrayList<Member> notSelectedMemberList = null;
    static ArrayList<Task> taskList = new ArrayList<>();
    static ArrayList<Task> selectedTaskList = new ArrayList<>();
    static ArrayList<Task> notSelectedTaskList = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        registerMembers();
        registerTasks();
        notSelectedMemberList = new ArrayList<>(memberList);
        notSelectedTaskList = new ArrayList<>(taskList);
        
        for (int i = 1; i <= 300; i++) {
            while (!notSelectedTaskList.isEmpty()) {
                boolean resetFlg;
                do {
                    resetFlg = false;
                    
                    for (Task task : taskList) {
                        if (task.isContainMember() && !task.excperiencdMembers.isEmpty()) {
                            task.excperiencdMembers.clear();
                            Log.writeLog("exp clear");
                        }
                    }
                    
                    Log.writeLog(notSelectedTaskList);
                    
                    for (Task task : notSelectedTaskList) {
                        if (notSelectedMemberList.size() == 1 && task.currentPerson.equals(notSelectedMemberList.get(0).name)) {
                            notSelectedMemberList = new ArrayList<>(memberList);
                            break;
                        }
                    }
                    
                    int rndM = new Random().nextInt(notSelectedMemberList.size());
                    Member member = notSelectedMemberList.get(rndM);
                    Log.writeLog("select " + member.name);
                    
                    int rndT = new Random().nextInt(notSelectedTaskList.size());
                    Task task = notSelectedTaskList.get(rndT);
                    Log.writeLog("select " + task.name);
                    Log.writeLog("currenntPerson" + task.currentPerson);
                    
                    if (!task.excperiencdMembers.contains(member.name) && !task.currentPerson.equals(member.name) && !member.isThisLoop) {
                        member.isThisLoop = true;
                        task.excperiencdMembers.add(member.name);
                        task.currentPerson = member.name;
                        
                        selectedTaskList.add(task);
                        notSelectedTaskList.remove(rndT);
                        
                        selectedMemberList.add(member);
                        notSelectedMemberList.remove(rndM);
                        
                        Log.writeLog("GET");
                    } else {
                        resetFlg = true;
                        Log.writeLog("DON'T GET");
                    }
                    resetList();
                } while (resetFlg);
            }
            
            for (Task task : taskList) {
                System.out.println(task.name + " : " + task.currentPerson);
            }
            System.out.println("-----------" + i + " loop-----------");
            Log.writeLog(i + " loop");
            for (Member m : memberList) {
                m.isThisLoop = false;
            }
            
            selectedTaskList.clear();
            notSelectedTaskList = new ArrayList<>(taskList);
//            if(i == 13 || i ==20){
//                System.out.println("a");
//            }
        }
        
    }
    
    static void registerMembers() {
        memberList.add(new Member("kosugi"));
        memberList.add(new Member("tomizawa"));
        memberList.add(new Member("nagahama"));
        memberList.add(new Member("wakita"));
        memberList.add(new Member("morihuzi"));
        memberList.add(new Member("sen"));
        memberList.add(new Member("you"));
    }
    
    static void registerTasks() {
        taskList.add(new Task("トイレ"));
        taskList.add(new Task("ゴミ出し"));
        taskList.add(new Task("床"));
        taskList.add(new Task("郵便"));
    }
    
    static void resetList() {
        if (selectedMemberList.size() == memberList.size()) {
            selectedMemberList.clear();
        }
        if (notSelectedMemberList.isEmpty()) {
            notSelectedMemberList = new ArrayList<>(memberList);
        }
        for (Task task : taskList) {
            if (task.excperiencdMembers.size() == memberList.size()) {
                task.excperiencdMembers.clear();
            }
        }
    }
    
}
