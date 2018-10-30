class Entity {

    private String _name;
    private Image _image;

    Entity(String name, Image image){
        _name = name;
        _image = image;
    }

    String getName() {
        return _name;
    }

    void setName(String name) {
        _name = name;
    }

    Image getImage() {
        return _image;
    }

    void setImage(Image image) {
        _image = image;
    }

    @Override
    public boolean equals(Object o) {
        return ((Entity) o).getName().equals(_name);
    }
}
