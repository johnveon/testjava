package com.fionchou.testdozer;

public class SickStander
{

	private String sickCode;
	
	private String redisSickRate;
	
	private String hostSickRate;
	
	private Integer interval;

	public String getSickCode()
	{
		return sickCode;
	}

	public void setSickCode(String sickCode)
	{
		this.sickCode = sickCode;
	}

	public String getRedisSickRate()
	{
		return redisSickRate;
	}

	public void setRedisSickRate(String redisSickRate)
	{
		this.redisSickRate = redisSickRate;
	}

	public String getHostSickRate()
	{
		return hostSickRate;
	}

	public void setHostSickRate(String hostSickRate)
	{
		this.hostSickRate = hostSickRate;
	}

	public Integer getInterval()
	{
		return interval;
	}

	public void setInterval(Integer interval)
	{
		this.interval = interval;
	}
	
}
