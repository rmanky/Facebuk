import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * This is a SUBSET of the unit tests with which we will grade your code.
 *
 * Make absolute sure that your code can compile together with this tester!
 * If it does not, you may get a very low grade for your assignment.
 */
public class FacebukPartialTester {
	private Person _barack, _michelle, _kevin, _ina, _joe, _malia;
	private Pet _bo, _sunny;
	private Moment _meAndBarack, _boAndSunnyMoment;
	private ArrayList _michelleAndBarack, _michelleJoeBoAndMalia;

	@Before
	public void setUp () {
		initPeople();
		initPets();
		initGroups();
		initPossessions();
		initMoments();
	}

	private void initPeople () {
		_michelle = new Person("Michelle", new Image("Michelle.png"));
		_barack = new Person("Barack", new Image("Barack.png"));
		_kevin = new Person("Kevin", new Image("Kevin.png"));
		_ina = new Person("Ina", new Image("Ina.png"));
		_joe = new Person("Joe", new Image("Joe.png"));
		_malia = new Person("Malia", new Image("Malia.png"));
	}

	private void initPets () {
		_bo = new Pet("Bo", new Image("Bo.png"));
		_sunny = new Pet("Sunny", new Image("Sunny.png"));

		_bo.setOwner(_michelle);
		_sunny.setOwner(_michelle);
	}

	private void initGroups () {
		// Kevin, Barack, and Ina
		final ArrayList michelleFriends = new ArrayList();
		michelleFriends.add(_kevin);
		michelleFriends.add(_barack);
		michelleFriends.add(_ina);

		// Michelle and Barack
		_michelleAndBarack = new ArrayList();
		_michelleAndBarack.add(_michelle);
		_michelleAndBarack.add(_barack);

		// Michelle, Joe, Bo, and Malia
		_michelleJoeBoAndMalia = new ArrayList();
		_michelleJoeBoAndMalia.add(_michelle);
		_michelleJoeBoAndMalia.add(_joe);
		_michelleJoeBoAndMalia.add(_bo);
		_michelleJoeBoAndMalia.add(_malia);

		// Malia and Sunny
		final ArrayList maliaAndSunny = new ArrayList();
		maliaAndSunny.add(_malia);
		maliaAndSunny.add(_sunny);

		// Michelle
		final ArrayList michelleList = new ArrayList();
		michelleList.add(_michelle);

		// Bo
		final ArrayList boList = new ArrayList();
		boList.add(_bo);

		// Set people's friend lists
		_michelle.setFriends(michelleFriends);
		_malia.setFriends(boList);
		_sunny.setFriends(boList);
		_barack.setFriends(michelleList);
		_kevin.setFriends(michelleList);
		_ina.setFriends(michelleList);

		// Finish configuring pets
		_bo.setFriends(maliaAndSunny);
		_sunny.setFriends(boList);
		final ArrayList boAndSunny = new ArrayList();
		boAndSunny.add(_bo);
		boAndSunny.add(_sunny);
		_michelle.setPets(boAndSunny);
	}

	private void initPossessions () {
		final Possession boxingBag = new Possession("BoxingBag", new Image("BoxingBag.png"), 20.0f);
		boxingBag.setOwner(_michelle);
		final ArrayList michellePossessions = new ArrayList();
		michellePossessions.add(boxingBag);
		_michelle.setPossessions(michellePossessions);
	}

