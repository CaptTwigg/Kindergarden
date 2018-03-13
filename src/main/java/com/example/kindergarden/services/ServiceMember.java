package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServiceMember {
    private ArrayList<Member> members = new ArrayList<>();
    public FileHandler fileHandler;

    //
    public ServiceMember() {
        try {
            fileHandler = new FileHandler("members.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Adds new member to members
    public void addMemberToList(Member me) {
        int id = members.size() == 0 ? 1 : getHighestIdOfMembers();
        members.add(me.setId(id));
        fileHandler.saveMemberToFile(members);
    }

    //Creates arraylist and gets members from file
    public ArrayList<Member> getMembers() {
        return members = fileHandler.loadMembers("members.txt");
    }

    //Find highest id and +1 to increment id
    private int getHighestIdOfMembers(){
        int id = 1;

        for(Member member : members){
            if(member.getId() > id){
                id = member.getId();
            }
        }
        return id + 1;
    }

    //Removes member from arraylist and file
    public void deleteMember(int id) {
        int index = getIndex(id);

        if (index > -1) {
            members.remove(index);
            System.out.println(id);
            System.out.println(Arrays.toString(members.toArray()));

            //Saves members to file
            fileHandler.saveMemberToFile(members);

        } else System.out.println("not found");
    }

    public void editMember(Member member){
        members.add(getIndex(member.getId()), member);
        members.remove(getIndex(member.getId())+1);
        fileHandler.saveMemberToFile(members);
    }

    public int getIndex(int id) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getId() == id)
                return i;
        return -1;
    }
}

