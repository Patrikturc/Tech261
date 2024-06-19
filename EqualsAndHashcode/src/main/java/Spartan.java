import java.util.Objects;

public class Spartan {
    private String firstName;
    private String lastName;

    public Spartan(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Override
    public boolean equals(Object obj) { //this.equals(otherSpartan)
        if (this == obj){
            return true;
        }

        return (obj instanceof Spartan otherSpartan) //Are these both Spartan objects?
                && getFirstName().equals(otherSpartan.getFirstName()) // Do they have same first name?
                && getLastName().equals(otherSpartan.getLastName()); // Do they have the same last name?
    }
    //@Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }


//Auto-gen version
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Spartan spartan = (Spartan) o;
//        return Objects.equals(firstName, spartan.firstName) && Objects.equals(lastName, spartan.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName);
//    }
}
