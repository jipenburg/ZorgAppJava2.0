package adsd.app.zorgapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


class ZorgApp
{
	//Zorgt voor userinput
	Scanner myScanner = new Scanner(System.in);
	private ArrayList<Profile> profileList;
    private ArrayList<Medicine> medicineList;
    private ArrayList<WeightMeasurePoint> weightMeasurePointList;
	private Map languageMap;
	private String language;
   
	
	  public ZorgApp() 
      {
          //initialize class object and lists
          profileList = new ArrayList<Profile>();
          medicineList = new ArrayList<Medicine>();
          weightMeasurePointList = new ArrayList<WeightMeasurePoint>();
          languageMap = new HashMap();
          AlarmClock alarmNotification = new AlarmClock();
          
          
          //call startup methods
          
          alarmNotification.checkAlarm(12,47);
          AddStartData();
          DisplayMenu();
      }
	//Add static data to ZorgApp
	  private void AddStartData()
      {
          //Add Profile Data
          profileList.add(new Profile("Joel","Ipenburg", 27, 80, 1.88));
          profileList.add(new Profile("Piet","Piraat", 35, 70, 1.70));
         
          //Add Medicine Data to list as an new object
          medicineList.add(new Medicine(
              "Oxazepam",
              "Het werkt rustgevend, spierontspannend, vermindert angstgevoelens en beïnvloedt de overdracht van elektrische prikkels in de hersenen.",
              "Oxazepam behoort tot de benzodiazepinen.",
              "50 mg per 24 uur."));
          medicineList.add(new Medicine(
              "Diclofenac",
              "Het is te gebruiken bij pijn waarbij ook sprake is van een ontsteking, zoals bij gewrichtspijn, reumatoïde artritis (ontsteking van de gewrichten), ziekte van Bechterew en jicht (onsteking in uw gewricht).",
              "Dit soort (Diclofenac) pijnstillers wordt ook wel NSAID's genoemd.",
              "1 tablet per 6 uur."));

          //Add WeightMeasurePoint Data to list as a new object
          weightMeasurePointList.add(new WeightMeasurePoint("20-04-2019", "19:40", 76));
          weightMeasurePointList.add(new WeightMeasurePoint("22-02-2019", "18:35", 77.5));
          
          //Translate words to the chosen language
          FillLanguageMap();
        
      }
	  
