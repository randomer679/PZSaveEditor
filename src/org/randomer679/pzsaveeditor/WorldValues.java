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

public class WorldValues {

	private int zombieDensity;
	private int zombieDistribution;
	private int survivors;
	private int speed;
	private int dayLength;
	private int startMonth;
	private int startTime;
	private int waterShutoff;
	private int electricShutoff;
	private int lootAmount;
	private int temperature;
	private int rain;
	private int zombieSpeed;
	private int zombieStrength;
	private int zombieToughness;
	private int zombieInfectionTransmission;
	private int zombieInfectionMortality;
	private int zombieReanimate;
	private int zombieCognition;
	private int zombieMemory;
	private int zombieDecomp;
	private int zombieSight;
	private int zombieHearing;
	private int zombieSmell;
	private final int worldVersion;
	private final int zombieDensityOrig;
	private final int zombieDistributionOrig;
	private final int survivorsOrig;
	private final int speedOrig;
	private final int dayLengthOrig;
	private final int startMonthOrig;
	private final int startTimeOrig;
	private final int waterShutoffOrig;
	private final int electricShutoffOrig;
	private final int lootAmountOrig;
	private final int temperatureOrig;
	private final int rainOrig;
	private final int zombieSpeedOrig;
	private final int zombieStrengthOrig;
	private final int zombieToughnessOrig;
	private final int zombieInfectionTransmissionOrig;
	private final int zombieInfectionMortalityOrig;
	private final int zombieReanimateOrig;
	private final int zombieCognitionOrig;
	private final int zombieMemoryOrig;
	private final int zombieDecompOrig;
	private final int zombieSightOrig;
	private final int zombieHearingOrig;
	private final int zombieSmellOrig;
	
	public WorldValues(int worldVersion, int zombieDensity, int zombieDistribution, int survivors, int speed, int dayLength, int startMonth, int startTime, int waterShutoff, int electricShutoff, int lootAmount, int temperature, int rain, int zombieSpeed, int zombieStrength, int zombieToughness, int zombieInfectionTransmission, int zombieInfectionMortality, int zombieReanimate, int zombieCognition, int zombieMemory, int zombieDecomp, int zombieSight, int zombieHearing, int zombieSmell) {
		this.worldVersion = worldVersion;
		this.zombieDensityOrig = zombieDensity;
		this.zombieDistributionOrig = zombieDistribution;
		this.survivorsOrig = survivors;
		this.speedOrig = speed;
		this.dayLengthOrig = dayLength;
		this.startMonthOrig = startMonth;
		this.startTimeOrig = startTime;
		this.waterShutoffOrig = waterShutoff;
		this.electricShutoffOrig = electricShutoff;
		this.lootAmountOrig = lootAmount;
		this.temperatureOrig = temperature;
		this.rainOrig = rain;
		this.zombieSpeedOrig = zombieSpeed;
		this.zombieStrengthOrig = zombieStrength;
		this.zombieToughnessOrig = zombieToughness;
		this.zombieInfectionTransmissionOrig = zombieInfectionTransmission;
		this.zombieInfectionMortalityOrig = zombieInfectionMortality;
		this.zombieReanimateOrig = zombieReanimate;
		this.zombieCognitionOrig = zombieCognition;
		this.zombieMemoryOrig = zombieMemory;
		this.zombieDecompOrig = zombieDecomp;
		this.zombieSightOrig = zombieSight;
		this.zombieHearingOrig = zombieHearing;
		this.zombieSmellOrig = zombieSmell;
		this.reset();
	}
	
