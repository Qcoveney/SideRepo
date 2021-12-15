import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Search")
public class Search extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private Race yourRace = new Race();
   private Classes yourClass = new Classes();
   private Backgrounds yourBackground = new Backgrounds();

   public Search() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword");
      search(keyword, response);
   }

   void search(String keyword, HttpServletResponse response) throws IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");

      Connection connection = null;
      PreparedStatement preparedStatement = null;
      
      try {
         Servlet.getDBConnection();
         connection = Servlet.connection;

         // Empty search returns all items.
         if (keyword.isEmpty()) {
            String selectSQL = "SELECT * FROM Characters";
            preparedStatement = connection.prepareStatement(selectSQL);
         } 
         
         // Search by race returns all characters of that race.
         else if(keyword.equalsIgnoreCase("dwarf")) {
             String selectSQL = "SELECT * FROM Characters WHERE RACE LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("elf")) {
             String selectSQL = "SELECT * FROM Characters WHERE RACE LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("halfling")) {
             String selectSQL = "SELECT * FROM Characters WHERE RACE LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("human")) {
        	 out.println("human here");
             String selectSQL = "SELECT * FROM Characters WHERE RACE LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         
         
         
         // Search by class returns all characters of that class.
         else if(keyword.equalsIgnoreCase("bard")) {
             String selectSQL = "SELECT * FROM Characters WHERE CLASS LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("cleric")) {
             String selectSQL = "SELECT * FROM Characters WHERE CLASS LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("fighter")) {
             String selectSQL = "SELECT * FROM Characters WHERE CLASS LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
         else if(keyword.equalsIgnoreCase("rogue")) {
             String selectSQL = "SELECT * FROM Characters WHERE CLASS LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
         }
           
         // This one returns a search by name.
         else {
             String selectSQL = "SELECT * FROM Characters WHERE NAME LIKE ?";
             preparedStatement = connection.prepareStatement(selectSQL);
             preparedStatement.setString(1, keyword +"%");
          }
         
         ResultSet rs = preparedStatement.executeQuery();

         /**
          * Needs to print out:
          * Name
          * Race
          * Class
          * Background
          * Stat line
          * ^ These are all from the MySQL server^
          * 
          * I have the rest of this set up to print from the race class
          * and the classes class, so it provides more info into your
          * stuff when you search for it.
          * 
          * Your ability score mod
          * Size
          * Speed
          * Whether or not you have darkvision
          * Your race's special trait
          */
         while (rs.next()) {
            String name = rs.getString("name").trim();
            String race = rs.getString("race").trim();
            String characterClass = rs.getString("class").trim();
            String background = rs.getString("background").trim();

            // Set a race to print the info out for.
            if (race.equalsIgnoreCase("dwarf")) {
            	yourRace.Dwarf();
            }
            if (race.equalsIgnoreCase("elf")) {
            	yourRace.Elf();
            }
            if (race.equalsIgnoreCase("halfling")) {
            	yourRace.Halfling();
            }
            if (race.equalsIgnoreCase("human")) {
            	yourRace.Human();
            }
            
            
            // Set a class to print the info out for.
            if (characterClass.equalsIgnoreCase("bard")) {
            	yourClass.Bard();
            }
            if (characterClass.equalsIgnoreCase("cleric")) {
            	yourClass.Cleric();
            }
            if (characterClass.equalsIgnoreCase("fighter")) {
            	yourClass.Fighter();
            }
            if (characterClass.equalsIgnoreCase("rogue")) {
            	yourClass.Rogue();
            }
            
            
            // Set a background to print the info out for.
            if (background.equalsIgnoreCase("charlatan")) {
            	yourBackground.Charlatan();
            }
            if (background.equalsIgnoreCase("entertainer")) {
            	yourBackground.Entertainer();
            }
            if (background.equalsIgnoreCase("hermit")) {
            	yourBackground.Hermit();
            }
            if (background.equalsIgnoreCase("soldier")) {
            	yourBackground.Soldier();
            }
            
            
            /**
             * This is where the printing happens. I have it set I think
             * to print out the full details for the character's race, class, and background.
             * 
             * We still need to set up the stat line stuff, but that's for later :D
             */
            if (keyword.isEmpty() || name.contains(keyword) || race.contains(keyword) || characterClass.contains(keyword)) {
               out.println("Name: " + name + "<br> ");
               out.println("Race: " + race + "<br> ");
               out.println("Class: " + characterClass + "<br>");
               out.println("Background: " + background + "<br>");
               out.println(yourRace.toString() + "<br>");
               out.println(yourClass.toString() + "<br>");
               out.println(yourBackground.toString() + "<br>");
            }
         }
         
         out.println("<a href=/ThisIsFineProject/search.html>Search Data</a> <br>");
         out.println("</body></html>");
         rs.close();
         preparedStatement.close();
         connection.close();
      } 
      
      catch (SQLException se) {
         se.printStackTrace();
      } 
      
      catch (Exception e) {
         e.printStackTrace();
      } 
      
      finally {
         try {
            if (preparedStatement != null)
               preparedStatement.close();
         } catch (SQLException se2) {
         }
         try {
            if (connection != null)
               connection.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
