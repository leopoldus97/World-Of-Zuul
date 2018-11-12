/**
 * Class Item - an item in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * An "Item" represents one item which is connected to one of
 * the rooms from the scenery of the game. 
 * 
 */

/**
 *
 * @author schemabuoi
 */
public class Item {
    
    private String description;
    private int weight;
    
     public Item(String description, int weight)
    {
        this.description = description;
        this.weight = weight;
    }
    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }
}
