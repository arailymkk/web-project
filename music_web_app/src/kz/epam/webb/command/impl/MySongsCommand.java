package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.database.dao.MusicDao;
import kz.epam.webb.entity.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MySongsCommand implements Command {
    MusicDao dao = new MusicDao();
    @Override
    public String execute(HttpServletRequest request) {
        String login = (String)request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", login);
        List<Song> songs = dao.getSongsByLogin(login);
        request.getSession().setAttribute("favoriteSongs", songs);
        String page = "/jsp/mysongs.jsp";
        return page;
    }
}
