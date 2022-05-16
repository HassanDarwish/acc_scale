package truck_scale;


import java.io.*;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
 
/**
 * This program demonstrates how to implement a UDP client program.
 *
 *
 * @author www.codejava.net
 */
public class truck_scale  {
	private String hostname;
	private int port ;
	 private String hex ;// "3c717565726965733e3c717565727920726571753d2272656d646973702220747970653d222a222077703d2241222f3e3c2f717565726965733e";
	
	public String getHex() {
		return hex;
	}




	public void setHex(String hex) {
		this.hex = hex;
	}


	private int value ;
	private String unit=null;
	
	public int getValue() {
		return value;
	}




	public void setValue(int value) {
		this.value = value;
	}




	public String getUnit() {
		return unit;
	}




	public void setUnit(String unit) {
		this.unit = unit;
	}




	private truck_scale(Builder builder) {
		this.setHostname(builder.getHostname());
		this.setPort(builder.getPort());
		this.setHex(builder.getHex());
	}
	
	
	
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void getWieght() throws Exception {

  //      String hostname = ip;
   //     int port =11020;
 
        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(6000);
            
           
            
   
            byte[] b = ParseHex(hex);
            
      //     while (true) {
 
                DatagramPacket request = new DatagramPacket(b, b.length, address, port);
                socket.send(request);
 
                byte[] buffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
 
                String quote = new String(buffer, 0, response.getLength());
 
                System.out.println(quote);
                quote=quote.trim();
     
                 
                FileWriter fw=new FileWriter("asd.xml");    
                fw.write(quote);    
                fw.close(); 
              
                
             // parsing XML file to get as String using DOM Parser 
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbFactory.newDocumentBuilder(); 
               // Document xmlDom = docBuilder.parse(quote); 
                
               // String xmlAsString = xmlDom.toString();
             //   xmlAsString.replace("Client error: no protocol:", "");
                
                Document xmlDocument =  docBuilder.newDocument() ;
                 xmlDocument =docBuilder.parse(new File("asd.xml"));
               int x=0;
                 NodeList nodeList = xmlDocument.getElementsByTagName("reply");
               // for(int x=0,size= nodeList.getLength(); x<size; x++) {
                     System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
                     System.out.println(nodeList.item(x).getAttributes().getNamedItem("unit").getNodeValue());
                     
                     this.setUnit(nodeList.item(x).getAttributes().getNamedItem("unit").getNodeValue());
                     this.setValue(Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue()));
              //   }
                
                // this will not print what you want System.out.println("XML as String using DOM Parser : "); System.out.println(xmlAsString);

                 	
                Thread.sleep(10000);
                
          //while(true)  }
 
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
	}
    public static void main(String[] args) throws Exception {
     
    	truck_scale udpclient= new truck_scale.Builder().setHostname("10.0.6.62").setPort(11020).setHex("3c717565726965733e3c717565727920726571753d2272656d646973702220747970653d222a222077703d2241222f3e3c2f717565726965733e").build();
    	udpclient.getWieght();
    	
    	 
    }
    				//"10.0.6.61"
    
    
    
    private static byte[] ParseHex(String hex) throws Exception
    {
 
      int index1 = hex.startsWith("0x") ? 2 : 0;
      if (hex.length() % 2 != 0)
        throw new Exception("Invalid length: ") ;
      byte[] numArray = new byte[(hex.length() - index1) / 2];
      for (int index2 = 0; index2 < numArray.length; ++index2)
      {
        numArray[index2] = (byte) (ParseNybble(hex.charAt(index1)) << 4 | ParseNybble(hex.charAt(index1 + 1)));
        index1 += 2;
      }
      return numArray;
    }

    private static int ParseNybble(char c) throws Exception
    {
      if (c >= '0' && c <= '9')
        return (int) c - 48;
      if (c >= 'A' && c <= 'F')
        return (int) c - 65 + 10;
      if (c >= 'a' && c <= 'f')
        return (int) c - 97 + 10;
      throw new Exception("Invalid hex digit: " );
    }
    
    
    public  static class Builder {
    	
    	private String hostname ;
        private int port ; //=11020;
        private String hex ;
        
		public String getHex() {
			return hex;
		}
		public Builder setHex(String hex) {
			this.hex = hex;return this;
		}
		public String getHostname() {
			return hostname;
		}
		public Builder setHostname(String hostname) {
			this.hostname = hostname;
			return this;
		}
		public int getPort() {
			return port;
		}
		public Builder setPort(int port) {
			this.port = port;
			return this;
		}
    	
    	public truck_scale build() {
    		
    		
    		return new truck_scale(this);
    	}
    	
    }
    
    
    
    
}

//UDPClient
