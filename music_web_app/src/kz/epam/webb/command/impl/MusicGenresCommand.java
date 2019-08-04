package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.entity.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MusicGenresCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = (String)request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", login);
        String page = "/jsp/genres.jsp";
        return page;
    }
}
