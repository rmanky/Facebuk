import java.util.ArrayList;

public class Person extends LivingEntity {

    private ArrayList _pets, _possessions;

    public Person(String name, Image image) {
        super(name, image);
    }

    public void setPets(ArrayList pets) {
        _pets = pets;
    }

    public void setPossessions (ArrayList possessions) {
        _possessions = possessions;
    }

    public ArrayList getPets() {
        return _pets;
    }

    public ArrayList getPossessions() {
        return _possessions;
    }
}
