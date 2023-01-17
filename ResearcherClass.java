public class ResearcherClass extends EmployeeClass implements Researcher {

    private String researchGoal, researchProgress;

    public ResearcherClass(int id, String name, int salary, int weeklyWorkload, String role, String researchGoal, String researchProgress) {
        super(id, name, salary, weeklyWorkload, role);
        this.researchGoal = researchGoal;
        this.researchProgress = researchProgress;
    }

    @Override
    public String getResearchGoal() {
        return researchGoal;
    }

    @Override
    public void setResearchGoal(String goal) {
        this.researchGoal = goal;
    }

    @Override
    public String getResearchProgress() {
        return researchProgress;
    }

    @Override
    public void setResearchProgress(String progress) {
        this.researchProgress = progress;
    }
}
