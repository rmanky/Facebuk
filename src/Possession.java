public class Possession extends Entity {

    private float possessionPrice;
    private Person possessionOwner;

    public Possession(String name, Image image, float price) {
        super(name, image);
        possessionPrice = price;
    }

    public void setOwner(Person owner)
    {
        possessionOwner = owner;
    }

    public float getPrice()
    {
        return possessionPrice;
    }

}
