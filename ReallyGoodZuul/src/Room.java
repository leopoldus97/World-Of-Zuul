
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String,Room> exits;
    private List<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String,Room>();
        items = new ArrayList();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
    * Return the room that is reached if we go from this
    * room in direction "direction "If there is no room in
    * that direction, return null.
    */
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    /**
    * Return a description of the room’s exits,
    * for example "Exits: north west".
    * @return A description of the available exits.
    */
    
    public String getExitString()
    {
        String exitString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit: keys)
        {
            exitString += " " + exit;
        }
        return exitString;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getItemsString()
    {
        if(items.size() == 0)
        {
            return "No items inside the room";
        }
        else
        {
            String itemsString = "Items inside the room: ";
            for(Item item: items)
            {
                itemsString += item.getDescription() + ", ";
            }
            itemsString = itemsString.substring(0,itemsString.length()-2);
            return itemsString;
        }
    }
    
    /**
    * Return a long description of this room, of the form:
    * You are in the kitchen.
    * Exits: north west
    * @return A description of the room, including exits.
    */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getItemsString() + ".\n" + getExitString();
    }
    public void addItem(Item item)
    {
        items.add(item);
    }

}
