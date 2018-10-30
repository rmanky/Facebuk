class Pet extends LivingEntity {

    private Person petOwner;

    Pet(String name, Image image) {
        super(name, image);
    }

    void setOwner(Person owner){
        petOwner = owner;
    }
}
