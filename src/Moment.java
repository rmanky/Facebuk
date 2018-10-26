import java.util.ArrayList;

public class Moment extends Entity {

    private ArrayList _participants, _smileValues;

    public Moment(String name, Image image, ArrayList participants, ArrayList smiles) {
        super(name, image);
        _participants = participants;
        _smileValues = smiles;
    }

    public ArrayList getParticipants() {
        return _participants;
    }

    public ArrayList getSmileValues() {
        return _smileValues;
    }

    public float getHappiness(LivingEntity livingEntity) {
        for (int i = 0; i < _participants.size(); i++) {
            if (livingEntity.equals(_participants.get(i))) {
                return (float) _smileValues.get(i);
            }
        }
        return -1;
    }

    public float getAverageHappiness() {
        float total = 0;
        for (Object happinessValue : _smileValues) {
            total += (float) happinessValue;
        }
        return total / _smileValues.size();
    }
}
