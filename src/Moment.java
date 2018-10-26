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

}
