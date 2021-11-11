package org.example.model;

public class Bot {
    private String id;
    private boolean executed;

    public Bot(String id, boolean executed){
        this.id = id;
        this.executed = executed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id='" + (id != null ? id : "no id") + '\'' +
                ", operate=" + executed +
                '}';
    }
}
