package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ChooseSignupCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/signup.jsp";
        return page;
    }
}
