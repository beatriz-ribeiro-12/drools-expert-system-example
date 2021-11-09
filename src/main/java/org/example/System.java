package org.example;

public class System {
    private String id;
    private boolean active;

    public System(String id, boolean active){
        this.id = id;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "System{" +
                "id='" + id + '\'' +
                ", active=" + active +
                '}';
    }
}
