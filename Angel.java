
public class Angel extends Player {
	/**
	 * always plays coop
	 */
	public boolean move(boolean[][] game, int pos,boolean player)
	{
		return true;
	}
	public String getName()
	{
		return "Angel";
	}
}
