package entities;

import entities.City;
import entities.Helper;
import entities.Road;
import entities.RoadCity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.addCity(new City(1 , "tehran"));
        helper.addCity(new City(2 , "esfahan"));
        helper.addCity(new City(3 , "shiraz"));
        helper.addCity(new City(4 , "bandar"));
        Road newroad = new Road(1,"first" , 1,4,new LinkedList<>(Arrays.asList(2,3)) , 10 , 20 , false);
        Road newroad2 = new Road(2,"second" , 4,1,new LinkedList<>() , 10 , 20 , false);
        Road newroad3 = new Road(3,"third" , 1,2,new LinkedList<>() , 10 , 20 , false);
        helper.addRoad(newroad);
        helper.addRoad(newroad2);
        helper.addRoad(newroad3);

        HashSet<ArrayList<RoadCity>> path = helper.getPath(3, 2);

        for( ArrayList<RoadCity> list : path){
            System.out.println("road:");
            for(RoadCity roadCity : list){
                System.out.println(roadCity);
            }
        }


    }
}
