import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

public class ReadCVS extends Thread {

  public static void main(String[] args) {

	ReadCVS obj = new ReadCVS();
	obj.run();

  }

  public void run() {

	String csvFile = "E:/Individual study/Homework/lers.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	HashMap<String, String> x = new HashMap<String, String>();
	HashMap<String, String> a = new HashMap<String, String>();
	HashMap<String, String> b = new HashMap<String, String>();
	HashMap<String, String> c = new HashMap<String, String>();
	HashMap<String, String> rules = new HashMap<String, String>();
	ArrayList<String> ip1=new ArrayList<String>();
	ArrayList<String> ip0=new ArrayList<String>();
	ArrayList<String> a1=new ArrayList<String>();
	ArrayList<String> a2=new ArrayList<String>();
	ArrayList<String> a3=new ArrayList<String>();
	ArrayList<String> b1=new ArrayList<String>();
	ArrayList<String> b2=new ArrayList<String>();
	ArrayList<String> c1=new ArrayList<String>();
	ArrayList<String> c2=new ArrayList<String>();
	ArrayList<String> loop2=new ArrayList<String>();
	int a1c=0,a2c=0,a3c=0,b1c=0,b2c=0,c1c=0,c2c=0;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                  
		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
			x.put(country[0], country[4]);
			a.put(country[0], country[1]);
			b.put(country[0], country[2]);
			c.put(country[0], country[3]);
		}
		
		Set set1 = x.entrySet();
		Set set2 = a.entrySet();
		Set set3 = b.entrySet();
		Set set4 = c.entrySet();
	      Iterator iterator1 = set1.iterator();
	      Iterator iterator2 = set2.iterator();
	      Iterator iterator3 = set3.iterator();
	      Iterator iterator4 = set4.iterator();
	      while(iterator1.hasNext()|iterator2.hasNext()| iterator3.hasNext()|iterator4.hasNext()) {
	          Map.Entry mentry1 = (Map.Entry)iterator1.next();
	          Map.Entry mentry2 = (Map.Entry)iterator2.next();
	          Map.Entry mentry3 = (Map.Entry)iterator3.next();
	          Map.Entry mentry4 = (Map.Entry)iterator4.next();
	          
	          if (mentry1.getValue().toString().equals("1"))
	          {
	        	  ip1.add(mentry1.getKey().toString());
	          }
	          else
	          {
	        	  ip0.add(mentry1.getKey().toString()); 
	          }
	          
	          if (mentry2.getValue().toString().equals("1"))
	          {
	        	  a1.add(mentry2.getKey().toString());
	          }
	          else if(mentry2.getValue().toString().equals("2"))
	          {
	        	  a2.add(mentry2.getKey().toString()); 
	          }
	          else if(mentry2.getValue().toString().equals("3"))
	          {
	        	  a3.add(mentry2.getKey().toString());
	          
	          }
	          
	          if (mentry3.getValue().toString().equals("1"))
	          {
	        	  b1.add(mentry3.getKey().toString());
	          }
	          else if(mentry3.getValue().toString().equals("2"))
	          {
	        	  b2.add(mentry3.getKey().toString()); 
	          }
	          
	          if (mentry4.getValue().toString().equals("1"))
	          {
	        	  c1.add(mentry4.getKey().toString());
	          }
	          else if(mentry4.getValue().toString().equals("2"))
	          {
	        	  c2.add(mentry4.getKey().toString()); 
	          }
	          
	      }
	          
