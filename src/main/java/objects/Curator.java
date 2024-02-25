package objects;

public class Curator {
    private long id;
    private String curatorFIO;

    @Override
    public String toString() {
        return "Кураторы{" +
                "id=" + id +
                ", curatorFIO='" + curatorFIO + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCuratorFIO() {
        return curatorFIO;
    }

    public void setCuratorFIO(String curatorFIO) {
        this.curatorFIO = curatorFIO;
    }

    public Curator(long id, String groupName) {
        this.id = id;
        this.curatorFIO = groupName;
    }

    public Curator(String curatorFIO) {
        this.curatorFIO = curatorFIO;
    }
}
