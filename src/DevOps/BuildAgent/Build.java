package DevOps.BuildAgent;

public class Build extends BuildAgent {

    public void build() {
        System.out.println("Build");
    }

    public void revert() {
        System.out.println("Reverting Build");
    }
}
