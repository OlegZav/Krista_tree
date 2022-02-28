package ru.yargu.prom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    void createTreeTest() {
        Node node = new Node("root");
        assertEquals("root", node.getName(), "Корневой узел создан с неправильным именем");
    }

    @Test
    void addChildTest() {
        Node node = new Node("root");
        Node child1 = node.createChild("child1");
        Node child2 = new Node("child2");
        node.addChild(child2);
        assertEquals("child2", node.findByName("child2").getName(), "");
    }

    @Test
    void searchChildTest() {
        Node node = new Node("root");
        Node child1 = node.createChild("child1");
        assertEquals("child1", node.findByName("child1").getName(), "");
    }

    @Test
    void deleteChildTest() {
        Node node = new Node("root");
        Node child1 = node.createChild("child1");
        Node child2 = node.createChild("child2");
        node.removeChild(12);
        assertNotEquals("child2", node.findByName("child2").getName(), "");
    }

    @Test
    void deleteAllChildTest() {
        Node node = new Node("root");
        Node child1 = node.createChild("child1");
        Node child2 = node.createChild("child2");
        node.removeAllChild(node);
        assertNotEquals("child1", node.findByName("child1").getName(), "");
        assertNotEquals("child2", node.findByName("child2").getName(), "");
    }

    @Test
    void changeValueTest() {
        Node node = new Node("root");
        Node child1 = node.createChild("child1");
        node.changeNode(node, "newRoot");
        assertEquals("newRoot", node.findByName("newRoot").getName(), "");
//        assertNotEquals("root", node.findByName("root").getName(), "");
    }
}
