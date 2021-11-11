package org.example.model;

public class Aggregate {
    private String id;
    private boolean working;

    public Aggregate(String id, boolean working){
        this.id = id;
        this.working = working;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "id='" + id + '\'' +
                ", working=" + working +
                '}';
    }
}