	  //Display menu with numbers to choose from
      private void DisplayMenu() 
      {
          //keep the menu running
          while (true)
          {
              //show options with assigned numbers
              System.out.println();
              System.out.println("\n" +TransLang("Welkom in het menu"));
              System.out.println("\n" +TransLang("Kies een optie")+
                  "\n1) " + TransLang("ProfielLijst tonen") +
                  "\n2) " + TransLang("Profiel bewerken") +
                  "\n3) " + TransLang("MedicijnLijst tonen") +
                  "\n4) " + TransLang("Medicijn bewerken") +
                  "\n5) " + TransLang("GewichtLijst tonen") +
                  "\n6) " + TransLang("Gewicht bewerken") +
                  "\n7) " + TransLang("Change language to English"));

              //call method depended on chosen number
              switch (myScanner.nextLine())
              {	 //1) ProfielLijst tonen.
                  case "1":
                	  
                      System.out.println(ShowProfileList(profileList));
                      myScanner.nextLine();
                      
                      
                      break;
                  case "2":
                	  
                	  System.out.println(ShowProfileList(profileList));
                      System.out.println("\nMaak een keuze om te bewerken: ");
                      int profileId = myScanner.nextInt();
                      myScanner.nextLine();
                      Profile profile = profileList.get(profileId -1);
                      System.out.println(ShowProfile(profile));
                      System.out.println("\nKies een nummer om te bewerken: (1, 2, 3, 4, 5)");
                       
                       switch (myScanner.nextLine()) 
                       {    
                       		case "1": 
                       			System.out.println("Voer uw voornaam in: ");
                       			EditProfile(profile,1);
                       			break;
                       		case "2":
                       			System.out.println("Voer uw achternaam in: ");
                       			EditProfile(profile,2);
                       			break;
                       		case "3":
                       			System.out.println("Voer uw leeftijd in: ");
                       			EditProfile(profile,3);
                       			break;
                       		case "4":    
                       			System.out.println("Voer uw gewicht in met een comma: ");
                       			EditProfile(profile,4);
                       			break;
                       		case "5":    
                       			System.out.println("Voer uw lengte in met een comma: ");
                       			EditProfile(profile,5);
                       			break;
                       		default:
                       			break;
                       }
                       System.out.println(ShowProfile(profile));
                       System.out.println("\nDruk op enter om terug naar het menu te gaan.");
                       myScanner.nextLine();
                       break;
                  case "3":
                       System.out.println(ShowMedicineList());
                       myScanner.nextLine();
                      break;
                  case "4":
                	   System.out.println(ShowMedicineList());
                       System.out.println("\nMaak een keuze om te bewerken: ");
                       int medicineId = myScanner.nextInt();
                       myScanner.nextLine();
                       Medicine medicine = medicineList.get(medicineId -1);
                       System.out.println(ShowMedicine(medicine));
                       System.out.println("\nKies een nummer om te bewerken: (1, 2, 3, 4)");
                       
                       switch (myScanner.nextLine()) 
                       {
					   		case "1":
					   			EditMedicine(medicine, 1);
					   			break;
					   		case "2":
					   			EditMedicine(medicine, 2);	
					   			break;
					   		case "3":
					   			EditMedicine(medicine, 3);					
					   			break;
					   		case "4":
					   			EditMedicine(medicine, 4);	
					   			break;
					   		default:
					   			break;	
					   }
                       System.out.println(ShowMedicine(medicine));
                       System.out.println("\nDruk op enter om terug naar het menu te gaan.");
                       
                       myScanner.nextLine();
                      break;
                      
                   case "5":
                	   	System.out.println(ShowWeightList());
                      	myScanner.nextLine();
                      	break;  
                   case "6":
                       	System.out.println(ShowWeightList());
                        System.out.println("\nMaak een keuze om te bewerken: ");
                        int weightId = myScanner.nextInt();
                        myScanner.nextLine();
                        WeightMeasurePoint weightMeasurePoint = weightMeasurePointList.get(weightId -1);
                        System.out.println(ShowWeight(weightMeasurePoint));
                        System.out.println("\nKies een nummer om te bewerken: (1, 2, 3)");
                        
                        switch (myScanner.nextLine()) 
                        {
 					   		case "1":
 					   			System.out.println("Voer de datum in: ");
 					   			EditWeight(weightMeasurePoint, 1);
 					   			break;
 					   		case "2":
 					   			System.out.println("Voer de tijd in: ");
 					   			EditWeight(weightMeasurePoint, 2);	
 					   			break;
 					   		case "3":
 					   			System.out.println("Voer uw gewicht in met een comma: ");
 					   			EditWeight(weightMeasurePoint, 3);					
 					   			break;
 					   		default:
 					   			break;	
 					   }
                        System.out.println(ShowWeight(weightMeasurePoint));
                        System.out.println("\nDruk op enter om terug naar het menu te gaan");
                        
                        myScanner.nextLine();
                        break;
                   case "7":
                	   	if (language == "EN") 
                	   	{
							language = "NL";
							System.out.println(TransLang("Taal is veranderd naar Nederlands") + "\n\n");
						}
                	   	else 
                	   	{
							language = "EN";
							System.out.println(TransLang("Taal is veranderd naar Engels") + "\n\n");
						}
                	   	
                	    System.out.println("\n" + TransLang("Druk op enter om terug naar het menu te gaan"));
                	    myScanner.nextLine();
                	   	break;
                	   	
                  default:
                      System.out.println("Nummer niet herkent! Probeer nogmaals..");
                      myScanner.nextLine();
                      break;
              }
          }
      }
		
	
	
	//Show methods
    private String ShowProfile(Profile profile) 
      {
          return
              "\n1)Voornaam: "+ profile.getFirstName() +
              "\n2)Achternaam: "+ profile.getLastName() +
              "\n3)Leeftijd: "+ profile.getAge() +
              "\n4)Gewicht: " + profile.getWeight() + " kg" +
              "\n5)Lengte: " + profile.getLength() + " m" +
              "\nBMI: " + profile.getBmi();
      }
    private String ShowProfileList(ArrayList<Profile> profileList) 
    {
    	String profileListReturn = "";
		int id = 1;
        for (Profile profile : profileList)
        {

            profileListReturn += 
            	"\n\nKeuze: "+ id + ")" +	
                "\nNaam: " + profile.getFirstName() +
                "\nAchternaam: " + profile.getLastName() +
                "\nLeeftijd: " + profile.getAge()  +
                "\nLengte: " + profile.getLength() +
                "\nBMI: " + profile.getBmi();
            id++;
        }
		
		return profileListReturn;
    			
    }
    
    private String ShowMedicine(Medicine medicine) 
    {
           return
            	"\n\n" +	
                "\n1)Medicijn: " + medicine.getMedicineName() +
                "\n2)Beschrijving: " + medicine.getDescription() +
                "\n3)Soort: " + medicine.getSort()  +
                "\n4)Dosering: " + medicine.getDosage();
    }
    
