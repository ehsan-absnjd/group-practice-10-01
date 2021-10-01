package entities;

import java.util.*;

public class Helper {
    Map<Integer, City> cities = new HashMap<>();
    Set<Road> roads = new HashSet<>();
    public void addCity(City city){
        cities.put( city.getId(),city);
    }
    public void addRoad(Road road){
        roads.add(road);
        ArrayList<City> cityList = road.getCityList();
        for(int city : road.getCities()){
            cityList.add(cities.get(city));
            ((City)cities.get(city)).getRoads().add(road);
        }
    }
    public HashSet<ArrayList<RoadCity>> getPath(int from , int to ){
        HashSet<ArrayList<RoadCity>> lis = new HashSet<>();
        getPath(1 ,3 , new ArrayList<RoadCity>() , lis);
        return lis;
    }
    public void removeCity(){

    }

    public void getPath(int from , int to , ArrayList<RoadCity>  roadCities , HashSet<ArrayList<RoadCity> >  results){

        City fromCity = cities.get(from);
        City toCity = cities.get(to);
        for(Road road : (cities.get(from)).getRoads()){
            RoadCity roadCity = new RoadCity(road , from);
            if(!roadCities.contains(roadCity)){

                if(road.getsFromTo(fromCity , toCity)) {

                    ArrayList<RoadCity> newRoadCities = new ArrayList<>(roadCities);
                    roadCity = new RoadCity(road , from , toCity.getId() );
                    newRoadCities.add(roadCity);
                    results.add(newRoadCities);
                }
                for (City city : road.MultiRoadCitiesFrom(fromCity) ) {
                    if(city.getId() == from)
                        continue;
                    ArrayList<RoadCity> newRoadCities = new ArrayList<>(roadCities);
                    roadCity = new RoadCity(road , from , city.getId() );
                    newRoadCities.add(roadCity);
                    getPath(city.getId(), to, newRoadCities , results);
                }
            }

        }
    }
}
