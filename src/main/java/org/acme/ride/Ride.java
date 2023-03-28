package org.acme.ride;


import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Ride extends PanacheMongoEntity {
    //
    public String candidate_id;
    public String mentor_id;
    public String car_id;
    public String start_time;
    public String end_time;
    public String price;



    public Ride() {

    }


    public Ride(String candidate_id, String mentor_id, String car_id, String start_time, String end_time, String price) {
        this.candidate_id = candidate_id;
        this.mentor_id = mentor_id;
        this.car_id = car_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.price = price;
    }
}