	private String ShowMedicineList() 
	{
		String medicineListReturn = "";
		int id = 1;
        for (Medicine medicine : medicineList)
        {

            medicineListReturn += 
            	"\n\nKeuze: "+ id + ")" +	
                "\nMedicijn: " + medicine.getMedicineName() +
                "\nBeschrijving: " + medicine.getDescription() +
                "\nSoort: " + medicine.getSort()  +
                "\nDosering: " + medicine.getDosage();
            id++;
        }
		
		return medicineListReturn;
	}
	
	private String ShowWeight(WeightMeasurePoint weightMeasurePointList) 
	{
		return
				"\n1)Datum: " + weightMeasurePointList.getDate() +
                "\n2)Tijd: " + weightMeasurePointList.getTime() +
                "\n3)Gewicht: " + weightMeasurePointList.getWeight();
	}
	
	private String ShowWeightList()	
	{
		String weightMeasurePointListReturn = "";
		int id = 1;
        for (WeightMeasurePoint weightMeasurePoint : weightMeasurePointList)
        {

        	weightMeasurePointListReturn += 
            	"\n\nKeuze: "+ id + ")" +	
                "\nDatum: " + weightMeasurePoint.getDate() +
                "\nTijd: " + weightMeasurePoint.getTime() +
                "\nGewicht: " + weightMeasurePoint.getWeight();
            id++;
        }
		return weightMeasurePointListReturn;
	}
	
	private char[] getWeightGraph() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	//Edit methods
	private void EditProfile(Profile profile,int userInput) 
	{
		switch (userInput) 
		{
		case 1: 
		    profile.setFirstName(myScanner.nextLine());
			break;
		case 2:
		    profile.setLastName(myScanner.nextLine());	
			break;
		case 3: 
			profile.setAge(myScanner.nextInt());
	        myScanner.nextLine();
			break;
		case 4:
		    profile.setWeight(myScanner.nextDouble());
		    myScanner.nextLine();
		    break;
		case 5:
		     profile.setLength(myScanner.nextDouble());
		     myScanner.nextLine();
			break;
			
		default:
		    break;
		}
		
		return;
	}

	private void EditMedicine(Medicine medicine,int userInput) 
	{    //userInput = Chosen number from the display menu.
		switch(userInput) 
		{
		case 1:
		medicine.setMedicineName(myScanner.nextLine());
			break;
		case 2:
			medicine.setDescription(myScanner.nextLine());
			break;
		case 3:
			medicine.setSort(myScanner.nextLine());
			break;
		case 4:
			medicine.setDosage(myScanner.nextLine());
			break;
		
		default:
		    break;
		    
		}
		
		return;
	}
	
	private void EditWeight(WeightMeasurePoint weightMeasurePoint,int userInput) 
	{    //userInput = Chosen number from the display menu.
		switch(userInput) 
		{
		case 1:
		weightMeasurePoint.setDate(myScanner.nextLine());
			break;
		case 2:
			weightMeasurePoint.setTime(myScanner.nextLine());
			break;
		case 3:
			weightMeasurePoint.setWeight(myScanner.nextDouble());
			 myScanner.nextLine();
			break;
		
			
		default:
		    break;
		    
		}
		
		return;
	}
	
	private void FillLanguageMap() 
	{	  
		  //Menu selection
		  languageMap.put("Welkom in het menu", "Welcome in the menu");
          languageMap.put("Kies een optie", "Pick an option");
          languageMap.put("Profiel bewerken", "Edit profile");
          languageMap.put("ProfielLijst tonen", "Show profilelist");
          languageMap.put("MedicijnLijst tonen", "Show medicinelist");
          languageMap.put("Medicijn bewerken", "Edit medicine");
          languageMap.put("GewichtLijst tonen", "Show WeightList");
          languageMap.put("Gewicht bewerken", "Edit WeightList");
          languageMap.put("Change language to English", "Verander taal naar Nederlands");
          //Other menu sentences
          languageMap.put("Taal is veranderd naar Nederlands", "Language changed to Dutch");
          languageMap.put("Taal is veranderd naar Engels", "Language changed to English");
          languageMap.put("Druk op enter om terug naar het menu te gaan", "Press enter to go back to the menu");
		
	}
	
	private String TransLang(String word) 
	{
		if (language == "EN") 
		{ 
			
			if ((String)languageMap.get(word) != null) 
			{
				return (String)languageMap.get(word);
			}
			
		}
		return word;
	}
	
}