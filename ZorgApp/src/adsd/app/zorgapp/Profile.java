package adsd.app.zorgapp;

class Profile
{
    //fields and properties
    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private double length;
    //constructor with 2 overloads
    public Profile() 
    { 
    	 setFirstName(null);
         setLastName(null);
         setAge(0);
         setWeight(0.00);
         setLength(0.00);
    }
    
    public Profile(String firstName, String lastName) 
    {
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    public Profile(String firstName, String lastName, int age, double weight, double length) 
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setWeight(weight);
        setLength(length);
    }

    //methods
    //setters
    public void setFirstName(String firstName) 
    { 
    	this.firstName = firstName; 
    }
    
    public void setLastName(String lastName) 
    { 
    	this.lastName = lastName; 
    }
    public void setAge(int age) 
    { 
    	this.age = age; 
    }
    public void setWeight(double weight) 
    { 
    	this.weight = weight; 
    }
    public void setLength(double length) 
    { 
    	this.length = length; 
    }

    //getters
    public String getFirstName() 
    { 
    	return firstName; 
    }
    public String getLastName() 
    { 
    	return lastName; 
    }
    public int getAge() 
    { 
    	return age; 
    }
    public double getWeight() 
    { 
    	return weight; 
    }
    public double getLength() 
    { 
    	return length; 
    }
	
	public String getBmi() 
	{
		double bmi = weight / (length * length);
		
		return String.format("%.2f", bmi);
	}
	

}
