public class FriendRequest {

    private LivingEntity _le1, _le2;
    private boolean _firstAccepted , _secondAccepted;

    public FriendRequest(LivingEntity entity1, LivingEntity entity2) {
        _le1 = entity1;
        _le2 = entity2;
    }

    public void approve(LivingEntity livingEntity) {
        if(livingEntity.equals(_le1)) {
            _firstAccepted = true;
        }
        if(livingEntity.equals(_le2)) {
            _secondAccepted = true;
        }
        if(_secondAccepted && _firstAccepted)
        {
            _le1.addFriend(_le2);
            _le2.addFriend(_le1);
        }
        else if(!livingEntity.equals(_le1) && !livingEntity.equals(_le2)){
            throw new IllegalArgumentException("Friend not found.");
        }
    }
}
