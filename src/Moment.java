import sun.security.ssl.Debug;

import java.util.ArrayList;

public class Moment extends Entity {

    private ArrayList momentParticipants;
    private ArrayList smileValues;

    public Moment(String name, Image image, ArrayList participants, ArrayList smiles)
    {
        super(name, image);
        momentParticipants = participants;
        smileValues = smiles;
    }

    public ArrayList getParticipants() {
        return momentParticipants;
    }

    public ArrayList getSmileValues() {
        return smileValues;
    }

    public float getHappiness(LivingEntity livingEntity) {
        for (int i = 0; i < momentParticipants.size(); i++) {
            if (livingEntity.equals(momentParticipants.get(i))) {
                return (float) smileValues.get(i);
            }
        }
        return -1;
    }

    public float getAverageHappiness() {
        float total = 0;

        for (Object happinessValue : smileValues) {
            total += (float) happinessValue;
        }

        return total / smileValues.size();
    }
}
