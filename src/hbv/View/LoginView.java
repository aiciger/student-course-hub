package hbv.View;

import hbv.Enum.Path;

public class LoginView extends Html {
    public LoginView(String title) {
        super(title);
    }

    public void update() {
        init();
        disableHeader();
        appendBody("<h2>Login</h2>");
        appendBody("<form action='" + Path.LOGIN.getPath() + "' method='POST' style='width:512px'>"
                + "<div class='mb-3'> <label for='name' class='form-label'>Name</label>"
                + "<input type='text' class='form-control' id='name' name='username'></div>"
                + "<div class='mb-3'><label for='password' class='form-label'>Password</label>"
                + "<input type='password' class='form-control' id='password' name='password'></div>"
                + "<div class='mb-3'> <a href='" + Path.REGESTRATION.getPath() + "'>Regestrieren</a> </div>"
                + "<button type='submit' class='btn btn-primary'>Login</button> </form>");
    }

    public void loginFail() {
        appendBody("<p>Login Fehlgeschlagen!</p>");
    }
}
