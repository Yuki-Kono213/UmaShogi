package application;

import org.h2.mode.FunctionsLegacy;

public class RaceCourseUtil 
{
	
	public static RaceCourse ReturnRaceCourse (String stage, String range, String raceName)
	{
		if(stage.contains("札幌")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) 
				{
					return new SapporoGrass1200();
				}
				else if(range.contains("1500")) {
					return new SapporoGrass1500();
					
				}
				else if(range.contains("1800")) {
					return new SapporoGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new SapporoGrass2000();
					
				}
				else if(range.contains("2600")) {
					return new SapporoGrass2600();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1000")) 
				{
					return new SapporoDirt1000();
				}
				else if(range.contains("1700")) {
					return new SapporoDirt1700();
					
				}
				else if(range.contains("2400")) {
					return new SapporoDirt2400();
					
				}
			}
		}
		else if(stage.contains("函館")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1000")) 
				{
					return new HakodateGrass1000();
				}
				else if(range.contains("1200")) {
					return new HakodateGrass1200();
					
				}
				else if(range.contains("1800")) {
					return new HakodateGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new HakodateGrass2000();
					
				}
				else if(range.contains("2600")) {
					return new HakodateGrass2600();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1000")) 
				{
					return new HakodateDirt1000();
				}
				else if(range.contains("1700")) {
					return new HakodateDirt1700();
					
				}
				else if(range.contains("2400")) {
					return new HakodateDirt2400();
					
				}
			}
		}
		else if(stage.contains("福島")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) {
					return new FukushimaGrass1200();
					
				}
				else if(range.contains("1800")) {
					return new FukushimaGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new FukushimaGrass2000();
					
				}
				else if(range.contains("2600")) {
					return new FukushimaGrass2600();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1150")) 
				{
					return new FukushimaDirt1150();
				}
				else if(range.contains("1700")) {
					return new FukushimaDirt1700();
					
				}
				else if(range.contains("2400")) {
					return new FukushimaDirt2400();
					
				}
			}
		}
		else if(stage.contains("中山")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) {
					return new NakayamaGrass1200();
					
				}
				else if(range.contains("1600")) {
					return new NakayamaGrass1600();
					
				}
				else if(range.contains("1800")) {
					return new NakayamaGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new NakayamaGrass2000();
					
				}
				else if(range.contains("2200")) {
					return new NakayamaGrass2200();
					
				}
				else if(range.contains("2500")) {
					return new NakayamaGrass2500();
					
				}
				else if(range.contains("3600")) {
					return new NakayamaGrass3600();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1200")) 
				{
					return new NakayamaDirt1200();
				}
				else if(range.contains("1800")) {
					return new NakayamaDirt1800();
					
				}
				else if(range.contains("2400")) {
					return new NakayamaDirt2400();
					
				}
				else if(range.contains("2500")) {
					return new NakayamaDirt2500();
					
				}
			}
		}
		else if(stage.contains("東京")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1400")) {
					return new TokyoGrass1400();
					
				}
				else if(range.contains("1600")) {
					return new TokyoGrass1600();
					
				}
				else if(range.contains("1800")) {
					return new TokyoGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new TokyoGrass2000();
					
				}
				else if(range.contains("2300")) {
					return new TokyoGrass2300();
					
				}
				else if(range.contains("2400")) {
					return new TokyoGrass2400();
					
				}
				else if(range.contains("2500")) {
					return new TokyoGrass2500();
					
				}
				else if(range.contains("3400")) {
					return new TokyoGrass3400();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1300")) 
				{
					return new TokyoDirt1300();
				}
				else if(range.contains("1400")) {
					return new TokyoDirt1400();
					
				}
				else if(range.contains("1600")) {
					return new TokyoDirt1600();
					
				}
				else if(range.contains("2100")) {
					return new TokyoDirt2100();
					
				}
				else if(range.contains("2400")) {
					return new TokyoDirt2400();
					
				}
			}
		}
		else if(stage.contains("新潟")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1000")) {
					return new NiigataGrass1000();
					
				}
				else if(range.contains("1200")) {
					return new NiigataGrass1200();
					
				}
				else if(range.contains("1400")) {
					return new NiigataGrass1400();
					
				}
				else if(range.contains("1600")) {
					return new NiigataGrass1600();
					
				}
				else if(range.contains("1800")) {
					return new NiigataGrass1800();
					
				}
				else if(range.contains("2000") && (raceName.contains("2歳") || raceName.contains("3歳未勝利"))) {
					return new NiigataGrass2000In();
					
				}
				else if(range.contains("2000")) {
					return new NiigataGrass2000Out();
					
				}
				else if(range.contains("2200")) {
					return new NiigataGrass2200();
					
				}
				else if(range.contains("2400")) {
					return new NiigataGrass2400();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1200")) 
				{
					return new NiigataDirt1200();
				}
				else if(range.contains("1800")) {
					return new NiigataDirt1800();
					
				}
				else if(range.contains("2500")) {
					return new NiigataDirt2500();
					
				}
			}
		}
		else if(stage.contains("中京")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) {
					return new ChukyoGrass1200();
					
				}
				else if(range.contains("1400")) {
					return new ChukyoGrass1400();
					
				}
				else if(range.contains("1600")) {
					return new ChukyoGrass1600();
					
				}
				else if(range.contains("2000")) {
					return new ChukyoGrass2000();
					
				}
				else if(range.contains("2200")) {
					return new ChukyoGrass2200();
					
				}
				else if(range.contains("3000")) {
					return new ChukyoGrass3000();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1200")) 
				{
					return new ChukyoDirt1200();
				}
				else if(range.contains("1400")) {
					return new ChukyoDirt1400();
					
				}
				else if(range.contains("1800")) {
					return new ChukyoDirt1800();
					
				}
				else if(range.contains("1900")) {
					return new ChukyoDirt1900();
					
				}
			}
		}
		else if(stage.contains("京都")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) 
				{
					return new KyotoGrass1200();
				}
				else if(range.contains("1400")&& raceName.contains("未勝利") ) {
					return new KyotoGrass1400In();
					
				}
				else if(range.contains("1400")) {
					return new KyotoGrass1400Out();
					
				}
				else if(range.contains("1600")&& (raceName.contains("2歳") && (raceName.contains("未勝利") || raceName.contains("新馬")))) {
					return new KyotoGrass1600In();
					
				}
				else if(range.contains("1600")) {
					return new KyotoGrass1600Out();
					
				}
				else if(range.contains("1800")) {
					return new KyotoGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new KyotoGrass2000();
					
				}
				else if(range.contains("2200")) {
					return new KyotoGrass2200();
					
				}
				else if(range.contains("2400")) {
					return new KyotoGrass2400();
					
				}
				else if(range.contains("3000")) {
					return new KyotoGrass3000();
					
				}
				else if(range.contains("3200")) {
					return new KyotoGrass3200();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1200")) 
				{
					return new KyotoDirt1200();
				}
				else if(range.contains("1400")) {
					return new KyotoDirt1400();
					
				}
				else if(range.contains("1800")) {
					return new KyotoDirt1800();
					
				}
				else if(range.contains("1900")) {
					return new KyotoDirt1900();
					
				}
			}
		}
		else if(stage.contains("阪神")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) {
					return new HanshinGrass1200();
					
				}
				else if(range.contains("1400")) {
					return new HanshinGrass1400();
					
				}
				else if(range.contains("1600")) {
					return new HanshinGrass1600();
					
				}
				else if(range.contains("1800")) {
					return new HanshinGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new HanshinGrass2000();
					
				}
				else if(range.contains("2200")) {
					return new HanshinGrass2200();
					
				}
				else if(range.contains("2400")) {
					return new HanshinGrass2400();
					
				}
				else if(range.contains("2600")) {
					return new HanshinGrass2600();
					
				}
				else if(range.contains("3000")) {
					return new HanshinGrass3000();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1200")) 
				{
					return new HanshinDirt1200();
				}
				else if(range.contains("1400")) {
					return new HanshinDirt1400();
					
				}
				else if(range.contains("1800")) {
					return new HanshinDirt1800();
					
				}
				else if(range.contains("2000")) {
					return new HanshinDirt2000();
					
				}
			}
		}else if(stage.contains("小倉")) 
		{
			if(range.contains("芝")) 
			{
				if(range.contains("1200")) {
					return new KokuraGrass1200();
					
				}
				else if(range.contains("1700")) {
					return new KokuraGrass1700();
					
				}
				else if(range.contains("1800")) {
					return new KokuraGrass1800();
					
				}
				else if(range.contains("2000")) {
					return new KokuraGrass2000();
					
				}
				else if(range.contains("2600")) {
					return new KokuraGrass2600();
					
				}
			}
			else if(range.contains("ダ")) 
			{
				if(range.contains("1000")) 
				{
					return new KokuraDirt1000();
				}
				else if(range.contains("1700")) {
					return new KokuraDirt1700();
					
				}
				else if(range.contains("2400")) {
					return new KokuraDirt2400();
					
				}
			}
		}
		return new RaceCourse();
	}

}
