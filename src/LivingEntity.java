import java.util.ArrayList;

public class LivingEntity extends Entity {

    private ArrayList _friendList = new ArrayList(), _momentList = new ArrayList();


    public LivingEntity(String name, Image image) { super(name, image); }

    public void setFriends(ArrayList friends) {
        _friendList = friends;
    }

    public void setMoments(ArrayList moments) {
        _momentList = moments;
    }

    public ArrayList getFriends() {
        return _friendList;
    }

    public void addFriend(LivingEntity friend) {
        _friendList.add(friend);
    }

    public LivingEntity getFriendWithWhomIAmHappiest() {
        LivingEntity friend = null;
        for (Object moment : _momentList) {
            ArrayList momentParticipants = ((Moment) moment).getParticipants();
            float myHappiness = ((Moment) moment).getHappiness(this);
            float maxHappiness = 0;
            for (Object livingEntity : momentParticipants) {
                float theirHappiness = ((Moment) moment).getHappiness((LivingEntity) livingEntity);
                if ((myHappiness + theirHappiness) / 2 > maxHappiness && _friendList.contains(livingEntity)) {
                    friend = (LivingEntity) livingEntity;
                }
            }
        }
        return friend;
    }

   public Moment getOverallHappiestMoment() {
        Moment happiestMoment = (Moment) _momentList.get(0);
        for(Object moment : _momentList) {
            Moment currentMoment = (Moment) moment;
            if(currentMoment.getAverageHappiness() > happiestMoment.getAverageHappiness()) {
                happiestMoment = currentMoment;
            }
        }
       return happiestMoment;
    }
}
