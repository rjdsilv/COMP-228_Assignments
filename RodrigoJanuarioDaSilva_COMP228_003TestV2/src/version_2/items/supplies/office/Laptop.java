package version_2.items.supplies.office;

import version_2.Closable;
import version_2.OpenCloseState;
import version_2.Openable;

public class Laptop extends OfficeSupply implements Openable, Closable {
	private static final String LAPTOP = "laptop";
	
	private OpenCloseState state;
	
	public Laptop() {
		super();
		name = LAPTOP;
	}

	@Override
	public void close() {
		state = OpenCloseState.CLOSED;
	}

	@Override
	public void open() {
		state = OpenCloseState.OPENED;
	}

	public OpenCloseState getState() {
		return state;
	}
}
