package pojo;



public class Students {


    private String sname;
    private int sid;
    private String stime;
    private int teacher;
    private String gai;
    private int kaohename;
    private String file;


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public String getGai() {
        return gai;
    }

    public void setGai(String gai) {
        this.gai = gai;
    }

    public int getKaohename() {
        return kaohename;
    }

    public void setKaohename(int kaohename) {
        this.kaohename = kaohename;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sname=" + sname +
                ", sid=" + sid +
                ", stime=" + stime +
                ", teacher=" + teacher +
                ", gai=" + gai +
                ", kaohename=" + kaohename +
                ", file=" + file +
                '}';
    }
}