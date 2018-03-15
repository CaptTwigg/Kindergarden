package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Parent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceParent {
    private ArrayList<Parent> parents;
    public FileHandler fileHandler;

    public ServiceParent() {
        try {
            fileHandler = new FileHandler("parents.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] saveParents(List<Parent> parents) {
        int[] returnedIDS = new int[2];

        for(int i = 0; i < returnedIDS.length; i++) {
            parents.get(i).setId(getHighestId()+i);
            returnedIDS[i] = parents.get(i).getId();
        }

        System.out.println(Arrays.toString(parents.toArray()));

        fileHandler.saveParents(parents);

        return returnedIDS;
    }

    public int getHighestId() {
        int id = 0;

        ArrayList<Parent> parentArrayList = fileHandler.loadAllParents();

        for(Parent parent: parentArrayList) {
            if(parent.getId() > id) {
                id = parent.getId();
            }
        }

        return id + 1;
    }
}
