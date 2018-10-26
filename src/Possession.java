public class Possession extends Entity {

    private float _price;
    private Person _owner;

    public Possession(String name, Image image, float price) {
        super(name, image);
        _price = price;
    }

    public void setOwner(Person owner) {
        _owner = owner;
    }

    public float getPrice() {
        return _price;
    }

    public Person getOwner() {
        return _owner;
    }

}
