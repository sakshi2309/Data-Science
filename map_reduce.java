#####Map Reduce code which does the same thing that the Hive code does. But the accuracy of data extracted is more here.#####

######Map Reduce code for Data wrangling######

public static class Map extends Mapper<LongWritable ,  Text ,  Text ,  Text >
         {
     
      public void map( LongWritable offset,  Text lineText,  Context context)
        throws  IOException,  InterruptedException 
                 {

       
         String line  = lineText.toString();
         String patent_number="",year_applied="",year_published="",patent_abstract="",patent_assignee="";
         Text PATENT_NUMBER=null;
          String match="orgname>General Motors";
        

            if(line.contains(match))
            {
             System.out.println("contains...");
            patent_number=StringUtils.substringBetween(line,"file=\"",".XML");
             System.out.println("patent number utils::"+patent_number);
             
             year_applied=StringUtils.substringBetween(line, "date-produced=\"","\"");
             System.out.println("applied date::"+year_applied);
           
             
              year_published=StringUtils.substringBetween(line, "date-publ=\"", "\">");
             System.out.println("publication date::"+year_published);
             
            
             PATENT_NUMBER=new Text(patent_number);
             Text application_year=new Text("YearApplied#"+year_applied);
             Text granted_year=new Text("YearGranted#"+year_published);
          
             
         //following code fetches patent title...
            String invent_title=StringUtils.substringBefore(line, "</invention-title>");   
            invent_title=StringUtils.reverse(invent_title);
            invent_title=StringUtils.substringBefore(invent_title, ">");
            invent_title=StringUtils.reverse(invent_title);
            
            System.out.println("found title:::::::::::::::::::::::::::::::"+invent_title); 
             
         
         //followng code fetched company name and abstract....
        
          System.out.println(".........................orgname exitsts.......................");
          String org_name=StringUtils.substringBetween(line, "<orgname>","</orgname");
             System.out.println("Organisation Name::"+org_name);
             org_name="CompanyName#"+org_name;
         
       
          System.out.println(".........................abstract exitsts.......................");
          patent_abstract=StringUtils.substringBetween(line, "abstract\">","</abstract");
          patent_abstract=StringUtils.substringBetween(patent_abstract, "\">","</p>");

             patent_abstract="PatentAbstract#"+patent_abstract;
         
       
          System.out.println(".........................asignee exitsts.......................");
          patent_assignee=StringUtils.substringBetween(line, "<assignee>","</assignee>");
         // System.out.println("Patent assignee:::"+patent_assignee);
          patent_assignee=StringUtils.substringBetween(patent_assignee, "<orgname>","</orgname>");
             System.out.println("Assignee::"+patent_assignee);
             
          
           
             
             //writing everything...
     
             if(org_name.contains("General Motors")|| org_name.contains("GM") || org_name.contains("Toyota Jidosha Kabushiki Kaisha") || org_name.contains("Denso")){
            Text final_patent_data=new Text(org_name+"###"+"PatentAssignee#"+patent_assignee+"###"+granted_year+"###"+application_year+"###"+"PatentTitle#"+invent_title+"###"+patent_abstract);
            context.write(PATENT_NUMBER,final_patent_data);
            
            
            //if condion for writing data ends..
             }

         //main if conditoon ends..
            }
            

       
    //map function eds...
      }
   }