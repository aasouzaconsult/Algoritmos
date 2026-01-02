public class IceCreamStore {
	public static void main (String [ ] args) {
		IceCreamStore world = new IceCreamStore();
	}

	IceCreamStore () {
		int t = 0;
		while (t < 120) {
			t += randBetween(2, 5);
			simulation.scheduleEvent(new ArriveEvent(t, randBetween(1,5)));
		}
		simulation.run();
		System.out.println("Total profits " + profit);
	}

	private int freeChairs = 35;
	private double profit = 0.0;
	private SimulationFramework simulation = new SimulationFramework();

	private int randBetween (int low, int high) {
		return low + (int) ((high - low + 1) * Math.random());
	}

	public boolean canSeat (int numberOfPeople) {
		System.out.println("Group of " + numberOfPeople +
			" customers arrives at time " + simulation.time());
		if (numberOfPeople < freeChairs) {
			System.out.println("Group is seated");
			freeChairs -= numberOfPeople;
			return true;
		} else 
			System.out.println("No Room, Group Leaves");
		return false;
	}

	private void order (int numberOfScoops) {
		System.out.println("Serviced order for " + numberOfScoops +
			" at time " + simulation.time());
		profit += 0.35 * numberOfScoops;
	}

	private void leave (int numberOfPeople) {
		System.out.println("Group of size " + numberOfPeople + 
			" leaves at time " + simulation.time());
		freeChairs += numberOfPeople;
	}

	private class ArriveEvent extends Event {
		ArriveEvent (int time, int gs) { super(time); groupSize = gs; }
		private int groupSize;

		public void processEvent () {
			if (canSeat(groupSize)) {
				simulation.scheduleEvent (
					new OrderEvent(time + randBetween(2,10), groupSize));
			}
		}
	}

	private class OrderEvent extends Event {
		OrderEvent (int time, int gs) { super(time); groupSize = gs; }
		private int groupSize;

		public void processEvent () {
			for (int i = 0; i < groupSize; i++)
				order(1 + randBetween(1, 3));
			simulation.scheduleEvent (
				new LeaveEvent(time + randBetween(15, 35), groupSize));
		}
	}

	private class LeaveEvent extends Event {
		LeaveEvent (int time, int gs) { super(time); groupSize = gs; }
		private int groupSize;

		public void processEvent () { leave(groupSize); }
	}
}

