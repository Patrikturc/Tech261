public interface Trainable {

    void train();
    void study();

    default void practice(){
        System.out.println("we are practicing for our training");
    }

}
