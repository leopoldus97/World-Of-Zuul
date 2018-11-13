
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
    private int maxWeight;

    public Player()
    {
        items = new ArrayList();
        maxWeight = 20000;
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
     
    public int getMaxWeight() {
        return maxWeight;
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
    
    public String getItemsString()
    {
        if(items.size() == 0)
        {
            return "Your inventory is empty";
        }
        else
        {
            String itemsString = "Items inside your inventory: ";
            for(Item item: items)
            {
                itemsString += item.getDescription() + ", ";
            }
            itemsString = itemsString.substring(0,itemsString.length()-2);
            itemsString += "\nTotal weight: " + getItemsWeight();
            return itemsString;
        }
    }
    
    public int getItemsWeight()
    {
        int weight = 0;
        for(Item item: items)
        {
            weight += item.getWeight();
        }
        return weight;
    }
    
}
