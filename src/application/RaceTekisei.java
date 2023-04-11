package application;

public class RaceTekisei 
{
	public RaceTekisei(RaceCourse rc) 
	{

		straightSlope = rc.straightSlope;
		straightDistance = rc.straightDistance;
		rotationSide = rc.rotationSide;
		rotationSize = rc.rotationSize;
		cornerShape = rc.cornerShape;
		grassStart = rc.grassStart;
		range = rc.range;
		raceGround = rc.raceGround;
		
	}
	public String straightSlope;
	public String straightDistance;
	public String rotationSide;
	public String rotationSize;
	public String cornerShape;
	public String grassStart;
	public int range;
	public String raceGround;
}
