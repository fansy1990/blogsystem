package blog.services;

/**
 * Created by fanzhe on 2017/12/27.
 */
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
