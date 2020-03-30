package adsd.app.zorgapp;

import java.util.ArrayList;

class Medicine
{
    //fields and properties
    private String medicineName;
    private String description;
    private String sort;
    private String dosage;

    //constructor with 1 overload
    public Medicine() 
    { 
    	  setMedicineName(null);
          setDescription(null);
          setSort(null);
          setDosage(null);
    }

    public Medicine(String medicineName, String description, String sort, String dosage) 
    {
        setMedicineName(medicineName);
        setDescription(description);
        setSort(sort);
        setDosage(dosage);
    }

    //methods
    //setters
    public void setMedicineName(String medicineName) 
    { 
    	this.medicineName = medicineName; 
    }
    public void setDescription(String description) 
    { 
    	this.description = description; 
    }
    public void setSort(String sort) 
    { 
    	this.sort = sort; 
    }
    public void setDosage(String dosage) 
    { 
    	this.dosage = dosage; 
    }

    //getters
    public String getMedicineName() 
    { 
    	return medicineName; 
    }
    public String getDescription() 
    { 
    	return description; 
    }
    public String getSort() 
    { 
    	return sort; 
    }
    public String getDosage() 
    { 
    	return dosage; 
    }
}