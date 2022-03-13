package ru.yargu.prom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    void createTreeTest() {
        Node node = new Node("root");
        assertNotNull(node, "Узел не создан");
        assertEquals("root", node.getName(), "Корневой узел создан с неправильным именем");
    }

    @Test
    void addChildTest() {
        Node node = new Node("root");
        Node child = node.createChild("child");
        node.addChild(child);
        assertTrue(node.hasChild(), "Созданный узел отсутствует");
    }

    @Test
    void searchChildTest() {
        Node node = new Node("root");
        Node child = node.createChild("child");
        node.addChild(child);
        assertEquals("child", node.findByName("child").getName(), "Искомый узел не найден");
    }

    @Test
    void deleteChildTest() {
        Node node = new Node("root");
        Node child = node.createChild("child");
        node.addChild(child);
        node.removeChild(child.id);
        assertTrue(node.hasChild(), "Дочерний узел не удалён");
    }

    @Test
    void deleteAllChildTest() {
        Node node = new Node("root");
        Node first_child = node.createChild("first_child");
        node.addChild(first_child);
        Node second_child = node.createChild("second_child");
        node.addChild(second_child);
        node.removeAllChild();
        assertTrue(node.children.isEmpty(), "Остались дочерние узлы");
    }

    @Test
    void changeValueTest() {
        Node node = new Node("root");
        Node child = node.createChild("child");
        node.addChild(child);
        child.changeNode("newRoot");
        assertEquals("newRoot", node.findByName("newRoot").getName(), "Узла с новым именем не обнаружено");
    }
}
