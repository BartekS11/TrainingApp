package pl.seafta.persistance.email;

public interface EmailSender {
    void send(String to, String email);
}
