package package1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Content implements Player {
	String weapon = "Punch";
	static int money = 0;
	static char decide; 
	int hp = 5;
	int guardHp = 5;
	static boolean b = true;
	static Scanner scn = new Scanner(System.in);
	
	public static void Runner(){
		Content c = new Content();
		while(b) {
			try {
			System.out.println("Instruction: To play the game you were about to pick to the included choices to play.");
			System.out.println("Your current hp is " + c.hp);
			System.out.println("The guard's hp is " + c.guardHp + "\n");
			System.out.println("***************************");
			System.out.println("******STREET GANGSTER******");
			System.out.println("******STREET GANGSTER******");
			System.out.println("******STREET GANGSTER******");
			System.out.println("***************************");
			System.out.println("You were ordered by your boss to deliver money to his acquaintance.");
			System.out.println("You are holding a large sum of money at this time.");
			System.out.println("However, unexpected events occur during the delivery.\n");
			if(c.money > 1) {
				System.out.println("To upgrade your skills. Buy a weapon.");
				System.out.println("[1] Gun");
				System.out.println("[2] Knife");
				c.money = c.money - 500000;
				c.weapon();
				System.out.println("Money: " + c.money + "\n");
			}
			System.out.println("[1]Continue");
			System.out.println("[2]Exit");
			char choice = scn.next().charAt(0);
			
			if(choice == '1') {
				System.out.println("");
			}else if(choice == '2'){
				break;
			}else {
				throw new InputMismatchException();
			}
			System.out.println("You are able to deliver 1 million dollars to the other group of gangsters");
			System.out.println("When you are in delivery address.");
			System.out.println("The guard invited you to the house but you are unaware that you have been betrayed by your boss");
			System.out.println("The guard released the dogs in the yard.\n" );
				while(b) {
					if(c.hp == 0) {
						c.health();
						break;
					}
					System.out.println("[1] Fight with dog.");
					System.out.println("[2] Run and escape.");
					
					char choice2 = scn.next().charAt(0);
					System.out.println("");
					if(choice2 == '1') {
						c.dogAttack();
					}else if(choice2 == '2'){
						c.dogRun();
						break;
					}else {
						throw new InputMismatchException();				
					}
				}
			if(c.hp == 0) {
				c.userDecide();
			}
			System.out.println("You are unaware that the security guard is running to punch you.");
			c.enemyPunch();
			while(b) {
				System.out.println("[1] " + c.weapon);
				System.out.println("[2] Run and Escape");
				char choice3 = scn.next().charAt(0);
				System.out.println("");
				if(choice3 == '1') {
					c.playerPunch();
				}else if(choice3 == '2'){
					c.playerEscape();
				}else {
					throw new InputMismatchException();
				}
				
			}
			System.out.println("After betraying you, you managed to overcome all obstacles.");
			System.out.println("Because of what happened, you withdrew from the group and never returned the money in the bag, living happily.");
			System.out.println("You were able to surpass everything. Well done!\n");
			c.money = c.money + 1000000;
			System.out.println("Money: " + c.money);
			c.userDecide();
			}catch(InputMismatchException ime) {
				System.out.println("Enter a valid input. Try again.");
				c.userDecide();
			}
		}
	
		
	}
	public void weapon() {
		char decide = scn.next().charAt(0);
		if(decide == '1') {
			weapon = "Gun";
		}
		else if(decide == '2') {
			weapon = "Knife";
		}
		else {
			System.out.println("Invalid input. Play again.");
			userDecide();
		}
		
	}
	public boolean userDecide() {
		if(hp >= 0) {
			System.out.println("Do you want to play again? [Y] or [N]");
			char decide = scn.next().toUpperCase().charAt(0);
			if(decide == 'Y') {
				b = true;
				System.out.println();
				hp = 5;
				guardHp = 5;
				Runner();
			}
			else {
				System.out.println("Exit.");
			}
		}
		return b = false;
	}
	
	//Interface Methods
	//Dog
	public void dogAttack() {
		hp = hp - 1;
		System.out.println("Your current hp is " + hp + "\n");
	}
	
	public void dogRun() {
		System.out.println("The dog is chasing you and you escaped the trap.");
		System.out.println("You are now in the road. \n");
	}
	
	//Player
	public void health() {
		System.out.println("You died. Game over. \n");
	}
	
	public void playerPunch() {
		guardHp = guardHp - 1;
		System.out.println("The security guard was punched ");
		System.out.println("The security guard HP becomes " + guardHp + "\n");
		if(guardHp == 0) {
			System.out.println("You win the fight. The guard was knocked down.\n");
			b = false;
		}
	}
	
	public void playerEscape() {
		hp= hp - 1;
		System.out.println("The guard shot you while you are running.");
		System.out.println("Your current hp is " + hp + "\n");
		if (hp == 0) {
			System.out.println("You died. Game over.");
			b = false;
			userDecide();
		}
		
	}
	
	//Enemy
	public void enemyPunch() {
		hp = hp - 1;
		System.out.println("You was hitted by the punch.\n");
		System.out.println("Your current hp is " + hp + "\n");
	}
}
