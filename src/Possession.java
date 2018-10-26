public class Possession extends Entity {

    private float possessionPrice;
    private Person possessionOwner;

    public Possession(String name, Image image, float price) {
        super(name, image);
        this.possessionPrice = price;
    }

    public void setOwner(Person owner)
    {
        this.possessionOwner = owner;
    }

    public float getPrice()
    {
        return this.possessionPrice;
    }

}
