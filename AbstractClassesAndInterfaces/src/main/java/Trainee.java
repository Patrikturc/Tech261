public abstract class Trainee implements Trainable{

    private String name;
    private int age;
    private String email;
    private String PhoneNumber;
    private int experience;
    private String[] certifications;
    private String[] projects;

    public Trainee(String name, int age, String email, String phoneNumber, int experience, String[] certifications, String[] projects) {
        this.name = name;
        this.age = age;
        this.email = email;
        PhoneNumber = phoneNumber;
        this.experience = experience;
        this.certifications = certifications;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String[] getCertifications() {
        return certifications;
    }

    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }

    public String[] getProjects() {
        return projects;
    }

    public void setProjects(String[] projects) {
        this.projects = projects;
    }
}