	private void initMoments () {
		// Smiles
		final ArrayList michelleAndBarackSmiles = new ArrayList();
		michelleAndBarackSmiles.add(0.25f);
		michelleAndBarackSmiles.add(0.75f);

		final ArrayList michelleJoeBoAndMaliaSmiles = new ArrayList();
		michelleJoeBoAndMaliaSmiles.add(0.2f);
		michelleJoeBoAndMaliaSmiles.add(0.3f);
		michelleJoeBoAndMaliaSmiles.add(0.4f);
		michelleJoeBoAndMaliaSmiles.add(0.5f);

		// Moments
		_meAndBarack = new Moment("Me & Barack", new Image("MeAndBarack.png"), _michelleAndBarack, michelleAndBarackSmiles);
		// TODO: Add boAndSunny test _boAndSunnyMoment = new Moment("Bo and Sunny", new Image("BoAndSunny.png"), )
		final Moment meJoeAndCo = new Moment("Me, Joe & co.", new Image("MeJoeAndCo.png"), _michelleJoeBoAndMalia, michelleJoeBoAndMaliaSmiles);

		final ArrayList michelleMoments = new ArrayList();
		michelleMoments.add(_meAndBarack);
		michelleMoments.add(meJoeAndCo);
		_michelle.setMoments(michelleMoments);

		final ArrayList barackMoments = new ArrayList();
		barackMoments.add(_meAndBarack);
		_barack.setMoments(barackMoments);

		final ArrayList joeMoments = new ArrayList();
		joeMoments.add(meJoeAndCo);
		_joe.setMoments(joeMoments);

		final ArrayList maliaMoments = new ArrayList();
		maliaMoments.add(meJoeAndCo);
		_malia.setMoments(maliaMoments);

		final ArrayList boMoments = new ArrayList();
		boMoments.add(meJoeAndCo);
		_bo.setMoments(boMoments);
	}

	@Test
	public void testEquals () {
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle.png")));
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle2.png")));  // should still work
		assertNotEquals(_michelle, _barack);
	}

	@Test
	public void testFindBestMoment () {
		assertEquals(_michelle.getOverallHappiestMoment(), _meAndBarack);
	}

	@Test
	public void testGetFriendWithWhomIAmHappiest () {
		assertEquals(_michelle.getFriendWithWhomIAmHappiest(), _barack);
	}

	@Test
    public void testGetFriendWithWhomIAmHappiest2 () {
	    assertEquals(_michelle.getFriendWithWhomIAmHappiest(), _barack);
    }

    @Test
    public void testGetFriendWithWhomIAmHappiest3 () {
	    assertEquals(_bo.getFriendWithWhomIAmHappiest(), _malia);
    }

	@Test
	public void testFriendRequest1 () {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));

		FriendRequest friendRequest1 = new FriendRequest(person1, person2);
		// Make sure the code also compiles for making friend requests for people and pets
		FriendRequest friendRequest2 = new FriendRequest(person1, pet1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFriendRequest2 () {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Person person3 = new Person("person3", new Image("person3.png"));
		FriendRequest friendRequest = new FriendRequest(person1, person2);
		// This should raise an IllegalArgumentException:
		friendRequest.approve(person3);
	}

	@Test
	public void testAddFriend () {
        Person person1 = new Person("person1", new Image("person1.png"));
        Person person2 = new Person("person2", new Image("person2.png"));
        Person person3 = new Person("person3", new Image("person3.png"));
        person1.addFriend(person2);
        person1.addFriend(person3);
        assertEquals(person1.getFriends().size(), 2); // Person 1 should have 2 friends
        assertEquals(person2.getFriends().size(), 0); // Person 2 should have 0 friends
        person2.addFriend(person1);
        assertEquals(person2.getFriends().size(), 1); // Person 2 should now have 1 friend
    }

    @Test // Check that both parties must accept the friend request
    public void testApprove () {
        Person person1 = new Person("person1", new Image("person1.png"));
        Person person2 = new Person("person2", new Image("person2.png"));
        FriendRequest friendRequest = new FriendRequest(person1, person2);
        friendRequest.approve(person2);
        assertEquals(person1.getFriends().size(), 0);
        assertEquals(person2.getFriends().size(), 0);
        friendRequest.approve(person1); // Both parties have accepted, now friends should be added
        assertTrue(person1.getFriends().contains(person2));
        assertTrue(person2.getFriends().contains(person1));
    }

	// TODO: write more methods to test getOverallHappiestMoment
    @Test
    public void testGetOverallHappiestMoment() {
	    assertEquals(_barack.getOverallHappiestMoment(), _meAndBarack);
    }

    @Test
    public void testGetOverallHappiestMoment2() {
        assertEquals(_michelle.getOverallHappiestMoment(), _meAndBarack);
    }

    @Test
    public void testGetOverallHappiestMoment3() {

    }

	// TODO: write methods to test isClique
	// TODO: write methods to test findMaximumCliqueOfFriends

}
