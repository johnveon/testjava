package com.fionchou.testdozer;

public class RedisHostheathReportConfig
{
	private Boolean open;
	
	private SickStander sickStander;
	
	private RootTest rootTest;

	public RootTest getRootTest()
	{
		return rootTest;
	}

	public void setRootTest(RootTest rootTest)
	{
		this.rootTest = rootTest;
	}

	public Boolean getOpen()
	{
		return open;
	}

	public void setOpen(Boolean open)
	{
		this.open = open;
	}

	public SickStander getSickStander()
	{
		return sickStander;
	}

	public void setSickStander(SickStander sickStander)
	{
		this.sickStander = sickStander;
	}
	
	
}
