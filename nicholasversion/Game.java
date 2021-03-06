package nicholasversion;

import java.util.ArrayList;

public class Game {
	/// pal holds the two players in the game.
	/// the final integers is the score awarded for the different possibilities.
	/// the playerTypes are passed to the Players as their types.
	public ArrayList<Player> pal;
	public final int BOTHCOOP=2,LOSE=0,WIN=3,BOTHDEFECT=1;
	public int playerType1,playerType2;

	public Game(int playerType1, int playerType2) {
		
		pal = new ArrayList<Player>();
		
		this.playerType1=playerType1;
		this.playerType2=playerType2;
		
		pal.add(new Player(playerType1));
		pal.add(new Player(playerType2));
	}
	/**
	 * loops the two competitors over multiple games, then prints their score at the end.
	 */
	public void loopAndPrint() {
		System.out.printf("Game between %s and %s:\n",pal.get(0).getTYPENAME(),pal.get(1).getTYPENAME());
		for (int i = 0; i < 100; i++) {
			interact(pal.get(0), pal.get(1));
		}
		pal.get(0).printScore();
		pal.get(1).printScore();
	}
	/**
	 * Players play one game and record results and update info.
	 * Based on how they are played, addScore will add the different values.
	 * the record of what they have played is also recorded.
	 * @param p1
	 * @param p2
	 */
	public void interact(Player p1, Player p2) {
		
		boolean p1Strat=p1.play();
		boolean p2Strat=p2.play();
		boolean[] p1Record={p1Strat,p2Strat};
		boolean[] p2Record={p2Strat,p1Strat};
		
		if (p1Strat && p2Strat) {
			p1.addScore(BOTHCOOP);
			p2.addScore(BOTHCOOP);
		}

		if (p1Strat && !p2Strat) {
			p1.addScore(LOSE);
			p2.addScore(WIN);
		}

		if (!p1Strat && p2Strat) {
			p1.addScore(WIN);
			p2.addScore(LOSE);
		}

		if (!p1Strat && !p2Strat) {
			p1.addScore(BOTHDEFECT);
			p2.addScore(BOTHDEFECT);
		}
		
		p1.addRecord(p1Record);
		p2.addRecord(p2Record);
		
		p1.incrementRound();
		p2.incrementRound();

	}
	/**
	 * main is here until I move it elsewhere.
	 * @param args
	 */
	public static void main(String[] args) {
		int amtOfPlayerTypes=4;
		ArrayList<Game> gameAL=new ArrayList<Game>();
		for(int i=0;i<amtOfPlayerTypes;i++){
			for(int j=0;j<=i;j++){
				Game game=new Game(i,j);
				game.loopAndPrint();
				gameAL.add(game);
				
			}
		}
	}
}
