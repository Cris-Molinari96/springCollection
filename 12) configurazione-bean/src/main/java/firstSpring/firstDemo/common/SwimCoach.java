package firstSpring.firstDemo.common;

// ! Qui non utilizzeremo la notazione @Component, per mettere in atto il metodo che restituisce il bean in sportConfig
public class SwimCoach implements Coach {
    private String nameCoach;
    // anche se non imposto un costruttore, questo viene richiamato esplicitamente da java.
    public SwimCoach(){
        System.out.println(getClass().getSimpleName()+" Sono stato chiamato in causa");
    }

    @Override
    public String getDailyWorkout() {
        return "100 giri di vasca \n" + "Totale km da percorrere: 5km";
    }
}
