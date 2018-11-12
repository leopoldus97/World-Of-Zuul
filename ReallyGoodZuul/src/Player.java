/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schemabuoi
 */
public class Player {
    private Room currentRoom;
    private Room previousRoom;
    
     public Room getCurrentRoom() {
        return currentRoom;
    }
     public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
     public Room getPreviousRoom() {
        return previousRoom;
    }
     public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }
    
}
