/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool2;

import java.util.ArrayList;

/**
 *
 * @author Yusuke
 */
public class Task {
    String name = "";
    String currentPerson = "";
    ArrayList <String> excperiencdMembers = new ArrayList<>();
    
    Task (String name){
        this.name = name;        
    }
    
    public boolean isContainMember(){
    boolean check = false;
    int count = 0;
    for(Member member: Tool2.selectedMemberList){
        if(this.excperiencdMembers.contains(member.name)){
        count ++;
        }
    }
    if(count == Tool2.selectedMemberList.size()){
        check = true;
    }
    return check;
    }
    
}
