package kz.epam.webb.command;

import kz.epam.webb.command.impl.*;

public enum  CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    ISLOGIN(new ChooseLoginCommand()),
    ISSIGNUP(new ChooseSignupCommand()),
    SIGNUP(new SignupCommand()),
    RETURN(new ReturnCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
