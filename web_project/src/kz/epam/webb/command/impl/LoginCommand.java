package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private UserService service = new UserService();
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if(service.checkLogin(login, password)) {
            request.setAttribute("user", login);
            page = "/jsp/welcome.jsp";
        } else {
            request.setAttribute("errorLoginPassMessage", "Incorrect login or password");
            page = "/jsp/login.jsp";
        }
        return page;
    }
}
