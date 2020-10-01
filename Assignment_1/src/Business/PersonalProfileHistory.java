/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
/**
 *
 * @author dell
 */
public class PersonalProfileHistory {
    private ArrayList<PersonalProfile> PersonalProfileHistory; //初始化ArrayList
    
    public PersonalProfileHistory()
    {
    PersonalProfileHistory = new ArrayList<PersonalProfile>();
    }

    public ArrayList<PersonalProfile> getPersonalProfileHistory() {
        return PersonalProfileHistory;
    }

    public void setPersonalProfileHistory(ArrayList<PersonalProfile> PersonalProfileHistory) {
        this.PersonalProfileHistory = PersonalProfileHistory;
    }
    
    public PersonalProfile addPerson()
    {
        PersonalProfile pp = new PersonalProfile();
        PersonalProfileHistory.add(pp);
        return pp;
    }
    public void delete(PersonalProfile p)
    {
        PersonalProfileHistory.remove(p);
    }
    
}
