/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Klaud
 */
public class Game {
  
    Board board;
    Square square;
    GiverEntity nboBank = new GiverEntity("NBoBank");
    ReceiverEntity mafiaBank = new ReceiverEntity("Mafia Bank");
    private ArrayList<Refugee> refugee;
    Win playerWinner = new Win();
    Lose playerLost = new Lose();
    Scanner input = new Scanner(System.in);
    
    
    public Game(Board board){
        this.board = board;
        this.refugee = new ArrayList<>();
    }
    
    public void addPlayer(Refugee refugee) {    // Adding a player in an ArrayList    
       this.refugee.add(refugee);
    }
    
    public void initiazileBoard(){              // Initialising the board with squares
        for(int i=0;i<40;i++){ 
            square = createSquare(i,board);     // Squares are created 1 by 1
            board.addSquare(square);            // And adding them to the board
        }
    }
        
    private Square createSquare(int squareNumber,Board board) {
        switch (squareNumber) {
            case 0:
                return new Square(squareNumber, "Country in conflict","In the last few years the main number of refugees come form Iraq, Syria, Pakistan, Libya, Afghanistan and Kurdistan, but also from many countries in Africa",board);
            case 1:
                Square square1 = new Square(squareNumber, "Food for the journey. Pay $100","This is key once leaving a country in conflict. The journey is always difficult to predict. Outsourcing food is fundamental once a refugee starts a journey",board);
                square1.addAction(new PayMoneyAction(100,mafiaBank,false));
                return square1;
            case 2:
                Square square2 = new Square(squareNumber, "Car. You get a free lift. Roll dice","NGO volunteers or simply samaritans often help refugees by taken them to countries borders for free in their personal cars",board);
                square2.addAction(new RollDiceAction(board, square2,true));
                return square2;
            case 3:
                Square square3 = new Square(squareNumber, "Communication gear. Mobile phone and sim card. Pay $300 to the Mafia Bank","Phone contact is an essential kit for the journey. Refugees required to be able to contact family or the mafia via phone during the journey to safety. Often the Mafia obligates refugees to buy their phones through them, to controls their numbers and communications",board);
                square3.addAction(new PayMoneyAction(300,mafiaBank,true));
                return square3;
            case 4:
                Square square4 = new Square(squareNumber, "Army Control. You go back to war box (0)","Often refugees find sudden Army Controls during their journey. The military stop them and in most of the cases divert them back to their countries of origin",board);
                square4.addAction(new GoToTile(0,board));
                return square4;
            case 5:
                Square square5 = new Square(squareNumber,"Border 1. Go back to war box (0)","There are country borders in every country that the refugees have to go through. Refugees are often stuck in these ones till they have their documents checked or pay money for visas to corrupt army forces in order to carry on the journey",board);
                square5.addAction(new GoToTile(0,board));
                return square5;
            case 6:
                Square square6 = new Square(squareNumber,"Mafia. Pay 1000$","Specialised in Refugees, Mafias have spread dramatically in the last few years. These ones have an enormous power in countries like Turkey and Libya. It is almost impossible to reach Europe without paying the Mafia",board);
                square6.addAction(new PayMoneyAction(1000,mafiaBank,true));
                return square6;
            case 7:
                Square square7 = new Square(squareNumber,"Live Vest. You have an extra life if you land in the sea (Box 10)","Once the refugees have reached the coast they must buy a life vest before they get on a boat. The Mafia sales these items, sometimes they don’t float",board);
                square7.addAction(new GoToTile(10,board));
                return square7;
            case 8:
                Square square8 = new Square(squareNumber,"GPS Location. Stay for a turn","Before boarding the boats, the Mafia concentrates the refugees in specific places. The Mafia move them in groups towards the departure points",board);
                square8.addAction(new loseTurn());
                return square8; // Prepei na ulopoihtei
            case 9:
                Square square9 = new Square(squareNumber,"Boat. Pay 3000$ to the Mafia Bank. Roll dice","The average price for crossing the Mediterranean is around 3000$. Sometimes refugee families get a discount",board);
                square9.addAction(new PayMoneyAction(3000,mafiaBank,true));
                square9.addAction(new RollDiceAction(board,square9,true));
                return square9;
            case 10:
                Square square10 = new Square(squareNumber,"Dead at Sea. You are dead and out of the game","Over 3000 people died and around 4000 have disappeared in the Mediterranean only in 2017",board);
                square10.addAction(new Lose());
                return square10;
            case 11:
                Square square11 = new Square(squareNumber,"You get sick. Stay one turn","The travelling conditions on the Mafia boats are terrible, lack of drinking water, enough fuel just to reach the coast, the extremely dangerous hygiene conditions and of course the uncertainty, It is very probable to arrived to the coast sick",board);
                square11.addAction(new loseTurn());
                return square11;            
            case 12:
                Square square12 = new Square(squareNumber, "You reach an EU coast. Roll dice","The lucky refugees that have made the sea journey and have reached an EU coast, start here another journey. Often some refugees are also tricked by the Mafia and land them in a beach not far from where they left. They are back in Libya or turkey",board);
                square12.addAction(new RollDiceAction(board, square12,true));
                return square12;
            case 13:
                Square square13 = new Square(squareNumber,"Tent and sleeping bag. Pay 200$ to the Mafia Bank","The Mafia does not allow refugees to carry much personal items with them. Once they arrived to an EU coast they have to buy essential stuff, a tent and a sleeping bag can be sold for 300$",board);
                square13.addAction(new PayMoneyAction(200,mafiaBank,true));
                return square13;
            case 14:
                Square square14 = new Square(squareNumber,"Border Police. Stay one turn","The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping them for days next to the border controls",board);
                square14.addAction(new loseTurn());
                return square14;            
            case 15:
                Square square15 = new Square(squareNumber,"Border Control 2. Back to Border Control 1","In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border",board);
                square15.addAction(new GoToTile(5,board));
                return square15;
            case 16:
                Square square16 = new Square(squareNumber,"Refugee Camp. Pay 500$ to the Mafia bank to leave and roll dice","The Mafia controls refugees all way through. Sometimes refugees have to pay the Mafia just to let them leave the camps",board);
                square16.addAction(new PayMoneyAction(500,mafiaBank,true));
                square16.addAction(new RollDiceAction(board,square16,true));
                return square16;
            case 17:
                Square square17 = new Square(squareNumber,"Train. Roll dice","Short distance trains are used by refugees within countries",board);
                square17.addAction(new RollDiceAction(board,square17,true));
                return square17;
            case 18:
                Square square18 = new Square(squareNumber,"Red Cross Shelter. Jump to river crossing box (22)","The Red Cross have a number of shelters in different parts of the European routes used by refugees. In those ones they provide of toilets, food and sometimes sleeping areas",board);
                square18.addAction(new GoToTile(22,board));
                return square18;
            case 19:
                Square square19 = new Square(squareNumber,"Guard Dogs. Stay one turn","It has been reported that in some Eastern European countries police and civilians use guard dogs to track refugees",board);
                square19.addAction(new loseTurn());
                return square19;            
            case 20:
                Square square20 = new Square(squareNumber,"NGO Support. You receive 1000$ from NGO Bank","Some NGOs help refugees by giving them sums of money to enable them to carry on the journey",board);
                square20.addAction(new ReceiveMoneyAction(1000,nboBank));
                return square20;
            case 21:
                Square square21 = new Square(squareNumber,"Theft. You lose 1500$","Robbery is very common in refugee camps. Some refugees lose all their savings due to thieves",board);
                square21.addAction(new PayMoneyAction(1500,mafiaBank,false));
                return square21;
            case 22:
                Square square22 = new Square(squareNumber,"River Crossing. Roll dice and go backwards by the number on the dice","There are many rivers to cross in order to avoid police control. Specially in winter these rivers are almost impossible to cross. Refugees sometimes spend days and weeks till the river level comes down and then can be crossed",board);
                square22.addAction(new RollDiceAction(board,square22,false));
                return square22;
            case 23:
                Square square23 = new Square(squareNumber,"NGO Lift. Jump to family reunion box (29)","NGO volunteers often give free lifts to refugees in private cars. Hidden them in the boot or covered with blankets",board);
                square23.addAction(new GoToTile(29,board));
                return square23;
            case 24:
                Square square24 = new Square(squareNumber,"Border Police. Stay one turn","The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping then for days next to the border controls",board);
                square24.addAction(new loseTurn());
                return square24;            
            case 25:
                Square square25 = new Square(squareNumber,"Border Control 3. Back to border 2 (box 15)","In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border",board);
                square25.addAction(new GoToTile(15,board));
                return square25;
            case 26:
                Square square26 = new Square(squareNumber,"Asylum Paperwork. Pay 1000$ to Mafia Bank. Option A: Pay $1500 to Mafia Bank and roll dice. Option B: Don’t pay and stay 2 turns","Some refugees are pressurised by the Mafia to let them deal with the Asylum Seeker Paperwork, obviously under a payment that sometimes can reach big sums of money. In many of the cases these documents never appear or get lost",board);                                    
                square26.addAction(new PayMoneyAction(1000,mafiaBank,true));
                square26.addAction(new PayMoneyAction(1500,mafiaBank,true));
                square26.addAction(new RollDiceAction(board,square26,true));
                square26.addAction(new loseTurn());
                return square26;
            case 27:
                Square square27 = new Square(squareNumber,"Storm. Stay one turn","Weather conditions in central Europe can be very extreme in winter. Often refugees get stuck for days and weeks in the middle of nowhere",board);
                square27.addAction(new loseTurn());
                return square27;            
            case 28:
                Square square28 = new Square(squareNumber,"UNHCR Aid. Roll dice","The United Nations High Commissioner for Refugees provides support in different parts of the refugee journey",board);
                square28.addAction(new RollDiceAction(board,square28,true));
                return square28;
            case 29:
                Square square29 = new Square(squareNumber,"Family Reunion. Jump to bus box (31)","Most of refugees families can’t travel together, due to money or due to complexity of moving in groups. Some refugee families reunite in different parts of the journey. Sometimes parents send their children ahead alone as it is more probable for a child to get asylum",board);
                square29.addAction(new GoToTile(31,board));
                return square29;
            case 30:
                Square square30 = new Square(squareNumber,"Right Wing Militia. Back to Border police box (24)","Fascist Militias have spread dramatically along many country borders in Europe. These people act in Paramilitary way, uniformed and sometimes with real arms, beating, raping and torturing refugees",board);
                square30.addAction(new GoToTile(24,board));
                return square30;
            case 31:
                Square square31 = new Square(squareNumber,"Mafia Bus. Pay 800$ to Mafia Bank. Roll dice","Mafia use buses to move long number of refugees from border to border. Due to stronger control of border policy, buses have been replaced by trucks or vans for this purpose. A long number of refugees have been found dead inside of abandoned lorries in car parks, petrol stations or even next to border controls by Mafia drivers",board);
                square31.addAction(new PayMoneyAction(800,mafiaBank,true));
                square31.addAction(new RollDiceAction(board,square31,true));
                return square31;
            case 32:
                Square square32 = new Square(squareNumber,"Government Detention Camp. Stay one turn","All European countries have Detention Camps for illegal immigrants. Immigration detention refers to the government practice of detaining asylum seekers and other migrants for administrative purposes, typically to establish their identities, or to facilitate their immigration claims resolution and/or their removals. It is an administrative process rather than a criminal procedure. Detention time defers from country to country, also does the conditions inside of those ones in each country",board);
                square32.addAction(new loseTurn());
                return square32;            
            case 33:
                Square square33 = new Square(squareNumber,"Asylum Seeker Application rejected. Back to Train box (17) and Roll dice","Decisions often depend on whether the case owner and the person’s account to be believable. There are a number of ways that an applicant’s credibility may be damaged, for example, if they have given inaccurate or inconsistent information. Case owners must also take the applicant’s behaviour into account",board);
                square33.addAction(new GoToTile(17,board));
                square33.addAction(new RollDiceAction(board,square33,true));
                return square33;
            case 34:
                Square square34 = new Square(squareNumber,"Border Police. Stay one turn","The border police in many countries in Europe discretionally stop refugees from crossing. Sometimes keeping then for days next to the border controls",board);
                square34.addAction(new loseTurn());
                return square34;            
            case 35:
                Square square35 = new Square(squareNumber,"Border Control 4. Back to Border 3 (box 25)","In some Border Controls in Europe, refugees are stopped and put in buses and taken to the previous country border",board);
                square35.addAction(new GoToTile(25,board));
                return square35;
            case 36:
                Square square36 = new Square(squareNumber,"Asylum Seeker Application Approved. You win","In The United Kingdom if the claim is allowed on the grounds of the 1951 Geneva Convention, either by the UK Border Agency or at appeal, the applicant gets Refugee Status, which lasts for five years. The UK Border Agency can review this grant of status during this time if there is good reason, such as if the circumstances in the country of origin have changed. After five years, if it is still unsafe for the person to return to their own country, they will be able to apply for a legal status known as Indefinite Leave to Remain (ILR) in the UK",board);
                square36.addAction(new Win());
                return square36;
            case 37:
                Square square37 = new Square(squareNumber,"Mafia. Pay 1000$ to Mafia Bank","Specialised Refugee Ma as have spread dramatically in the last few years. These ones have an enormous power in countries like Turkey, Afghanistan or Libya. It is almost impossible to reach Europe without paying the Mafia",board);
                square37.addAction(new PayMoneyAction(1000,mafiaBank,true));
                return square37;
            case 38:
                Square square38 = new Square(squareNumber,"Deported. You are sent back to war box (0)","Deportation, legally speaking (UK) is the enforced removal of someone “for the public good”, usually after serving a criminal sentence in the UK. Removals and deportations are usually carried out either on a commercial airline (one person being removed/deported, usually escorted by security guards, and the other passengers are the public travelling for holiday or business) or by private charter flight (usually lots of people being removed/deported to the same country at the same time)",board);
                square38.addAction(new GoToTile(0,board));
                return square38;
            case 39:
                Square square39 = new Square(squareNumber,"New Home. You are finally accepted. You win","According to the European Parliament in 2015 and 2016 alone, more than 2.5 million people applied for asylum in the EU. Authorities in the member states issued 593,000 first instance asylum decisions in 2015 - over half of them positive. Most people who applied for protection at the height of the refugee crisis in 2015 had to wait until 2016 to receive their ruling. That year 1.1 million asylum decisions were made. 61% of those were positive with one third of applicants granted refugee status, the highest level of international protection",board);
                square39.addAction(new Win());
                return square39;            
            default:
                // Default square if needed
                return new Square(squareNumber, "Default Square","Adding new Squares in the future?",board);
        }
    }
    
    
    public void startGame(){
        System.out.println("Welcome to Refugeoly !!");
        Square currentSquare;
        boolean endGame = true;
        boolean turn = true;
        int endOfSquares,numberDice = 0;

        
        while(endGame){
            ArrayList<Refugee> copyOfRefugee = new ArrayList<>(refugee);
            for (Refugee player : copyOfRefugee) {
                
                System.out.println("It's " + player.getName() + "'s turn");
                System.out.println("Previous position of " + player.getName() + " was the square " + player.getPreviousPosition());
                if(player.getIsMyTurn() == false){          // if the player went to a square which is a "Skip Round"
                    System.out.println("You cant play. You skip a round");
                    turn = false;
                } 
                System.out.println("Type anything and press Enter:");
                // Read user input
                input.nextLine(); // Just so the programm doesn't end directly
                
                if(turn){         // Just so the programm does't print the diceroll
                    numberDice = board.rollDice();
                    System.out.println("Dice: " + numberDice);
                }
                else{
                    turn = true;
                }
                endOfSquares = numberDice;                              // Storing the roll of the dice
                numberDice += player.getPreviousPosition();             // Computing where the player should go now
                if(numberDice > 39){                                    // If we are out of bounds
                    numberDice = 39 - player.getPreviousPosition();     // take the 39(max square) - where the player was before
                    endOfSquares = endOfSquares - numberDice;           // take the roll of the dice(example 6) - numberDice(if the previous position was 35 then the numberDice should be 4)
                    numberDice = 39 - endOfSquares;                     // Go numberDice backwords(in this example 2 squares back)
                }
                if(!skipTurn(player)){                                  // If the player has to skip a round
                    continue;
                }
                else if(!calculateDiceRoll(player,numberDice)){         // If all the playres have won/lost 
                    endGame = false;                                    // End the programm 
                    break;
                }
                else{                                                   // Else start the round
                    currentSquare = board.getSquare(numberDice);        // Taking the specific square from the board       
                    numberDice = 0;
                    player.moveTo(currentSquare);                       // Moving the player to that square
                    
                    if(!skipTurn(player)){                              // If the player was on a skip turn square continue
                        continue;
                    }
                    
                    handleSquare(player,currentSquare);                // Start the actions to that square
                }
                
                if(!calculateDiceRoll(player,numberDice)){
                    endGame = false;
                    break;
                }
               if(refugee.isEmpty()){                                   // If there no players left stop
                   break;
               }
            }
            System.out.println();
        }
        printWinnerLosers(playerWinner,playerLost);                     // Print winners/losers
    }
    
