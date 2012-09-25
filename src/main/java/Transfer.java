import java.net.InetAddress;
import java.net.UnknownHostException;


public class Transfer 
{
	private String sip;
	private String tip;
	private String protocol;
	private Integer size;
	
	public Transfer()
	{
		
	}
	
	public Transfer(String sip, String tip, String protocol, Integer size)
	{
		setSip(sip);
		setTip(tip);
		setProtocol(protocol);
		setSize(size);
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
	
	/**
	 * @return the sip
	 */
	public String getSip() {
		return sip;
	}
	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
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
	
	/**
	 * @param sip the sip to set
	 */
	public void setSip(String sip) 
	{
		try 
		{
			InetAddress tmp = InetAddress.getByName(sip);
			if(tmp != null)
			{
				this.sip = sip;
			}
			else
			{
				this.sip = "0.0.0.0";
			}
			
		}
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("The parameter is no valid IP Address!");
		}
		
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) 
	{
		try 
		{
			InetAddress tmp = InetAddress.getByName(tip);
			if(tmp != null)
			{
				this.tip = tip;
			}
			else
			{
				this.tip = "0.0.0.0";
			}
				
		}
		catch (UnknownHostException e) 
		{
			throw new IllegalArgumentException("The parameter is no valid IP Address!");
			
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
