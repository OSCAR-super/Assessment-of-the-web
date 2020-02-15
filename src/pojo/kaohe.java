package pojo;

public class kaohe {
    private int id;
    private String name;
    private String time;
    private String neiron;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNeiron() {
        return neiron;
    }

    public void setNeiron(String neiron) {
        this.neiron = neiron;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "kaohe{" +
                "name=" + name +
                ",id='" + id + '\'' +
                ",time='"+time+'\'' +
                ",neiron='"+neiron+'\'' +
                '}';
    }
}
