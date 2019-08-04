package kz.epam.webb.command.impl;

import kz.epam.webb.command.Command;
import kz.epam.webb.database.dao.MusicDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddSongCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter("page");
        //String page = "/jsp/musicMain.jsp";
        String login = (String)request.getSession().getAttribute("user");

        String id = request.getParameter("id");
        int i = Integer.parseInt(request.getParameter("increment"));

        //request.getSession().setAttribute("user", login);
        MusicDao dao = new MusicDao();
        dao.addSongToUser(login, Integer.parseInt(id));

        ((List<Boolean>) request.getSession().getAttribute("existenceList")).set(i, true);

        //List<Boolean> existenceList = (List<Boolean>) request.getSession().getAttribute("existenceList");
        //request.getSession().removeAttribute("existenceList");
        //existenceList.set(i, true);
        //request.getSession().setAttribute("existenceList", existenceList);
        return page;
    }
}
