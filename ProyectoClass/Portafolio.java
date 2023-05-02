import java.util.ArrayList;

public class Portafolio <T extends Project>{
    private ArrayList<T> listaProyectos = new ArrayList<>();

    public ArrayList<T> getListaProyectos(){
        return this.listaProyectos;
    }
    public void setListaProyectos(ArrayList<T> listaProyectos){
        this.listaProyectos = listaProyectos;
    }
    public void ShowPortafolio(){
        for (T proyecto : listaProyectos) {
            System.out.println(proyecto.elevatorPitch());
        }
    }
    public double getPortafolioCost(){
        double totalProject = 0;
        for (T proyecto : listaProyectos) {
            totalProject+= proyecto.getInitialCost();
        }
        return totalProject;

    }
}
