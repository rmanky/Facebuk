class Possession extends Entity {

    private float _price;
    private Person _owner;

    Possession(String name, Image image, float price) {
        super(name, image);
        _price = price;
    }

    float getPrice() {
        return _price;
    }

    void setPrice(float price) {
        _price = price;
    }

    Person getOwner() {
        return _owner;
    }

    void setOwner(Person owner) {
        _owner = owner;
    }
}
