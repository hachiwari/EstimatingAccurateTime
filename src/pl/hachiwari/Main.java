package pl.hachiwari;

import pl.hachiwari.algorithm.Intersection;
import pl.hachiwari.algorithm.Marzullo;
import pl.hachiwari.manager.DataManager;

class Main {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager("test_data");
        Marzullo marzullo = new Marzullo(dataManager.getData());
        System.out.println(marzullo.toString());

        System.out.println();

        Intersection intersection = new Intersection(dataManager.getData());
        System.out.println(intersection.toString());
    }
}
