package com.gs.practice;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */

/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


public class H32TrainMap {

//public class Solution {
    /**
     * class Station
     * <p>
     * Respresents Station in the rail network. Each station is identified by unique
     * name. Station is connected with other stations - this information is stored
     * in the 'neighbours' field. Two station objects with the same name are equal
     * therefore they are considered to be same station.
     */
    private static class Station{
        String name;
        List<Station> neighbours;

        public Station(String name){
            this.name= name;
            this.neighbours= new LinkedList<>();
        }

        String getName(){
            return this.name;
        }
        void addNeighbour(Station n){
            this.neighbours.add(n);
        }

        List<Station> getNeighbours(){
            return this.neighbours;
        }

        @Override
        public boolean equals(Object obj){
            return obj instanceof Station && this.name.equals(((Station) obj).getName());       }


    }

    private static class Node{
        Station station;
        List<Station> path;

        public Node(Station station){
            this.station=station;
            this.path= new LinkedList<>();
        }

        Station getStation(){
            return this.station;
        }

        List<Station> getPath(){
            return this.path;
        }
    }

    //added a class Node to store path

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2
     * stations is of same constant distance unit. This implies that shortest
     * distance between any 2 stations depends only on number of stations in between
     */
    private static class TrainMap {
        private HashMap<String,Station> stations;

        public TrainMap(){
            this.stations= new HashMap<>();
        }

        TrainMap addStation(String name){
            Station s= new Station(name);
            this.stations.putIfAbsent(name, s);
            return this;
        }

        Station getStation(String name){
            return this.stations.get(name);
        }

        TrainMap connectStations(Station from, Station to){
            if(from == null || to == null){
                throw new IllegalArgumentException("given stations do not exist");
            }
            from.addNeighbour(to);
            to.addNeighbour(from);
            return this;
        }

        List<Station> shortestPath(String from, String to){
            if(from.equals(to)){
                return Collections.emptyList();
            }

            HashSet<Node> isVisited = new HashSet<>();
            Queue<Node> stationQueue = new LinkedList<>();

            Node newNode = new Node(stations.get(from));
            newNode.getPath().add(stations.get(from));

            stationQueue.add(newNode);
            Node curNode = null;

            while(!stationQueue.isEmpty()){
                curNode = stationQueue.poll();
                isVisited.add(curNode);

                if(curNode.getStation().getName().equals(to)){
                    return curNode.getPath();
                }

                for(Station s: curNode.getStation().getNeighbours()){
                    newNode = new Node(s);
                    if(!isVisited.contains(newNode)){
                        stationQueue.add(newNode);
                        newNode.getPath().addAll(curNode.getPath());
                        newNode.getPath().add(s);

                    }
                }

            }

            return Collections.emptyList();


        }

        private static String convertPathToStringRepresentation(List<Station> path){
            if(path.isEmpty()){
                return "";
            }

            System.out.println(path.stream().map(Station:: getName).reduce((s1,s2)->s1 + "->" + s2).get());
            return path.stream().map(Station:: getName).reduce((s1, s2)-> s1 + "->"+s2).get();
        }





    }

    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
            .addStation("Moorgate").addStation("Farringdon").addStation("Barbican").addStation("Russel Square")
            .addStation("Holborn").addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
            .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
            .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
            .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
            .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
            .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
            .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
            .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("St Paul's"))
            .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Farringdon->Barbican->St Paul's";

        return solution.equals(TrainMap
            .convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}