	public void reset() {
		this.setZombieDensity(zombieDensityOrig);
		this.setZombieDistribution(zombieDistributionOrig);
		this.setSurvivors(survivorsOrig);
		this.setSpeed(speedOrig);
		this.setDayLength(dayLengthOrig);
		this.setStartMonth(startMonthOrig);
		this.setStartTime(startTimeOrig);
		this.setWaterShutoff(waterShutoffOrig);
		this.setElectricShutoff(electricShutoffOrig);
		this.setLootAmount(lootAmountOrig);
		this.setTemperature(temperatureOrig);
		this.setRain(rainOrig);
		this.setZombieSpeed(zombieSpeedOrig);
		this.setZombieStrength(zombieStrengthOrig);
		this.setZombieToughness(zombieToughnessOrig);
		this.setZombieInfectionTransmission(zombieInfectionTransmissionOrig);
		this.setZombieInfectionMortality(zombieInfectionMortalityOrig);
		this.setZombieReanimate(zombieReanimateOrig);
		this.setZombieCognition(zombieCognitionOrig);
		this.setZombieMemory(zombieMemoryOrig);
		this.setZombieDecomp(zombieDecompOrig);
		this.setZombieSight(zombieSightOrig);
		this.setZombieHearing(zombieHearingOrig);
		this.setZombieSmell(zombieSmellOrig);
	}

	public boolean hasChanged() {
		boolean changed = false;
		if(this.zombieDensity != this.zombieDensityOrig) {
			changed = true;
		} else if(this.zombieDistribution != this.zombieDistributionOrig) {
			changed = true;
		} else if(this.survivors != this.survivorsOrig) {
			changed = true;
		} else if(this.speed != this.speedOrig) {
			changed = true;
		} else if(this.dayLength != this.dayLengthOrig) {
			changed = true;
		} else if(this.startMonth != this.startMonthOrig) {
			changed = true;
		} else if(this.startTime != this.startTimeOrig) {
			changed = true;
		} else if(this.waterShutoff != this.waterShutoffOrig) {
			changed = true;
		} else if(this.electricShutoff != this.electricShutoffOrig) {
			changed = true;
		} else if(this.lootAmount != this.lootAmountOrig) {
			changed = true;
		} else if(this.temperature != this.temperatureOrig) {
			changed = true;
		} else if(this.rain != this.rainOrig) {
			changed = true;
		} else if(this.zombieSpeed != this.zombieSpeedOrig) {
			changed = true;
		} else if(this.zombieStrength != this.zombieStrengthOrig) {
			changed = true;
		} else if(this.zombieToughness != this.zombieToughnessOrig) {
			changed = true;
		} else if(this.zombieInfectionTransmission != this.zombieInfectionTransmissionOrig) {
			changed = true;
		} else if(this.zombieInfectionMortality != this.zombieInfectionMortalityOrig) {
			changed = true;
		} else if(this.zombieReanimate != this.zombieReanimateOrig) {
			changed = true;
		} else if(this.zombieCognition != this.zombieCognitionOrig) {
			changed = true;
		} else if(this.zombieMemory != this.zombieMemoryOrig) {
			changed = true;
		} else if(this.zombieDecomp != this.zombieDecompOrig) {
			changed = true;
		} else if(this.zombieSight != this.zombieSightOrig) {
			changed = true;
		} else if(this.zombieHearing != this.zombieHearingOrig) {
			changed = true;
		} else if(this.zombieSmell != this.zombieSmellOrig) {
			changed = true;
		}
		return changed;
	}

	public int getZombieDensity() {
		return zombieDensity;
	}

	public void setZombieDensity(int zombieDensity) {
		this.zombieDensity = zombieDensity;
	}

	public int getZombieDistribution() {
		return zombieDistribution;
	}

	public void setZombieDistribution(int zombieDistribution) {
		this.zombieDistribution = zombieDistribution;
	}

	public int getSurvivors() {
		return survivors;
	}

