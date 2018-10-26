import java.util.ArrayList;

public class LivingEntity extends Entity {

    private ArrayList friendList;
    private ArrayList momentList;

    public LivingEntity(String name, Image image) {
        super(name, image);
    }

    public void setFriends(ArrayList friends) {
        friendList = friends;
    }

    public void setMoments(ArrayList moments) {
        momentList = moments;
    }

    public ArrayList getFriends() {
        return friendList;
    }

    public void addFriend(LivingEntity friend) {
        friendList.add(friend);
    }

    public LivingEntity getFriendWithWhomIAmHappiest() {

        LivingEntity friend = null;

        for (Object moment : momentList) {
            ArrayList momentParticipants = ((Moment) moment).getParticipants();

            float myHappiness = ((Moment) moment).getHappiness(this);
            float maxHappiness = 0;

            for (Object livingEntity : momentParticipants) {
                float theirHappiness = ((Moment) moment).getHappiness((LivingEntity) livingEntity);
                if ((myHappiness + theirHappiness) / 2 > maxHappiness && friendList.contains(livingEntity)) {
                    friend = (LivingEntity) livingEntity;
                }
            }
        }

        return friend;
    }

   public Moment getOverallHappiestMoment() {

        Moment happiestMoment = (Moment) momentList.get(0);

        for(Object moment : momentList) {
            Moment currentMoment = (Moment) moment;
            if(currentMoment.getAverageHappiness() > happiestMoment.getAverageHappiness()) {
                happiestMoment = currentMoment;
            }
        }

       return happiestMoment;
    }

}
