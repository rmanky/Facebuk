public class FriendRequest {

    private LivingEntity le1;
    private LivingEntity le2;

    public FriendRequest(LivingEntity entity1, LivingEntity entity2) {
        this.le1 = entity1;
        this.le2 = entity2;
    }

    public void approve(LivingEntity livingEntity) {
        if(livingEntity.equals(le1) || livingEntity.equals(le2)) {
            le1.addFriend(le2);
            le2.addFriend(le1);
        }
        else {
            throw new IllegalArgumentException("Friend not found.");
        }
    }

}
