package adsd.app.zorgapp;

class WeightMeasurePoint
{
    //fields and properties
    private String date;
    private String time;
    private double weight;

    //constructor
    public WeightMeasurePoint(String date, String time, double weight) 
    {
        setDate(date);
        setTime(time);
        setWeight(weight);
    }

    //methods
    //setters
    public void setDate(String date) 
    { 
    	this.date = date; 
    }
    public void setTime(String time) 
    { 
    	this.time =  time; 
    }
    public void setWeight(double weight) 
    { 
    	this.weight = weight; 
    }

    //getters
    public String getDate() 
    { 
    	return date; 
    }
    public String getTime() 
    { 
    	return time; 
    }
    public double getWeight() 
    { 
    	return weight; 
    }

}