package version_2.items.supplies.school;

import version_2.Closable;
import version_2.OpenCloseState;
import version_2.Openable;

public class Notebook extends SchoolSupply implements Openable, Closable {
	private static final String NOTEBOOK = "notebook";

	private OpenCloseState state;
	
	public Notebook() {
		super();
		name = NOTEBOOK;
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