	public void setSurvivors(int survivors) {
		this.survivors = survivors;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getDayLength() {
		return dayLength;
	}

	public void setDayLength(int dayLength) {
		this.dayLength = dayLength;
	}

	public int getWaterShutoff() {
		return waterShutoff;
	}

	public void setWaterShutoff(int waterShutoff) {
		this.waterShutoff = waterShutoff;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getLootAmount() {
		return lootAmount;
	}

	public void setLootAmount(int lootAmount) {
		this.lootAmount = lootAmount;
	}

	public int getElectricShutoff() {
		return electricShutoff;
	}

	public void setElectricShutoff(int electricShutoff) {
		this.electricShutoff = electricShutoff;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getRain() {
		return rain;
	}

	public void setRain(int rain) {
		this.rain = rain;
	}

	public int getZombieSpeed() {
		return zombieSpeed;
	}

	public void setZombieSpeed(int zombieSpeed) {
		this.zombieSpeed = zombieSpeed;
	}

	public int getZombieStrength() {
		return zombieStrength;
	}

	public void setZombieStrength(int zombieStrength) {
		this.zombieStrength = zombieStrength;
	}

	public int getZombieToughness() {
		return zombieToughness;
	}

	public void setZombieToughness(int zombieToughness) {
		this.zombieToughness = zombieToughness;
	}

	public int getZombieInfectionTransmission() {
		return zombieInfectionTransmission;
	}

	public void setZombieInfectionTransmission(int zombieInfectionTransmission) {
		this.zombieInfectionTransmission = zombieInfectionTransmission;
	}

	public int getZombieInfectionMortality() {
		return zombieInfectionMortality;
	}

	public void setZombieInfectionMortality(int zombieInfectionMortality) {
		this.zombieInfectionMortality = zombieInfectionMortality;
	}

	public int getZombieReanimate() {
		return zombieReanimate;
	}

	public void setZombieReanimate(int zombieReanimate) {
		this.zombieReanimate = zombieReanimate;
	}

	public int getZombieCognition() {
		return zombieCognition;
	}

	public void setZombieCognition(int zombieCognition) {
		this.zombieCognition = zombieCognition;
	}

	public int getZombieMemory() {
		return zombieMemory;
	}

	public void setZombieMemory(int zombieMemory) {
		this.zombieMemory = zombieMemory;
	}

	public int getZombieDecomp() {
		return zombieDecomp;
	}

	public void setZombieDecomp(int zombieDecomp) {
		this.zombieDecomp = zombieDecomp;
	}

	public int getZombieSight() {
		return zombieSight;
	}

	public void setZombieSight(int zombieSight) {
		this.zombieSight = zombieSight;
	}

	public int getZombieHearing() {
		return zombieHearing;
	}

	public void setZombieHearing(int zombieHearing) {
		this.zombieHearing = zombieHearing;
	}

	public int getZombieSmell() {
		return zombieSmell;
	}

	public void setZombieSmell(int zombieSmell) {
		this.zombieSmell = zombieSmell;
	}

	public int getOrigZombieDensity() {
		return zombieDensityOrig;
	}

	public int getOrigZombieDistribution() {
		return zombieDistributionOrig;
	}

	public int getOrigSurvivors() {
		return survivorsOrig;
	}

	public int getOrigSpeed() {
		return speedOrig;
	}

	public int getOrigStartMonth() {
		return startMonthOrig;
	}

	public int getOrigDayLength() {
		return dayLengthOrig;
	}

	public int getOrigWaterShutoff() {
		return waterShutoffOrig;
	}

	public int getOrigStartTime() {
		return startTimeOrig;
	}

	public int getOrigLootAmount() {
		return lootAmountOrig;
	}

	public int getOrigElectricShutoff() {
		return electricShutoffOrig;
	}
	
	public int getOrigTemperature() {
		return temperatureOrig;
	}

	public int getOrigRain() {
		return rainOrig;
	}

	public int getOrigZombieSpeed() {
		return zombieSpeedOrig;
	}

	public int getOrigZombieStrength() {
		return zombieStrengthOrig;
	}

	public int getOrigZombieToughness() {
		return zombieToughnessOrig;
	}

	public int getOrigZombieInfectionTransmission() {
		return zombieInfectionTransmissionOrig;
	}

	public int getOrigZombieInfectionMortality() {
		return zombieInfectionMortalityOrig;
	}

	public int getOrigZombieReanimate() {
		return zombieReanimateOrig;
	}

	public int getOrigZombieCognition() {
		return zombieCognitionOrig;
	}

	public int getOrigZombieMemory() {
		return zombieMemoryOrig;
	}

	public int getOrigZombieDecomp() {
		return zombieDecompOrig;
	}

	public int getOrigZombieSight() {
		return zombieSightOrig;
	}

	public int getOrigZombieHearing() {
		return zombieHearingOrig;
	}

	public int getOrigZombieSmell() {
		return zombieSmellOrig;
	}

	public int getWorldVersion() {
		return worldVersion;
	}
}
