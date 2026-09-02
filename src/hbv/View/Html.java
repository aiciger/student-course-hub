package hbv.View;

import hbv.Enum.Path;

public class Html {
    private StringBuilder html;
    private StringBuilder body;
    private String title;
    private boolean headerOn = true;

    public Html(String title) {
        init();
        this.title = title;
    }

    public void disableHeader() {
        headerOn = false;
    }

    public String getBody() {
        return body.toString();
    }

    public void appendBody(String value) {
        body.append(value);
    }

    public void init() {
        this.html = new StringBuilder();
        this.body = new StringBuilder();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        html.append("<!doctype html><html>");
        html.append("<head>");
        html.append("<title>" + getTitle() + "</title>");
        html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        html.append("<link href='/docker-aiciger-java/css/bootstrap5/bootstrap.min.css' rel='stylesheet'/>");
        html.append("<script src='/docker-aiciger-java/js/bootstrap5/bootstrap.bundle.min.js'></script>");
        html.append("</head>");
        html.append("<body class='vh-100 text-white bg-dark'>");
        html.append(getNav());
        html.append("<div class='container p-3 mx-auto'>");
        html.append(getBody());
        html.append("</div>");
        html.append("</body></html>");

        return html.toString();
    }

    private String getNav() {
        if (headerOn) {
            return "<nav class='navbar navbar-expand-sm navbar-dark bg-dark'> <div class='container-fluid'> <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#mynavbar'> <span class='navbar-toggler-icon'></span> </button> <a class='navbar-brand' href='javascript:void(0)'>Ahmet's App</a> <div class='collapse navbar-collapse' id='mynavbar'> <ul class='navbar-nav me-auto'> "
            + "<li class='nav-item dropdown'> <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-bs-toggle='dropdown' aria-expanded='false'>Studiengänge</a> <ul class='dropdown-menu' aria-labelledby='navbarDropdown'>"
            + "<li><a class='dropdown-item' href='" + Path.STUDIENGANG.getPath() + "/Informatik'>Informatik</a></li>"
            + "<li><a class='dropdown-item' href='" + Path.STUDIENGANG.getPath() + "/Wirtschaftsinformatik'>Wirtschaftsinformatik</a></li>"
            + "<li><a class='dropdown-item' href='" + Path.STUDIENGANG.getPath() + "/Digitale Medienproduktion'>Digitale Medienproduktion</a></li>"
            + "</ul></li>"
            + "<li class='nav-item'> <a class='nav-link' href='" + Path.USER.getPath() + "'>Benutzer suchen</a> </li>" 
            + "<li class='nav-item'> <a class='nav-link' href='" + Path.USER.getPath() + "/me'>Mein Profil</a> </li></ul>"
            + "<a href='" + Path.LOGOUT.getPath() + "' class='btn bg-white'>Logout</a> </div> </div> </nav>";
        }
        return "";
    }
}
