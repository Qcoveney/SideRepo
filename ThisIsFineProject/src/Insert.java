/**
 * @file Insert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public Insert() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String race = request.getParameter("race");
      String characterClass = request.getParameter("characterClass");
      String strength = request.getParameter("strength");
      String dexterity = request.getParameter("dexterity");
      String constitution = request.getParameter("constitution");
      String intelligence = request.getParameter("intelligence");
      String wisdom = request.getParameter("wisdom");
      String charisma = request.getParameter("charisma");
      String equipment = request.getParameter("equipment");
      String background = request.getParameter("background");

      Connection connection = null;
      String insertSql = " INSERT INTO Characters (id, NAME, RACE, CLASS, STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA, EQUIPMENT, BACKGROUND) values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      try {
         Servlet.getDBConnection();
         connection = Servlet.connection;
         PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
         preparedStmt.setString(1, name);
         preparedStmt.setString(2, race);
         preparedStmt.setString(3, characterClass);
         preparedStmt.setString(4, strength);
         preparedStmt.setString(5, dexterity);
         preparedStmt.setString(6, constitution);
         preparedStmt.setString(7, intelligence);
         preparedStmt.setString(8, wisdom);
         preparedStmt.setString(9, charisma);
         preparedStmt.setString(10, equipment);
         preparedStmt.setString(11, background);
         preparedStmt.execute();
         connection.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>\n" + 
    		  "<html>\n" + 
    		  "\n" + 
    		  "<head>\n" + 
    		  "    <meta charset=\"utf-8\">\n" + 
    		  "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" + 
    		  "    <title>Successful Creation</title>\n" + 
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
    		  "            <h1 class=\"text-center text-white-50\" style=\"height: 46px;font-size: 48px;font-weight: bold;margin-top: 0px;text-decoration: underline;\">Character Created!</h1>\n" + 
    		  "        </section>\n" + 
    		  "        <section class=\"text-white-50 portfolio-block block-intro border-bottom\" style=\"margin-right: 40px;margin-left: 40px;\">");
      	out.println(
            "  <li><b>Character's Name</b>: " + name + "\n" + //
            "  <li><b>Character's Race</b>: " + race + "\n" + //
            "  <li><b>Character's Class</b>: " + characterClass + "\n" + //
            "  <li><b>Character's Background</b>: " + background + "\n" + //

			"  <li><b>Stat Line</b>\n" + //
			"  <li><b>Strength</b>: " + strength + "\n" + //
			"  <li><b>Dexterity</b>: " + dexterity + "\n" + //
			"  <li><b>Constitution</b>: " + constitution + "\n" + //
			"  <li><b>Intelligence</b>: " + intelligence + "\n" + //
			"  <li><b>Wisdom</b>: " + wisdom + "\n" + //
			"  <li><b>Charisma</b>: " + charisma + "\n" + //
			"  <li><b>Equipment</b>: " + equipment + "\n" + //
			"  <li><b>Background</b>: " + background + "\n" + //

            "<br><br><br></ul>\n");

      out.println("</section>\n" + 
       		"    </main>\n" + 
       		"        <footer class=\"bg-light footer\">\n" + 
       		"        <div class=\"container\">\n" + 
       		"            <div class=\"row\">\n" + 
       		"                <div class=\"col-lg-6 text-center text-lg-start my-auto h-100\">\n" + 
       		"                    <p class=\"text-muted small mb-4 mb-lg-0\">© DnD Builder 2021. All Rights Reserved.</p>\n" + 
       		"                </div>\n" + 
       		"            </div>\n" + 
       		"        </div>\n" + 
       		"    </footer>" + 
       		"    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" + 
       		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js\"></script>\n" + 
       		"    <script src=\"assets/js/theme.js\"></script>\n" + 
       		"</body>\n" + 
       		"\n" + 
       		"</html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}