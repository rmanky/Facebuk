public class Entity {

    private String _name;
    private Image _image;

    public Entity(String name, Image image){
        _name = name;
        _image = image;
    }

    public String getName() {
        return _name;
    }

    public Image getImage() {
        return _image;
    }

    // TODO: Is this needed?
    @Override
    public boolean equals(Object o) {
        return ((Entity) o).getName().equals(_name);
    }
}
