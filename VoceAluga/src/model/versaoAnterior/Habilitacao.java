package model.versaoAnterior;

public class Habilitacao {
    public static int id;
    public static boolean validez;

    public boolean isValidez() {
        return validez;
    }

    public void inverteValidez() {
        this.validez = !validez;
    }
}