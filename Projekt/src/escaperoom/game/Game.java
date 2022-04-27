package EscapeRoom;

public class Game {
    public static final int MAX_ROOMS = 3;
    public static void main(String[] args) {
        int maxRooms = MAX_ROOMS;
        int[] amountOfRooms;
        int rooms = 0, riddlesForOneRoom = 0;

        InOut inOut = InOut.getInOut();   //Ein InOut Objekt erzeugen
        inOut.startScanner();

        inOut.print("How many rooms do you want to have?");
        boolean isValid = false;
        do {    //How many Rooms he wants to be there
            try {
                rooms = inOut.getInteger();
                if (rooms > maxRooms)
                    isValid = false;
                isValid = true;

            } catch (InvalidInputException e) {
                System.err.println("Please only enter a number");
                isValid = false;
            }
        }while(!isValid);

        amountOfRooms = new int[rooms];

        for(int i = 0; i > amountOfRooms.length; i++){
            inOut.print("How many riddles for one room");
            isValid = false;
            do{     //How many riddles for one room
                try{
                    riddlesForOneRoom = inOut.getInteger();
                    isValid = true;
                    amountOfRooms[i] = riddlesForOneRoom;
                } catch(InvalidInputException e){
                    System.err.println("Please only enter a number");
                    isValid = false;
                }
            }while(!isValid);
        }

        EscapeRoom eRoom = new EscapeRoom(amountOfRooms);

        if(eRoom.play() == true)
            System.out.println("solved");
        else
            System.out.println("unsolved");

        inOut.closeScanner();
    }

}
