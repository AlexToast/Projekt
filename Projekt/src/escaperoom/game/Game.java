package escaperoom.game;

public class Game {
    
    public static final int MAX_ROOMS = 3;

    public static void main(String[] args) {
        int maxRooms = MAX_ROOMS;
        int[] amountOfRooms;
        int rooms = 0, riddlesForOneRoom = 0;

        InOut inOut = InOut.getInOut();   //Ein InOut Objekt erzeugen
        inOut.startScanner();

        boolean isValid = false;
        do {    //How many Rooms he wants to be there
            inOut.print("How many rooms do you want to have?");
            try {
                rooms = inOut.getInteger();
                if (rooms > maxRooms) {
                    isValid = false;
                    inOut.print("(Maximum: " + MAX_ROOMS + ")");
                } else if (rooms < 1) {
                    inOut.print("(Minimum: 1)");
                } else
                    isValid = true;
            } catch (InvalidInputException e) {
                inOut.print("Please only enter a number");
                isValid = false;
            }
        } while (!isValid);

        amountOfRooms = new int[rooms];

        for (int i = 0; i < amountOfRooms.length; i++) {
            inOut.print("How many riddles for room: " + (i + 1));
            isValid = false;
            do {     //How many riddles for one room
                try {
                    riddlesForOneRoom = inOut.getInteger();
                    isValid = true;
                    amountOfRooms[i] = riddlesForOneRoom;
                } catch (InvalidInputException e) {
                    inOut.print("Please only enter a number");
                    isValid = false;
                }
            } while (!isValid);
        }

        EscapeRoom eRoom = new EscapeRoom(amountOfRooms);

        if (eRoom.play() == true)
            inOut.print("solved");
        else
            inOut.print("unsolved");

        inOut.closeScanner();
    }
}

