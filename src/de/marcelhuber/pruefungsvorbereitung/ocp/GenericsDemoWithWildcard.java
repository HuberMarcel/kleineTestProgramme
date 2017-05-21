package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class GenericsDemoWithWildcard {

    GenericsDemoWithWildcardChilds child00;
    GenericsDemoWithWildcardChilds child01;
    GenericsDemoWithWildcardChilds child02;
    GenericsDemoWithWildcardChilds child03;
    GenericsDemoWithWildcardParents parent00;
    GenericsDemoWithWildcardParents parent01;
    GenericsDemoWithWildcardParents parent02;
    GenericsDemoWithWildcardParents parent03;
    GenericsDemoWithWildcardGrandParents gp00;
    GenericsDemoWithWildcardGrandParents gp01;
    GenericsDemoWithWildcardGrandParents gp02;
    GenericsDemoWithWildcardGrandParents gp03;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new GenericsDemoWithWildcard().go();
    }

    private void go() {
        child00 = new GenericsDemoWithWildcardChilds();
        parent00 = new GenericsDemoWithWildcardParents();
        gp00 = new GenericsDemoWithWildcardGrandParents();

        child01 = new GenericsDemoWithWildcardChilds("child01");
        parent01 = new GenericsDemoWithWildcardParents("parent01");
        gp01 = new GenericsDemoWithWildcardGrandParents("gp01");

        child02 = new GenericsDemoWithWildcardChilds("child02");
        parent02 = new GenericsDemoWithWildcardParents("parent02");
        gp02 = new GenericsDemoWithWildcardGrandParents("gp02");

        child03 = new GenericsDemoWithWildcardChilds("child03");
        parent03 = new GenericsDemoWithWildcardParents("parent03");
        gp03 = new GenericsDemoWithWildcardGrandParents("gp03");

        List<GenericsDemoWithWildcardParents> parents = new ArrayList<>();
        add(parents, child00);
        add(parents, child01);
        add(parents, child02);
        add(parents, child03);
        add(parents, parent00);
        add(parents, parent01);
        add(parents, parent02);
        add(parents, parent03);
//        System.out.println(parents);
        System.out.println("Parents-Liste:");
        showList(parents);
//        add(parents,gp01);      // geht nicht
        List<GenericsDemoWithWildcardChilds> childs = new ArrayList<>();
//        add(childs, parent00);  // hier können nur Kinder von Kindern aufgenommen werden
        add(childs, child00);
        add(childs, child01);
        add(childs, child02);
        add(childs, child03);
//        System.out.println(childs);
        System.out.println("");
        System.out.println("Childs-Liste:");
        showList(childs);
        List<GenericsDemoWithWildcardGrandParents> gps = new ArrayList<>();
        add(gps, child00);
        add(gps, child01);
        add(gps, child02);
        add(gps, child03);
        add(gps, parent00);
        add(gps, parent01);
        add(gps, parent02);
        add(gps, parent03);
        add(gps, gp00);
        add(gps, gp01);
        add(gps, gp02);
        add(gps, gp03);
//        System.out.println(gps);
        System.out.println("");
        System.out.println("Grandparents-Liste:");
        showList(gps);
    }

    private void showList(List<?> liste) {
        for (Object object : liste) {
            System.out.println(object);
        }
    }

    private <A extends GenericsDemoWithWildcardGrandParents> void add(List<A> liste, A object) {
//    private void add(List<?> liste, object) {       // das kann so nicht funktionieren
        liste.add(object);
    }

    private <A extends GenericsDemoWithWildcardParents> void add(List<A> liste, A object) {
//    private void add(List<?> liste, object) {       // das kann so nicht funktionieren
        liste.add(object);
    }

    private <A extends GenericsDemoWithWildcardChilds> void add(List<A> liste, A object) {
//    private void add(List<?> liste, object) {       // das kann so nicht funktionieren
        liste.add(object);
    }
}

class GenericsDemoWithWildcardGrandParents {

    private String name;

    public GenericsDemoWithWildcardGrandParents() {
    }

    public GenericsDemoWithWildcardGrandParents(String name) {
        this.name = "Grandparent: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return "Grandparent: (NoName)";
        }
    }
}

class GenericsDemoWithWildcardParents extends GenericsDemoWithWildcardGrandParents {

    private String name;

    public GenericsDemoWithWildcardParents() {
    }

    public GenericsDemoWithWildcardParents(String name) {
        this.name = "Parent: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return "Parent: (NoName)";
        }
    }
}

class GenericsDemoWithWildcardChilds extends GenericsDemoWithWildcardParents {

    private String name;

    public GenericsDemoWithWildcardChilds() {
    }

    public GenericsDemoWithWildcardChilds(String name) {
        this.name = "Child: " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return "Child: (NoName)";
        }
    }
}
