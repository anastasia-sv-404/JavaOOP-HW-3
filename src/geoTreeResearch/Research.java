package geoTreeResearch;

import java.util.ArrayList;

public class Research{
    private ArrayList<Node> tree;
    private ArrayList<Person> result;

    public Research(GeoTree geoTree) {
        this.tree = geoTree.getTree();
        this.result = new ArrayList<>();
    }

    public ArrayList<Person> spendRelationships(Person p, Relationship re) {
        for (Node t : this.tree) {
            if (t.getPersonFirst().getName() == p.getName() && t.getRelationship() == re) {
                this.result.add(t.getPersonSecond());
            }
        }
        return this.result;
    }

    public ArrayList<Person> spendGender(Person.Gender gender){
        for (Node t : this.tree){
            if(t.getPersonFirst().getGender() == gender && !this.result.contains(t.getPersonFirst())){
                this.result.add(t.getPersonFirst());
            }
        }
        return this.result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Person p : this.result){
            sb.append(p.getName());
        }
        return sb.toString();
    }
}
