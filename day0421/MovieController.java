package day0421;

import java.awt.List; 

public class MovieController { 
   MovieModel model = new MovieModel( ); 
   public void addTitle(String title,List movieList){ 
     try{ 
         model.addTitle(title,movieList); 
     }catch(Exception e){ 
         e.printStackTrace( ); 
     } 
  } 

   public void delTitle(String title,List movieList){ 
      model.delTitle(title, movieList); 
   } 

   public void saveTitles(List movieList){ 
      try{ 
         model.saveTitles(movieList); 
      }catch(Exception e){ 
         e.printStackTrace( ); 
      } 
   } 
} 

