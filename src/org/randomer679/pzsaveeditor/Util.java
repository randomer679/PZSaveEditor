/*******************************************************************************
 * Copyright © 2013 Ben Taylor.
 * 
 * This file is part of PZSaveEditor.
 * 
 * PZSaveEditor is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * PZSaveEditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with PZSaveEditor. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.randomer679.pzsaveeditor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Util {
	
	@SuppressWarnings("serial")
	public static class OldWorldException extends Exception {
		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return super.getMessage();
		}
	}

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
	static final String copyright = "Copyright © 2013 Ben Taylor (a.k.a. randomer679).\n\n" +
			"PZSaveEditor is free software: you can redistribute it and/or modify\n" +
			"it under the terms of the GNU General Public License as published by\n" +
			"the Free Software Foundation, either version 3 of the License, or\n" +
			"(at your option) any later version.\n\n" +
			"PZSaveEditor is distributed in the hope that it will be useful,\n" +
			"but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
			"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
			"GNU General Public License for more details.\n\n" +
			"You should have received a copy of the GNU General Public License\n" +
			"along with PZSaveEditor. If not, see <http://www.gnu.org/licenses/>.";
	
	public static void saveSandbox(File saveLoc, WorldValues vals) { // TODO: Doh!
		if(saveLoc.exists()) {
			if(!(saveLoc.delete())) {
				return;
			}
		}
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(saveLoc));
			output.writeInt(vals.getZombieDensity());
			output.writeInt(vals.getZombieDistribution());
			output.writeInt(vals.getSurvivors());
			output.writeInt(vals.getSpeed());
			output.writeInt(vals.getDayLength());
			output.writeInt(vals.getStartMonth());
			output.writeInt(vals.getStartTime());
			output.writeInt(vals.getWaterShutoff());
			output.writeInt(vals.getElectricShutoff());
			output.writeInt(vals.getLootAmount());
			if(vals.getWorldVersion() >= 5) {
				output.writeInt(vals.getTemperature());
				output.writeInt(vals.getRain());
			}
			output.writeInt(vals.getZombieSpeed());
			output.writeInt(vals.getZombieStrength());
			output.writeInt(vals.getZombieToughness());
			output.writeInt(vals.getZombieInfectionTransmission());
			output.writeInt(vals.getZombieInfectionMortality());
			output.writeInt(vals.getZombieReanimate());
			output.writeInt(vals.getZombieCognition());
			output.writeInt(vals.getZombieMemory());
			output.writeInt(vals.getZombieDecomp());
			output.writeInt(vals.getZombieSight());
			output.writeInt(vals.getZombieHearing());
			output.writeInt(vals.getZombieSmell());
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WorldValues loadSandbox(File world) throws OldWorldException {
		currentWorld = world;
		mapVerFile = new File(currentWorld+File.separator+"map_ver.bin");
		sandboxInfo = new File(currentWorld+File.separator+"map_sand.bin");
		WorldValues values = null;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(mapVerFile));
			int worldVersion = input.readInt();
			if(worldVersion < 7) {
				input.close();
				throw new OldWorldException();
			}
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
