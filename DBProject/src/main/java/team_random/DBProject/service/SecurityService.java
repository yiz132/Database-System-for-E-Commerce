package team_random.DBProject.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
