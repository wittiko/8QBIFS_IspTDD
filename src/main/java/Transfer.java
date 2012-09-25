import java.net.InetAddress;
import java.net.UnknownHostException;


public class Transfer 
{
	
	private String protocol;
	private Integer size;
	
	public Transfer()
	{
		
	}
	
	// getters

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	
	// setters

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) 
	{
		if(protocol != null)
		{
			if(protocol.equals("IPv4") || protocol.equals("IPv6"))
			{
				this.protocol = protocol;
			}
			else
			{
				throw new IllegalArgumentException("Only IPv4 or IPv6 als Protocol allowed!");
			}
		}
		else
		{
			throw new NullPointerException("NULL @ setProtocol");
		}
		
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) 
	{
		if(size != null)
		{
			if(size > 0)
			{
				this.size = size;
			}
			else
			{
				throw new IllegalArgumentException("Size can't be less than 0");
			}
		}
		else
		{
			throw new NullPointerException("NULL @ setSize()");
		}
		
	}
	
	public Integer calculateWeightedSize()
	{
		Integer res = new Integer(-999);
		if(protocol != null)
		{
			if(protocol.equals("IPv4"))
			{
				res = size * 2;
			}
			if(protocol.equals("IPv6"))
			{
				res = size;
			}
		}
		else
		{
			throw new NullPointerException("Protocol is still NULL! You have to set Protocol first");
		}
		
		return res;
	}
	
	
}
