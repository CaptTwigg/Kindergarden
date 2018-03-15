package com.example.kindergarden.wrappers;

import com.example.kindergarden.base.Parent;

import java.util.ArrayList;
import java.util.List;

public class ParentWrapper {
    private ArrayList<Parent> parents;

    public ParentWrapper() {
        parents = new ArrayList<>();
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }
}
