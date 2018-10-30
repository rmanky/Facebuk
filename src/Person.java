import java.util.ArrayList;

public class Person extends LivingEntity {

    private ArrayList _pets, _possessions;

    Person(String name, Image image) {
        super(name, image);
    }

    void setPets(ArrayList pets) {
        _pets = pets;
    }

    void setPossessions(ArrayList possessions) {
        _possessions = possessions;
    }

    public ArrayList getPets() {
        return _pets;
    }

    public ArrayList getPossessions() {
        return _possessions;
    }
}
