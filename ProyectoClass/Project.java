public class Project {
    private String nameProject;
    private String descriptionProject;
    private double initialCost = 0;
    private int countProjects;

    public Project(){
        countProjects++;
    }
    public Project(String name){
        this.nameProject = name;
        countProjects++;
    }
    public Project(String name, String description){
        this.nameProject = name;
        this.descriptionProject = description;
        countProjects++;
    }
    public Project(String name, String description, double initialCost){
        this.nameProject = name;
        this.descriptionProject = description;
        this.initialCost = initialCost;
        countProjects++;
    }

    public String getNameProject(){
        return this.nameProject;
    }
    public void setNameProject(String name){
        this.nameProject = name;
    }
    public String getDescription(){
        return this.descriptionProject;
    }
    public void setDescriptionProject(String description){
        this.descriptionProject = description;
    }
    public double getInitialCost(){
        return this.initialCost;
    }
    public void setInitialCost(double cost){
        this.initialCost = cost;
    }
    public int getCountProjects(){
        return this.countProjects;
    }

    public String elevatorPitch(){
        return "Name: "+nameProject+"(Cost): "+initialCost+" | description:"+descriptionProject;
    }
}
