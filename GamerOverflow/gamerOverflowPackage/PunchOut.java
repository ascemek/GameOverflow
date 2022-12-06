import java.util.Random;
import java.util.Scanner;

public class PunchOut extends Game {

    int playerChoice;
    int specialPoints = 3;
    int npcPoints = 3;
    int turns = 0;
    int totalScore = 0;

    Scanner playerInput;
    
    public PunchOut()
    {
        System.out.println("Welcome to Punch Out!");
    }

    @Override
    void computerTurn(Player p, NPC npc) {

        System.out.println("-------------------------------------------------------------------------------");
        int compChoice = actionChose();

        //PLayer BLeft
        if (playerChoice == 0)
        {
            //NPC Blocks
            if ((compChoice == 0)||(compChoice == 1))
            {
                System.out.println("Both fighters blocked!");
                System.out.println("Nobody got hit!");
            }
            //NPC Punch Left
            else if (compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You got hit!");
                totalScore = totalScore - 10;

                int damage = npc.getAttack()-p.getDefense();
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Punch Right
            else if (compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their right!");
                System.out.println("You blocked the punch!");
            }
            //NPC Dodge
            else if ((compChoice == 4)||(compChoice == 5))
            {
                System.out.println("Enemy fighter dodged!");
                System.out.println("Nobody got hit!");
            }
            //NPC Super Attack
            else if (compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("Blocking Special Attacks doesnt work!");
                    totalScore = totalScore - 20;

                    int damage = 2*(npc.getAttack()-p.getDefense());
                    System.out.println("You take " + damage + " damage!");
                    p.setHealth(damage);
                    npcPoints--;
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    npcPoints--;
                }
            }
        }
        //Player BRight
        else if (playerChoice == 1)
        {
            //NPC Blocks
            if((compChoice == 0)||(compChoice == 1))
            {
                System.out.println("Both fighters blocked!");
                System.out.println("Nobody got hit!");
            }
            //NPC Punch Left
            else if(compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You blocked the punch!");
            }
            //NPC Punch Right
            else if(compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their right!");
                System.out.println("You got hit!");
                totalScore = totalScore - 10;

                int damage = npc.getAttack()-p.getDefense();
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Dodge
            else if((compChoice == 4)||(compChoice == 5))
            {
                System.out.println("Enemy fighter dodged!");
                System.out.println("Nobody got hit!");
            }
            //NPC Super Attack
            else if(compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("Blocking Special Attacks doesnt work!");
                    totalScore = totalScore - 20;

                    int damage = 2*(npc.getAttack()-p.getDefense());
                    System.out.println("You take " + damage + " damage!");
                    p.setHealth(damage);
                    npcPoints--;
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    npcPoints--;
                }
            }
            
        }
        //Player PLeft
        else if (playerChoice == 2)
        {
            //NPC Blocks Left
            if(compChoice == 0)
            {
                System.out.println("The enemy fighter blocked to their left!");
                System.out.println("You landed a hit!");
                totalScore = totalScore+10;

                int damage = (npc.getAttack()-p.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);
            }
            //NPC Blocks Right
            else if(compChoice == 1)
            {
                System.out.println("The enemy fighter blocked to their right!");
                System.out.println("The enemy blocked your hit!");
            }
            //NPC Punch Left
            else if(compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("Both blows connect! Both fighters are hit!");

                int damage = (p.getAttack()-npc.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);

                damage = (npc.getAttack()-p.getDefense());
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Punch Right
            else if(compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their right!");
                System.out.println("Your fists collide! No damage!");
            }
            //NPC Dodge Left
            else if(compChoice == 4)
            {
                System.out.println("The enemy fighter dodged to their left");
                System.out.println("Your fist doesn't connect!");
            }
            //NPC Dodge Right
            else if(compChoice == 5)
            {
                System.out.println("The enemy fighter dodged-");
                System.out.println("INTO YOUR FIST! Your blow lands!");
            
                int damage = (p.getAttack()-npc.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);
                
            }
            //NPC Super Attack
            else if(compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("You lightly jab them before it can go off!");
                    System.out.println("No damage is dealt, but you gain special energy!");
                    totalScore = totalScore+ 15;
                    npcPoints--;
                    specialPoints++;
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    System.out.println("They stumble straight into your attack! DOUBLE DAMAGE!");
                    totalScore = totalScore+ 30;

                    int damage = 2*(npc.getAttack()-p.getDefense());
                    System.out.println("The enemy takes " + damage + " damage!");
                    npc.setHealth(damage);
                    npcPoints--;
                }

            }
        }
        //Player PRight
        else if (playerChoice == 3)
        {
            //NPC Blocks Left
            if(compChoice == 0)
            {
                System.out.println("The enemy fighter blocked to their left!");
                System.out.println("The enemy blocked your hit!");
            }
            //NPC Blocks Right
            else if(compChoice == 1)
            {
                System.out.println("The enemy fighter blocked to their right!");
                System.out.println("You landed a hit!");

                int damage = (p.getAttack()-npc.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);
            }
            //NPC Punch Left
            else if(compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("Your fists collide! No damage!");
            }
            //NPC Punch Right
            else if(compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their right!");
                System.out.println("Both blows connect! Both fighters are hit!");

                int damage = (p.getAttack()-npc.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);

                damage = (npc.getAttack()-p.getDefense());
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Dodge Left
            else if(compChoice == 4)
            {
                System.out.println("The enemy fighter dodged-");
                System.out.println("INTO YOUR FIST! Your blow lands!");

                int damage = (p.getAttack()-npc.getDefense());
                System.out.println("The enemy takes " + damage + " damage!");
                npc.setHealth(damage);
            }
            //NPC Dodge Right
            else if(compChoice == 5)
            {
                System.out.println("The enemy fighter dodged to their right");
                System.out.println("Your fist doesn't connect!");
            }
            //NPC Super Attack
            else if(compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("You lightly jab them before it can go off!");
                    System.out.println("No damage is dealt, but you gain special energy!");
                    totalScore = totalScore + 15;
                    npcPoints--;
                    specialPoints++;
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    System.out.println("They stumble straight into your attack! DOUBLE DAMAGE!");
                    totalScore = totalScore+ 30;

                    int damage = 2*(npc.getAttack()-p.getDefense());
                    System.out.println("The enemy takes " + damage + " damage!");
                    npc.setHealth(damage);
                    npcPoints--;
                }
            }
        }
        //Player DodgeL
        else if (playerChoice == 4)
        {
            //NPC Blocks
            if((compChoice == 0)||(compChoice == 1))
            {
                System.out.println("Enemy fighter blocked!");
                System.out.println("Nobody got hit!");
            }
            //NPC Punch Left
            else if(compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You dodge their attack!");
            }
            //NPC Punch Right
            else if(compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You dodge right into their fist!");

                int damage = (npc.getAttack()-p.getDefense());
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Dodge
            else if((compChoice == 4)||(compChoice == 5))
            {
                System.out.println("Enemy fighter dodged!");
                System.out.println("Nobody got hit!");
            }
            //NPC Super Attack
            else if(compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("You barely manage to dodge the hit!");
                    totalScore = totalScore + 5;
                    npcPoints--;
                    
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    System.out.println("They stumble as you manage to easily avoid their attempted attack!");
                    npcPoints--;
                }
            }
        }
        //Player DodgeR
        else if (playerChoice == 5)
        {
            //NPC Blocks
            if((compChoice == 0)||(compChoice == 1))
            {
                System.out.println("Enemy fighter blocked!");
                System.out.println("Nobody got hit!");
            }
            //NPC Punch Left
            else if(compChoice == 2)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You dodge right into their fist!");
                totalScore = totalScore - 10;

                int damage = (npc.getAttack()-p.getDefense());
                System.out.println("You take " + damage + " damage!");
                p.setHealth(damage);
            }
            //NPC Punch Right
            else if(compChoice == 3)
            {
                System.out.println("The enemy fighter punched to their left!");
                System.out.println("You dodge their attack!");
            }
            //NPC Dodge
            else if((compChoice == 4)||(compChoice == 5))
            {
                System.out.println("Enemy fighter dodged!");
                System.out.println("Nobody got hit!");
            }
            //NPC Super Attack
            else if(compChoice == 6)
            {
                if(npcPoints>0)
                {
                    System.out.println("Enemy fighter uses a special move!");
                    System.out.println("You barely manage to dodge the hit!");
                    totalScore = totalScore + 5;
                    npcPoints--;
                    
                }
                else
                {
                    System.out.println("Enemy fighter tries a special move but has no energy left!");
                    System.out.println("They stumble as you manage to easily avoid their attempted attack!");
                    npcPoints--;
                }
            }
        }
        //Player Special Punch 
        else if (playerChoice == 6)
        {
            //NPC Blocks
            if((compChoice == 0)||(compChoice == 1))
            {
                if(specialPoints>0)
                {
                    System.out.println("You use a special move!");
                    System.out.println("They attempt to block it and take damage!");

                    int damage = 2*(p.getAttack()-npc.getDefense());
                    System.out.println("The enemy takes " + damage + " damage!");
                    specialPoints--;
                    
                }
                else
                {
                    System.out.println("You try to use a special move but have no energy left!");
                    System.out.println("You stumble around and land nothing!");
                    specialPoints--;
                }
            }
            //NPC Punch
            else if((compChoice == 2)||(compChoice == 3))
            {
                if(specialPoints>0)
                {
                    System.out.println("You use a special move!");
                    System.out.println("The enemy fighter lightly jabs you before it can go off!");
                    System.out.println("No damage is dealt, but they gain special energy!");
                    totalScore = totalScore - 15;

                    specialPoints--;
                    npcPoints++;
                }
                else
                {
                    System.out.println("You try a special move but have no energy left!");
                    System.out.println("You stumble straight into their attack! DOUBLE DAMAGE!");
                    totalScore = totalScore -  30;

                    int damage = 2*(p.getAttack()-npc.getDefense());
                    System.out.println("The enemy takes " + damage + " damage!");
                    p.setHealth(damage);
                    specialPoints--;
                }

            }
            //NPC Dodge
            else if((compChoice == 4)||(compChoice == 5))
            {
                if(specialPoints>0)
                {
                    System.out.println("You use a special move!");
                    System.out.println("The enemy fighter barely manages to dodge the hit!");
                    totalScore = totalScore - 5;
                    specialPoints--;
                    
                }
                else
                {
                    System.out.println("You try a special move but have no energy left!");
                    System.out.println("You stumble as the enemy fighter manages to easily avoid your attempted attack!");
                    specialPoints--;
                }

            }
            //NPC Super Attack
            if(compChoice == 6)
            {
                if(specialPoints>0)
                {
                    if(npcPoints>0)
                    {
                        System.out.println("BOTH FIGHTERS GO IN FOR A SPECIAL ATTACK!!!");
                        System.out.println("THE BLOWS CANCEL EACH OTHER OUT BUT YOU'RE BOTH BLOWN BACK!!!");
                        npcPoints--;
                    }
                    else
                    {
                        System.out.println("The enemy fighter tries to use a special but has no energy for it!");
                        System.out.println("YOU LAND A SPECIAL ATTACK ON THE ENEMY FIGHTER WHO IS DEFENSELESS! DOUBLE DAMAGE!!!");
                        totalScore = totalScore + 30;

                        int damage = 4*(p.getAttack()-npc.getDefense());
                        System.out.println("The enemy takes " + damage + " damage!");
                        npc.setHealth(damage);
                        npcPoints--;
                    }
                    specialPoints--;
                }
                else
                {
                    if(npcPoints>0)
                    {
                        System.out.println("You try to use a special but lack the energy! The enemy on the other hand-");
                        System.out.println("THEY LAND A SPECIAL ATTACK ON THE YOU! DOUBLE DAMAGE!!!");
                        totalScore = totalScore + 30;

                        int damage = 4*(npc.getAttack()-p.getDefense());
                        System.out.println("You take " + damage + " damage!");
                        p.setHealth(damage);
                        npcPoints--;
                    }
                    else
                    {
                        System.out.println("Neither fighter has the energy for a special attack but they do it anyways!");
                        System.out.println("Stumbling forward, both contestants trip and fall over each other!");
                        npcPoints--;
                    }
                    specialPoints--;
                }
            }
        }
    }


    @Override
    void playerTurn(Player p, Scanner scan) {

        turns++;
        boolean choose = false;
        String bLeft = "block left";
        String bRight = "block right";
        String pLeft = "punch left";
        String pRight = "punch right";
        String dLeft = "dodge left";
        String dRight = "dodge right";
        String special = "special attack";

        while (choose == false)
        {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("You are currently at: " + p.getHealth() + " health with " + specialPoints + " special attacks left.");
            System.out.println("Your enemy is still standing with " + npcPoints + " special attacks left.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Your options are:");
            System.out.println("1) Block Left       2) Block Right");
            System.out.println("3) Punch Left       4) Punch Right");
            System.out.println("5) Dodge Left       6) Dodge Right");
            System.out.println("7) Special Attack");
            System.out.println("Enter the move you want to make:");
            String input  = scan.nextLine();

            if (input.toLowerCase().contains(bLeft))
            {
                System.out.println("You choose to block left!");
                playerChoice = 0;
                choose = true;
            }
            else if (input.toLowerCase().contains(bRight))
            {
                System.out.println("You choose to block right!");
                playerChoice = 1;
                choose = true;
            }
            else if (input.toLowerCase().contains(pLeft))
            {
                System.out.println("You choose to punch left!");
                playerChoice = 2;
                choose = true;
            }
            else if (input.toLowerCase().contains(pRight))
            {
                System.out.println("You choose to punch right!");
                playerChoice = 3;
                choose = true;
            }
            else if (input.toLowerCase().contains(dLeft))
            {
                System.out.println("You choose to dodge left!");
                playerChoice = 4;
                choose = true;
            }
            else if (input.toLowerCase().contains(dRight))
            {
                System.out.println("You choose to dodge right!");
                playerChoice = 5;
                choose = true;
            }
            else if (input.toLowerCase().contains(special))
            {
                System.out.println("You choose to use a special attack!");
                playerChoice = 6;
                choose = true;
            }
            else
            {
                System.out.println("Your input can't be read! Try again!");
            }
        }
    }

    @Override
    int updateScore() {
        totalScore = totalScore + 10;
        return totalScore;
    }

    @Override
    void victoryEnd() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("You won the championship!!!");
        System.out.println("Your total score is: " + totalScore);
        
    }

    @Override
    void loseEnd() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("You lose!");
        System.out.println("Your total score is: " + totalScore);
    }

    static int actionChose()
    {
        Random randy = new Random();
        int actionChoice = randy.nextInt(7);
        return actionChoice;

    }

    @Override
    void checkVictory(Player p1, NPC e1) {

        if((p1.isDead() == true) && (e1.isDead() == true))
        {
            System.out.println("DOUBLE KO!!!");
            lose = true;
        }
        else if (p1.isDead() == true)
        {
            System.out.println("You got knocked out!!!");
            lose = true;
        }
        else if (e1.isDead() == true)
        {
            System.out.println("YOU KNOCKED OUT THE OPPONENT!!!");
            victory = true;
        }
        else
        {
            System.out.println("Both fighters are still standing!!!");
        }
    }
}