package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;

import javax.servlet.http.HttpServletRequest;

public class RandomCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String ll = (String)request.getAttribute("user");
        request.setAttribute("user", ll);
        String page = "/random.jsp";
        return page;
    }
}
