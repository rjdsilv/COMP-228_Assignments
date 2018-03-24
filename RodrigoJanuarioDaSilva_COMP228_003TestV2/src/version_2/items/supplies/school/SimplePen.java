package version_2.items.supplies.school;

import version_2.Closable;
import version_2.OpenCloseState;
import version_2.Openable;

public final class SimplePen extends SchoolSupply implements Openable, Closable {
	private static final String SIMPLE_PEN = "simple pen";

	private OpenCloseState state;
	
	public SimplePen() {
		super();
		name = SIMPLE_PEN;
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
