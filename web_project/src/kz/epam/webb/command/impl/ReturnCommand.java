package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ReturnCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/main.jsp";
        return page;
    }
}
