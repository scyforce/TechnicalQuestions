package com.interview.puzzle.u2;

import java.util.Arrays;

public class U2State {
	public enum FLASH_LIGHT_STATE {
	    LEFT, RIGHT 
	}

	public String[] leftbank;
    public String[] rightbank;
    public Integer timeElapsed;
    public FLASH_LIGHT_STATE flashlight; 
    public U2State parent;
    public int depth;
    public int fvalue;
    
    public String[] getLeftbank() {
		return leftbank;
	}
	public U2State setLeftbank(String[] leftbank) {
		this.leftbank = leftbank;
		return this;
	}
	public String[] getRightbank() {
		return rightbank;
	}
	public U2State setRightbank(String[] rightbank) {
		this.rightbank = rightbank;
		return this;
	}
	public Integer getTimeElapsed() {
		return timeElapsed;
	}
	public U2State setTimeElapsed(Integer timeElapsed) {
		this.timeElapsed = timeElapsed;
		return this;
	}
	public FLASH_LIGHT_STATE getFlashlight() {
		return flashlight;
	}
	public U2State setFlashlight(FLASH_LIGHT_STATE flashlight) {
		this.flashlight = flashlight;
		return this;
	}
	public U2State getParent() {
		return parent;
	}
	public U2State setParent(U2State parent) {
		this.parent = parent;
		return this;
	}
	public int getDepth() {
		return depth;
	}
	public U2State setDepth(int depth) {
		this.depth = depth;
		return this;
	}
	public int getFvalue() {
		return fvalue;
	}
	public U2State setFvalue(int fvalue) {
		this.fvalue = fvalue;
		return this;
	}   
	
	@Override
    public String toString() {
		String flashlightLocation = "LEFT";
		if (flashlight==FLASH_LIGHT_STATE.RIGHT) {
			flashlightLocation = "RIGHT";
		}
    	return String.format("(%s,%s,%s,%d)", Arrays.toString(leftbank), Arrays.toString(rightbank), flashlightLocation, timeElapsed);
    }
    
}
