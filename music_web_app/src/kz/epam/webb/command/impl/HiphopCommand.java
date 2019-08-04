package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.database.dao.MusicDao;
import kz.epam.webb.entity.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class HiphopCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/hiphop.jsp";
        MusicDao dao = new MusicDao();
        List<Song> songs = dao.getSongsByGenre("hiphop");
        String login = (String)request.getSession().getAttribute("user");
        if(login != null) {
            List<Boolean> existenceList = new ArrayList<>();

            for (Song song : songs) {
                if (dao.checkExistenceOfSong(login, song.getId())) {
                    existenceList.add(true);
                } else {
                    existenceList.add(false);
                }
            }
            request.getSession().setAttribute("existenceList", existenceList);
        }

        request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
        request.getSession().setAttribute("songs", songs);
        return page;
    }
}