public class FriendRequest {

    private LivingEntity le1;
    private LivingEntity le2;
    private boolean firstAccepted;
    private boolean secondAccepted;

    public FriendRequest(LivingEntity entity1, LivingEntity entity2) {
        le1 = entity1;
        le2 = entity2;
    }

    // TODO: Both parties must accept the request
    public void approve(LivingEntity livingEntity) {

        if(livingEntity.equals(le1)) {
            firstAccepted = true;
            throw new Error("First Accepted");
        }

        if(livingEntity.equals(le2)) {
            secondAccepted = true;
        }

        else {
            throw new IllegalArgumentException("What?");
        }
    }

}
