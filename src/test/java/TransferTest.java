
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TransferTest 
{
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public void setup()
	{
		
	}
	
	@Test
	public void whenWeCalculateWeightedSize()
	{
		Transfer t1 = new Transfer();
		thrown.expect(NullPointerException.class);
		assertThat(t1.calculateWeightedSize(), is(-999));
		t1.setSize(250);
		assertThat(t1.calculateWeightedSize(), is(-999));
		t1.setProtocol("IPv4");
		t1.setSize(250);
		assertThat(t1.calculateWeightedSize(), is(500));
		t1.setProtocol("IPv6");
		assertThat(t1.calculateWeightedSize(), is(250));
	}
	
	@Test
	public void whenWeTryToSetAnInvalidProtocoll()
	{
		Transfer t1 = new Transfer();
		thrown.expect(IllegalArgumentException.class);
		t1.setProtocol("ipx");
		thrown.expect(NullPointerException.class);
		t1.setProtocol(null);
		
	}
	
	@Test
	public void whenWeTryToSetAInvalidSize()
	{
		Transfer t1 = new Transfer();
		thrown.expect(NullPointerException.class);
		t1.setSize(null);
		thrown.expect(IllegalArgumentException.class);
		t1.setSize(-3);
		t1.setSize(0);
	}
	
	@Test
	public void whenWeTryToSetAValidSize()
	{
		Transfer t1 = new Transfer();
		t1.setSize(250);
		assertThat(t1.getSize(), is(250));
	}
	
	
	
	
	
	
	
}
