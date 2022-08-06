package com.ecnav.cotacaomoeda.model;

public class Currency
{
    private final String code;
    private final String name;
    private double bid;
    private double high;
    private double low;
    private double varBid;
    private double pctChange;
    private double ask;
    private String timestamp;

    public Currency(String code, String name, double high, double low, double bid, double varBid, double pctChange, double ask, String timestamp)
    {
        this.code = code;
        this.name = name;
        this.bid = bid;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public double getBid()
    {
        return bid;
    }

    public void setBid(float bid)
    {
        this.bid = bid;
    }

    public double getHigh()
    {
        return high;
    }

    public void setHigh(float high)
    {
        this.high = high;
    }

    public double getLow()
    {
        return low;
    }

    public void setLow(float low)
    {
        this.low = low;
    }

    public void setBid(double bid)
    {
        this.bid = bid;
    }

    public void setHigh(double high)
    {
        this.high = high;
    }

    public void setLow(double low)
    {
        this.low = low;
    }

    public double getVarBid()
    {
        return varBid;
    }

    public void setVarBid(double varBid)
    {
        this.varBid = varBid;
    }

    public double getPctChange()
    {
        return pctChange;
    }

    public void setPctChange(double pctChange)
    {
        this.pctChange = pctChange;
    }

    public double getAsk()
    {
        return ask;
    }

    public void setAsk(double ask)
    {
        this.ask = ask;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
}
