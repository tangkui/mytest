package domain;

/**
 * Created by tanghao on 2017/2/22.
 */
public class Birthday {

    private String birthday;

    public Birthday(String birthday) {
        super();
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "birthday='" + birthday + '\'' +
                '}';
    }
}
