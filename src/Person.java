import java.util.ArrayList;

public class Person extends LivingEntity {

    private ArrayList personPets;
    private ArrayList personPossessions;

    public Person(String name, Image image) {
        super(name, image);
    }

    public void setPets(ArrayList pets) {
        this.personPets = pets;
    }

    public void setPossessions (ArrayList possessions)
    {
        this.personPossessions = possessions;
    }
}