	      System.out.println("X Values with F=1 "+ ip1);
          System.out.println("X Values with F=0 "+ ip0);
          System.out.println("X Values with a=1 "+ a1);
          System.out.println("X Values with a=2 "+ a2);
          System.out.println("X Values with a=3 "+ a3);
          System.out.println("X Values with b=1 "+ b1);
          System.out.println("X Values with b=2 "+ b2);
          System.out.println("X Values with c=1 "+ c1);
          System.out.println("X Values with c=2 "+ c2);
          System.out.println("Loop-1");
          for (int i=0;i<ip1.size();i++) 
          {
        	  for (int j=0;j<a1.size();j++)
        	  {
        		  if(a1.get(j).equals(ip1.get(i)))
        		  {
        			  a1c= a1c+1 ;
        		  }
        	  }
        	  for (int j=0;j<a2.size();j++)
        	  {
        		  if(a2.get(j).equals(ip1.get(i)))
        		  {
        			  a2c= a2c+1 ;
        		  }
        	  } 
        	  for (int j=0;j<a3.size();j++)
        	  {
        		  if(a3.get(j).equals(ip1.get(i)))
        		  {
        			  a3c= a3c+1 ;
        		  }
        	  }
        	  for (int j=0;j<b1.size();j++)
        	  {
        		  if(b1.get(j).equals(ip1.get(i)))
        		  {
        			  b1c= b1c+1 ;
        		  }
        	  }
        	  for (int j=0;j<b2.size();j++)
        	  {
        		  if(b2.get(j).equals(ip1.get(i)))
        		  {
        			  b2c= b2c+1 ;
        		  }
        	  } 
        	  for (int j=0;j<c1.size();j++)
        	  {
        		  if(c1.get(j).equals(ip1.get(i)))
        		  {
        			  c1c= c1c+1 ;
        		  }
        	  }
        	  for (int j=0;j<c2.size();j++)
        	  {
        		  if(c2.get(j).equals(ip1.get(i)))
        		  {
        			  c2c= c2c+1 ;
        		  }
        	  } 
        	  
          }
          if(a1.size()==a1c)
          {
        	  System.out.println("a,1 ---> F,1");
        	  rules.put("A1", "F1");
          }
           if(a2.size()==a2c)
          {
        	  System.out.println("a,2 ---> F,1");
        	  
          }
           else
           {
        	   loop2.add("a2");
           }
           if(a3.size()==a3c)
          {
        	  System.out.println("a,3 ---> F,1");  
          }
           else
           {
        	   loop2.add("a3");
           }
           if(b1.size()==b1c)
           {
         	  System.out.println("b,1 ---> F,1");
           }
           else
           {
        	   loop2.add("b1");
           }
            if(b2.size()==b2c)
           {
         	  System.out.println("b,2 ---> F,1");  
         	 rules.put("B2", "F1");
           }
            if(c1.size()==c1c)
            {
          	  System.out.println("c,1 ---> F,1");
          	rules.put("C1", "F1");
            }
             if(c2.size()==c2c)
            {
          	  System.out.println("c,2 ---> F,1");  
            }
             else
             {
          	   loop2.add("c2");
             }
          // a1c=0;a2c=0;a3c=0;b1c=0;b2c=0;c1c=0;c2c=0; 
             ArrayList<String> c2b1 = new ArrayList<String>(c2);
             ArrayList<String> b1a2 = new ArrayList<String>(b1);
             ArrayList<String> a2c2 = new ArrayList<String>(a2);
             ArrayList<String> a3c2 = new ArrayList<String>(a3);
             ArrayList<String> a3b1 = new ArrayList<String>(a3);
             c2b1.retainAll(b1);
             b1a2.retainAll(a2);
             a2c2.retainAll(c2);
             a3c2.retainAll(c2);
             a3b1.retainAll(b1);
             System.out.println("Unmarked Sets");
             System.out.println("C2^B1--->"+c2b1);
             System.out.println("B1^A2--->"+b1a2);
             System.out.println("A2^C2--->"+a2c2);
             System.out.println("A3^C2--->"+a3c2);
             System.out.println("A3^B1--->"+a3b1);
             System.out.println("Loop-2");
             if(ip0.containsAll(a3c2))
             {
            	 System.out.println("A3,C2--->F0"); 
            	 rules.put("A3,C2","F0");
             }
             else if(ip1.containsAll(a3c2))
             {
            	 System.out.println("A3,C2--->F1"); 
             }
             if(ip0.containsAll(a3b1))
             {
            	 System.out.println("A3,B1--->F0"); 
            	 rules.put("A3,B1","F0");
             }
             else if(ip1.containsAll(a3b1))
             {
            	 System.out.println("A3,B1--->F1"); 
             }
             if(ip0.containsAll(a2c2))
             {
            	 System.out.println("A2,C2--->F0"); 
            	 rules.put("A2,C2","F0");
             }
             
             else if(ip1.containsAll(a2c2))
             {
            	 System.out.println("A2,C2--->F1"); 
             }

          System.out.println("All the Rules Extracted - "+rules);
          
          
          
	} 
	
		
	catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
  }

}