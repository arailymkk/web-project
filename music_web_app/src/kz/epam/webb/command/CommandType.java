package kz.epam.webb.command;

import kz.epam.webb.command.impl.*;

public enum  CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    ISLOGIN(new ChooseLoginCommand()),
    ISSIGNUP(new ChooseSignupCommand()),
    SIGNUP(new SignupCommand()),
    RETURN(new ReturnCommand()),
    MUSICMAIN(new MusicMainCommand()),
    MYSONGS(new MySongsCommand()),
    ADDSONG(new AddSongCommand()),
    MUSICGENRES(new MusicGenresCommand()),
    ROCK(new RockCommand()),
    RNB(new RnBCommand()),
    COUNTRY(new CountryCommand()),
    HIPHOP(new HiphopCommand()),
    POP(new PopCommand()),
    JAZZ(new JazzCommand()),
    REMOVESONG(new RemoveSongCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
