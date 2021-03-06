
public class TiTa2 extends Player {
	/*
	 *  classic Tit-for-Tat with twist
	 *  starts with defect, then does whatever the opponent did previously
	 */
	public boolean move(boolean[][] game, int pos,boolean player)
	{
		if (pos==0)
			return false;
		return game[(!player)?1:0][pos-1];
	}
	public String getName()
	{
		return "TitTat2";
	}
}
