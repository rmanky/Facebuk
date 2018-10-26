public class Pet extends LivingEntity {

    private Person petOwner;

    public Pet(String name, Image image) {
        super(name, image);
    }

    public void setOwner(Person owner){
        this.petOwner = owner;
    }



}
