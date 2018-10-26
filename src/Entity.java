public class Entity {

    private String entityName;
    private Image entityImage;

    public Entity(String name, Image image){
        entityName = name;
        entityImage = image;
    }

    // TODO: Is this needed?
    public boolean equals(Object o) {
        return ((Entity) o).entityName.equals(this.entityName);
    }
}
