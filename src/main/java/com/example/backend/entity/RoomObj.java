package com.example.backend.entity;

import java.util.List;

public class RoomObj {
    private Room room;

    public Room getRoom() {
        return room;
    }

    public RoomObj(Room room, List<Subroom> subrooms) {
        this.room = room;
        this.subrooms = subrooms;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Subroom> getSubrooms() {
        return subrooms;
    }

    public void setSubrooms(List<Subroom> subrooms) {
        this.subrooms = subrooms;
    }

    private List<Subroom> subrooms;
}
