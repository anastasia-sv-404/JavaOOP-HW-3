package geoTreeResearch;

import geoTreeResearch.Interface.Printable;

import java.util.ArrayList;

public class GeoTree implements Printable {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return this.tree;
    }

    public void append(Family f1, Relationship re1, Family f2, Relationship re2) {
        if(f1.getFamily().contains(f2.getPerson()) && f2.getFamily().contains(f1.getPerson())) {
            tree.add(new Node(f1.getPerson(), re1, f2.getPerson()));
            tree.add(new Node(f2.getPerson(), re2, f1.getPerson()));
        } else{
            System.out.printf("Нельзя установить отношения: персоны %s и %s принадлежат разным семьям.\n",
                    f1.getPerson().getName(), f2.getPerson().getName());
        }
    }//Для формирования отношений передаем Семьи, принадлежащие Персонам, между которыми хотим установить отношения.


    public void print(){
        for (Node node: this.getTree()){
            node.print();
        }
        System.out.println();
    }
}