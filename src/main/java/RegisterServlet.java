import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "RegisterServlet")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("pwd");
        String encryptedPassword = StringUtil.toSHA256(password);
        String name= request.getParameter("name");
        String email = request.getParameter("email");
        User newUser = new User.UserBuilder().setName(name).setUserName(userName).setEmail(email).setPassword(encryptedPassword).setDateOfRegister().build();

        RegisterDAOImpl regDAO = new RegisterDAOImpl();
        regDAO.registerUser(newUser);
        response.sendRedirect("/SuccessRegister.jsp");


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
