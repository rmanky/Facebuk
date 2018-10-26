public class Entity {

    private String entityName;
    private Image entityImage;

    public Entity(String name, Image image){
        this.entityName = name;
        this.entityImage = image;
    }

    public boolean equals(Object o)
    {
        return this.entityName == ((Entity) o).entityName;
    }
}
