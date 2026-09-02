package hbv.View;

import hbv.Enum.Path;

public class RegisterView extends Html {

    public RegisterView(String title) {
        super(title);
    }

    public void update() {
        init();
        disableHeader();
        appendBody("<h2>Register</h2>");

        appendBody("<form action='" + Path.REGESTRATION.getPath() + "' method='POST' style='width:512px'>"
                + "<div class='mb-3'> <label for='name' class='form-label'>Name</label>"
                + "<input type='text' class='form-control' id='name' name='username'></div>"
                + "<div class='mb-3'><label for='password' class='form-label'>Password</label>"
                + "<input type='password' class='form-control' id='password' name='password'></div>"
                + "<div class='mb-3'><label for='studiengang' class='form-label'>Studiengang</label>"
                + "<select id='studiengang' class='form-select' name='studiengang'>"
                + "<option value='Informatik'>Informatik</option>"
                + "<option value='Wirtschaftsinformatik'>Wirtschaftsinformatik</option>"
                + "<option value='Digitale Medienproduktion'>Digitale Medienproduktion</option></select></div>"
                + "<div class='mb-3'> <a href='" + Path.LOGIN.getPath() + "'>Zum Login</a> </div>"
                + "<button type='submit' class='btn btn-primary'>Bestätigen</button> </form>");
    }

    public void registerFail() {
        appendBody("<p>Register Fehlgeschlagen!</p>");
    }
}
