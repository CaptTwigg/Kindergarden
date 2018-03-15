package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceChild {
    private ArrayList<Child> children = new ArrayList<>();
    public FileHandler fileHandler;

    public ServiceChild() {
        try {
            fileHandler = new FileHandler("children.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addChildToList(Child child, int[] ids) {
        int id = children.size() == 0 ? 1 : getHighestIdOfChild();
        children.add(child.setId(id).setParentKeyOne(ids[0]).setParentKeyTwo(ids[1]));
        fileHandler.saveChildren(children);
    }

    //Creates arraylist and gets children from file
    public ArrayList<Child> getChildren() {
        return children = fileHandler.loadChildren();
    }

    //Find highest id and +1 to increment id
    private int getHighestIdOfChild(){
        int id = 1;

        for(Child child : children){
            if(child.getId() > id){
                id = child.getId();
            }
        }
        return id + 1;
    }

    //Removes member from arraylist and file
    public void deleteChild(int id) {
        int index = getIndex(id);

        if (index > -1) {
            children.remove(index);

            //Saves children to file
            fileHandler.saveChildren(children);

        } else System.out.println("not found");
    }

    public void editChild(Child child){
        children.add(getIndex(child.getId()), child);
        children.remove(getIndex(child.getId())+1);
        fileHandler.saveChildren(children);
    }

    public int getIndex(int id) {
        for (int i = 0; i < children.size(); i++)
            if (children.get(i).getId() == id)
                return i;
        return -1;
    }
}

