package uk.ac.ebi.pride.px;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class runs the ProteomeXchange stateic website as a Spring web application.
 *
 * @author Tobias-Ternent
 */
@SpringBootApplication
public class PxWebApplication {

  /**
   * This method launches the Spring web application.
   * @param args program arguments, which are unused
   */
  public static void main(String[] args) {
    SpringApplication.run(PxWebApplication.class, args);
  }

  /**
   * This inner class is the controller to handle errors encountered on the website.
   */
  @Controller
  public class RedirectUnknownUrls implements ErrorController {

    /**
     * This method maps the "/error" path, which redirects the user to the root home page "/".
     * @param response redirects the user to the root home page "/".
     * @throws IOException problem when redirecting user.
     */
    @GetMapping("/error")
    public void redirectNonExistentUrlsToHome(HttpServletResponse response) throws IOException {
      response.sendRedirect("/");
    }

    /**
     * Gets the error path.
     * @return the error path "/error"
     */
    @Override
    public String getErrorPath() {
      return "/error";
    }
  }
}
