import java.util.ArrayList;

class Moment extends Entity {

    private ArrayList _participants, _smileValues;

    Moment(String name, Image image, ArrayList participants, ArrayList smiles) {
        super(name, image);
        _participants = participants;
        _smileValues = smiles;
    }

    ArrayList getParticipants() {
        return _participants;
    }

    ArrayList getSmileValues() {
        return _smileValues;
    }

    float getHappiness(LivingEntity livingEntity) {
        for (int i = 0; i < _participants.size(); i++) {
            if (livingEntity.equals(_participants.get(i))) {
                return (float) _smileValues.get(i);
            }
        }
        return 0;
    }

    float getAverageHappiness() {
        float total = 0;
        for (Object happinessValue : _smileValues) {
            total += (float) happinessValue;
        }
        return total / _smileValues.size();
    }
}
