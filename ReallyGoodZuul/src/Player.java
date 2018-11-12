
import java.util.ArrayList;
import java.util.List;

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
    private List<Item> items;
    
    public Player()
    {
        items = new ArrayList();
    }
    
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
     
     public void addItem(Item item)
    {
        items.add(item);
    }
     
     public void removeItem(String name)
    {
        for(int i =0; i<items.size();i++)
        {
            if(items.get(i).getName().equals(name))
            {
                items.remove(i);
            }
        }
    }
     
    public Item getItem(String itemName)
    {
        for(Item roomItem: items)
        {
            if(roomItem.getName().equals(itemName))
            {
                return roomItem;
            }
        }
        return null;
    }
    
}
