package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SignupCommand implements Command {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private UserService service = new UserService();
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if(service.checkUserExistence(login)) {
            //request.setAttribute("user", login);
            request.setAttribute("errorSignupPassMessage", "User already exists");
            page = "/jsp/signup.jsp";
        } else {
            service.addUser(login, password);
            request.setAttribute("newUserNotification", "You have just registered");
            request.setAttribute("user", login);
            page = "/jsp/welcome.jsp";
        }
        return page;
    }
}
