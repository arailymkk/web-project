package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ChooseLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/login.jsp";
        return page;
    }
}
