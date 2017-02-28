package com.safety.bean;

public abstract class Inspection {
	public final static int TYPE_HTTP = 1;
	public final static int TYPE_PING = 2;
	public final static int TYPE_DNS = 3;

	public final static int STATE_NORMAL = 1;
	public final static int STATE_UNKNOW = 2;
	public final static int STATE_EXCEPTION = 3;

	private String target;
	private String name;
	private int taskType;
	private int frequency;
	private int state;
	private boolean enabled;

	public void start() {
		enabled = true;
	}

	public void close() {
		enabled = false;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
