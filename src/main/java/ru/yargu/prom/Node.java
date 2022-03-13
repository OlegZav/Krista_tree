package ru.yargu.prom;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    int id;
    List<Node>children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean hasChild() {
        return !children.isEmpty();
    }

    public Node createChild(String name) {
        Node child = new Node(name);
        children.add(child);
        return child;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public Node findByName(String name) {
        for (Node child : children) {
            if (name.equals(child.getName()))
                return child;
        }
        return null;
    }

    public void removeChild(int id) {
        for (Node child : children) {
            if (child.id == id)
                children.remove(id);
        }
    }

    public void removeAllChild() {
        children.clear();
    }

    public void changeNode(String newName) {
        this.name = newName;
    }
}
