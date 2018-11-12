/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room startingCell, centralCorridor, southernCorridor, northernCorridor, rightCorridor, leftCorridor,
                emptyCellNorth, emptyCellCentral, luxuriousCell, graveyard, exitRoom, guardRoom, armory;
      
        // create the rooms
        startingCell = new Room("in the cell of the nameless hero");
        centralCorridor = new Room("in the central part of the corridor");
        northernCorridor = new Room("in the northern part of the corridor");
        southernCorridor = new Room("in the southern part of the corridor");
        rightCorridor = new Room("in the right wing of the corridor");
        leftCorridor = new Room("in the left wing of the corridor");
        emptyCellCentral = new Room("in the empty cell");
        emptyCellNorth = new Room("in the empty cell");
        luxuriousCell = new Room("in cell with a bed");
        graveyard = new Room("in a room full of skeletons");
        exitRoom = new Room("in a room with locked doors");
        guardRoom = new Room("in a guard room");
        armory = new Room("in an armory");
        
        // initialise room exits
        startingCell.setExit("east", centralCorridor);
        centralCorridor.setExit("north", northernCorridor);
        centralCorridor.setExit("east", emptyCellCentral);
        centralCorridor.setExit("south", southernCorridor);
        centralCorridor.setExit("west", startingCell);
        emptyCellCentral.setExit("west", centralCorridor);
        northernCorridor.setExit("north", graveyard);
        northernCorridor.setExit("east", emptyCellNorth);
        northernCorridor.setExit("south", centralCorridor);
        northernCorridor.setExit("west", luxuriousCell);
        luxuriousCell.setExit("east", northernCorridor);
        emptyCellNorth.setExit("west", northernCorridor);
        graveyard.setExit("south", northernCorridor);
        southernCorridor.setExit("north", centralCorridor);
        southernCorridor.setExit("east", rightCorridor);
        southernCorridor.setExit("west", leftCorridor);
        leftCorridor.setExit("east", southernCorridor);
        leftCorridor.setExit("south", armory);
        leftCorridor.setExit("west", guardRoom);
        rightCorridor.setExit("south", exitRoom);
        rightCorridor.setExit("west", southernCorridor);
        guardRoom.setExit("east", leftCorridor);
        armory.setExit("north", leftCorridor);
        exitRoom.setExit("north", rightCorridor);

        currentRoom = startingCell;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }
    
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if(commandWord.equals("look")) {
            printLocationInfo();
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
