import java.util.ArrayList;

class Person extends LivingEntity {

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

    ArrayList getPets() {
        return _pets;
    }

    ArrayList getPossessions() {
        return _possessions;
    }
}
