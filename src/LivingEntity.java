import java.util.ArrayList;

public class LivingEntity extends Entity {

    private ArrayList friendList;
    private ArrayList momentList;

    public LivingEntity(String name, Image image) {
        super(name, image);
    }

    public void setFriends (ArrayList friends) {
        this.friendList = friends;
    }

    public void setMoments (ArrayList moments) {
        this.momentList = moments;
    }

    public ArrayList getFriends() {
        return this.friendList;
    }

    void addFriend (LivingEntity friend) {
        friendList.add(friend);
    }

}
