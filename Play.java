import java.util.*;

class player {
	Scanner sc = new Scanner(System.in);
	String player_one_name;
	String player_two_name;
	int player_one = 0,player_two = 0;;

	void name() {
		System.out.println("Please, Enter the name of player One : ");
		player_one_name = sc.next();
		System.out.println("Please, Enter the name of player Two : ");
		player_two_name = sc.next();
	}

	void scoreone() {
		player_one++;
	}
	void scoretwo() {
		player_two++;
	}
}

public class Play {
	static int box[][] = new int[8][8];
	int x=1,y=0,u=6,v=7,draw=0,game_over=0;
	Scanner sc = new Scanner(System.in);
	static player po=new player();
	private int check()
	{
		int k=0;
		if((box[x][x]==box[u][u]&&box[x][x]==1)||(box[x][y]==box[7-v][7-u]&&box[x][y]==1)||(x==v&&y==u))
			k=1;
		return k;
	}
	
	private int checkdraw()
	{
		int d=0;
		if(box[x+1][y]==1||box[x][y+1]==1)
			d=1;
		return d;
	}

	private void moveone() {
		int c=check();
		int d=checkdraw();
		if(c==1)
		{
			po.player_one+=3;
			System.out.println(po.player_one_name+" 1 Won the game.\n Total Points : "+po.player_one);
			game_over=1;
		}
		else if(d==1)
			draw=1;
		else
		{
			box[x][y]=0;
			System.out.println(po.player_one_name+", 1 Please press 1 to move left or 2 to move Right : ");
			int m=sc.nextInt();
			if(m==1)
				y++;
			else
				x++;
			box[x][y]=1;
			System.out.println("Player one position is : "+x+""+y);
		}
		

	}
	private void movetwo() {

		int c=check();
		int d=checkdraw();
		if(c==1)
		{
			po.player_two+=3;
			System.out.println(po.player_two_name+" 2 Won the game.\n Total Points : "+po.player_two);
			game_over=1;
		}
		else if(d==1)
			draw=1;
		else
		{
			box[u][v]=0;
			System.out.println(po.player_two_name+", 2 Please press 1 to move left or 2 to move Right : ");
			int m=sc.nextInt();
			if(m==1)
				v--;
			else
				u--;
			box[u][v]=1;
			System.out.println("Player two position is : "+u+""+v);
		}
		
		
	}

	public static void main(String[] args)
	{
		int first_move,total_move=-1,i,j; 
		
		Play p=new Play();
		
		for(i=0;i<8;i++)
			for(j=0;j<8;j++)
				box[i][j]=0;
		//taking names of the player
		
		po.name();
		
		//displaying the name
		
		System.out.println("Player one name is : "+po.player_one_name);
		System.out.println("\nPlayer two name is : "+po.player_two_name);
		
		//getting the first chance for the player
		
		System.out.println("Generating the first chance for move.");
		int toss=(int)Math.random()*99 +1;
		
		first_move=toss%2;
		
		 
		if(first_move==0)
			System.out.println("First move will be made by '"+po.player_one_name+"'");
		else
			System.out.println("First move will be made by '"+po.player_two_name+"'");
		
		//defining the position of the players
		
		System.out.println(po.player_one_name+"'s position is : "+p.x+""+p.y);
		System.out.println(po.player_two_name+"'s position is : "+p.u+""+p.v);
		
		
		//Moving the positions
		while(p.draw==0&&p.game_over==0)
		{
			if(first_move==0)
			{
				p.moveone();
				first_move=1;
			}
			else
			{
				p.movetwo();
				first_move=0;
			}
			total_move++;
		}
		if(p.draw==1)
			System.out.println("Game Draw");
		System.out.println("Total move made in the game is : "+total_move);
	}
}