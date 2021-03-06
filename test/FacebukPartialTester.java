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
	private Moment _meAndBarack, _meAndKevin, _barackAndKevinMoment;
	private ArrayList _michelleAndBarack, _michelleJoeBoAndMalia, _michelleAndKevin, _barackAndKevin;

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

		_barackAndKevin = new ArrayList();
		_barackAndKevin.add(_barack);
		_barackAndKevin.add(_kevin);

		_michelleAndKevin = new ArrayList();
		_michelleAndKevin.add(_michelle);
		_michelleAndKevin.add(_kevin);

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

		final ArrayList michelleKevinSmiles = new ArrayList();
		michelleKevinSmiles.add(0.1f);
		michelleKevinSmiles.add(0.3f);

		final ArrayList barackKevinSmiles = new ArrayList();
		barackKevinSmiles.add(0.9f);
		barackKevinSmiles.add(0.8f);

		// Moments
		_meAndBarack = new Moment("Me & Barack", new Image("MeAndBarack.png"), _michelleAndBarack, michelleAndBarackSmiles);
		_meAndKevin = new Moment("Me & Kevin", new Image("MeAndKevin.png"), _michelleAndKevin, michelleKevinSmiles);
		_barackAndKevinMoment = new Moment("Barack & Kevin", new Image("Barack&Kevin.png"), _barackAndKevin, barackKevinSmiles);
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

		final ArrayList kevinMoments = new ArrayList();
		kevinMoments.add(_meAndKevin);
		kevinMoments.add(_barackAndKevinMoment);
		_kevin.setMoments(kevinMoments);
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
        assertEquals(_kevin.getOverallHappiestMoment(), _barackAndKevinMoment);
    }

    @Test
    public void testIsClique() {
	    assertEquals(LivingEntity.isClique(_barackAndKevin), true);
    }

    @Test
    public void testIsClique2() {
        Person person1 = new Person("person1", new Image("person1.png"));
        Person person2 = new Person("person2", new Image("person2.png"));
        ArrayList personAndPerson = new ArrayList();
        personAndPerson.add(person1);
        personAndPerson.add(person2);
	    assertEquals(LivingEntity.isClique(personAndPerson), false);
    }

	@Test
	public void testFindMaximumCliqueOfFriends() {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Person person3 = new Person("person3", new Image("person3.png"));
		Person person4 = new Person("person4", new Image("person4.png"));
		person1.addFriend(person2);
		person1.addFriend(person3);
		person1.addFriend(person4);
		person2.addFriend(person1); // Only 1 and 2 are friends with each other
		ArrayList person1Clique = new ArrayList();
		person1Clique.add(person2);
		assertEquals(person1.findMaximumCliqueOfFriends(), person1Clique);
	}

	@Test
	public void testFindMaximumCliqueOfFriends2() {
		Person person1 = new Person("person1", new Image("person1.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		person1.addFriend(pet1);
		person1.addFriend(person2);
		pet1.addFriend(person1);
		pet1.addFriend(person2);
		person2.addFriend(pet1);
		person2.addFriend(person1);
		// Only person 1 is mutual friends with pet 1 and person 2
		ArrayList person1Clique = new ArrayList();
		person1Clique.add(pet1);
		person1Clique.add(person2);
		assertEquals(person1.findMaximumCliqueOfFriends(), person1Clique);
		ArrayList pet1Clique = new ArrayList(); // Order matters
		pet1Clique.add(person1);
		pet1Clique.add(person2);
		assertEquals(pet1.findMaximumCliqueOfFriends(), pet1Clique);
	}

	@Test
	public void testFindMaximumCliqueOfFriends3() {
		Person person1 = new Person("person1", new Image("person1.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		person1.addFriend(pet1);
		person1.addFriend(person2);
		pet1.addFriend(person1);
		person2.addFriend(person1);
		// person 2 and pet 1 aren't friends, so the clique should only consist of person 2
		ArrayList person1Clique = new ArrayList();
		person1Clique.add(pet1);
		assertEquals(person1.findMaximumCliqueOfFriends(), person1Clique);
	}

	@Test
	public void testFindMaximumCliqueOfFriends4() {
		Person p1 = new Person("p1", new Image("p1.png"));
        Person p2 = new Person("p2", new Image("p2.png"));
        Person p3 = new Person("p3", new Image("p3.png"));
        Person p4 = new Person("p4", new Image("p4.png"));
        Person p5 = new Person("p5", new Image("p5.png"));
        Person p6 = new Person("p6", new Image("p6.png"));
        Person p7 = new Person("p7", new Image("p7.png"));
        Person p8 = new Person("p8", new Image("p8.png"));
        p1.addFriend(p2);
        p2.addFriend(p1);
        p2.addFriend(p3);
        p3.addFriend(p2);
        p2.addFriend(p4);
        p4.addFriend(p2);
        p1.addFriend(p4);
        p4.addFriend(p1);  // NOT
        p1.addFriend(p6);  // SORRY
        p6.addFriend(p1);
        p6.addFriend(p8);
        p8.addFriend(p6);
        p1.addFriend(p5);
        p5.addFriend(p1);
        p6.addFriend(p5);
        p5.addFriend(p6);
        p1.addFriend(p7);
        p7.addFriend(p1);
        p6.addFriend(p7);
        p7.addFriend(p6);
        ArrayList clique = new ArrayList();
        clique.add(p6);
        clique.add(p5);
        clique.add(p7);
        assertEquals(p1.findMaximumCliqueOfFriends(), clique);
	}
}
