import sun.security.ssl.Debug;

import java.util.ArrayList;

public class Moment extends Entity {

    private ArrayList momentParticipants;
    private ArrayList smileValues;

    public Moment(String name, Image image, ArrayList participants, ArrayList smileValues)
    {
        super(name, image);
        this.momentParticipants = participants;
        this.smileValues = smileValues;
    }

    public ArrayList getParticipants() {
        return this.momentParticipants;
    }

    public ArrayList getSmileValues() {
        return this.smileValues;
    }

    public float getHappiness(LivingEntity livingEntity) {
        for (int i = 0; i < momentParticipants.size(); i++) {
            if (livingEntity.equals(momentParticipants.get(i))) {
                return (float) smileValues.get(i);
            }
        }
        return -1;
    }
}
