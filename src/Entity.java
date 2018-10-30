public class Entity {

    private String _name;
    private Image _image;

    Entity(String name, Image image){
        _name = name;
        _image = image;
    }

    private String getName() {
        return _name;
    }

    public Image getImage() {
        return _image;
    }

    @Override
    public boolean equals(Object o) {
        return ((Entity) o).getName().equals(_name);
    }
}
