import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class LivingEntity extends Entity {

    private ArrayList _friendList = new ArrayList(), _momentList = new ArrayList();


    public LivingEntity(String name, Image image) {
        super(name, image);
    }

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
        if (!_friendList.contains(friend)) {
            _friendList.add(friend);
        }
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
        Moment happiestMoment = null;
        for (Object moment : _momentList) {
            Moment currentMoment = (Moment) moment;
            if (happiestMoment == null) {
                happiestMoment = currentMoment;
            }
            if (currentMoment.getAverageHappiness() > happiestMoment.getAverageHappiness()) {
                happiestMoment = currentMoment;
            }
        }
        return happiestMoment;
    }

    public ArrayList findMaximumCliqueOfFriends(){
        ArrayList cliques = new ArrayList();

        for (Object friendObj : _friendList) {
            ArrayList currentClique = new ArrayList();
            LivingEntity friend = (LivingEntity) friendObj;
            if(friend.getFriends().contains(this))
            {
                currentClique.add(friend);
                for (Object secondLevelFriendObj : friend.getFriends())
                {
                    LivingEntity secondLevelFriend = (LivingEntity) secondLevelFriendObj;
                    if(secondLevelFriend.getFriends().contains(this) && secondLevelFriend.getFriends().contains(friend))
                    {
                        currentClique.add(secondLevelFriend);
                    }
                }
            }
            cliques.add(currentClique);
        }
        // Find biggest clique in cliques
        ArrayList largestClique = new ArrayList();
        for (Object cliqueObj : cliques)
        {
            ArrayList clique = (ArrayList) cliqueObj;
            if(clique.size() > largestClique.size())
            {
                largestClique = clique;
            }
        }

        return largestClique;
    }

    public static boolean isClique(ArrayList set) {
        boolean allFriends = true;

        for (LivingEntity member : (ArrayList<LivingEntity>) set) {
            if (member.getFriends().size() == 0) {
                allFriends = false;
                break;
            } else {
                for (LivingEntity friend : (ArrayList<LivingEntity>) member.getFriends()) {
                    if (!member.getFriends().contains(friend)) {
                        allFriends = false;
                        break;
                    }
                }
            }
        }

        return allFriends;
    }
}
