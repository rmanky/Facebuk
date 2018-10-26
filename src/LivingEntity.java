import java.util.ArrayList;

public class LivingEntity extends Entity {

    private ArrayList friendList;
    private ArrayList momentList;

    public LivingEntity(String name, Image image) {
        super(name, image);
    }

    public void setFriends(ArrayList friends) {
        this.friendList = friends;
    }

    public void setMoments(ArrayList moments) {
        this.momentList = moments;
    }

    public ArrayList getFriends() {
        return this.friendList;
    }

    public void addFriend(LivingEntity friend) {
        friendList.add(friend);
    }

    public LivingEntity getFriendWithWhomIAmHappiest() {

        LivingEntity friend = null;

        for (Object moment : this.momentList) {
            ArrayList momentParticipants = ((Moment) moment).getParticipants();

            float myHappiness = ((Moment) moment).getHappiness(this);
            float maxHappiness = -1;

            for (Object livingEntity : momentParticipants) {
                float theirHappiness = ((Moment) moment).getHappiness((LivingEntity) livingEntity);
                if ((myHappiness + theirHappiness) / 2 > maxHappiness && friendList.contains(livingEntity)) {
                    friend = (LivingEntity) livingEntity;
                }
            }
        }

        return friend;
    }

   // public Moment getOverallHappiestMoment() {
    //    return;
    //}

}
