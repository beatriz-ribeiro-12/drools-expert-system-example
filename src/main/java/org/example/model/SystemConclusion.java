package org.example.model;

public class SystemConclusion {
    private String id;
    private boolean active;

    public SystemConclusion(String id, boolean active){
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
