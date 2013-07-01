package org.randomer679.pzsaveeditor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Util {
	
	private static File currentWorld;
	private static File mapVerFile;
	private static File sandboxInfo;

	static final int ProperZombieSpeed = 2;
	static final int ProperZombieStrength = 2;
	static final int ProperZombieToughness = 2;
	static final int ProperZombieInfectionTransmission = 1;
	static final int ProperZombieInfectionMortality = 5;
	static final int ProperZombieReanimate = 3;
	static final int ProperZombieCognition = 2;
	static final int ProperZombieMemory = 2;
	static final int ProperZombieDecomp = 1;
	static final int ProperZombieSight = 2;
	static final int ProperZombieHearing = 2;
	static final int ProperZombieSmell = 2;
	
	public static WorldValues loadSandbox(File world) {
		currentWorld = world;
		mapVerFile = new File(currentWorld+File.separator+"map_ver.bin");
		sandboxInfo = new File(currentWorld+File.separator+"map_sand.bin");
		WorldValues values = null;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(mapVerFile));
			int worldVersion = input.readInt();
			input.close();
			input = new DataInputStream(new FileInputStream(sandboxInfo));
			int zombieDensity = input.readInt();
			int zombieDistribution = input.readInt();
			int survivors = input.readInt();
			int speed = input.readInt();
			int dayLength = input.readInt();
			int startMonth = input.readInt();
			int startTime = input.readInt();
			int waterShutoff = input.readInt();
			int electricShutoff = input.readInt();
			int lootAmount = input.readInt();
			int temperature = -1;
			int rain = -1;
			if (worldVersion >= 5) {
				temperature = input.readInt();
				rain = input.readInt();
			}
			int zombieSpeed = input.readInt();
			int zombieStrength = input.readInt();
			int zombieToughness = input.readInt();
			int zombieInfectionTransmission = input.readInt();
			int zombieInfectionMortality = input.readInt();
			int zombieReanimate = input.readInt();
			int zombieCognition = input.readInt();
			int zombieMemory = input.readInt();
			int zombieDecomp = input.readInt();
			int zombieSight = input.readInt();
			int zombieHearing = input.readInt();
			int zombieSmell = input.readInt();
			values = new WorldValues(worldVersion, zombieDensity, zombieDistribution, survivors, speed, dayLength, startMonth, startTime, waterShutoff, electricShutoff, lootAmount, temperature, rain, zombieSpeed, zombieStrength, zombieToughness, zombieInfectionTransmission, zombieInfectionMortality, zombieReanimate, zombieCognition, zombieMemory, zombieDecomp, zombieSight, zombieHearing, zombieSmell);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return values;
	}
}