package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceChild {
    private ArrayList<Child> children = new ArrayList<>();
    public FileHandler fileHandler;

    //
    public ServiceChild() {
        try {
            fileHandler = new FileHandler("children.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Adds new member to children
    public void addMemberToList(Child me) {
        int id = children.size() == 0 ? 1 : getHighestIdOfMembers();
        children.add(me.setId(id));
        fileHandler.saveMemberToFile(children);
    }

    //Creates arraylist and gets children from file
    public ArrayList<Child> getChildren() {
        return children = fileHandler.loadMembers("children.txt");
    }

    //Find highest id and +1 to increment id
    private int getHighestIdOfMembers(){
        int id = 1;

        for(Child child : children){
            if(child.getId() > id){
                id = child.getId();
            }
        }
        return id + 1;
    }

    //Removes member from arraylist and file
    public void deleteMember(int id) {
        int index = getIndex(id);

        if (index > -1) {
            children.remove(index);
            System.out.println(id);
            System.out.println(Arrays.toString(children.toArray()));

            //Saves children to file
            fileHandler.saveMemberToFile(children);

        } else System.out.println("not found");
    }

    public void editMember(Child child){
        children.add(getIndex(child.getId()), child);
        children.remove(getIndex(child.getId())+1);
        fileHandler.saveMemberToFile(children);
    }

    public int getIndex(int id) {
        for (int i = 0; i < children.size(); i++)
            if (children.get(i).getId() == id)
                return i;
        return -1;
    }
}

