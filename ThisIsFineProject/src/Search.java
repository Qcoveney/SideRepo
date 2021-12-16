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
      out.println(
    		  "<!DOCTYPE html>\n" + 
    		  "<html>\n" + 
    		  "\n" + 
    		  "<head>\n" + 
    		  "    <meta charset=\"utf-8\">\n" + 
    		  "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" + 
    		  "    <title>Results For&nbsp;" + keyword + "</title>\n" + 
    		  "    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n" + 
    		  "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700\">\n" + 
    		  "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css\">\n" + 
    		  "</head>\n" + 
    		  "\n" + 
    		  "<body style=\"background: var(--bs-gray-800);\">\n" + 
    		  "    <nav class=\"navbar navbar-light navbar-expand bg-danger navigation-clean\" style=\"background: var(--bs-danger);color: var(--bs-danger);\">\n" + 
    		  "        <div class=\"container\"><a class=\"navbar-brand link-light\" href=\"/ThisIsFineProject/search.html\" style=\"color: rgba(255,255,255,0.9);\">DnD Builder</a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navcol-1\"></button>\n" + 
    		  "            <div class=\"collapse navbar-collapse text-light\" id=\"navcol-1\" style=\"text-align: right;\"><a class=\"btn btn-danger ms-auto\" role=\"button\" href=\"/ThisIsFineProject/search.html\" style=\"border-width: 0px;border-color: var(--bs-gray-900);background: var(--bs-gray-900);\">Search Character</a><a class=\"btn btn-danger\" role=\"button\" href=\"/ThisIsFineProject/insert.html\" style=\"margin-left: 13px;background: var(--bs-gray-900);border-width: 0px;\">Create Character</a></div>\n" + 
    		  "        </div>\n" + 
    		  "    </nav>\n" + 
    		  "    <main class=\"page cv-page\" style=\"background: var(--bs-gray-800);\">\n" + 
    		  "        <section class=\"portfolio-block block-intro border-bottom\" style=\"height: 144px;\">\n" + 
    		  "            <h1 class=\"text-center text-white-50\" style=\"height: 46px;font-size: 48px;font-weight: bold;margin-top: 0px;text-decoration: underline;\">Search Results</h1>\n" + 
    		  "        </section>\n" + 
    		  "        <section class=\"text-white-50 portfolio-block block-intro border-bottom\" style=\"margin-right: 40px;margin-left: 40px;\">");

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
               out.println("Name:            &nbsp;&ensp;&ensp;&ensp;&emsp;&emsp;" + name + "<br> ");
               out.println("Race:            &nbsp;&emsp;&emsp;&emsp;&emsp;" + race + "<br> ");
               out.println("Class:           &emsp;&emsp;&emsp;&emsp;" + characterClass + "<br>");
               out.println("Background:      &emsp;" + background + "<br>");
               out.println(yourRace.toString() + "&emsp;<br>");
               out.println(yourClass.toString() + "&emsp;<br>");
               out.println(yourBackground.toString() + "<br><br>");
            }
         }
         
         out.println("</section>\n" + 
         		"    </main>\n" + 
         		"    <footer class=\"text-center page-footer\" style=\"background: var(--bs-gray-200);margin-top: -3px;justify-content:center;align-items:center;\">\n" + 
         		"      <div class=\"container\">\n" + 
         		"        <div class=\"social-icons\">\n" + 
         		"            <p class=\"text-start text-muted small mb-4 mb-lg-0\">© DnD Builder 2021. All Rights Reserved.</p>\n" + 
         		"        </div>\n" + 
         		"      </div>\n" + 
         		"	 </footer>" + 
         		"    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" + 
         		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js\"></script>\n" + 
         		"    <script src=\"assets/js/theme.js\"></script>\n" + 
         		"</body>\n" + 
         		"\n" + 
         		"</html>");
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