    private void handleSquare(Refugee player,Square currentSquare){
        ArrayList<Action> actions = new ArrayList<>(currentSquare.getActions());    // Making an Arraylist with actions from that specific square

        for (Action action : actions) {                                             // Start the actions to that square
            System.out.println("Before: _______________________________________________________________");
            printPlayerStatus(player,nboBank,mafiaBank);                            // Print before
            System.out.println("_______________________________________________________________________");
            System.out.println();
            System.out.println("After: ________________________________________________________________");
            System.out.println("Square " + player.getNumber() + ": " + currentSquare.getText());
            System.out.println("~~~ Description: " + currentSquare.getDescription() + " ~~~");
            System.out.println();
            if (doWeRollAgain(player)) {    // If the square says to roll again
                action.act(player);         // action
                
                // Making sure that the square exists
                if (board.getSquare(player.getNumber()) == null) {      
                    System.out.println("No such square");
                    break;
                }

                // Update the player's position based on forward/backward movement
                if (!calculateDiceRoll(player, player.getNumber())) {
                    break;
                }

                // Recursive call to handle the updated square
                player.setPreviousPosition(player.getNumber());
                handleSquare(player, board.getSquare(player.getNumber()));
                break;

            } else if (doWeRollAgainTwice(player)) {    // If the square has an action with rolldice
                // Execute the first action
                Action firstAction = actions.get(0);    // I take every action separately
                firstAction.act(player);

                // Check if the player needs to roll the dice again
                if (!calculateDiceRoll(player, player.getNumber())) {
                    break;
                }

                // Update the player's position after the first action
                player.moveTo(board.getSquare(player.getNumber()));

                // Execute the second action
                Action secondAction = actions.get(1);
                secondAction.act(player);

                // Check if the player needs to roll the dice again or he won/lost
                if (!calculateDiceRoll(player, player.getNumber())) {
                    break;
                }

                // Update the player's position after the second action
                player.moveTo(board.getSquare(player.getNumber()));

                // Recursive call to handle the updated square
                player.setPreviousPosition(player.getNumber());
                handleSquare(player, board.getSquare(player.getNumber()));
                break;
    
            }
            else if(player.getNumber() == 26){      // Just for the square 26
                System.out.println("You are on square 26. You lose 1000$ and you give it to Mafia");
                Action firstAction26 = actions.get(0);
                firstAction26.act(player);

                // Check if the player needs to roll the dice again
                if (!calculateDiceRoll(player, player.getNumber())) {
                    break;
                }
                
                System.out.println("You should choose between Option A or Option B");
                System.out.println("OPTION A: Pay 1500$ to Mafia and Roll Dice");
                System.out.println("OPTION B: Lose turn 2 times");
                String choice;
                while (true) {
                    System.out.println("Enter your choice (A or B):");
                    choice = input.nextLine();

                    if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("b")) {     //Making sure that the player types a/A or b/B
                        break; // Break out of the loop if the choice is valid
                    } else {
                        System.out.println("Invalid choice. Please enter A or B.");
                    }
                }
                
                if(choice.equalsIgnoreCase("a")){       // If a/A take the second and third action
                    Action secondAction26 = actions.get(1);
                    secondAction26.act(player);

                    // Check if the player needs to roll the dice again
                    if (!calculateDiceRoll(player, player.getNumber())) {
                        break;
                    }
                    
                    Action thirdAction26 = actions.get(2);
                    thirdAction26.act(player);

                    // Check if the player needs to roll the dice again
                    if (!calculateDiceRoll(player, player.getNumber())) {
                        break;
                    }
                    player.moveTo(board.getSquare(player.getNumber()));
                    player.setPreviousPosition(player.getNumber());
                    handleSquare(player, board.getSquare(player.getNumber()));
                    break;
                }
                else if(choice.equalsIgnoreCase("b")){  // if b/B take only the fourth action
                    if (!calculateDiceRoll(player, player.getNumber())) {
                        break;
                    }
                    Action forthAction26 = actions.get(3);
                    forthAction26.act(player);
                    player.setPreviousPosition(player.getNumber());
                    break;
                }
                else{
                    System.out.println("Choose between A OR B");
                }
            }
            else {                                  // Else if there is a square without rolling the dice again just use the actions
                if (!calculateDiceRoll(player, player.getNumber())) {
                    break;
                }
                action.act(player);
                player.setPreviousPosition(player.getNumber()); // Updating the previous position
            }
            printPlayerStatus(player,nboBank,mafiaBank);        // Printing the Aftermath
        }
        System.out.println("_______________________________________________________________________");
        System.out.println();
    }
            
    private boolean doWeRollAgain(Refugee currentRefugee){      // If there is a square with only a rolldice and nothing else(a different action)
        if(currentRefugee.getNumber() == 2  || currentRefugee.getNumber() == 12 || currentRefugee.getNumber() == 17 || currentRefugee.getNumber() == 22 || currentRefugee.getNumber() == 28){
            return true;
        }
        return false;
    } 
    
    private boolean doWeRollAgainTwice(Refugee player){         // If there is a square with rolldice and an onother action
        if(player.getNumber() == 9 || player.getNumber() == 16 || player.getNumber() == 31 || player.getNumber() == 33){
            return true;
        }
        return false;
    }

    private boolean calculateDiceRoll(Refugee player,int numberDice){       // Check if the player has won/lost
                if (numberDice == 36 || numberDice == 39) {
                    
                    if (refugee.contains(player)) {
                        
                        playerWinner.addWinningPlayer(player);
                        refugee.remove(player);                             // Remove the player from the original list
                        System.out.println();
                        System.out.println("Congratulations you WON !!!!");
                        System.out.println();
                    }
                }
                
                else if (numberDice == 10 || !player.getMoneyLeft()){       // If the player landed on square 10 or has no money loses
                    if (refugee.contains(player)) {
                        playerLost.addLosingPlayer(player);
                        refugee.remove(player);                             // Remove the player from the original list
                        System.out.println();
                        System.out.println("What a shame..... You LOST");
                        System.out.println();
                    } 
                }
                if(refugee.isEmpty()){
                    return false;
                }
                else{
                    return true;
                }
    }
    
    private boolean skipTurn(Refugee player){       // If the players counter is >0 he will skip the rounds according to the counter
        if(!player.getIsMyTurn()){                  // The player has stepped in a square with skip turn
            if(player.getCounterIsMyTurn() == 0){   // The players has't yet skiped a turn
                player.plusCounterIsMyTurn();       // +1 the counter 
                if(player.getNumber() == 26){   // If the player is in the square 26 and he chose the option B he loses 2 turns
                    player.plusCounterIsMyTurn();   // +1 the counter
                }
            }
            else if(player.getCounterIsMyTurn() == 1){  // Making sure that the player which he lost a round makes the counter back at 0
                player.minusCounterIsMyTurn();
            }
            player.setIsMyTurn(true);           // Returning true so the player goes to the next if so he can skip the round
         }
        if(player.getIsMyTurn()){                   // If the player skiped a round decrease his counter
            if(player.getCounterIsMyTurn() == 1 || player.getCounterIsMyTurn() == 2){
                player.minusCounterIsMyTurn();
                return false;                       // And return false so he can skip it
            }
        }
        return true;
    }
    
    private void printPlayerStatus(Refugee player,GiverEntity nbo,ReceiverEntity mafia) {       // Printing the: Before and After
        System.out.println(player);
        System.out.println(nbo);
        System.out.println(mafia);
    }
    
    public void printWinnerLosers(Win playerWinner,Lose playerLoser){                           // Printing who won and lost
        playerWinner.getWinners();
        System.out.println("----------------------");
        playerLoser.getLosers();
    }
}
