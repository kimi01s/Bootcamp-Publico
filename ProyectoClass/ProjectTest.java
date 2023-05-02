import java.util.ArrayList;

public class ProjectTest{
    public static void main(String[] args) {
        Portafolio<Project> portafolio = new Portafolio<>();
        ArrayList<Project> listaProyectosAdd = new ArrayList<>();
        Project proyecto1 = new Project();
        proyecto1.setNameProject("proyecto 1");
        proyecto1.setInitialCost(25);
        proyecto1.setDescriptionProject("esta es la descripcion del proyecto 1.");

        Project proyecto2 = new Project("proyecto 2");
        proyecto2.setDescriptionProject("esta es la descripcion del proyecto 2");
        proyecto2.setInitialCost(25);

        Project proyecto3 = new Project("proyecto 3", "esta es la descripcion del proyecto 3");
        proyecto3.setInitialCost(4.7);

        Project proyecto4 = new Project("proyecto 3", "esta es la descripcion del proyecto 4", 45.3);
        
        listaProyectosAdd.add(proyecto1);
        listaProyectosAdd.add(proyecto2);
        listaProyectosAdd.add(proyecto3);
        listaProyectosAdd.add(proyecto4);
        portafolio.setListaProyectos(listaProyectosAdd);
        portafolio.ShowPortafolio();
        System.out.println(portafolio.getPortafolioCost());
    }
}